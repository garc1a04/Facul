package Arvore.Busca;

public class ArvoreBusca {
	
	private Node raiz;
	
	public void insercao(int valor) {
		if(raiz == null) {
			raiz = new Node(valor);
			return;
		}
		
		
		insercao(valor,raiz);
	}
	
	private void insercao(int valor, Node atual) {
		if(atual.valor > valor) {
			if(atual.filhoEsq == null) {
				atual.filhoEsq = new Node(valor);
				return;
			}
			
			insercao(valor, atual.filhoEsq);
		}
		
		if(atual.valor < valor) {
			if(atual.filhoDir == null) {
				atual.filhoDir = new Node(valor);
				return;
			}
			
			insercao(valor, atual.filhoDir);
		}
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
		remocao(valor, raiz,null);
	}

	private void remocao(int valor, Node atual, Node pai) {
		if(atual.valor == valor) {
			
			 if(atual.isDir() && atual.isEsq()) {
				atual.valor = menor(atual.filhoDir);
				remocao(atual.valor,atual.filhoDir,atual);
				return;
			}
			 
			 //remoção de um filho ou sem filho...
			 pai = pai.filhoDir == atual ? pai.filhoDir = atual.filhoDir : (pai.filhoEsq = pai.filhoEsq == atual ? atual.filhoEsq : pai.filhoDir);
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

	public void print() {
		exibir(raiz);
	}
	
	private void exibir(Node raiz) {
		if(raiz.filhoEsq != null) {
			exibir(raiz.filhoEsq);
		}
		
		System.out.print(raiz.valor+" ");
		
		if(raiz.filhoDir != null) {
			exibir(raiz.filhoDir);
		}
	}
}

class Node{
	int valor;
	Node filhoDir;
	Node filhoEsq;
	
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