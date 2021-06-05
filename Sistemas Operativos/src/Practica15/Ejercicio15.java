package Practica15;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		int tamanoArreglo=0,i,numeroHilos=0;
		boolean validacion = true;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame el tamaño del arreglo: ");
		tamanoArreglo = teclado.nextInt();
			
		System.out.println("Cuantos hilos deseas? ");
		numeroHilos = teclado.nextInt();
			
		if(tamanoArreglo < numeroHilos) {
			numeroHilos = tamanoArreglo;
			System.out.println("Como el numero de hilos es mayor que el tamaño de arreglo se trunca a que sea igual al tamaño del arreglo");
			}
		
		DatosHilos[] h = new DatosHilos[tamanoArreglo];
		int arr[] = new int[tamanoArreglo];
		
		
		for(i=0; i<numeroHilos; i++) {
			h[i] = new DatosHilos(tamanoArreglo,arr);
			h[i].start();
			}
		
		for(i=0; i<numeroHilos; i++) {
			try {
				h[i].join();
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println("Error");
			}
		}
		
		
		for(i=0; i<arr.length; i++) {
			System.out.println("El elemento " + (i+1) + " es: " + arr[i]);
		}
	}
}