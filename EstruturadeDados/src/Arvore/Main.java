package Arvore;

import Arvore.Busca.ArvoreBusca;

public class Main {
	public static void main(String[] args) {
		ArvoreBusca busca = new ArvoreBusca();
		
		busca.insercao(7);
		busca.insercao(5);
		busca.insercao(12);
		busca.insercao(2);
		busca.insercao(6);
		busca.insercao(9);
		busca.insercao(21);
		busca.insercao(19);
		busca.insercao(25);
		
		
		busca.print();
		System.out.println("\nEncontrou o valor: "+busca.pesquisa(6));
		System.out.println("\nEncontrou o valor: "+busca.pesquisa(20));
	
		busca.remocao(9);
		busca.print();
		System.out.println();
		busca.remocao(12);
		busca.print();
		
		
	}
}
