package sumaarreglos_nproductores;

import arregloSincronizado.Arreglo;

public class SumaArreglos_NProductores {
    public static void main(String[] args) {
        Arreglo muestrasA, muestrasB;
        Generador []hpA, hpB;
        SumaArreglos hs;
        int []A,B,C;
        int n,i;
        
        n=5;//Teclado.entero("Numero de elementos del arreglo: ");
        A=new int[n];
        B=new int[n];
        C=new int[n];
        muestrasA=new ______________(___,_____);
        muestrasB=new ______________(___,_____);
        hs=new SumaArreglos(___,____,____);
        
        n=2;//Teclado.entero("Numero de Hilos generadores de A: ");
        hpA=new ______________[__];
        for (i=0; i<n; i++){
            hpA[__]=new ___________("A_productor"+i+": ", ___________);
            hpA[__]._________;
        }
 
        n=3;//Teclado.entero("Numero de Hilos generadores de B: ");
        hpB=new ______________[__];
        for (i=0; i<n; i++){
            hpB[i]=new ___________("B_productor"+i+": ", ___________);
            hpB[i].___________;
        }
    
        for (i=0; i<hpA.___________; i++)
            try {
                hpA[___].___________;
            } catch (InterruptedException ex) { }
        for (i=0; i<hpB.___________; i++)
            try {
                hpB[___].___________;
            } catch (InterruptedException ex) { }
      
        hs.___________;
        try { _________________} catch (InterruptedException ex) { }
        
      	System.out.println("================================");
        
        for (i=0; i<A.length; i++){
        	System.out.print("["+i+"]=" +A[i]);
                System.out.print("\t\t["+i+"]=" +B[i]);
                System.out.println("\t\t["+i+"]=" +C[i]);
        }
        System.out.println();
    }
}
