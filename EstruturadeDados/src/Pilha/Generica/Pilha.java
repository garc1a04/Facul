package Pilha.Generica;

public class Pilha<T> {
	
	private Node<T> top;
	private int tamanho;
	
	public void push(T valor) {
		Node<T> newNode = new Node<>(valor);
		
		if(tamanho == 0) {
			top = newNode;
		
		} else {
			newNode.next = top;
			top = newNode;
		}
		
		tamanho++;
	}
	
	public int size() {
		return tamanho;
	}
	
	
	public T pop() {
		T aux = top.valor;
		top = top.next;
		tamanho--;
		
		return aux;
	}
	
	public T top() {
		
		if(top != null) {
			return top.valor;			
		}
		
		return null;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public boolean contains(T valor) {
		Node<T> aux = top;
		
		while(aux != null) {
			if(aux.equals(valor)) {
				return true;
			}
			aux = aux.next;
		}
		
		return false;
	}
	
	public String toString() {
		String saida = "";
		Node<T> aux = top;
		
		while(aux != null) {
			saida+= aux.valor +" ";
			aux = aux.next;
		}
		
		return saida;
	}
	
}

class Node <T>{
	T valor;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
}
