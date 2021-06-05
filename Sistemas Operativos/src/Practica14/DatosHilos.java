package Practica14;

public class DatosHilos extends Thread{
	int tamanoArreglo;
	int [] arr;
	
	public DatosHilos(int tamanoArreglo,int [] arr) {
		this.tamanoArreglo = tamanoArreglo;
		this.arr = new int[tamanoArreglo];
		this.arr = arr;
	}

	public void run() {
		int i;
		for(i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*20);
		}
	}
}
