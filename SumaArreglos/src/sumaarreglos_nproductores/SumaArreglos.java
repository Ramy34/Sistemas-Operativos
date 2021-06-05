package sumaarreglos_nproductores;
class SumaArreglos extends Thread {
	private int []A;
	private int []B;
	private int []C;
	
	public SumaArreglos(int []x, int[]y, int []z){
		A=x;
		B=y;
		C=z;
	}

	public void run() {
		int i;
		for(i=0; i<A.length;i++)
			C[i]= A[i] + B[i];	
	}
}
