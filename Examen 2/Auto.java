public class Auto {
    private String nombre;
    private int serie;
    private Nodo[] piezas = new Nodo[4];  
    private Auto siguiente;
    
    public Auto(String nombre, int serie, Nodo pieza1, Nodo pieza2, Nodo pieza3, Nodo pieza4){
        this.nombre = nombre;
        this.serie = serie;
        piezas[0] = pieza1;
        piezas[1] = pieza2;
        piezas[2] = pieza3;
        piezas[3] = pieza4;
    }
    public String getNombre(){
        return nombre;
    }
    public int getSerie(){
        return serie;
    }
    public Nodo[] getPiezas(){
        return piezas;
    }
    public void setSiguiente(Auto s){
        siguiente = s;
    }
    public Auto getSiguiente(){
        return siguiente;
    }
}