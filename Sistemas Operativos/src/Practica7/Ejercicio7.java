package Practica7;

public class Ejercicio7 {

	public static void main(String[] args) {
		DatosHilos h1 = new DatosHilos(1,"Tabla 1");
		DatosHilos h2 = new DatosHilos(2,"Tabla 2");
		DatosHilos h3 = new DatosHilos(3,"Tabla 3");
		DatosHilos h4 = new DatosHilos(4,"Tabla 4");
		DatosHilos h5 = new DatosHilos(5,"Tabla 5");
		DatosHilos h6 = new DatosHilos(6,"Tabla 6");
		DatosHilos h7 = new DatosHilos(7,"Tabla 7");
		DatosHilos h8 = new DatosHilos(8,"Tabla 8");
		DatosHilos h9 = new DatosHilos(9,"Tabla 9");
		DatosHilos h10 = new DatosHilos(10,"Tabla 10");
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
		h8.start();
		h9.start();
		h10.start();

	}

}
