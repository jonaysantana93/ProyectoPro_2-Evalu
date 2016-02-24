package controlador;

public class Lista {

	private Nodo primero;
	private int size;
	
	public Lista() {
		primero = null;
		size = 0;
	}
	
	public void add(Object o){
		Nodo n = new Nodo();
		n.setO(o);
		if (primero == null)
			primero = n;
		else {
			Nodo aux = primero;
			while (aux.getSig() != null)
				aux = aux.getSig();
			aux.setSig(n);
		}
		n.setSig(null);
		size = size + 1;
	}
	
	public Object get (int index) {
		if (index >= 0 && index < size) {
			Nodo aux = primero;
			for (int i=0; i<index; i++)
				aux = aux.getSig();
			return aux.getO();
		} else
			return null;
	}
	
	public Object[] get(String s) {
		Lista ls = new Lista();
		for (int i=0; i<size; i++) {
			Buscable b = (Buscable)get(i);
			if (b.buscar().toUpperCase().contains(s.toUpperCase()))
				ls.add(get(i));
		}
		Object[] vec = new Object[ls.size];
		for (int i=0; i<ls.size; i++)
			vec[i] = ls.get(i);
		
		return vec;
	}
	
	public int indexOf(Object o) {
		Nodo aux = primero;
		int pos = 0;
		while(aux != null && aux.getO() != o) {
			aux = aux.getSig();
			pos = pos + 1;
		}
		if (aux != null)
			return pos;
		else
			return -1;
	}
	
	public boolean remove (Object o) {
		int pos = indexOf(o);
		if (pos != -1) {
			remove(pos);
			size = size - 1;
			return true;
		} else
			return false;
			
	}
	
	public int size() {
		return size;
	}
}
