public class ejercicio3{
	public static void main(String[] args){
		datosHilo hilo1, hilo2, hilo3 = new datosHilo();
		hilo1 = new datosHilo();
		hilo2 = new datosHilo();
		hilo1.run();
		hilo2.run();
		hilo3.run();
	}
}