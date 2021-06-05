public class Trasponer extends Thread{
	int renglon;
	int columna;
	int[][] matriz;
	int[][] matrizt;
	String nombre;
	
	public Trasponer(int renglon, int columna, int[][] matriz, int[][] matrizt,String nombre) {
		this.renglon = renglon;
		this.columna = columna;
		this.matriz = matriz;
		this.matrizt = matrizt;
		this.nombre = nombre;
	}
	
	public void run() {
		int i,num;
		for(i=0;i<columna;i++) {
			System.out.println(nombre + "[" + i + "]"+ "[" + renglon + "] = " + matriz[renglon][i]);
			matrizt[i][renglon] = matriz[renglon][i];	
		}
	}
}