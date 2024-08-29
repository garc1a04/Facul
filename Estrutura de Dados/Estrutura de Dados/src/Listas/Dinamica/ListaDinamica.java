package Listas.Dinamica;

public class ListaDinamica {

	private Node primeiro;
	private Node ultimo;
	private int tamanho;

	public void add(int valor) {
		Node novoNode = new Node(valor);

		if (tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
		} else {
			
			ultimo.proximo = novoNode;
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
			novoNode.proximo = primeiro;
			primeiro = novoNode;
		}
		
		else {
			aux = get(index-1);
			novoNode.proximo = aux.proximo;
			aux.proximo = novoNode;			
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
			 
			 temp = temp.proximo;
		 }
		 
		 
		 return false;
	 }

	
	public Node remove(int index) {
		Node temp;
		
		if(tamanho == 0) return null;
		
		if(index < 0 || index >= tamanho)
			throw new IndexOutOfBoundsException("Indice: "+index+", Tamanho: "+ tamanho);
		
		if(tamanho == 1) clear();
		
		if(index == 0) remove();

		if(index == tamanho-1) { //ultimo
			temp = get(index-1);
			
			ultimo = temp;
			ultimo.proximo = null;
			
		} else { // pelo meio
			temp = get(index-1);
			Node aux = temp.proximo;
			
			temp.proximo = aux.proximo;
			aux.proximo = null;
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
			primeiro = primeiro.proximo;
			
			temp.proximo = null;
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
			temp = temp.proximo;
		}
		
		return temp;
	}
	
	public int indexOf(int valor) {
		Node temp = primeiro;
		int index = 0;
		
		while(temp != null) {
			if(temp.valor == valor)
				return index;
			
			temp = temp.proximo;
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
		Node temp = null;
		
		if(primeiro != null)
			temp = primeiro;

		while (temp != ultimo && temp != null) {
			saida += temp.valor + ", ";

			temp = temp.proximo;
		}
		
		if(ultimo != null)
			saida += ultimo.valor;

		return saida + "]";
	}
}

class Node {

	int valor;
	Node proximo;

	public Node(int valor) {
		this.valor = valor;
	}
}