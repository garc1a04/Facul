package Listas.Dinamica;

public class ListaDinamicaOrdenada {

	private Node2 primeiro;
	private Node2 ultimo;
	private int tamanho;

	public void add(int valor) {
		Node2 novoNode = new Node2(valor);
		
		if(tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
			
		} else if(primeiro.valor > valor) {
			novoNode.next = primeiro;
			primeiro = novoNode;
			
		} else if(ultimo.valor < valor) {
			ultimo.next = novoNode;
			ultimo = novoNode;
			
		} else {
			Node2 temp = primeiro;
			Node2 pre = temp.next;
			
			while(temp != null && temp.valor < valor) {
				pre = temp;
				temp = temp.next;
			}
			
			novoNode.next = pre.next;
			pre.next = novoNode;
		}
		
		tamanho++;
	}
	
	 public boolean remove(Integer valor) {
		 Node2 temp = primeiro;
		 int index = 0;
		 
		 while(temp != null) {
			 if(temp.valor == valor) {
				 remove(index);
				 
				 return true;
			 }
			 
			 temp = temp.next;
			 index++;
		 }
		 
		 return false;
	 }
	 
	 
	 public Node2 remove(int index) {
			Node2 temp;
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
				Node2 aux = temp.next;
				
				temp.next = aux.next;
				aux.next = null;
			}
			
			
			tamanho--;		
			return temp;
	}
	
	public Integer remove() {
		Node2 temp = null;
		return temp.valor;
	}
	
	public Node2 get(int index) {
		Node2 temp = primeiro;
		int i = 0;
		
		while(i < index) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public int indexOf(int valor) {
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
		Node2 temp = primeiro;
		
		while (temp != null) {
			saida += temp.valor + ", ";

			temp = temp.next;
		}
		
		if(saida.length() > 2)
			saida = saida.substring(0,saida.length()-2);
		
		return saida + "]";
	}
}

class Node2 {

	int valor;
	Node2 next;

	public Node2(int valor) {
		this.valor = valor;
	}
}