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
		
		if(atual.valor > valor && atual.filhoEsq == null) {
			atual.fatorBalanceamento+=1;
			atual.filhoEsq = new Node(valor);
			return;
		}
		
		else if(atual.valor < valor && atual.filhoDir == null) {
			atual.fatorBalanceamento-=1;
			atual.filhoDir = new Node(valor);
			return;
		} 
		
		insercao(valor,atual.valor > valor ? atual.filhoEsq: atual.filhoDir);
		
		FatorBalanceamento(atual);
	}

	private void FatorBalanceamento(Node atual) {
		if(atual.filhoDir != null && atual.filhoDir.fatorBalanceamento != 0) {
			atual.fatorBalanceamento-=1;
			
		} else if(atual.filhoEsq != null && atual.filhoEsq.fatorBalanceamento != 0) {
			atual.fatorBalanceamento+=1;
			
		}
		
		if(Math.abs(atual.fatorBalanceamento) > 1) {
			System.out.println("Valor desbalanceado: "+atual.valor+"\nFB(v) =" + atual.fatorBalanceamento);
			balancear(atual);
		}
	}
	
	//TODO Consertar para o desbalanceamento de outros nós(Funciona somente a raiz)
	private void balancear(Node atual) {

		if(atual.fatorBalanceamento < 0) {
			
			if(atual.filhoDir.fatorBalanceamento <= 0) {
				rotacaoEsquerda(atual);
				return;
			}
			
			rotacaoEsquerdaDupla(atual);
		} else if(atual.fatorBalanceamento > 0) {
			
			if(atual.filhoEsq.fatorBalanceamento >= 0) {
				rotacaoDireita(atual);
				return;
			}
			
			rotacaoDireitaDupla(atual);	
		}
	}
	
	private void rotacaoEsquerda(Node atual) {
		Node aux = atual.filhoDir.filhoEsq;
		trocarFator(atual,atual.filhoDir);
		atual.filhoDir.filhoEsq = atual;
		this.raiz = atual.filhoDir;
		atual.filhoDir = aux;
	}
	
	private void rotacaoDireita(Node atual) {
		
		Node aux = atual.filhoEsq.filhoDir;
		trocarFator(atual,atual.filhoEsq);
		atual.filhoEsq.filhoDir = atual;
		this.raiz = atual.filhoEsq;
		atual.filhoEsq = aux;
	}
	
	//FIXME ta tudo errado kkkkk
	private void trocarFator(Node atual, Node atualFilho) {
		if(atual.isEsq() && atualFilho == atual.filhoDir) {
			int aux =  atual.filhoEsq.fatorBalanceamento+1;
			atual.fatorBalanceamento = aux;
			atual.fatorBalanceamento += atualFilho.fatorBalanceamento;
			atualFilho.fatorBalanceamento+=aux;
			
			
		} else if(atual.isDir() && atualFilho == atual.filhoEsq) {
			int aux = atual.filhoDir.fatorBalanceamento-1;
			atual.fatorBalanceamento = aux;
			atual.fatorBalanceamento += atualFilho.fatorBalanceamento;
			atualFilho.fatorBalanceamento+=aux;
		}
	}
	
	private void rotacaoEsquerdaDupla(Node atual) {
		rotacaoDireita(atual.filhoDir);
		rotacaoEsquerda(atual);
	}

	private void rotacaoDireitaDupla(Node atual) {
		rotacaoEsquerda(atual.filhoEsq);
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
		saida += raiz.valor+"\nFB(v) ="+raiz.fatorBalanceamento+"\n";
		
		if(raiz.filhoEsq != null) {
			emOrdem(raiz.filhoEsq);
		}
		
		
		if(raiz.filhoDir != null) {
			emOrdem(raiz.filhoDir);
		}
	}
}
