package Practica2;

public class DatosHilo extends Thread{
	public void run(){
		System.out.println("Prioridades de java: ");
		System.out.println("Minima: "+ MIN_PRIORITY + " Normal: " + NORM_PRIORITY + " Maxima: " + MAX_PRIORITY);
		System.out.println("Nombre: " + getName());
		System.out.println("Prioridad: " + getPriority());
	}
}