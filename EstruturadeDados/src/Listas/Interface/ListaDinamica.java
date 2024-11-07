package Listas.Interface;


public class ListaDinamica<T>{
	
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
		String saida = "[";
		Node<T> temp = null;
		
		if(primeiro != null)
			temp = primeiro;

		while (temp != ultimo && temp != null) {
			saida += temp.valor + ", ";

			temp = temp.next;
		}
		
		if(ultimo != null)
			saida += ultimo.valor;

		return saida + "]";
	}
}

class Node<T>{
	T valor;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
}