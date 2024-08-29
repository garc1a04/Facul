package recursividade.exercicios;

public class Ackerman {
	public static void main(String[] args) {
		System.out.println(Acker(1,2));
	}
	
	public static int Acker(int M, int N) {
		if(M == 0) return N+1;
		if(M > 0 && N == 0) return Acker(M-1,1);
		
		
		System.out.println(M + " " + N);
		return Acker(M-1,Acker(M,N-1));
	}
}
