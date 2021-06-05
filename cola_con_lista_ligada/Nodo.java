class Nodo {
   private int dato;
	private Nodo siguiente;
	
	public Nodo (int num) {
		dato = num;
		siguiente = null;
	}

	public Nodo (int num, Nodo n) {
		dato = num;
		siguiente = n;
	}

	public int GetDato() {
		return dato;
	}
	
	public void SetDato(int nvodato) {
		dato= nvodato;
	}

	public Nodo GetSiguiente() {
		return siguiente;
	}
	
	public void SetSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	 
}