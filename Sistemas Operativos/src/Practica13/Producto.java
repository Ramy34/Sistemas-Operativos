package Practica13;

public class Producto extends Thread{
	int x,y;

	public Producto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void run() {
		System.out.println(x + " * " + y +" = " + (x*y));
		System.out.println("Se terminó de ejecutar :" /*+ nombre*/);
	}
	
	
	
}
