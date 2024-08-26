package Listas.Interface;

public class ListaDinamica<T> implements Lista<T>{
	
	private Node<T> inicio;
	private Node<T> fim;
	private int tamanho;
	
	@Override
	public void add(T valor) {
		Node<T> newNode = new Node<T>(valor);
		
		if(tamanho == 0) {
			inicio = newNode;
			fim = newNode;
		}
		
		fim.setNext(newNode);
		fim = newNode;
		
		tamanho++;
	}
	
	@Override
	public void add(int index, T valor) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean remove() {
		if(tamanho == 0) return false;
		
		Node<T> temp = inicio;
		inicio = inicio.getNext();
		temp.setNext(null);
		
		tamanho--;
		
		if(tamanho == 0) {
			inicio = null;
			fim = null;
		}
		
		return true;
	}
	
	@Override
	public boolean remove(T valor) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T remove(int index) {
		if(index == tamanho)
			remove();
		
		Node<T> temp = getNode(index);
		
		tamanho--;
		return null;
	}
	@Override
	public int indexOf(T valor) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T get(int index) {
		Node<T> temp = inicio;
		
		for(int i = 0; i < index;i++) {
			temp = temp.getNext();
		}
		
		return temp.getValor();
	}
	
	private Node<T> getNode(int index){
		Node<T> temp = inicio;
		
		for(int i = 0; i < index;i++) {
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	public void printList() {
		Node<T> temp = inicio;
		
		while(temp!=null) {
			System.out.print(temp.getValor()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	
}

class Node<T>{
	private T valor;
	private Node<T> next;
	
	public Node(T valor) {
		setValor(valor);
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
}