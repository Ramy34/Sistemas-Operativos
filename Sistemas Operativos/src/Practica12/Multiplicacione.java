package Practica12;

public class Multiplicacione extends Thread{
	int x;
	String nombre;

	public Multiplicacione(int x,String nombre) {
		this.x = x;
		this.nombre = nombre;
	}
	public void run() {
		int y;
		//System.out.println("Se imprimira la " + nombre);
		for(y=1;y<=10;y++) {
			System.out.println(x + " * " + y + " = " + (x*y) );
		}
		System.out.println("Se terminó de ejecutar :" + nombre);
	}
}