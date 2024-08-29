package recursividade.exercicios;

public class Comb {
	public static void main(String[] args) {
		System.out.println(combinacao(4,3));
	}
	
	public static int combinacao(int N, int K) {
		if(K == 1) return N;
		if(K== N) return 1;
		
		return combinacao(N-1, K-1)+combinacao(N-1, K);
	}
}
