package cl.duoc.tsa.solemne2.datos;

public class PlataformasVO {

	private int id_plataforma;
	private String nombre_plataforma;
	private String descripcion;
	private char log_estado;
	
	public int getId_plataforma() {
		return id_plataforma;
	}

	public void setId_plataforma(int id_plataforma) {
		this.id_plataforma = id_plataforma;
	}

	public String getNombre_plataforma() {
		return nombre_plataforma;
	}

	public void setNombre_plataforma(String nombre_plataforma) {
		this.nombre_plataforma = nombre_plataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getLog_estado() {
		return log_estado;
	}

	public void setLog_estado(char log_estado) {
		this.log_estado = log_estado;
	}

	public PlataformasVO() {
	}
	
	public PlataformasVO(int id_plataforma, String nombre_plataforma,
			String descripcion, char log_estado) {
		this.id_plataforma = id_plataforma;
		this.nombre_plataforma = nombre_plataforma;
		this.descripcion = descripcion;
		this.log_estado = log_estado;
	}
	
	
	
}
