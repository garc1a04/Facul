package Listas.Dinamica;

public class ListaDinamicaDupla {
	private Node3 primeiro;
	private Node3 ultimo;
	private int tamanho;
	
	public void add(int valor) {
		Node3 novoNode = new Node3(valor);

		if (primeiro == null) {
			primeiro = novoNode;
			ultimo = novoNode;
			
		} else {
			Node3 temp = ultimo;
			
			ultimo.next = novoNode;
			ultimo = novoNode;
			ultimo.prev = temp;
		}

		tamanho++;
	}
	
	public void add(int index, int valor) {
		Node3 novoNode = new Node3(valor);
		
		if(index >= tamanho) {
			add(valor);
			return;
		}
		
		if(index <= 0) {
			primeiro.prev = novoNode;
			novoNode.next = primeiro;
			primeiro = novoNode;
			return;
		}
		
		Node3 temp = get(index);
		novoNode.prev = temp.prev;
		novoNode.next = temp;
		temp.prev.next = novoNode;
		temp.prev = novoNode;		
		
		tamanho++;
	}
	
	 public boolean remove(Integer valor) {
		 Node3 temp = primeiro;
		 
		 if(primeiro.valor == valor) { 
			  temp = primeiro.next;
			  temp.prev = null;
			  primeiro = temp;
			  
			 return true; 
		 }

		
		if(ultimo.valor == valor) {
			temp = ultimo.prev;
			ultimo = temp;
			ultimo.next = null;
			
			return true;
		}
		 for(int i = 0; i < tamanho;i++) {
			 if(temp.valor == valor) {
				 
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				 return true;
			 }
			 
			 temp = temp.next;
		 }
		 
		 
		 return false;
	 }

	
	public Node3 remove(int index) {
		
		if(tamanho == 0) return null;
		
		if(tamanho == 1) {
			clear();
			return null;
		}
		
		
		Node3 temp;
		 if(index == 0) { 
			  temp = primeiro.next;
			  temp.prev = null;
			  primeiro = temp;
			  
			 return null; 
		 }

		
		if(index >= tamanho-1) { //ultimo
			temp = ultimo.prev;
			ultimo = temp;
			ultimo.next = null;
			
			return temp;
		}
		
		temp = get(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		
		tamanho--;		
		return temp;
	}
	
	public Integer remove() {
		Node3 temp = null;
		if(tamanho == 0) return null;
		
		if(tamanho == 1) {
			primeiro = null;
			ultimo = null;
		} else {
			
			temp = primeiro;
			primeiro = primeiro.next;
			temp.next = null;
		}
		
		
		tamanho--;
		return temp.valor;
	}
	
	public Node3 get(int index) {
		if(index > tamanho) return null;
		
		if(index == 0) return primeiro;
		
		if(index == tamanho) return ultimo;
		
		Node3 temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public int indexOf(int valor) {
		
		Node3 temp = primeiro;
		int index = 0;
		
		while(temp != null) { 
			if(temp.valor == valor)
				return index;
			
			temp = temp.next;
			index++;
		}
		
		
		return -1;
	}
	
	public void clear() {
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}
	
	public boolean contains(int valor) {
		return indexOf(valor) >= 0 ? true : false;
	}

	public int size() {
		return tamanho;
	}
	
	public String Reverse() {
		String saida = "[";
		
		Node3 temp = ultimo;
		while(temp!=null) {
			saida+=temp.valor+", ";
			temp = temp.prev;
		}
		
		return saida.substring(0, saida.length()-2)+"]";
	}
	
	public String toString() {
		String saida = "[";
		
		Node3 temp = primeiro;
		while(temp!=null) {
			saida+=temp.valor+", ";
			temp = temp.next;
		}
		
		return saida.substring(0, saida.length()-2)+"]";
	}
	
}

class Node3{
	int valor;
	Node3 next;
	Node3 prev;
	
	public Node3(int valor) {
		this.valor = valor;
	}
	
}