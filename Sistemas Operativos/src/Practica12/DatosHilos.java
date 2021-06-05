package Practica12;

public class DatosHilos extends Thread{
	int tablaInicial, tablaFinal;
	String nombre;

	public DatosHilos(int tablaInicial, int tablaFinal, String nombre) {
		this.tablaInicial = tablaInicial;
		this.tablaFinal = tablaFinal;
		this.nombre = nombre;
	}


	public void run() {
		int tablasTotales = tablaFinal - tablaInicial + 1,i;
		Multiplicacione[] m = new Multiplicacione[tablasTotales];
		for(i=0;i<tablasTotales;i++) {
			m[i] = new Multiplicacione(tablaInicial, "Tabla " + tablaInicial);
			tablaInicial++;
			m[i].start();
		}
		for(i=0;i<m.length;i++) {
			try {
				m[i].join();
				}
			catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		System.out.println("Se terminó de ejecutar el hilo:" + nombre);
	}
}
