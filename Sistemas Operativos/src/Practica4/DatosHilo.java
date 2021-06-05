package Practica4;

import java.util.*;
import java.io.*;
public class DatosHilo extends Thread{
	int retardo;
	public void run(){
		int retardo = (int)(Math.random()*2000);
		try{
		    sleep(retardo);	
		}
		catch (InterruptedException ex){
			System.out.println("Se genero una interrupcion");
		}
		
		System.out.println("Saludo soy: " + getName() + " despues de haber dormido: " + retardo);
	}
}