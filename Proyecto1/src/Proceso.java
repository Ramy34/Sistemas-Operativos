public class Proceso implements Cloneable{
	
	private int idProceso,prioridad,tiempoLlegada,tiempoEjecucion;
	private String nombreProceso;
	private float tamano;
	
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getTiempoLlegada() {
		return tiempoLlegada;
	}
	public void setTiempoLlegada(int tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}
	public int getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	public void setTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	public float getTamano() {
		return tamano;
	}
	public void setTamano(float tamano) {
		this.tamano = tamano;
	}
	
	public Proceso(int idProceso, int prioridad, int tiempoLlegada, int tiempoEjecucion, String nombreProceso,
			float tamano) {
		this.idProceso = idProceso;
		this.prioridad = prioridad;
		this.tiempoLlegada = tiempoLlegada;
		this.tiempoEjecucion = tiempoEjecucion;
		this.nombreProceso = nombreProceso;
		this.tamano = tamano;
	}
	
}