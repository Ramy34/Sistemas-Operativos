package Practica6;

public class DatosHilo extends Thread{
	public void run() {
		int x,y;
		for(x=1; x<=10; x++) {
			for(y=1; y<=10; y++) {
				System.out.println(getName() + " " + x + " * " + y + " = " + (x*y) );
			}
		}
	}

}
