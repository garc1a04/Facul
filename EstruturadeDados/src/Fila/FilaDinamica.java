package Fila;


public class FilaDinamica<T> {
	
	private Node<T> primeiro;
	private Node<T> ultimo;
	private int tamanho;
	
	public void enqueue(T valor) {
		Node<T> newNode = new Node<T>(valor);
		
		if(isEmpty()) {
			primeiro = newNode;
			ultimo = newNode;
			return;
		}
		
		ultimo.next = newNode;
		ultimo = newNode;
		tamanho++;
	}
	
	public T dequeue() {
		Node<T> temp = primeiro;
		primeiro = primeiro.next;
		
		tamanho--;
		return temp.valor;
	}
	
	public boolean isEmpty() {
		return primeiro == null;
	}
	
	public T front() {
		return primeiro.valor;
	}
	
	public boolean contains(T valor) {
		Node<T> temp = primeiro;
		
		while(temp != null) {
			if(temp.valor.equals(valor)) {
				return true;
			}
			
			temp = temp.next;
		}
		
		return false;
	}
	
	public int indexOf(T valor) {	
		Node<T> temp = primeiro;
		int index = 0;
		
		while(temp != null) {
			if(temp.valor.equals(valor)) {
				return index;
			}
			
			temp = temp.next;
			index++;
		}
		
		return -1;
	}
	
	public int size() {
		return tamanho;
	}
	
	public String toString() {
		String saida = "";
		Node<T> temp = primeiro;
		
		while(temp != null) {
			saida+= temp.valor +" ";
			temp = temp.next;
		}
		
		return saida.trim();
	}
}

class Node<T>{
	T valor;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
	
}
