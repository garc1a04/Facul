package Listas.Dinamica;

public class ListaDuplaOrdenada {

	private Nodee primeiro;
	private Nodee ultimo;
	private int tamanho;
	
	public void add(String valor) {
		Nodee novoNode = new Nodee(valor);
		
		if(tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
			
		} else if(primeiro.valor.length() > novoNode.valor.length()) {
			primeiro.prev = novoNode;
			novoNode.next = primeiro;
			primeiro = novoNode;
			
		} else if(primeiro.valor.length() < novoNode.valor.length()) {
			Nodee temp = ultimo;
			
			ultimo.next = novoNode;
			ultimo = novoNode;
			ultimo.prev = temp;
			
		} else {
			Nodee temp = primeiro;
			Nodee prev = temp.next;
			
			while(temp != null && temp.valor.length() < valor.length()) {
				prev = temp;
				temp = temp.next;
			}
			
			novoNode.next = prev.next;
			novoNode.prev = prev.prev;
			prev.prev.next = novoNode;
			prev.prev = novoNode;
		}
		
		tamanho++;
	}
	
	public boolean remove(String valor) {
		Nodee temp = primeiro;
		 
		 if(primeiro.valor.equals(valor)) { 
			  temp = primeiro.next;
			  temp.prev = null;
			  primeiro = temp;
			  
			 return true; 
		 }

		
		if(ultimo.valor.equals(valor)) {
			temp = ultimo.prev;
			ultimo = temp;
			ultimo.next = null;
			
			return true;
		}
		 for(int i = 0; i < tamanho;i++) {
			 if(temp.valor.equals(valor)) {
				 
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				 return true;
			 }
			 
			 temp = temp.next;
		 }
		 
		 
		 return false;
	 }

	
	public Nodee remove(int index) {
		
		if(tamanho == 0) return null;
		
		if(tamanho == 1) {
			clear();
			return null;
		}
		
		
		Nodee temp;
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
	
	
	
	private Nodee get(int index) {
		Nodee temp = primeiro;
		
		for(int i = 0; i < index;i++) {
			temp = temp.next;
		}
		
		
		return temp;
	}

	
	public int indexOf(String valor) {
		
		Nodee temp = primeiro;
		int index = 0;
		
		while(temp != null) { 
			if(temp.valor.equals(valor))
				return index;
			
			temp = temp.next;
			index++;
		}
		
		
		return -1;
	}
	
	public boolean contains(String valor) {
		return indexOf(valor) >= 0 ? true : false;
	}

	public int size() {
		return tamanho;
	}

	private void clear() {
		primeiro = null;
		ultimo = null;
		tamanho = 0;	
	}

	public String toString() {
		String saida = "[";
		
		Nodee temp = primeiro;
		while(temp!=null) {
			saida+=temp.valor+", ";
			temp = temp.next;
		}
		
		return saida.substring(0, saida.length()-2)+"]";
	}
	
}

class Nodee{
	
	String valor;
	Nodee next;
	Nodee prev;
	
	public Nodee(String valor) {
		this.valor = valor;
	
	}
	
}
