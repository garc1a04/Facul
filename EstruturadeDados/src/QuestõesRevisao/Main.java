package QuestõesRevisao;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			ListaDinamica2<String> texto = new ListaDinamica2<>();
			
			String nome[] = input.nextLine().split("");
			int contador = 0;
			
			for(int i = 0; i < nome.length;i++) {
				
				if(nome[i].equals("]")) {
					contador = texto.size();
				}
				
				if(nome[i].equals("[")) {
					contador = 0;
				}
				
				if((!nome[i].equals("]") && !nome[i].equals("["))) {
					texto.add(contador,nome[i]);
					contador++;
				}
				
			}
			
			System.out.println(texto);
		}
	}
}
class ListaDinamica2<T>{
	
	private Node2<T> primeiro;
	private Node2<T> ultimo;
	private int tamanho;
	
	public void add(int index, T valor) {
		Node2<T> novoNode = new Node2<>(valor);
		
		if(tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
		}
		
		if(index == 0) { //final da lista
			novoNode.next = primeiro;
			primeiro = novoNode;
			
		} else if(index == tamanho) {
			ultimo.next = novoNode;
			ultimo = novoNode;
			
		} else {
			Node2<T> temp = primeiro;
			
			for(int i = 0; i < index-1;i++) {
				temp = temp.next;
			}
			
			
			novoNode.next = temp.next;
			temp.next = novoNode;
		}
		
		tamanho++;
	}

	
	public int size() {
		return tamanho;
	}
	
	public String toString() {
		String saida = "";
		Node2<T> temp = primeiro;

		while (temp != null) {
			saida += temp.valor;
			temp = temp.next;
		}

		return saida;
	}
}

class Node2<T>{
	T valor;
	Node2<T> next;

	public Node2(T valor) {
		this.valor = valor;
	}
}