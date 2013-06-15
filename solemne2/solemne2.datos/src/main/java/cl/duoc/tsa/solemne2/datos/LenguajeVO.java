package cl.duoc.tsa.solemne2.datos;

public class LenguajeVO {

	private int id_lenguaje;
	private String descripcion;
	
	public int getId_lenguaje() {
		return id_lenguaje;
	}
	public void setId_lenguaje(int id_lenguaje) {
		this.id_lenguaje = id_lenguaje;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LenguajeVO(int id_lenguaje, String descripcion) {
		this.id_lenguaje = id_lenguaje;
		this.descripcion = descripcion;
	}

	public LenguajeVO() {
	}

}
