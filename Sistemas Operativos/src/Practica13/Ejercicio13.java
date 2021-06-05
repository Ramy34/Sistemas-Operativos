package Practica13;

import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		
		int tablaInicial,tablaFinal,tmp,i;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Desde que tabla quieres iniciar: ");
		tablaInicial = teclado.nextInt();
		System.out.println("En que tabla quieres terminar: ");
		tablaFinal = teclado.nextInt();
		
		if(tablaInicial > tablaFinal) {
			System.out.println("Entré");
			tmp = tablaFinal;
			tablaFinal = tablaInicial;
			tablaInicial = tmp;
		}
		
		DatosHilos[] h=new DatosHilos[tablaFinal-tablaInicial+1];
		
		for(i=0;i<h.length;i++) {
			h[i]=new DatosHilos(tablaInicial);
			h[i].start();
		}
		
		for(i=0;i<h.length;i++) {
			try {
				h[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Se terminó de ejecutar el main");
	}
}