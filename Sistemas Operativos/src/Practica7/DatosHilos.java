package Practica7;

public class DatosHilos extends Thread{
	int x;
	String nombre;
	public DatosHilos(int x,String nombre) {
		this.x = x;
		this.nombre = nombre;
	}
	
	public void run() {
		int y;
		System.out.println("Se imprimira la " + nombre);
		for(y=1;y<=10;y++) {
			System.out.println(nombre + " " + x + " * " + y + " = " + (x*y) );
		}
	}
}
