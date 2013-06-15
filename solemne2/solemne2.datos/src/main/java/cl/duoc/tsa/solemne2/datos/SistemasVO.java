package cl.duoc.tsa.solemne2.datos;

public class SistemasVO {

	private int id_sistema;
	private String descripcion;
	
	/*   */
	
	public int getId_sistema() {
		return id_sistema;
	}

	public void setId_sistema(int id_sistema) {
		this.id_sistema = id_sistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SistemasVO(int id_sistema, String descripcion) {
		this.id_sistema = id_sistema;
		this.descripcion = descripcion;
	}

	public SistemasVO() {
	}
}
