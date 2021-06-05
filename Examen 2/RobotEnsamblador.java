public class RobotEnsamblador extends Thread {

    private Cola_LSE ensamble;
    private String nombre;
    private ColaBodega bodega;
    private int serie, numBots;

    public RobotEnsamblador(String nombre, Cola_LSE e, ColaBodega b, int num, int nb) {
        ensamble = e;
        this.nombre = nombre;
        bodega = b;
        this.serie = num;
        numBots = nb;
    }

    public void run() {
        Nodo[] auxiliar = new Nodo[4];
        Nodo pieza = null;
        int indice = 0;
        while (true) {
            System.out.println("El robot ensamblador " + nombre + " entra a la lista de piezas lista para ensamblar buscando piezas con la serie " 
        + serie);
            pieza = ensamble.Borrar(serie, nombre);
            System.out.println("El robot " + nombre + " ensambla la pieza " + pieza.getName() + pieza.getDato());
            auxiliar[indice] = pieza;
            indice++;
            if (indice > auxiliar.length-1) {
                indice = 0;
                System.out.println("\nEl robot ensamblador " + nombre + " ha terminado el auto " + serie + 
                		" y lo manda a la bodega");
                bodega.InsertarAlFinal(new Auto("Auto serie " + serie, serie, auxiliar[0], auxiliar[1], auxiliar[2], auxiliar[3]));
                serie += numBots;
            }
            pieza = null;
        }
    }
}