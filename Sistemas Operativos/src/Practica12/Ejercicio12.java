package Practica12;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) throws InterruptedException {
		int tablaInicial,tablaFinal,tmp;
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
		
		DatosHilos h1= new DatosHilos(tablaInicial, tablaFinal,"Tablas Join");
		
		h1.start();
		
		h1.join();
		
		System.out.println("Se terminó de ejecutar el main");
	}

}
