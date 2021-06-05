public class Generadores extends Thread{
	
	private Cola_LSE cola;
    private int serie, Robots, tiempo;
    private String nombre,nombrePieza;
    String [] colores = {"Negro","Blanco","Gris","Azul","Rojo"};
    
    public Generadores(String nombre, int serie, Cola_LSE cola, int num, String nombrePieza, int tiempo) {
        this.serie = serie;
        this.cola = cola;
        this.nombre = nombre;
        this.nombrePieza = nombrePieza;
        this.tiempo = tiempo;
        Robots = num;
    }

     public void run() {
        String color = null;
        int colorId;
        while (true) {
            colorId = (int) (Math.random() * 5); //Obtenemos el id del color de la pieza
            color = colores[colorId]; //Obtenemos el color de la pieza
            try {
				Thread.sleep(tiempo);
				cola.InsertarAlFinal(serie, nombre, (nombrePieza + " " + nombre), color); //Insertamos la pieza generada a la cola para pintar
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            serie += Robots;
        }
    }
}