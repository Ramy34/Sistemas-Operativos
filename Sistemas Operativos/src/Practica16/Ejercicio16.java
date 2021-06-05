package Practica16;

import java.util.Scanner;

import Practica14.DatosHilos;

public class Ejercicio16 {

	public static void main(String[] args) {
		int tamanoArreglo,i;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame el tamaño de los arreglo: ");
		tamanoArreglo = teclado.nextInt();
		
		int a[] = new int[tamanoArreglo];
		int b[] = new int[tamanoArreglo];
		int c[] = new int[tamanoArreglo];
		
		DatosHilos h1 = new DatosHilos(tamanoArreglo,a);
		DatosHilos h2 = new DatosHilos(tamanoArreglo,b);
		Suma s = new Suma(tamanoArreglo,a,b,c);
		
		h1.start();
		h2.start();
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.start();
		try {
			s.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(i=0; i<tamanoArreglo; i++) {
			System.out.println("Arreglo A: " + a[i]);
		}
		
		for(i=0; i<tamanoArreglo; i++) {
			System.out.println("Arreglo B: " + b[i]);
		}
		
		for(i=0; i<tamanoArreglo; i++) {
			System.out.println("Arreglo C: " + c[i]);
		}
		
		
		
		

	}

}
