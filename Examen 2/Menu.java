import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        //Definimos las variables a usar
        Scanner teclado = new Scanner(System.in);
        int numPiezas = 4, numHilosPiezas = 1, robotPintores, robotEnsambladores = 2, capacidadBodega;
        int i,j,k;

        //Mensajes para pedir los valores necesarios
        System.out.print("Cuantos robots pintores deseas? ");
        robotPintores = teclado.nextInt();

        System.out.print("Cuantos robots ensambladores deseas? ");
        robotEnsambladores = teclado.nextInt();

        System.out.print("Cuantos autos deseas que se almacenen en la bodega? ");
        capacidadBodega = teclado.nextInt();

        //Se crea la cola de piezas generadas
        Cola_LSE piezas = new Cola_LSE();
        piezas.setMaxElemento(numPiezas);

        //Se crea la cola de las piezas a ensamblas
        Cola_LSE ensamble = new Cola_LSE();
        ensamble.setMaxElemento(numPiezas*4);

        //Se crea la cola de la bodega donde se almanecaran los autos
        ColaBodega bodega = new ColaBodega();
        bodega.setMaxElemento(capacidadBodega);

         //Creamos los robots generadores
        Generadores[] robotsA = new Generadores[numHilosPiezas];
        Generadores[] robotsB = new Generadores[numHilosPiezas];
        Generadores[] robotsC = new Generadores[numHilosPiezas];
        Generadores[] robotsD = new Generadores[numHilosPiezas];
        
        //Se crean los robots encargados de pintar
        RobotPintor[] pintores = new RobotPintor[robotPintores];

        //Se crean los robots encargados del ensamblaje
        RobotEnsamblador[] robotsE = new RobotEnsamblador[robotEnsambladores];
        
        //Iinicializamos a los robots generadores y los ejecutamos 
        for(i = 0; i < robotsA.length; i++){
            robotsA[i] = new Generadores("A " + i, i + 1, piezas, numHilosPiezas, "Cajuela", 100);
            robotsA[i].start();
            robotsB[i] = new Generadores("B " + i, i + 1, piezas, numHilosPiezas, "Defensa", 120);
            robotsB[i].start();
            robotsC[i] = new Generadores("C " + i, i + 1, piezas, numHilosPiezas, "Puertas", 90);
            robotsC[i].start();
            robotsD[i] = new Generadores("D " + i, i + 1, piezas, numHilosPiezas, "Parabrisas", 100);
            robotsD[i].start();
        }

        //Se inicializan los puintores y ejecutan
        for(j = 0; j < pintores.length; j++){
            pintores[j] = new RobotPintor("Pintor " + j, piezas, ensamble);
            pintores[j].start();
        }

        //Se inicializan los ensambladores y ejecutan
        for(k = 0; k < robotsE.length; k++){
            robotsE[k] = new RobotEnsamblador("Ensamblador "+k, ensamble, bodega, k+1, robotEnsambladores);
            robotsE[k].start();
        }
    }
}