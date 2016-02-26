package controlador;

public class Nodo {
	
	private Object o;
	private Nodo sig;
	public Object getO() {
		return o;
	}
	public void setO(Object o) {
		this.o = o;
	}
	public Nodo getSig() {
		return sig;
	}
	public void setSig(Nodo sig) {
		this.sig = sig;
	}
}