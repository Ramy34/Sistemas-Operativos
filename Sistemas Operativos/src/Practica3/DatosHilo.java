package Practica3;

public class DatosHilo extends Thread{
	public void run(){
		int i;
		for (i=1;i<=100;i++){
			System.out.println(getName() + ": " + i);
		}
	}
}