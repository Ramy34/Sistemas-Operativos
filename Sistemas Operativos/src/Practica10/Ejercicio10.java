package Practica10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		int numeroSeries,ciclo;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuantas series deseas");
		numeroSeries = teclado.nextInt();
		DatosHilos[] h = new DatosHilos[numeroSeries];
		for(ciclo = 0; ciclo < numeroSeries; ciclo++) {
			h[ciclo] = new DatosHilos( -(int)(Math.random()*20)-1 , (int)(Math.random()*20)+1 );
			h[ciclo].start();
			}
		}
	}