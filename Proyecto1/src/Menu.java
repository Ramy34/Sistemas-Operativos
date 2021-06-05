import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		//Declaración de las variables a usar
		int i,idProceso,numeroProcesos,prioridad,tiempoLlegada,tiempoEjecucion,opc=0,quantum;
		boolean capacidad;
		String nombreProceso = "Proceso";
		float tamano=0,memoria;
		Planificador plan = new Planificador();
		Scanner teclado = new Scanner(System.in);
		
		//Pedir la cantidad de procesos
		System.out.println("¿Cuantos Procesos deseas crear: ");
		numeroProcesos = teclado.nextInt();
		
		Proceso[] p = new Proceso[numeroProcesos]; //Crea el arreglo de procesos
		teclado.nextLine();
		
		System.out.println("Dime el tamano de la memoria: ");
		memoria = teclado.nextFloat();
		teclado.nextLine();
		
		//Creacion de los procesos
		for(i=0; i<numeroProcesos;i++) {
			capacidad = true;
			System.out.println("¿Cual es el nombre del proceso " + (i+1) + "?");
			nombreProceso = teclado.nextLine();
			idProceso = i;
			System.out.println("¿Cual es la prioridad del proceso?");
			prioridad = teclado.nextInt();
			/*System.out.println("¿Cual es su tiempo de llegada?");
			tiempoLlegada = teclado.nextInt();*/
			System.out.println("¿Cual es su tiempo de ejecucion?");
			tiempoEjecucion = teclado.nextInt();
			while(capacidad) {
				System.out.println("¿De cuanto es su tamano?");
				tamano = teclado.nextFloat();
				teclado.nextLine();
				if(tamano <= memoria) {
					capacidad = false;
				}
				else {
					System.out.println("No se puede aceptar debido a que es mayor que el tamaño de la memoria");
				}
			}
			p[i] = new Proceso(idProceso, prioridad, /*tiempoLlegada*/0, tiempoEjecucion, nombreProceso, tamano);
		}
		
		//Elección del planificador
		while(opc != 3){
			System.out.println("Escoge una opción de planificacion\n");
			System.out.println("1)Round Robin.\n");
			System.out.println("2)Prioridad Apropiativo.\n");
			System.out.println("3)Salir");
			opc = teclado.nextInt();
			//teclado.nextLine();
			switch(opc) {
			case 1:
				System.out.println("¿De cuanto deseas el quantum?: ");
				quantum = teclado.nextInt();
				teclado.nextLine();
				plan.roundRobin(p, quantum, memoria, numeroProcesos);
				break;
			case 2:
				plan.prioridadAsociativo(p, memoria, numeroProcesos);
				break;
			case 3:
				System.out.println("Saliendo");
				break;
			}
		}
	}
}