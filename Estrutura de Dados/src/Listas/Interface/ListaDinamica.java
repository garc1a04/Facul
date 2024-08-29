package Listas.Interface;


public class ListaDinamica<T> implements Lista<T>{
	
	private Node<T> primeiro;
	private Node<T> ultimo;
	private int tamanho;
	
	@Override
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
	
	@Override
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

	
	
	@Override
	public boolean remove(T valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T valor) {
		Node<T> temp = primeiro;
		int index = 0;
		
		while(temp != null) {
			if(temp.valor == valor)
				return index;
			
			temp = temp.next;
			index++;
		}
		
		return -1;
	}

	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public void clear() {
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}

	@Override
	public T get(int index) {
		Node<T> temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		return temp.valor;
	}
	
	@Override
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