public class DatosHilos extends Thread{
	int renglon;
	int columna;
	int[][] matriz;
	String nombre;
	
	public DatosHilos(int renglon, int[][] matriz, int columna, String nombre) {
		this.renglon = renglon;
		this.matriz = matriz;
		this.columna = columna;
		this.nombre = nombre;
	}
	
	public void run() {
		int i,num;
		for(i=0;i<columna;i++) {
			num = (int)(Math.random()*10);
			System.out.println(nombre + "[" + renglon + "]"+ "[" + i + "] = " + num );
			matriz[renglon][i] = num;
			
		}
	}
	
}