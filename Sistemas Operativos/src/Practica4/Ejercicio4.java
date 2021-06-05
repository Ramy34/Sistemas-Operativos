package Practica4;

public class Ejercicio4{
	public static void main(String[] args){
		DatosHilo hilo1, hilo2, hilo3 = new DatosHilo();
		hilo1 = new DatosHilo();
		hilo2 = new DatosHilo();
		hilo1.start(); //4000
		hilo2.start(); //2000
		hilo3.start(); //100
	}
}