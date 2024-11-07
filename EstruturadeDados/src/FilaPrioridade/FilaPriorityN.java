package FilaPrioridade;

public class FilaPriorityN<T> {
	
	private Node<T> primeiro;
	private Node<T> ultimo;
	private int tamanho;
	
	public void enqueue(T valor) {
		Node<T> newNode = new Node<>(valor);
		
		if(primeiro == null) {
			primeiro = newNode;
			ultimo = newNode;
		} else {
			
			ultimo.next = newNode;
			ultimo = newNode;
		}
	}
	
	public void enqueue(T valor,int prioridade) {
		Node<T> newNode = new Node<>(valor, prioridade);
		
		if(primeiro == null) {
			primeiro = newNode;
			ultimo = newNode;
		} else {
			
			ultimo.next = newNode;
			ultimo = newNode;
		}
		
		tamanho++;
		
	}
	
	public T dequeue() {
		Node<T> temp = primeiroFila();
		T valor = temp.valor; 
		
		if(temp.equals(primeiro)) {
			primeiro = primeiro.next;
			
		} else if(temp.equals(ultimo)) {
			ultimo = temp;
		
		} else {
			
			Node<T> aux = temp.next;
			temp.next = aux.next;
			
		}
		
		tamanho--;
		return valor;
	}
	
	private Node<T> primeiroFila() {
		
		Node<T> temp = primeiro;
		Node<T> menor = temp;
		
		while(temp.next != null) {
			
			if(temp.next.prioridade < menor.next.prioridade) {
				
				menor = temp;
				
			}
			
			temp = temp.next;
		}
		
		
		return menor;
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
