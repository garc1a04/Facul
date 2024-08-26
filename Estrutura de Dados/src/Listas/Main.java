package Listas;


import Listas.Interface.Lista;
import Listas.Interface.ListaDinamica;
import Listas.Interface.ListaEstatica;

public class Main {
	public static void main(String[] args) {
		ListaEstatica<Integer> a = new ListaEstatica<>();
		
		a.add(2);
		a.add(3);
		a.add(10);
		a.add(20);
		a.add(2);
		
		System.out.println(a);
	}
}

class Produto{
	private int preco;
	private String nome;
	
	public Produto(String nome, int preco) {
		setNome(nome);
		setPreco(preco);
	}
	
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
