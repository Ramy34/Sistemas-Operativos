import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		int renA=0,renB=0,colA=0,colB=0,numeroHilos,i,j,k;
		int nombreHilo=0;
		boolean opc=true;
		Scanner teclado = new Scanner(System.in);
		
		//Pedimos los datos
		while(opc){
			System.out.println("Dame el tamano del renglon de la matriz A");
			renA = teclado.nextInt();
			System.out.println("Dame el tamano de la columna de la matriz A");
			colA = teclado.nextInt();
			System.out.println("Dame el tamano del renglon de la matriz b");
			renB = teclado.nextInt();
			System.out.println("Dame el tamano de la columna de la matriz A");
			colB = teclado.nextInt();
			if(renA == colB) {
				opc = false;
				System.out.println("Matrices validas");
			}
			else {
				System.out.println("Dimensión no valida");
			}
		}
		
		//Creacion de las matrices a llenar
		int matrizA[][] = new int[renA][colA];
		int matrizB[][] = new int[renA][colB];
		
		int matrizAt[][] = new int[colA][renA];
		int matrizBt[][] = new int[colB][renB];
		
		int matrizRespesta[][] = new int[colA][renB];

		//Definimos el numero de hilos a usar para el llenado
		numeroHilos = renA + renB;

		//Crea los hilos correspondientes para el llenado
		DatosHilos [] h = new DatosHilos[numeroHilos];
		
		//Se realiza la creación de los hilos para el llenado
		for(i=0;i<renA; i++) {
			h[i] = new DatosHilos(i,matrizA,colA,("Hilo " + nombreHilo + " A"));
			nombreHilo++;
		}
		for(j=0; j<renB; i++,j++) {
			h[i] = new DatosHilos(j,matrizB,colB,("Hilo " + nombreHilo + " B"));
			nombreHilo++;
		}

		//Llenamos las matrices 
		for(i=0;i<numeroHilos;i++) {
			h[i].start();
			}
		
		//Espera
		for(i=0;i<numeroHilos;i++) {
			try {
				h[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//Crea los hilos correspondientes para trasponer
		Trasponer [] t = new Trasponer[numeroHilos];
		
		//Se crean los hilos para la trasposición
		for(i=0;i<renA;i++) {
			t[i] = new Trasponer(i,colA,matrizA,matrizAt,("Hilo " + nombreHilo + " At"));
			nombreHilo++;
			}
		
		for(j=0; j<renB;j++,i++) {
			t[i] = new Trasponer(j,colB,matrizB,matrizBt,("Hilo " + nombreHilo + " Bt"));
			nombreHilo++;
			
			}
		
		//Ejecuta los hilos para trasponer
		for(k=0; k<numeroHilos; k++) {
			t[k].start();
			}
		
		//Espera
		for(k=0; k<numeroHilos; k++) {
			try {
				t[k].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Multiplicacion m = new Multiplicacion(matrizAt, matrizBt, matrizRespesta, renB, colA, nombreHilo, renA);

		m.multiplicacionMatriz();		
		
		//Impresión de matriz
		Impresion impA = new Impresion(renA,colA,matrizA);
		Impresion impAt = new Impresion(colA,renA,matrizAt);
		System.out.println("Matriz A");
		impA.start();
		
		try {
			impA.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Matriz At");
		impAt.start();
		try {
			impAt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();

		//Impresión de matriz
		Impresion impB = new Impresion(renB,colB,matrizB);
		Impresion impBt = new Impresion(colB,renB,matrizBt);
		System.out.println("Matriz B");
		impB.start();
		try {
			impB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Matriz Bt");
		impBt.start();
		try {
			impBt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Matriz Resultados");
		Impresion impRespuesta = new Impresion(renB, colA, matrizRespesta);
		impRespuesta.start();
		try {
			impRespuesta.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}