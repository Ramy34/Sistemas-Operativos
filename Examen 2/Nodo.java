class Nodo {
    private String nombre, color;
    private int ID;
    private Nodo siguiente;

    public Nodo(int num) {
        ID = num;
        siguiente = null;
    }
    
    public Nodo(int num, String nombre, String color) {
        ID = num;
        this.nombre = nombre;
        this.color = color;
        siguiente = null;
    }

    public Nodo(int num, Nodo n) {
        ID = num;
        siguiente = n;
    }

    public int getDato() {
        return ID;
    }

    public void setDato(int nvodato) {
        ID = nvodato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getName(){
        return nombre;
    }
    
    public String getColor(){
        return color;
    }
}