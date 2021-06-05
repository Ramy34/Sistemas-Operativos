package Practica5;

public class Ejercicio5{
	public static void main(String[] args){
		datosHilo hilo1, hilo2, hilo3 = new datosHilo(100);
		hilo1 = new datosHilo(4000);
		hilo2 = new datosHilo(2000);
		hilo1.start(); //4000
		hilo2.start(); //2000
		hilo3.start(); //100
	}
}