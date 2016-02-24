package controlador;


public class Clientes implements Buscable{
	private String nombre;
	private String dni;
	private String telefono;
	private String direccion;
	private String codigoSocio;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCodigoSocio() {
		return codigoSocio;
	}
	
	public void setCodigoSocio(String codigoSocio) {
		this.codigoSocio = codigoSocio;
	}

	@Override
	public String buscar() {
		return nombre + " " + dni;
	}
	
	public String toString(){
		return nombre + "   -   " + dni + "   -   " + telefono + "   -   " + direccion + "   -   " + codigoSocio;
	}
}