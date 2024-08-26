package Listas.Interface;

public class ListaEstatica<T> implements Lista<T>{
	
	private int ultimo;
	private Object[] vetor;
	
	public <T> ListaEstatica() {
		this.vetor = (T[]) new Object[10];
		ultimo = 0;
	}
	
	@Override
	public void add(Object valor) {
		if(ultimo == vetor.length)
			atualizar(vetor);
		
		vetor[ultimo++] = valor;	
	}
	

	@Override
	public void add(int index, Object valor) {
		if(ultimo == vetor.length)
			atualizar(vetor);
		
		for(int i = ultimo;i > index-1;i--) {
			vetor[i+1] = vetor[i];
		}
		
		vetor[index] = valor;
		ultimo++;
		
	}
	
	private void atualizar(Object[] vetor2) {
		Object newVetor[] = (T[])new Object[vetor2.length+10];
		
		for(int i = 0; i < vetor2.length;i++) {
			newVetor[i] = vetor2[i];
		}
		
		setVetor(newVetor);
	}
	
	@Override
	public boolean remove(Object valor) {
		for(int i = 0; i < vetor.length;i++) {
			
			if(valor instanceof String && vetor[i].equals(valor)) {
				organizarVetor(i);
				return true;
				
			} else if(vetor[i] == valor && !(valor instanceof String)) {
				organizarVetor(i);
				return true;
			} 
			
		}
		
		return false;
	}

	@Override
	public T remove(int index) {
		T temp = (T) vetor[index];
		organizarVetor(index);
		
		return temp;
	}
	
	

	private void organizarVetor(int index) {
		if(ultimo == vetor.length)
			atualizar(vetor);
		
		for(int i = index; i < ultimo;i++) {
			vetor[i] = vetor[i+1];
		}
		
		ultimo--;
	}

	@Override
	public int indexOf(Object valor) {
		
		for(int i = 0; i < ultimo;i++) {
			if(valor instanceof String && vetor[i].equals(valor)) {
				organizarVetor(i);
				return i;
				
			} else if(vetor[i] == valor && !(valor instanceof String)) {
				organizarVetor(i);
				return i;
			} 
		}
		
		return -1;
	}

	@Override
	public int size() {
		return ultimo;
	}

	@Override
	public void clear() {
		for(int i = 0 ;i < ultimo;i++) {
			vetor[i] = null;
		}
		
		ultimo = 0;
	}

	@Override
	public T get(int index) {
		return (T) vetor[index];
	}
	
	public void setVetor(Object vetor[]) {
		this.vetor = vetor;
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