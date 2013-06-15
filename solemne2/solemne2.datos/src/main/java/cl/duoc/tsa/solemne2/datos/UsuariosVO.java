package cl.duoc.tsa.solemne2.datos;

public class UsuariosVO {

	private int rut;
	private String nombre;
	private String apellido_pat;
	private String apellido_mat;

	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_pat() {
		return apellido_pat;
	}
	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}
	public String getApellido_mat() {
		return apellido_mat;
	}
	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}
	
	public UsuariosVO(int rut, String nombre, String apellido_pat, String apellido_mat) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
	}

	public UsuariosVO() {
	}

	
}
