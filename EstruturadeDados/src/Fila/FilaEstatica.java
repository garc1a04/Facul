package Fila;

public class FilaEstatica<T> {
	
	private int primeiro;
	private int ultimo;
	private Object[] vetor;
	
	public FilaEstatica() {
		primeiro = 0;
		ultimo = 0;
		vetor = (T[]) new Object[5];
	}
	
	public void enqueue(T valor) {
		if(primeiro > 0 && ultimo >= vetor.length) {
			ultimo = 0;
		}
		
		if(ultimo < primeiro) {				
			atualizar();
		}
		
		vetor[ultimo++] = valor;		
	}
	
	private void atualizar() {
		Object []vetor2 = (T[]) new Object[vetor.length+10];
		
		if(ultimo <= primeiro) {
			for(int i = 0; i < vetor.length; i++) {
				vetor2[i] = vetor[i];
			}
		
		} else {
			
			for(int i = primeiro; i < vetor.length; i++) {
				vetor2[i] = vetor[i];
			}
			
			for(int i = 0; i < ultimo; i++) {
				vetor2[i] = vetor[i];
			}
			
		}
		
		
		
		
		this.vetor = vetor2;
	}

	public void dequeue() {
		primeiro++;
	}
	
	public int size() {
		return primeiro-ultimo+1;
	}
	
	public String toString() {
		String saida = "";
		
		for(int i = primeiro; i < ultimo;i++) {
			saida+= vetor[i]+" ";
		}
		
		return saida;
	}
	
}
