import java.util.Scanner;

public class Cadenas {

	public static void main(String[] args) {
		String [] cadena = new String[3];
		int [] numeros = new int[3];
		int i;
		Scanner teclado = new Scanner(System.in);
		
		for(i=0;i<3;i++) {
			System.out.println("Escribe: ");
			cadena[i] = teclado.nextLine(); 
			System.out.println("Escribe numero: ");
			numeros[i] = teclado.nextInt();
			teclado.nextLine();
		}
		
		for(i=0;i<3;i++) {
			System.out.println(cadena[i]);
			System.out.println(numeros[i]);
		}
	}

}
