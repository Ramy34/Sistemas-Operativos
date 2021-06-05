package Practica3;

public class Ejercicio3{
	public static void main(String[] args){
		DatosHilo hilo1, hilo2, hilo3 = new DatosHilo();
		hilo1 = new DatosHilo();
		hilo2 = new DatosHilo();
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}