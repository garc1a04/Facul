package Listas.Dinamica;

public class ListaDinamica {

	private Node primeiro;
	private Node ultimo;
	private int tamanho;

	public ListaDinamica() {
		clear();
	}
	public void add(int valor) {
		Node novoNode = new Node(valor); // Novo No

		if (primeiro == null) {
			
			primeiro = novoNode;
			ultimo = novoNode;
			
		} else {
			
			ultimo.next = novoNode;
			ultimo = novoNode;
				
		}

		tamanho++;
	}

	public void add(int index, int valor) {
		Node novoNode = new Node(valor);
		Node aux = null;
		if(index < 0 || index > tamanho ) 
			throw new ArrayIndexOutOfBoundsException("Index "+index+" é maior que o tamanho " + (tamanho));
		
		if(index == tamanho) {
			add(valor);
			return;
		}
		
		else if(index == 0) {
			novoNode.next = primeiro;
			primeiro = novoNode;
		}
		
		else {
			aux = get(index-1);
			novoNode.next = aux.next;
			aux.next = novoNode;			
		}
		
		tamanho++;
	}
	
	
	 public boolean remove(Integer valor) {
		 Node temp = primeiro;
		
		 for(int i = 0; i < tamanho;i++) {
			 if(temp.valor == valor) {
				 remove(i);
				 return true;
			 }
			 
			 temp = temp.next;
		 }
		 
		 
		 return false;
	 }

	
	public Node remove(int index) {
		Node temp;
		if(index < 0 || index >= tamanho)
			throw new IndexOutOfBoundsException("Indice: "+index+", Tamanho: "+ tamanho);
		
		if(tamanho == 0) 
			return null;
		
		if(tamanho == 1)
			clear();
		
		if(index == 0) 
			remove();

		if(index == tamanho-1) { //ultimo
			temp = get(index-1);
			
			ultimo = temp;
			ultimo.next = null;
			
		} else { // pelo meio
			temp = get(index-1);
			Node aux = temp.next;
			
			temp.next = aux.next;
			aux.next = null;
		}
		
		
		tamanho--;		
		return temp;
	}
	
	public Integer remove() {
		Node temp = null;
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
	
	public Node get(int index) {
		if(index > tamanho) return null;
		
		if(index == 0) return primeiro;
		
		if(index == tamanho) return ultimo;
		
		Node temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public int indexOf(int valor) {
		
		Node temp = primeiro;
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
	
	public String toString() {
		String saida = "[";
		Node temp = primeiro;
		
		while (temp != null) {
			saida += temp.valor + ", ";
			temp = temp.next;
			
		}
		
		return saida.substring(0, saida.length()-2)+"]";
	}
}









class Node {
	
	public int valor;
	public Node next; // ENDEREÇO DO PROXIMO VALOR

	public Node(int valor) {
		this.valor = valor;
	}
	
	
}







