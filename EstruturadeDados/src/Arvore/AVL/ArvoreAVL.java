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
		if(atual.valor > valor && atual.getFilhoEsq() == null) {
			atual.filhoEsq = new Node(valor);
			return;
		}
		
		else if(atual.valor < valor && atual.getFilhoDir() == null) {
			atual.filhoDir = new Node(valor);
			return;
		}
		
		insercao(valor,atual.valor > valor ? atual.filhoEsq : atual.filhoDir);
		
		
		if(atual != null && Math.abs(atual.fatorBalanceamento) > 1) {
			balancear(atual);
		}
	}

	private void balancear(Node atual) {
		System.out.println("Entrou...");
		if(atual.fatorBalanceamento < 0) { //desbalanceado para A DIREITA
			RotacaoEsquerda(atual);
		}
	}

	private void RotacaoEsquerda(Node atual) {
		Node aux = atual.filhoDir.filhoEsq;
		atual.filhoDir.filhoEsq = atual;
		this.raiz = atual.filhoDir;
		atual.filhoDir = aux;
		
		//TODO Organizar o fator de balanceamento...
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
		if(raiz.filhoEsq != null) {
			emOrdem(raiz.filhoEsq);
		}
		
		saida += raiz.valor+" ";
		
		if(raiz.filhoDir != null) {
			emOrdem(raiz.filhoDir);
		}
	}
}
