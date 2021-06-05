package Practica10;

public class DatosHilos extends Thread{
	int valorInicio, valorFinal;
	
	public DatosHilos(int valorInicio, int valorFinal) {
		this.valorInicio = valorInicio;
		this.valorFinal = valorFinal;
	}
	
	public void run() {
		int i;
		System.out.println(getName() + " La serie a imprimir sera de :" + valorInicio + " a " + valorFinal);
		for(i=valorInicio; i<=valorFinal; i++){
			System.out.println(getName() + " : " + i);
			}
		System.out.println(getName() + " he terminado.");
	}
}
