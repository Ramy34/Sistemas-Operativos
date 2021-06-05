package Practica14;

import java.util.Scanner;

public class Ejercicio14 {
	
	public static void main(String[] args){
		int tamanoArreglo,i;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame el tamaño del arreglo: ");
		tamanoArreglo = teclado.nextInt();
		
		int arr[] = new int[tamanoArreglo];
		DatosHilos h = new DatosHilos(tamanoArreglo,arr);
		
		h.start();
		try {
			h.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(i=0;i<arr.length;i++) {
			System.out.println("El elemento " + (i+1) + " es: " +arr[i]);
		}	
	}
}
