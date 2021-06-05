public class Producto extends Thread{
	int[][] x,y,z;
	int renglonActual,columnaActual;
	int columnaAt;

	public Producto(int[][] x, int[][] y, int[][] z, int renglonActual, int columnaActual, int columnaAt){
		this.x = x;
		this.y = y;
		this.z = z;
		this.renglonActual = renglonActual;
		this.columnaActual = columnaActual;
		this.columnaAt = columnaAt;
	}
	
	public void run(){
		int k;
		for(k=0; k<columnaAt; k++){
			z[renglonActual][columnaActual] = z[renglonActual][columnaActual] + (x[renglonActual][k] * y[k][columnaActual]);
		}
		System.out.println("El valor de la matriz respuesta en [" + renglonActual +"][" + columnaActual + "] = " + z[renglonActual][columnaActual]);
	}
}