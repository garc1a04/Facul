package Hash;

public class TabelaHash {
private ListaDinamica<Integer> vetor[];
	
	public TabelaHash(int N) {
		vetor = new ListaDinamica[N];
	}
	
	public void add(int valor) {
		int i = hash(valor);
		
		if(vetor[i] != null) {
			vetor[i].add(valor);
			return;
		}
		
		vetor[i] = new ListaDinamica<Integer>();
		vetor[i].add(valor);
	}
	
	private int hash(int valor) {
		return valor%vetor.length;
	}
	
	public void remocao(Integer valor) {
		int i = hash(valor);
		vetor[i].remove(valor);
		
		if(vetor[i].size() == 0) {
			vetor[i] = null;
		}
	}
	
	
	public String toString() {
		String saida = "";
		
		for(int i = 0; i < vetor.length;i++) {
			saida += vetor[i] == null ? i+" -> \\\n" :i+ " -> "+vetor[i]+"\n"; 
		}
		
		return saida+"";
	}
}
