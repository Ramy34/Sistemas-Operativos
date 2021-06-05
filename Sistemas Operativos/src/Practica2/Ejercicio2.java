package Practica2;

public class Ejercicio2{
	public static void main(String[] args){
		DatosHilo hilo1, hilo2, hilo3 = new DatosHilo();
		hilo1 = new DatosHilo();
		hilo2 = new DatosHilo();
		hilo1.run();
		hilo2.run();
		hilo3.run();
	}
}