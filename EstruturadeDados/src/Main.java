import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			PilhaEstatica pilha = new PilhaEstatica();
			String expressao = input.nextLine();
			boolean correto = true;
			
			for(int i = 0; i < expressao.length();i++) {
				if(expressao.charAt(i) == '(') {
					pilha.push(expressao.charAt(i)+"");
				}
				
				if(expressao.charAt(i) == ')') {
					if(pilha.top().equals("(")) {
						pilha.pop();						
					}else {
						correto = false;
						break;
					}
				}
			}
			
			if(pilha.size() != 0) {
				correto = false;
			}
			
			String saida = correto ? "correct" : "incorrect";
			System.out.println(saida);
		}
	}
}

class PilhaEstatica {
	private String pilha[];
	private int topo;
	
	public PilhaEstatica() {
		pilha = new String[10];
	}
	
	public void push(String valor) {
		if(topo >= pilha.length-1) {
			atualizar();
		}
		
		pilha[topo++] = valor;
	}
	
	private void atualizar() {
		String newPilha[] = new String[pilha.length+10];
		
		for(int i = 0;i < pilha.length;i++) {
			newPilha[i] = pilha[i];
		}
		
		
		this.pilha = newPilha;
	}
	
	public void pop() {
		topo--;
	}
	
	public String top() {
		if(topo > 0) {
			return pilha[topo-1];			
		}
		
		return "";
	}
	
	public int size() {
		return topo;
	}
	
	public String toString() {
		String saida = "";
		
		for(int i = 0; i < pilha.length;i++) {
			saida+= pilha[i]+" ";
		}
		
		return saida;
	}
}
