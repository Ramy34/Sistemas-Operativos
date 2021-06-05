public class Multiplicacion {
	int[][] matrizAt;
	int[][] matrizBt;
	int[][] matrizRespuesta;
	int columna, renglon, nombre, columnaAt;

	public Multiplicacion(int[][] matrizAt, int[][] matrizBt, int[][] matrizRespuesta, int columna, int renglon, int nombreHilo, int columnaAt){
		this.matrizAt = matrizAt;
		this.matrizBt = matrizBt;
		this.matrizRespuesta = matrizRespuesta;
		this.columna = columna;
		this.renglon = renglon;
		this.nombre = nombre;
		this.columnaAt = columnaAt;
	}

	public void multiplicacionMatriz(){
		int i, j, aux=0, numeroHilos =renglon * columna;

		Producto p[] = new Producto[numeroHilos];


		for(i=0; i<renglon; i++){
			for(j=0; j<columna; j++){
				p[aux] = new Producto(matrizAt, matrizBt, matrizRespuesta, i, j, columnaAt);
				aux ++;
			}
		}

		for(i=0; i<numeroHilos; i++){
			p[i].start();
		}

		for(i=0;i<numeroHilos;i++){
			try {
				p[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}