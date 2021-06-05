class Cola_LSE {

    private Nodo H; 	    // H primer elemento
    private Nodo T;         //T es el ultimo elemento
    private int piezas = 0;
    private int vacia = -1; //indice de que la lista esta vacia

    public Cola_LSE() { //Constructor de la cola
        H = null;
        T = null;
    }

    public void setMaxElemento(int maximo) { 
        piezas = maximo;
    }

    public int getNumElemento() {
        return piezas;
    }

    public boolean ListaLlena() {
        if (piezas == vacia) {
            return true;
        } else {
            return false;
        }
    }

    //El método inserta al final de la cola la pieza creada por los robots creadores de piezas # este método sincroniza los hilos
    public synchronized void InsertarAlFinal(int numero, String nombre, String nombrePieza, String color) {
        System.out.println("\nEl robot " + nombre + " ha terminado la pieza " + nombrePieza + numero);
        Nodo q = new Nodo(numero, nombrePieza, color); //Crea el nodo a insertar
        while (ListaLlena()) {
        	try {
        		if (ListaLlena()) { //Reviasa que la lista no esté llena
        			System.out.println("El robot " + nombre + " se encuentra en espera para insertar pieza creada");
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
        piezas++;
        System.out.println("Piezas listas para pintar");
        this.Listar();
        notifyAll();
    }
    
    //El método inserta al final de la cola la pieza ya pintada por los robots pintores # este método sincroniza los hilos
    public synchronized void InsertarAlFinalEnsamblaje(Nodo n, String nombre) {
        System.out.println("\nEl robot " + nombre + " ha terminado de pintar la pieza " + n.getName() + n.getDato() + 
        		" la inserta en la lista para ensamblar");
        while (ListaLlena()) {
            try {
                if (ListaLlena()) {
                    System.out.println("El robot " + nombre + " se encuentra en espera para inserta pieza pintada");
                }

                wait();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
        Nodo q = n;
        if (T == null) {
            H = T = q;
        } else {
            T.setSiguiente(q);
            T = q;
        }
        piezas++;
        System.out.println("Piezas listas para ensamblaje\n");
        this.Listar();
        notifyAll();
    }

    //Extrae un pieza de la lista para poder pintarla
    public synchronized Nodo Borrar(String nombre) {
        while (H == null) {
            try {
                if (H == null) {
                    System.out.println("\nLista vacia, en espera " + nombre + " para poder pintar pieza");
                }
                
                wait();
                
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }

        Nodo aux = H;
        if (H == T) {
            H = T = null;
            piezas--;
        } else {
            H = H.getSiguiente();
            piezas--;
        }
        aux.setSiguiente(null);
        System.out.println("Piezas listas para pintar\n");
        this.Listar();
        notifyAll();
        return aux;
    }

    public synchronized Nodo Borrar(int num, String nombre) {
        Nodo aux = null;
        while (aux == null) {
            while (H == null) {
                try {
                    if (H == null) {
                        System.out.println("\nLista de piezas listas para ensamblaje vacia, el robot " + nombre + " espera.\n");
                    }
                    wait();
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
            aux = this.Buscar(num);
            if (aux == null) {
                try {
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        }
        aux.setSiguiente(null);
        piezas --;
        System.out.println("A continuacion se lista la linea de piezas listas para ensamblaje\n");
        this.Listar();
        notifyAll();
        return aux;
    }

    //Imprime toda la lista
    public synchronized void Listar() {
        Nodo q = H;
        while (q != null) {
            System.out.print(q.getName() + q.getDato() + "(" + q.getColor()+") || ");
            q = q.getSiguiente();
        }
        System.out.println("\n");

    }

    //busca un nodo mediante su ID
    public synchronized Nodo Buscar(int id) {
        // Recorrer la lista
        Nodo q = H;
        Nodo p = null;
        while (q != null) {
            if (q.getDato() == id) {
                break;
            }
            p = q;
            q = q.getSiguiente();
        }
        if (q != null) {
            if (q == H) {
                if (H == T) {
                    H = T = null;
                } else {
                    H = H.getSiguiente();
                }
            } else if (q == T) {
                T = p;
                T.setSiguiente(null);
            } else {
                p.setSiguiente(q.getSiguiente());
            }
        }
        return q;
    }
}