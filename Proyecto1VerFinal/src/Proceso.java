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

public class Proceso implements Cloneable{

	private int idProceso;
	private String nombreProceso;
	private float tamanio;
	private int tiempoEjecucion;
	private int prioridad;
	/*private int timeES;*/
	private int tiempoLlegada;
	private int numeroProcesos; 


	Proceso(){}

	Proceso(int id, String nombreP, float tamanio, int tiempoE, int prioridad, /*int timeES,*/ int tiempoL, int numeroProcesos){
		idProceso=id;
		nombreProceso=nombreP;
		this.tamanio=tamanio;
		tiempoEjecucion=tiempoE;
		this.prioridad=prioridad;
		/*this.timeES=timeES;*/
		tiempoLlegada=tiempoL;
		this.numeroProcesos=numeroProcesos;

	}

	

	public void setId(String idProceso){
		this.idProceso=idProceso;
	}

	public String getId(){
		return idProceso;
	}

	public void setNombre(String nombreProceso){
		this.nombreProceso=nombreProceso;
	}

	public String getNombre (){
		return nombreProceso;
	}

	public void setTamanio(int tamanio){
		this.tamanio=tamanio;
	}

	public int getTamanio(){
		return tamanio; 
	}

	public void setTiempo(int tiempoEjecucion){
		this.tiempoEjecucion=tiempoEjecucion;
	}

	public int getTiempo(){
		return tiempoEjecucion;
	}

	public void setPrioridad(int prioridad){
		this.prioridad=prioridad;
	}

	public int getPrioridad(){
		return prioridad;
	}

	/*public void setTimeES(int timeES){
		this.timeES=timeES;
	}

	public int getTimeES(){
		return timeES;
	}*/

	public void setTiempoLlegada(int tiempoLlegada){
		this.tiempoLlegada=tiempoLlegada;
	}

	public int getTiempoLlegada(){
		return tiempoLlegada;
	}



} 