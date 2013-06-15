package cl.duoc.tsa.solemne2.datos;

public class AplicacionesVO {
	private int id_aplicacion;
	private String descripcion;
	private int id_sistema;
	
	public int getId_aplicacion() {
		return id_aplicacion;
	}
	public void setId_aplicacion(int id_aplicacion) {
		this.id_aplicacion = id_aplicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_sistema() {
		return id_sistema;
	}
	public void setId_sistema(int id_sistema) {
		this.id_sistema = id_sistema;
	}
	
	public AplicacionesVO(int id_aplicacion, String descripcion, int id_sistema) {
		this.id_aplicacion = id_aplicacion;
		this.descripcion = descripcion;
		this.id_sistema = id_sistema;
	}
	
	public AplicacionesVO() {
	}
	

}
