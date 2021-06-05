package Practica16;

public class Suma extends Thread{
	int tamanoArreglo;
	int [] a,b,c;
	
	public Suma(int tamanoArreglo,int [] a,int [] b, int [] c) {
		this.tamanoArreglo = tamanoArreglo;
		this.a = new int[tamanoArreglo];
		this.a = a;
		this.b = new int[tamanoArreglo];
		this.b = b;
		this.c = new int[tamanoArreglo];
		this.c = c;
	}
	
	public void run() {
		int i;
		for(i=0; i<tamanoArreglo;i++) {
			c[i] = a[i] + b[i];
		}
	}
}
