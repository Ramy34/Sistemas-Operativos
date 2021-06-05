public class RobotPintor extends Thread {   
    private Cola_LSE piezas, piezasPintadas;
    private int tiempo = 100;
    private String nombre;
    
    public RobotPintor(String nombre, Cola_LSE piezas, Cola_LSE piezasPintadas) {
        this.nombre = nombre;
        this.piezas = piezas;
        this.piezasPintadas = piezasPintadas;
    }

    public void run() {
        Nodo pieza = null;
        int random = 0;
        while (true) {
            pieza = piezas.Borrar(nombre);
            if(pieza != null){ //Revisa que haya pieza que pintar
                random = (int) (Math.random() * tiempo); //Para el tiempo de espera
                System.out.println("El robot pintor " + nombre + " pinta la pieza " + pieza.getName() + pieza.getDato() + 
                		" de color " + pieza.getColor() + "\n" + "Tardara en pintar la pieza " + random + " min.");
                try {
                    sleep(random);
                    piezasPintadas.InsertarAlFinalEnsamblaje(pieza, nombre); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pieza = null;
            }
        }
    }
}