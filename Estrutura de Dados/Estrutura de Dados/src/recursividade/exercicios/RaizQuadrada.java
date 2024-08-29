package recursividade.exercicios;

public class RaizQuadrada {
	public static void main(String[] args) {
		System.out.println(raizQuadrada(13, 3.2, 0.001));
	}
	
	public static double raizQuadrada(int x, double x0, double e) {
		if(Math.abs(Math.pow(x0, 2) - x) <= e) return x0;
		
		
		double conta =  (Math.pow(x0, 2) + x)/(2*x0);
		return raizQuadrada(x,conta, e);
	}
}
