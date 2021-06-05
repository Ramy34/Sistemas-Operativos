package arregloSincronizado;
public class Arreglo {
    //ATRIBUTOS
        private int []arreglo;
	private int indice;
        private char c;
	
	//CONSTRUCTOR
	public Arreglo(int n) {
	    arreglo = new int [n];
            indice = -1;
           
	}
	public Arreglo(int []arreglo,char nombre) {
	    this.arreglo = arreglo;
            indice = -1;
            c = nombre;
	}
	public void ImprimeDatos() {
            for(int i =0; i <=indice; i++)
		System.out.println("\t"+c+"["+i+"]=" +arreglo[i]);
            System.out.println();
	}
	
	public ______________ ___________ almacenar(int dato, String hilo) {
            _________ (__________ == ____________) 
                return _________;
            ____________;
            arreglo[indice]= dato;
            System.out.println("\t(ALMACENA " + hilo+"indice="+indice+") = " + dato);  
            ImprimeDatos();
            _________________;
            return _________;
	}	

}
