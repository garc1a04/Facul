package Listas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ListaDinamicaOrdenada Godofor = new ListaDinamicaOrdenada();
		int repeticoes = input.nextInt();
		
		for(int i = 0; i < repeticoes;i++) {
			Godofor.add(new Deus(input.next(),input.nextInt(),input.nextInt(),input.nextInt()));	
		}
		
		System.out.println(Godofor.getPrimeiro());
	}
}

class ListaDinamicaOrdenada {

	private Node2 primeiro;
	private Node2 ultimo;
	private int tamanho;

	public void add(Deus valor) {
		Node2 novoNode = new Node2(valor);
		
		if(tamanho == 0) {
			primeiro = novoNode;
			ultimo = novoNode;
			
		} else if(primeiro.compare(valor) > 0) {
			novoNode.next = primeiro;
			primeiro = novoNode;
			
		} else if(primeiro.compare(valor) < 0) {
			ultimo.next = novoNode;
			ultimo = novoNode;
			
		} else {
			Node2 temp = primeiro;
			Node2 pre = temp.next;
			
			while(temp != null && temp.compare(valor) < 0) {
				pre = temp;
				temp = temp.next;
			}
			
			novoNode.next = pre.next;
			pre.next = novoNode;
		}
		
		tamanho++;
	}
	
	public String getPrimeiro() {
		return primeiro.valor.nome;
	}
	
	public String toString() {
		String saida = "[";
		Node2 temp = primeiro;
		
		while (temp != null) {
			saida += temp.valor + ", ";

			temp = temp.next;
		}
		
		if(saida.length() > 2)
			saida = saida.substring(0,saida.length()-2);
		
		return saida + "]";
	}
}
class Deus{
	String nome;
	int poder;
	int kills;
	int morte;
	
	public Deus(String nome, int poder,int kills, int morte) {
		this.nome = nome;
		this.poder = poder;
		this.kills = kills;
		this.morte = morte;
	}
}

/*
 O godofor deve ser o candidato mais poderoso, caso ocorra empate deverá ser o candidato 
 que mais matou outros deuses, caso ocorra empate novamente o escolhido será o candidato 
 que menos morreu, se mesmo assim o empate persistir o godofor será o candidato com o menor
 nome lexicograficamente.
 */

class Node2 {

	Deus valor;
	Node2 next;

	public Node2(Deus valor) {
		this.valor = valor;
	}

	public int compare(Deus valor2) {
		boolean comparador = valor.poder == valor2.poder ? true : false;
		int resultado = valor.poder < valor2.poder ? 1 : -1;
		
		if(comparador) {
			comparador = valor.kills == valor2.kills ? true : false;
			resultado = valor.kills < valor2.kills ? 1 : -1;
		} 
		if(comparador) {
			comparador = valor.morte == valor2.morte ? true : false;
			resultado = valor.morte > valor2.morte ? 1 : -1;
		}
		if(comparador) {
			resultado = valor.nome.compareTo(valor2.nome) > 0 ? 1 : -1;
		}
		
		return resultado;
	}
}