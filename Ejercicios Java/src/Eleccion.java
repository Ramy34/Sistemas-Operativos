import java.util.Scanner;

public class Eleccion {

	public static void main(String[] args) {
		int opc=0;
		boolean salir = false;
		Scanner teclado = new Scanner(System.in);
		
		while(opc != 1) {
			System.out.println("Para salir: 1 ");
			System.out.println("Para continuar: 2");
			opc = teclado.nextInt();
			teclado.nextLine();
			switch(opc){
			case 1:
				//salir = true;
				break;
			case 2:
				System.out.println("Repito");
				break;
			}
		}
		System.out.println("Ya salí del bucle");
	}

}
