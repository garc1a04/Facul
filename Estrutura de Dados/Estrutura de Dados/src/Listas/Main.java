package Listas;

import Listas.Interface.Lista;

import java.util.LinkedList;

import Listas.Interface.ListaDinamica;

public class Main {
	public static void main(String[] args) {
		ListaDinamica<Integer> a = new ListaDinamica<>();
		//LinkedList<Integer> a = new LinkedList<>();
		System.out.println("-- Adicão --");
		a.add(6);
		a.add(3);
		a.add(8);
		a.add(7);
		a.add(0, 10);
		a.add(5, 20);
		
		
		System.out.println("Valor da lista: "+a);
		
		System.out.println("--- Remoção ---");
		
		a.remove();
		a.remove(2);
		
		System.out.println("Valor da lista: "+a);
	}
}