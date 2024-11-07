package Fila;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FilaDinamica<Integer> fila = new FilaDinamica<Integer>(); 
		FilaDinamica<Integer> filaSairam = new FilaDinamica<Integer>(); 
		
		int repeticoes = input.nextInt();
		for(int i = 0 ; i < repeticoes;i++) {
			fila.enqueue(input.nextInt());
		}
		
		
		repeticoes = input.nextInt();
		for(int i = 0 ; i < repeticoes;i++) {
			filaSairam.enqueue(input.nextInt());
		}
		
		int primeiro = fila.front();
		
		while(!filaSairam.isEmpty()) {
			
			
			if(!filaSairam.front().equals(fila.front()) ) {
				
				fila.enqueue(fila.dequeue());
			
			} else {
				fila.dequeue();
				
				if(filaSairam.front().equals(primeiro)) {
					primeiro = fila.front();
				} 
				
				filaSairam.dequeue();
			}
			
		}
		
		
		while(fila.front() != primeiro ) { 
			fila.enqueue(fila.dequeue()); 
		}
		
		System.out.println(fila);
	}
}