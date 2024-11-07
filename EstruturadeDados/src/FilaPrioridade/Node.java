package FilaPrioridade;

public class Node<T>{
	T valor;
	int prioridade;
	Node<T> next;
	
	public Node(T valor) {
		this.valor = valor;
	}
	
	public Node(T valor,int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
}
