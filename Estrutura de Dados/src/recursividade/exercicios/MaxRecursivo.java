package recursividade.exercicios;

public class MaxRecursivo {
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,10,7,8,9,2};
		
		System.out.println(maxValue(array,0));
	}
	
	public static int maxValue(int vetor[],int N) {
		if(N == vetor.length-1) {
			return vetor[N];
		} else {
			int valor = maxValue(vetor, N+1);
			
			if(valor < vetor[N]) {
				return vetor[N];
			} else {
				return valor;
			}
			
		}
		
	}
}
