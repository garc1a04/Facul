package Arvore.AVL;

public class ArvoreAVL {
	private Node raiz;
	private String saida;
	
	class Node{
		int valor;
		int fatorBalanceamento;
		private Node filhoDir;
		private Node filhoEsq;
		
		
		public Node(int valor) {
			this.valor = valor;
		}
		
		public Node getFilhoDir() {
			
			this.fatorBalanceamento-=1;				
			return filhoDir;
		}
		
		public Node getFilhoEsq() {
			this.fatorBalanceamento+=1;				
			return filhoEsq;
		}
		
		public boolean isEsq() {
			return filhoEsq != null;
		}
		
		public boolean isDir() {
			return filhoDir != null;
		}
	}
	
	
	public ArvoreAVL() {
		raiz = null;
		saida = "";
	}
	
	public void insercao(int valor) {
		if(raiz == null) {
			raiz = new Node(valor);
			return;
		}
		
		insercao(valor,raiz);
	}
	
	private void insercao(int valor, Node atual) {
		
		//TODO refazer a implementação {NÃO POSSO USAR RECURSIVIDADE DE CAUDA...}
		
		if(atual.valor > valor && atual.filhoEsq == null) {
			atual.filhoEsq = new Node(valor);
			return;
		}
		
		else if(atual.valor < valor && atual.filhoDir == null) {
			atual.filhoDir = new Node(valor);
			return;
		}
		
		insercao(valor,atual.valor > valor ? atual.getFilhoEsq() : atual.getFilhoDir());
		
		
		
		if(atual != null && Math.abs(atual.fatorBalanceamento) > 1) {
			System.out.println("Valor desbalanceado: "+atual.valor+"\nFB(v) =" + atual.fatorBalanceamento);
			balancear(atual);
		}
	}

	private void balancear(Node atual) {
		System.out.println("Entrou...");
		if(atual.fatorBalanceamento < 0) { //desbalanceado para A DIREITA
			
			if(atual.filhoDir.fatorBalanceamento <= 0) {
				rotacaoEsquerda(atual);
				return;
			}
			
			
			rotacaoEsquerdaDupla(atual);
		} else if(atual.fatorBalanceamento > 0) { //desbalanceado para A ESQUERDA
			
			if(atual.filhoEsq.fatorBalanceamento >= 0) {
				rotacaoDireita(atual);				
			}
			
			rotacaoDireitaDupla(atual);	
		}
	}
	


	private void rotacaoEsquerda(Node atual) {
		Node aux = atual.filhoDir.filhoEsq;
		atual.filhoDir.filhoEsq = atual;
		this.raiz = atual.filhoDir;
		atual.filhoDir = aux;
		
		//TODO Organizar o fator de balanceamento...
	}
	
	private void rotacaoEsquerdaDupla(Node atual) {
		rotacaoDireita(atual);
		rotacaoEsquerda(atual);
	}
	
	private void rotacaoDireita(Node atual) {
		Node aux = atual.filhoEsq.filhoDir;
		atual.filhoEsq.filhoDir = atual;
		this.raiz = atual.filhoEsq;
		atual.filhoEsq = aux;
		
		//TODO Organizar o fator de balanceamento...
	}

	private void rotacaoDireitaDupla(Node atual) {
		rotacaoEsquerda(atual);
		rotacaoDireita(atual);		
	}
	
	public Integer pesquisa(int valor) {
		return pesquisa(valor, raiz);
	}
	
	private Integer pesquisa(int valor, Node atual) {
		if(atual.valor == valor) return atual.valor;
		
		if(atual.filhoDir != null && atual.valor > valor) {
			pesquisa(valor, atual.filhoDir);
		}
		
		if(atual.filhoEsq != null && atual.valor < valor) {
			pesquisa(valor, atual.filhoEsq);
		}
		
		return null;
	}
	
	
	public void remocao(int valor) {
		if(raiz == null) return;
		
		if(raiz.valor == valor && !(raiz.isDir() && raiz.isEsq())) {
			raiz = raiz.filhoDir != null ? raiz.filhoDir :  raiz.filhoEsq;	
			return;
		}
		
		remocao(valor, raiz,null);
	}

	private void remocao(int valor, Node atual, Node pai) {
		if(atual.valor == valor) {
			
			if(!(atual.isDir() && atual.isEsq())) { //Não pode ter dois filhos.
				 pai = pai.filhoDir == atual ? pai.filhoDir = atual.filhoDir : 
					 (pai.filhoEsq = pai.filhoEsq == atual ? atual.filhoEsq : null);
				 
				return;
			}
			 
			atual.valor = menor(atual.filhoDir);
			remocao(atual.valor,atual.filhoDir,atual);
		}
		
		if(atual.filhoDir != null && atual.valor < valor) {
			remocao(valor, atual.filhoDir, atual);
		}
		
		if(atual.filhoEsq != null && atual.valor > valor) {
			remocao(valor, atual.filhoEsq, atual);
		}
	}

	private int menor(Node raiz) {
		if(raiz.filhoEsq == null) return raiz.valor;
		
		return menor(raiz.filhoEsq);
	}
	
	
	public String toString() {
		saida = "";
		emOrdem(raiz);
		
		return saida.trim();
	}
	
	private void emOrdem(Node raiz) {
		saida += raiz.valor+" ";
		
		if(raiz.filhoEsq != null) {
			emOrdem(raiz.filhoEsq);
		}
		
		
		if(raiz.filhoDir != null) {
			emOrdem(raiz.filhoDir);
		}
	}
}
