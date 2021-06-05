package Practica13;

public class DatosHilos extends Thread{ 
	int tabla;
	
	public DatosHilos(int tabla) {
		this.tabla = tabla;
	}
	
	public void run() {
		int i;
		Producto[] p = new Producto[10];
		//Producto p;
		
		for(i=0; i<10;i++) {
			p[i] = new Producto(tabla,i+1);
			p[i].start();
		}
		for(i=0; i<10;i++) {
			try {
				p[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
