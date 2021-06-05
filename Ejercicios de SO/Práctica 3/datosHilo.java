public class datosHilo extends Thread{
	public void run(){
		int i;
		for (i=1;i<=100;i++){
			System.out.println(getName() + ": " + i);
		}
	}
}