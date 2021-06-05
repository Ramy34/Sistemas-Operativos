//package Simulador.SO;

import java.io.*;
import java.util.*; 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.StringTokenizer;
import java.util.Scanner;


public class SimuladorMejorado{ 

	SimuladorMejorado(){}

	public static void main(String[] args) {
		int /*i,*/idProceso,numeroProcesos,prioridad,tiempoLlegada,tiempoEjecucion;
		String nombreProceso = "Proceso";
		float tamanio=0 ,memoria; 
		int opc=5; 
		int d=0;
		SimuladorMejorado s= new SimuladorMejorado();
		RownRobin r=new RownRobin();
		//Apropiativo a= new Apropiativo();
		//Multi_planificador m = new Multi_planificador();
		Scanner teclado = new Scanner(System.in);


		System.out.println("Cuantos procesos quieres crear");
		numeroProcesos= teclado.nextInt();

		Proceso[] p=new Proceso(numeroProcesos);
		teclado.nextInt();

		do{
			System.out.println("\n------------------------------Bienvenido------------------------------\n");
			System.out.println("---Con este simulador prodras visualizar los planificadores Rown Robin--\n");
			System.out.println("---y planificador por prioridades apropitativo y tendras la opcion de---\n");
			System.out.println("-----crear tus propios procesos especificando los siguientes datos------\n");
			System.out.println("---A) Id del proceso");
			System.out.println("---B) Nombre del proceso");
			System.out.println("---C) Tamanio del proceso");
			System.out.println("---D) Tiempo para su ejecucion");
			System.out.println("---E) Prioridad del proceso");
			System.out.println("---F) Tiempo requerido para operaciones E/S");
			System.out.println("---G) Tiempo de llegada del proceso");
			System.out.println("---Recuerda que crearas proceso por proceso, asi que depende de ti cuantos ceraras...");
			System.out.println("\n------------------------Planificador de memoria-------------------------\n");
			System.out.println("-------Puedes simular con las siguientes opciones de Planificador-------\n");
			System.out.println("\t1) Planificador Rown Robin\n");
			System.out.println("\t2) Planificador por prioridades apropiativo\n");
			System.out.println("\t3) Ambos Planificadores\n");
			System.out.println("\t4) Salir");

			opc= teclado.nextInt(); 

			switch(opc){

				case 1 : 
					System.out.println("Ocuparas un planificador Rown Robin");
					int quantum; 
					int i 
					
					for(int i=0 ; i<=numeroProcesos; i++){
						try{
						System.out.println("¿Cual es el nombre del proceso?");
						nombreProceso = teclado.nextLine();
						idProceso = i;
						System.out.println("¿Cual es la prioridad del proceso?");
						prioridad = teclado.nextInt();
						System.out.println("¿Cual es su tiempo de llegada?");
						tiempoLlegada = teclado.nextInt();
						System.out.println("¿Cual es su tiempo de ejecucion?");
						tiempoEjecucion = teclado.nextInt();
						System.out.println("¿De cuanto es su tamanio?");
						tamanio = teclado.nextFloat();
						teclado.nextLine();		
						p[i] = new Proceso(idProceso, nombreProceso, tamanio, tiempoEjecucion, prioridad, /*tiempoES*/ tiempoLlegada);
						
						System.out.println("Dame el tamaño de la memoria: ");
						memoria=teclado.nextFloat();	

						System.out.println("¿De cuanto tiempo quieres el quantum?");
						quantum=teclado.nextInt();
						teclado=nextLine();
						
						}catch( IOException ioe ){
							System.out.println("Error al leer de teclado\n" + ioe);
							ioe.printStackTrace();
						}
					}
					r.simularProcesoRown(p,quantum,memoria,numeroProcesos);
					break; 

				case 2: 
					System.out.println("Elegiste un planificador de prioridades apropiativo");
					int d;
					System.out.println("Cuantos procesos quieres crear");
					d= teclado.nextInt();
					for(int i=0 ; i<=d ; i++){
						try{
						BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
						System.out.println("Dame el id del proceso:\t\n");
						String id =br.readline();
						p.setId(id);
						System.out.println("Que nombre le pondras a tu proceso:\t\n");
						String nombre =br.readline();
						p.setNombre(nombre);
						System.out.println("Dame el Tamanio del proceso: \t\n");
						String tamanio =br.readline();
						p.setTamanio(tamanio);
						System.out.println("Dame el tiempo de ejecucion del proceso\t\n");
						String tiempo =br.readline();
						p.setTiempo(tiempo);
						System.out.println("Dame la prioridad del proceso\t\n");
						String priori =br.readline();
						p.setPrioridad(priori);
						System.out.println("Dame el tiempo E/S del proceso\t\n");
						String tiempoES =br.readline();
						p.setTimeES(tiempoES);
						System.out.println("Dame tiempo de llegada del proceso\t\n");
						String tiempoLlegada =br.readline();
						p.setTiempoLlegada(tiempoLlegada);
									
						}catch( IOException ioe ){
							System.out.println("Error al leer de teclado\n" + ioe);
							ioe.printStackTrace();
						}
					}
					//a.simularProcesoApropia(p);
					break;

				case 3: 
					System.out.println("Simulador multi_planificador");
					int d;
					System.out.println("Cuantos procesos quieres crear");
					d= teclado.nextInt();
					for(int i=0 ; i<=d ; i++){
						try{
						BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
						System.out.println("Dame el id del proceso:\t\n");
						String id =br.readline();
						p.setId(id);
						System.out.println("Que nombre le pondras a tu proceso:\t\n");
						String nombre =br.readline();
						p.setNombre(nombre);
						System.out.println("Dame el Tamanio del proceso: \t\n");
						String tamanio =br.readline();
						p.setTamanio(tamanio);
						System.out.println("Dame el tiempo de ejecucion del proceso\t\n");
						String tiempo =br.readline();
						p.setTiempo(tiempo);
						System.out.println("Dame la prioridad del proceso\t\n");
						String priori =br.readline();
						p.setPrioridad(priori);
						System.out.println("Dame el tiempo E/S del proceso\t\n");
						String tiempoES =br.readline();
						p.setTimeES(tiempoES);
						System.out.println("Dame tiempo de llegada del proceso\t\n");
						String tiempoLlegada =br.readline();
						p.setTiempoLlegada(tiempoLlegada);
									
						}catch( IOException ioe ){
							System.out.println("Error al leer de teclado\n" + ioe);
							ioe.printStackTrace();
						}
					}
					//m.simularMulti(p);
					break; 

				case 4: 
					System.exit(0);
					break; 

				default: 
					System.out.println("ERROR: LA OPCION ELEGIDA ESTA FUERA DEL RANGO QUE SE ESPECIFICO\n");
					break;
			}
		}while(opc < 5);		
	}
}
