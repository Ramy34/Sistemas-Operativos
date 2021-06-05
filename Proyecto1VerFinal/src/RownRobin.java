//package Simulador.SO;

import java.util.*;
import java.io.*;

public class RownRobin{

	public void simularProcesoRown(Proceso [] lista, int quantum, float memoria, int numProcesos ){
		System.out.println("\n\n\n\n\n\n\n\n\n\n"); //Limpiar pantalla
		Proceso[] colaListo = new Proceso[numeroProcesos]; //Cola para antes de subir el proceso a memoria
		Proceso[] colaEjecucion = new Proceso[numeroProcesos]; //Cola de procesos en memoria
		int i, tiempo, tiempoTotal=0, j=0, k=0;
		
		//Obtenemos el tiempo que se tardara en ejecutar todos los procesos
		for(i=0; i<lista.length; i++) {
			tiempoTotal = tiempoTotal + lista[i].getTiempoEjecucion();
		}	
		
		for(tiempo=0; tiempo<tiempoTotal; tiempo++) {
			for(i=0;i<lista.length;i++) { //Ciclo para agregar los procesos que entren en este instante de tiempo
				if(tiempo == lista[i].getTiempoLlegada()) { //Comparacion del tiempo actual con el tiempo en el que llega el proceso
					//Agrega el proceso a la cola de listo
					colaListo[j] = new Proceso(lista[i].getIdProceso(),lista[i].getPrioridad(),lista[i].getTiempoLlegada(),
							lista[i].getTiempoEjecucion(),lista[i].getNombreProceso(),lista[i].getTamano()); 
					j++;
					}
				}
			System.out.println("Listo para ejecutarse");
			impresionPantalla(colaListo,memoria); //Imprimimos para ver el contenido de la cola
			for(i=0; i<colaListo.length; i++) { //Ciclo para agregar los procesos que se van a ejecutar
				if(memoria >= colaListo[i].getTamano()) { //Compara el tamano del proceso a ejeutarse con el tamano disponible
					memoria = memoria - colaListo[i].getTamano(); //Disminuimos el tamano de la memoria
					//Agrega el proceseso a la cola de ejecucion
					colaEjecucion[k] = new Proceso(colaListo[i].getIdProceso(),colaListo[i].getPrioridad(),colaListo[i].getTiempoLlegada(),
							colaListo[i].getTiempoEjecucion(),colaListo[i].getNombreProceso(),colaListo[i].getTamano());
					k++;
					}
				else { //En caso de que no haya espacio se dira que no se agrego dicho proceso
					System.out.println("Espacio insificiente para agregar " + colaListo[i].getNombreProceso());
					}
				}
			System.out.println("En ejecución");
			impresionPantalla(colaEjecucion,memoria);//Muestra los procesos que se estan ejecutando
		}

	}

	public void impresionPantalla(Proceso[] cola, float memoria) { //Método para la impresión de cualquier cola
		System.out.println(cola.length);
		for(Proceso c : cola) {
			System.out.println("id: " + c.getIdProceso() + 
					" prioridad: " + c.getPrioridad() + 
					" tiempoLlegada: " + c.getTiempoLlegada() + 
					" tiempoEjecución: " + c.getTiempoEjecucion() + 
					" nombre: " + c.getNombreProceso() + 
					" tamano: " + c.getTamano());
			}
		System.out.println("Memoria Disponible: " + memoria);
		System.out.println("Terminé");
	}
}