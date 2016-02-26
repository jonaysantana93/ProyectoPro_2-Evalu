package controlador;

public class Peliculas implements Buscable{
	
	private String titulo;
	private String director;
	private String genero;
	private String year;
	private String pais;

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String buscar() {
		return titulo + " " + director;
	}
	
	public String toString(){
		return titulo + "   -   " + director + "   -   " + genero + "   -   " + year + "   -   " + pais;
	}
	
}
