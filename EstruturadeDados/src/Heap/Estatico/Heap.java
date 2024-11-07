package Heap.Estatico;

public class Heap<T> {
	
	private Node<T> vetor[];
	private int tamanho;
	
	public Heap() {
		vetor = new Node[10];
		tamanho = 0;
	}
	
	public void add(T valor, int prioridade) {
		Node<T> novoNode = new Node(valor, prioridade);
		
		if(tamanho == 0) {
			vetor[tamanho++] = novoNode;
			return;
		}
		
		vetor[tamanho] = novoNode;
		
		int posicao = tamanho;
		while(vetor[pai(posicao)].prioridade < vetor[posicao].prioridade) {
			troca(pai(posicao), posicao);
			posicao = pai(posicao);
		}
		
		tamanho++;
	}
	
	
	private void troca(int i, int j) {
		Node<T> aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}

	private int pai(int i) {
		return (i-1)/2;
	}
	
	public T remove() {
		
		if(tamanho == 0) return null;
		
		Node<T> temp = vetor[0];
		vetor[0] = vetor[tamanho-1];
		vetor[tamanho-1] = null;
		tamanho--;
		ajeitarHeap(0);
		return temp.valor;
	}
	
	
	private void ajeitarHeap(int index) {
		if(index >= tamanho) {
			return;
		}
		
		Node<T> maior = vetor[index];
		int posicao = index;
		
		if(filhoEsq(posicao) < tamanho && maior.prioridade <= vetor[filhoEsq(posicao)].prioridade) {
			maior = vetor[filhoEsq(posicao)];
			
			posicao = vetor[filhoEsq(posicao)].prioridade < vetor[filhoDir(posicao)].prioridade ? posicao : filhoEsq(posicao);
		}
		
		if(filhoDir(posicao) < tamanho && maior.prioridade <= vetor[filhoDir(posicao)].prioridade) {
			maior = vetor[filhoEsq(posicao)];
			posicao = filhoDir(posicao);
		}
		
		if(posicao != index) {
			troca(index, posicao);
			ajeitarHeap(posicao);
		}
		
	}
	
	
	

	private int filhoDir(int i) {
		return i*2+1;
	}
	
	private int filhoEsq(int i) {
		return i*2+2;
	}
	
	
	
	public String toString() {
		String saida = "[";
		
		for(int i = 0; i < tamanho;i++) {
			saida+=vetor[i]+", ";
		}
		
		saida = saida.length() > 2 ? saida.substring(0, saida.length()-2): saida;
		return saida+"]";
	}
}

class Node<T>{
	T valor;
	int prioridade;
	Node<T> next;
	
	public Node(T valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
		
	}
	
	public String toString() {
		return valor+"";
	}
	
}
