package Listas.Estatica;

public class ListaEstatica {
	
	private int ultimo;
	private int vetor[];
	
	public ListaEstatica() {
		vetor = new int[10];
		ultimo = 0;
		
	}
	
	public void add(int valor) {
		vetor[ultimo++] = valor;
		
		if(ultimo == vetor.length) 
			atualizar(vetor);
	}
	
	public void add(int index, int valor) {	
		if(ultimo == vetor.length)
			atualizar(vetor);

		

		for(int i = ultimo;i > index-1;i--) {
			vetor[i+1] = vetor[i];
			
		}
		
		vetor[index] = valor;
		ultimo++;
	}
	
	private void atualizar(int vetor[]) {
		int newVetor[] = new int[vetor.length+10];
		
		for(int i = 0;i < vetor.length;i++) {
			
			newVetor[i] = vetor[i];
		}
		
		setVetor(newVetor);

	}
	
	public int size() {
		return ultimo;
	}
	
	public boolean contais(int Elemento) {
		
		for(int i = 0; i < ultimo;i++) {
			if(vetor[i] == Elemento)
				return true;
		}
		
		return false;
	}
	
	public boolean remove(Integer elemento) {
		
		for(int i = 0; i < ultimo;i++) {
			if(vetor[i] == elemento) {
				organizarVetor(i);
				return true;
			}
		}
		
		return false;
	}
	
	public int remove(int posicao) {
		if(posicao > ultimo)
			throw new IndexOutOfBoundsException("A posicao " + posicao+" está fora do limite para o tamanho "+ultimo);
		
		int temp = vetor[posicao];
		organizarVetor(posicao);
		
		return temp;
	}
	
	private void organizarVetor(int index) {
		
		for(int i = index;i < ultimo;i++) {
			vetor[i] = vetor[i+1];
		}
		
		ultimo--;
	}
	
	public int indexOf(Integer valor) {
		
		for(int i = 0; i < ultimo;i++) {
			if(vetor[i] == valor) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void clear() {
		vetor = new int[10];
	}
	
	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}
	
	public int get(int index) {
		return vetor[index];
	}
	
	public String toString() {
		String saida = "[";
		
		for(int i = 0;i < ultimo-1;i++) {
			saida+= vetor[i]+", ";
		}
		
		saida+=vetor[ultimo-1];
		return saida+"]";
	}
	
}