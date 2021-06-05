package Practica15;

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
		for(i=0; i<arr.length; i++) {
			if(arr[i] == 0 ) {
				arr[i] = (int)(Math.random()*100) + 1;
				//System.out.println("Entró :" + getName() + " y escribió el elemento: " + arr[i] + " en la posicion: " + (i+1));
			}
		}
	}
	
}
