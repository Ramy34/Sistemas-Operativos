import java.util.ArrayList;
import java.util.List;

public class Planificador {
	
	public void roundRobin(Proceso[] lista, int quantum, float memoria,int numeroProcesos) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n"); //Limpiar pantalla
		Proceso[] colaListo = new Proceso[numeroProcesos]; //Cola para antes de subir el proceso a memoria
		Proceso[] colaEjecucion = new Proceso[numeroProcesos]; //Cola de procesos en memoria
		int i, tiempo, tiempoTotal=0, j=0, k=0,tiempoEjecutado=0;
		Proceso ejecucion = null;
		int[] tmp = new int[numeroProcesos];
		int[] tmp2 = new int[numeroProcesos];
		int[] tiemposEspera = new int[numeroProcesos];
		int[] tiemposRespuesta = new int[numeroProcesos];
		int[] tiemposEjecucion = new int[numeroProcesos];
		
		
		//Inicializando las colas
		for(i=0; i<numeroProcesos; i++) {
			colaListo[i] = inicializandoCola();
			colaEjecucion[i] = inicializandoCola();
		}
		
		//Obtenemos el tiempo que se tardara en ejecutar todos los procesos
		for(i=0; i<lista.length; i++) {
			tiempoTotal = tiempoTotal + lista[i].getTiempoEjecucion();
		}
		
		for(tiempo=0; tiempo<=tiempoTotal; tiempo++) {
			for(i=0; i<lista.length; i++) { //Ciclo para agregar los procesos que entren en este instante de tiempo
				if(tiempo == lista[i].getTiempoLlegada()) { //Comparacion del tiempo actual con el tiempo en el que llega el proceso
					//Agrega el proceso a la cola de listo
					colaListo[j] = new Proceso(lista[i].getIdProceso(),lista[i].getPrioridad(),lista[i].getTiempoLlegada(),
							lista[i].getTiempoEjecucion(),lista[i].getNombreProceso(),lista[i].getTamano());
					j++;
					}
				}
			System.out.println("Listo para subir a memoria");
			impresionPantalla(colaListo,memoria,tiempo); //Imprimimos para ver el contenido de la cola
			
			for(i=0; i<colaListo.length; i++) { //Ciclo para agregar los procesos que se van a ejecutar
				if(memoria >= colaListo[i].getTamano()) { //Compara el tamano del proceso a ejeutarse con el tamano disponible
					memoria = memoria - colaListo[i].getTamano(); //Disminuimos el tamano de la memoria
					//Agrega el proceseso a la cola de ejecucion
					colaEjecucion[k] = colaListo[0];
					k++;
					for(int h=0; h< colaListo.length; h++) {
						if(h == (colaListo.length - 1)) {
							colaListo[h] = inicializandoCola();
							j--;
						}
						else {
							colaListo[h] = colaListo[h+1];	
							}
						}
					}
				else { //En caso de que no haya espacio se dira que no se agrego dicho proceso
					if(colaListo[i].getNombreProceso() != "Vacio") {
						System.out.println("Espacio insificiente para agregar " + colaListo[i].getNombreProceso());
						i = colaListo.length-1;
						}
					}
				}
			System.out.println("Listos para ejecutarse");
			impresionPantalla(colaEjecucion,memoria,tiempo);//Muestra los procesos que están listos para ejecutarse
			
			if(colaEjecucion[0].getNombreProceso() != "Vacio" || ejecucion != null) { //Valida que el primer elemento de la cola para ejecutar exista o que no haya algo en ejecucion
				if(ejecucion == null) { //Revisa que no haya algo en ejecucion
					ejecucion = colaEjecucion[0]; //El primer proceso que esté en la cola pasa a ser ejecutado
					tiempoEjecutado = 0; //inicializamos su contador
					if(tmp2[ejecucion.getIdProceso()] == 0) { //Para obtener los tiempos de respuestas
						tiemposRespuesta[ejecucion.getIdProceso()] = tiempo;
						tmp2[ejecucion.getIdProceso()] = 1;
					}
					for(i=0; i< colaEjecucion.length; i++) { //Recorre los procesos
						if(i == (colaEjecucion.length - 1)) {
							colaEjecucion[i] = inicializandoCola();
							k--;
						}
						else {
							colaEjecucion[i] = colaEjecucion[i+1];	
							}
					}
					if(quantum >= ejecucion.getTiempoEjecucion()) { //Para obtener los tiempos de espera
						tiemposEspera[ejecucion.getIdProceso()] = tiempo; 
					}
					else {
						tmp[ejecucion.getIdProceso()] = quantum + tmp[ejecucion.getIdProceso()];
					}
				}
				ejecucion.setTiempoEjecucion(ejecucion.getTiempoEjecucion() - 1); //reduce el tiempo de ejecucion del proceso
				System.out.println(ejecucion.getNombreProceso() + " en ejecucion: " + ejecucion.getTiempoEjecucion() +"[ms]"); //imprime informacion sobre el proceso que se está ejecutando
				tiempoEjecutado ++; //incrementa su contador
				if(ejecucion.getTiempoEjecucion() == 0) { //Revisa si el procese se terminó de ejecutar
					memoria = memoria + ejecucion.getTamano(); //Librera la memoria
					System.out.println("Se liberó memoria, la cantidad actual es de: " + memoria);
					tiemposEjecucion[ejecucion.getIdProceso()] = tiempo + 1; //Para obtener los tiempos de ejecucion
					ejecucion = null; //Libera la "CPU"
					}
				else {
					if(quantum == tiempoEjecutado) { //Revisa si todavia tiene tiempo para continuar ejecutando ese proceso
						memoria = memoria + ejecucion.getTamano(); //Libera memoria
						System.out.println("Se liberó memoria, la cantidad actual es de: " + memoria);
						colaListo[j] = ejecucion; //Agrega el proceso a la cola de listo
						j++; //Mueve el indice de la cola listo
						ejecucion = null;//Libera la "CPU"
					}	
				}
			}
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
		}
		//Imprime los resultados
		resultadoEjecucion(tiemposEjecucion,lista);
		resultadoEspera(tiemposEspera,lista,tmp);
		resultadoRespuesta(tiemposRespuesta,lista);
	}
	
	public void resultadoEjecucion(int[] vector,Proceso[] lista) {
		int i;
		float respuesta=0;
		for(i=0; i < vector.length;i++) {
			System.out.println("numero :" + (i+1) +" : " + vector[i]);
			respuesta = (vector[i] - lista[i].getTiempoLlegada() + respuesta);
		}
		System.out.println("El tiempo de ejecución promedio es de: " + (float) (respuesta / lista.length) + "[ms]");
	}
	
	public void resultadoEspera(int[] vector, Proceso[] lista, int[] tmp) {
		int i;
		float respuesta=0;
		for(i=0;i<lista.length;i++) {
			System.out.println("numero :" + (i+1) +" : " + vector[i] + " ->  tiempo ejecutado: " +tmp[i]);
			respuesta = (vector[i] - tmp[i] -lista[i].getTiempoLlegada()) + respuesta;
		}
		System.out.println("El tiempo de espera promedio es de: " + (float) (respuesta / lista.length) + "[ms]");
	}
	
	public void resultadoRespuesta(int[] vector, Proceso[] lista) {
		int i;
		float respuesta=0; 
		for (i=0;i<lista.length;i++) {
			System.out.println("numero :" + (i+1) +" : " + vector[i]);
			respuesta = (vector[i] - lista[i].getTiempoLlegada()) + respuesta;
		}
		System.out.println("El tiempo de respuesta promedio es de: " + (float) (respuesta / lista.length) + "[ms]");
		
	}
	
	public void impresionPantalla(Proceso[] cola, float memoria,int tiempo) { //Método para la impresión de cualquiera de las colas
		System.out.println("Memoria Disponible: " + memoria + "\nTiempo: " + tiempo);
		int i=0;
		for(Proceso c : cola) {
			if (cola[i].getNombreProceso() != "Vacio") {
				System.out.println("id: " + c.getIdProceso() +
						" nombre: " + c.getNombreProceso() +
						" prioridad: " + c.getPrioridad() + 
						" tiempoLlegada: " + c.getTiempoLlegada() + 
						" tiempoEjecución: " + c.getTiempoEjecucion() + 
						" tamano: " + c.getTamano());
				i++;
				}
			}
	}

	public Proceso inicializandoCola() {
		Proceso p = new Proceso(999999999, -1, 999999, 99999999, "Vacio", 9999999);
		return p;
		}
	
	public void prioridadAsociativo(Proceso[] lista, float memoria,int numeroProcesos) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n"); //Limpiar pantalla
		Proceso[] colaListo = new Proceso[numeroProcesos]; //Cola para antes de subir el proceso a memoria
		Proceso[] colaEjecucion = new Proceso[numeroProcesos]; //Cola de procesos en memoria
		int i, tiempo, tiempoTotal=0, j=0, k=0,tiempoEjecutado=0,l=0;
		Proceso ejecucion = null;
		Proceso temp = null;
		Proceso copia = null;
		int[] tmp = new int[numeroProcesos];
		int[] tmp2 = new int[numeroProcesos];
		int[] tiemposEspera = new int[numeroProcesos];
		int[] tiemposRespuesta = new int[numeroProcesos];
		int[] tiemposEjecucion = new int[numeroProcesos];
		
		//Inicializando las colas
		for(i=0; i<numeroProcesos; i++) {
			colaListo[i] = inicializandoCola();
			colaEjecucion[i] = inicializandoCola();
		}
		
		//Obtenemos el tiempo que se tardara en ejecutar todos los procesos
		for(i=0; i<lista.length; i++) {
			tiempoTotal = tiempoTotal + lista[i].getTiempoEjecucion();
		}
		
		for(tiempo=0; tiempo<=tiempoTotal; tiempo++) {
			for(i=0; i<lista.length; i++) { //Ciclo para agregar los procesos que entren en este instante de tiempo
				if(tiempo == lista[i].getTiempoLlegada()) { //Comparacion del tiempo actual con el tiempo en el que llega el proceso
					//Agrega el proceso a la cola de listo
					if (colaListo[0].getNombreProceso() == "Vacio") {
						colaListo[0] = lista[i];
						j=1;
					}
					else {
						copia = lista[i];
						for(l=0; l < colaListo.length; l++) {
							if(copia.getPrioridad() > colaListo[l].getPrioridad()) {
								temp = colaListo[l];
								colaListo[l] = copia;
								copia = temp;
							}
							}
						j++;
						}
					}
				}
			System.out.println("Listo para subir a memoria");
			impresionPantalla(colaListo,memoria,tiempo); //Imprimimos para ver el contenido de la cola
			
			for(i=0; i < numeroProcesos; i++) { //Ciclo para agregar los procesos que se van a ejecutar
				if(memoria >= colaListo[0].getTamano()) { //Compara el tamano del proceso a ejeutarse con el tamano disponible
					memoria = memoria - colaListo[0].getTamano(); //Disminuimos el tamano de la memoria
					System.out.println("Se disminuyó la memoria después de agregar a: " + colaListo[0].getNombreProceso() + " La memoria actual es de: " + memoria);
					//Agrega el proceseso a la cola de ejecucion de manera directa si no hay nada en cpu
					if(colaEjecucion[0].getNombreProceso() == "Vacio") {
						colaEjecucion[0] = colaListo[0];
						k = 1;
					}
					else {
						copia = colaListo[0];
						for(l=0; l < colaEjecucion.length; l++) {
							if(copia.getPrioridad() > colaEjecucion[l].getPrioridad() || colaEjecucion[l].getNombreProceso() == "Vacio") {
								temp = colaEjecucion[l];
								colaEjecucion[l] = copia;
								copia = temp;
								}
							}
						k++;
						}
					for(int h=0; h< colaListo.length; h++) {
						if(h == (colaListo.length - 1)) {
							colaListo[h] = inicializandoCola();
							j--;
							}
						else {
							colaListo[h] = colaListo[h+1];	
							}
						}
					}
				else {
					if(colaListo[i].getNombreProceso() != "Vacio") {
						System.out.println("Espacio insificiente para agregar " + colaListo[i].getNombreProceso());
						i = colaListo.length - 1;
						}
					}
				}
			System.out.println("Listos para ejecutarse");
			impresionPantalla(colaEjecucion,memoria,tiempo);//Muestra los procesos que se estan ejecutando
			
			
			//Comienza la ejecucion del proceso
			if(colaEjecucion[0].getNombreProceso() != "Vacio" || ejecucion != null) { //Valida que el primer elemento de la cola para ejecutar exista o que no haya algo en ejecucion
				if(ejecucion == null) { //Revisa que no haya algo en ejecucion
					ejecucion = colaEjecucion[0]; //El primer proceso que esté en la cola pasa a ser ejecutado
					tiempoEjecutado = 0; //inicializamos su contador
					for(i=0; i< colaEjecucion.length; i++) { //Recorre los procesos
						if(i == (colaEjecucion.length - 1)) {
							colaEjecucion[i] = inicializandoCola();
							k--;
						}
						else {
							colaEjecucion[i] = colaEjecucion[i+1];	
							}
					}
					tiemposEspera[ejecucion.getIdProceso()] = tiempo; 
					tmp[ejecucion.getIdProceso()] = tiempoEjecutado + tmp[ejecucion.getIdProceso()];
					
					if(tmp2[ejecucion.getIdProceso()] == 0) { //Para obtener los tiempos de respuestas
						tiemposRespuesta[ejecucion.getIdProceso()] = tiempo;
						tmp2[ejecucion.getIdProceso()] = 1;
					}
				}
				else {
					if(colaEjecucion[0].getPrioridad() > ejecucion.getPrioridad()) {
						tmp[ejecucion.getIdProceso()] = tiempoEjecutado + tmp[ejecucion.getIdProceso()];
						
						copia = ejecucion;
						ejecucion = colaEjecucion[0];
						tiempoEjecutado = 0; //inicializamos su contador
						
						tiemposEspera[ejecucion.getIdProceso()] = tiempo; 
						
						if(tmp2[ejecucion.getIdProceso()] == 0) { //Para obtener los tiempos de respuestas
							tiemposRespuesta[ejecucion.getIdProceso()] = tiempo;
							tmp2[ejecucion.getIdProceso()] = 1;
						}
						for(int h=0; h< colaEjecucion.length; h++) {
							if(h == (colaEjecucion.length - 1)) {
								colaEjecucion[h] = inicializandoCola();
								j--;
								}
							else {
								colaEjecucion[h] = colaEjecucion[h+1];	
								}
							}
						
						
						//Volvemos a formar el proceso a la cola de listo
						if (colaListo[0].getNombreProceso() == "Vacio") {
							colaListo[0] = copia;
							j=1;
						}
						else {
							for(l=0; l < colaListo.length; l++) {
								if(copia.getPrioridad() > colaListo[l].getPrioridad()) {
									temp = colaListo[l];
									colaListo[l] = copia;
									copia = temp;
								}
								}
							j++;
							}
						//Intentamos formar el proceso en la cola para ejecutar
						if(memoria >= colaListo[0].getTamano()) { //Compara el tamano del proceso a ejeutarse con el tamano disponible
							memoria = memoria - colaListo[0].getTamano(); //Disminuimos el tamano de la memoria
							//Agrega el proceseso a la cola de ejecucion
							if(colaEjecucion[0].getNombreProceso() == "Vacio") {
								colaEjecucion[0] = colaListo[0];
								k = 1;
							}
							else {
								copia = colaListo[0];
								for(l=0; l < colaEjecucion.length; l++) {
									if(copia.getPrioridad() > colaEjecucion[l].getPrioridad()) {
										temp = colaEjecucion[l];
										colaEjecucion[l] = copia;
										copia = temp;
										}
									}
								k++;
								
								
								
								for(int h=0; h< colaListo.length; h++) {
									if(h == (colaListo.length - 1)) {
										colaListo[h] = inicializandoCola();
										j--;
										}
									else {
										colaListo[h] = colaListo[h+1];	
										}
									}
								}
							}
						}
					}
				ejecucion.setTiempoEjecucion(ejecucion.getTiempoEjecucion() - 1); //reduce el tiempo de ejecucion del proceso
				System.out.println(ejecucion.getNombreProceso() + " en ejecucion: " + ejecucion.getTiempoEjecucion() +"[ms]"); //imprime informacion sobre el proceso que se está ejecutando
				tiempoEjecutado ++; //incrementa su contador
				if(ejecucion.getTiempoEjecucion() == 0) { //Revisa si el proceso se terminó de ejecutar
					memoria = memoria + ejecucion.getTamano(); //Librera la memoria
					System.out.println("Se liberó memoria, la cantidad actual es de: " + memoria);
					tiemposEjecucion[ejecucion.getIdProceso()] = tiempo + 1; //Para obtener los tiempos de ejecucion
					ejecucion = null; //Libera la "CPU"
					}
				}
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			}
		//Imprime los resultados
				resultadoEjecucion(tiemposEjecucion,lista);
				resultadoEspera(tiemposEspera,lista,tmp);
				resultadoRespuesta(tiemposRespuesta,lista);
		}
	}