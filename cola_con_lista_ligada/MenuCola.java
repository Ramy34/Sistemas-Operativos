import java.util.Scanner;

public class MenuCola {
	public static void main (String args[]){

		int opcion;
		Scanner scan = new Scanner(System.in);
		Cola_LSE colita = new Cola_LSE();

		do{
		System.out.printf("\n\nSelecciona una opcion:\n\n 1. Insertar dato.\n 2. Mostrar datos.\n 3. Borrar datos.\n 4. Salir\n\nOpcion: ");
			opcion = scan.nextInt();

			switch(opcion){
				case 1:
					System.out.printf("\nDatos a insertar: ");
					int datos = scan.nextInt();
					for(int i=0;i<datos;i++){
						System.out.printf("Dato " + i + ": ");
						colita.InsertarAlFinal(scan.nextInt());
					}
					System.out.println("\nDato(s) guardado(s).");
					break;

				case 2:
					if(colita.ListaVacia()==false){
						System.out.println("\nLos datos guardados son: ");
						colita.Listar();
					}else
						System.out.println("La cola esta vacia.");
					break;

				case 3:
					if(colita.ListaVacia()==false){
						Nodo aux = colita.Borrar();
						System.out.println("El dato borrado fue " + aux.GetDato());
					}else
						System.out.println("La cola esta vacia");
					break;

				case 4:
					System.out.println("Gracias, vuelve pronto!");
					break;

				default:
					System.out.println("\nPor favor ingresa solamente valores permitidos.\n");
					break;

			}
		} while (opcion != 4);
	}
}