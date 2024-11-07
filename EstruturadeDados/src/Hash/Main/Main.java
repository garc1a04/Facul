package Hash.Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		
		for(int i = 0; i < N;i++) {
			TabelaHash tabelas = new TabelaHash(input.nextInt());
			int repeticoes = input.nextInt();
			
			for(int j = 0; j < repeticoes;j++) {
				tabelas.add(input.nextInt());
			}
			
			System.out.println(tabelas);
			
		}
		
	}
}

class TabelaHash{
	
	private ListaDinamica<Integer> vetor[];
	
	public TabelaHash(int N) {
		vetor = new ListaDinamica[N];
	}
	
	public void add(int valor) {
		int i = hash(valor);
		
		if(vetor[i] != null) {
			vetor[i].add(valor);
			return;
		}
		
		vetor[i] = new ListaDinamica<Integer>();
		vetor[i].add(valor);
	}
	
	private int hash(int valor) {
		return valor%vetor.length;
	}
	
	public void remocao(Integer valor) {
		int i = hash(valor);
		vetor[i].remove(valor);
		
		if(vetor[i].size() == 0) {
			vetor[i] = null;
		}
	}
	
	
	public String toString() {
		String saida = "";
		
		for(int i = 0; i < vetor.length;i++) {
			saida += vetor[i] == null ? i+" -> \\\n" :i+ " -> "+vetor[i]+"\n"; 
		}
		
		return saida+"";
	}
}

class ListaDinamica<T>{
	
	private Node<T> primeiro;
	private Node<T> ultimo;
	private int tamanho;
	
	
	public void add(T valor) { //final da lista
		Node<T> novoNode = new Node<>(valor);
		
		if(tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
		} else{
			ultimo.next = novoNode;
			ultimo = novoNode;
		}
		
		tamanho++;
	}
	

	public void add(int index, T valor) {
		Node<T> novoNode = new Node<>(valor);
		
		if(index < 0 || index > tamanho) throw new ArrayIndexOutOfBoundsException();
		
		if(index == 0) { //final da lista
			novoNode.next = primeiro;
			primeiro = novoNode;
			
		} else if(index == tamanho) {
			ultimo.next = novoNode;
			ultimo = novoNode;
			
		} else {
			Node<T> temp = primeiro;
			
			for(int i = 0; i < index-1;i++) {
				temp = temp.next;
			}
			
			
			novoNode.next = temp.next;
			temp.next = novoNode;
		}
		
		tamanho++;
	}
	
	public boolean remove(T valor) {
		Node<T> temp = primeiro;
		int index = 0;
		
		while(temp != null) {
			if(temp.valor.equals(valor)) {
				remove(index);
				
				return true;
			}
			
			temp = temp.next;
			index++;
		}
		
		return false;
	}

	
	public T remove(int index) {
		if(index < 0 || index > tamanho) return null;
		
		if(index == 0) return remove();
		
		Node<T> pos = getNode(index-1);
		Node<T> temp = pos.next;
		
		pos.next = temp.next;
		temp.next = null;
		
		if(index == tamanho-1) ultimo = pos;
		
		tamanho--;
		return temp.valor;
	}
	
	public T remove() { //Primeiro elemento!!
		Node<T> temp = primeiro;
		primeiro = primeiro.next;
		temp.next = null;
		
		return temp.valor;
	}

	
	public int indexOf(T valor) {
		Node<T> temp = primeiro;
		int index = 0;
		
		while(temp != null) {
			if(temp.valor.equals(valor))
				return index;
			
			temp = temp.next;
			index++;
		}
		
		return -1;
	}

	
	public int size() {
		return tamanho;
	}


	public void clear() {
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}

	public T get(int index) {
		Node<T> temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		return temp.valor;
	}
	
	private Node<T> getNode(int index) {
		Node<T> temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public boolean contais(T Elemento) {
		return indexOf(Elemento) >= 0 ? true : false;
	}
	
	public String toString() {
		String saida = "";
		Node<T> temp = primeiro;

		while (temp != null) {
			saida += temp.valor + " -> ";
			temp = temp.next;
		}


		return saida + "\\";
	}
}

class Node<T>{
	T valor;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
}