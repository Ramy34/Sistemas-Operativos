package sumaarreglos_nproductores;

import arregloSincronizado.Arreglo;

public class Generador extends Thread{
  private Arreglo arreglo;
  
  public Generador(String name, ________ arreglo) {
	this.arreglo = arreglo;
	setName(name);
  }
  public void run() {
    int dato;
    do {
        dato= (int)(Math.random()* 10);
        System.out.println(getName()+ " "+dato );
    } while (______________________________________(dato, getName()));
    System.out.println(getName()+ ": No registro su muestra: "+dato+", ya no hay espacio...");
 }
}
