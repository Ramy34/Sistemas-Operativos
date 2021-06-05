public class ColaBodega {  

    private Auto H; 		   
    private Auto T;         
    private int piezas = 0;
    private int max = -1;
    private boolean listando = false;

   
    public synchronized boolean ListaVacia() {
        return H == null;
    }
    
    public boolean ListaLlena() {
        if (piezas == max) {
            return true;
        } else {
            return false;
        }
    }

    //Agrega los autos a la bodega
    public synchronized void InsertarAlFinal(Auto nuevo) {
        Auto q = nuevo;
        while (piezas == max || listando == true) { 
            try {
                if (piezas == max){ //comprueba si no hay espacio en la bodega
                    System.out.println("Bodega de autos llena.");
                    this.Listar();
                    System.exit(0);
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (T == null) {
            H = T = q;
        } else {
            T.setSiguiente(q);
            T = q;
        }
        piezas ++;
        System.out.println("Autos en la bodega");
        this.Listar();
        notifyAll();
    }

    //Saca a los autos de la cola
    public synchronized Auto Borrar(int num) {
        Auto aux = H; //Creamos un auto auxiliar
        if (H == null) {
            System.out.println("\nLista vacia....");
        } else if (H == T) {
            H = T = null;
            piezas--;
        } else {
            H = H.getSiguiente();
            piezas--;
        }
        return aux;
    }

    //Lista los autos
    public synchronized void Listar() {
        listando = true;
        System.out.println("\n");
        Auto q = H; 
        while (q != null) {
            Nodo[] pieza = q.getPiezas();
            System.out.println("\nAuto con id (A" + pieza[0].getDato() + " B" + pieza[1].getDato() + " C" + pieza[2].getDato() + 
            		" D" + pieza[3].getDato() + ")"
                    + " y piezas:\n\n-" + pieza[0].getName() 
                    + pieza[0].getDato() + " " 
                    + pieza[0].getColor() + "\n-" 
                    + pieza[1].getName() + pieza[1].getDato() + " " 
                    + pieza[1].getColor() + "\n-" 
                    + pieza[2].getName() + pieza[2].getDato() 
                    + " " + pieza[2].getColor() + "\n-" 
                    + pieza[3].getName() + pieza[3].getDato() 
                    + " " + pieza[3].getColor());
            q = q.getSiguiente();
        }
        System.out.println("\n");
        listando = false;
    }

    public void setMaxElemento(int max) {
        this.max = max;
    }

    public int getMaxElemento() {
        return max;
    }
}