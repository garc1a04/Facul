package FilaPrioridade;


public class FilaPriority<T>{
	private Node<T> primeiro;
	private Node<T> ultimo;
	private int tamanho;
	
	public void enqueue(T valor,int prioridade) {
		Node<T> newNode = new Node<>(valor, prioridade);
		
		if(primeiro == null) {
			primeiro = newNode;
			ultimo = newNode;
		} if(primeiro.prioridade < newNode.prioridade) {
			
			newNode.next = primeiro;
			primeiro = newNode;
			
			
		} else if(ultimo.prioridade >= newNode.prioridade) {
			
			ultimo.next = newNode;
			ultimo = newNode;
			
		} else {

			Node<T> temp = primeiro;
			Node<T> pre = temp.next;
			
			while(temp != null && temp.prioridade >= prioridade) {
				pre = temp;
				temp = temp.next;
			}
			
			newNode.next = pre.next;
			pre.next = newNode;
			
		}
		
		tamanho++;
		
	}
	
	public T dequeue() {
		Node<T> temp = primeiro;
		primeiro = primeiro.next;
		
		tamanho--;
		return temp.valor;
	}
	

	public int size() {
		return tamanho;
	}
	
	public T front() {
		Node<T> temp = primeiro;
		Node<T> menor = temp;
		
		while(temp.next != null) {
			
			if(temp.prioridade < menor.prioridade) {
				
				menor = temp;
				
			}
			
			temp = temp.next;
		}
		
		
		return menor.valor;
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
	int prioridade;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
	
	public Node(T valor,int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
}
