package Practica11;

import java.io.*;
import java.util.*;

public class Ejercicio11{
	public static void main(String[] args) {
		int numeroSeries,i,incremento,parar;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cuantas series deseas: ");
		numeroSeries = teclado.nextInt();
		
		DatosHilos[] h = new DatosHilos[numeroSeries];
		int x[] = new int[numeroSeries];
		
		for (i=0; i < numeroSeries; i++){
			System.out.println("De cuanto quieres el incremento: ");
			incremento = teclado.nextInt();
			System.out.println("Donde quieres parar: ");
			parar = teclado.nextInt();
			h[i] = new DatosHilos (incremento, parar);
			}
		for (i=0;i<numeroSeries;i++) {
			h[i].start();
			}
		}
	}