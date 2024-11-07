package recursividade;

public class TorreDeHanói {
	public static void main(String[] args) {
		torre(2,'A','C','B');
	}
	
	public static void torre(int N, char Orig,char dest,char aux) {
		if(N == 1) {
			MoveDisco(Orig,dest);
		}else {
			torre(N-1,Orig,aux,dest);
			MoveDisco(Orig,dest);
			torre(N-1,aux,dest,Orig);
		}
	}

	private static void MoveDisco(char Orig,char dest) {
		System.out.println("Movimento: "+Orig +"-> "+dest);
	}
}