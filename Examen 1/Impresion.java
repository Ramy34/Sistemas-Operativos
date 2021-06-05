public class Impresion extends Thread{
	int renglon, columna;
	int[][] matriz;
	
	public Impresion(int renglon, int columna, int[][] matriz) {
		super();
		this.renglon = renglon;
		this.columna = columna;
		this.matriz = matriz;
	}

	public void run() {
		int i,j;
		for(i=0;i<renglon;i++) {
			for(j=0;j<columna;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}	
}