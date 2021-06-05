package Practica5;

import java.util.*;
import java.io.*;
public class datosHilo extends Thread{
	
	int retardo;
	
	public datosHilo(int retardo){
		this.retardo = retardo;
	}

	public void run(){
		try{
		    sleep(retardo);	
		}
		catch (InterruptedException ex){
			System.out.println("Se genero una interrupcion");
		}
		
		System.out.println("Saludo soy: " + getName() + " despues de haber dormido: " + retardo);
	}
}