package cl.duoc.tsa.solemne2.datos;

public class DetalleApliVO {

	private int id_det;
	private int id_lenguaje;
	private int id_aplicacion;
	private int id_plataforma;
	private String descripcion;
	private int rut_especialista;
	private int rut_dueno;
	private char base_de_datos;
	private char log_estado;
	
	public int getId_det() {
		return id_det;
	}
	public void setId_det(int id_det) {
		this.id_det = id_det;
	}
	public int getId_lenguaje() {
		return id_lenguaje;
	}
	public void setId_lenguaje(int id_lenguaje) {
		this.id_lenguaje = id_lenguaje;
	}
	public int getId_aplicacion() {
		return id_aplicacion;
	}
	public void setId_aplicacion(int id_aplicacion) {
		this.id_aplicacion = id_aplicacion;
	}
	public int getId_plataforma() {
		return id_plataforma;
	}
	public void setId_plataforma(int id_plataforma) {
		this.id_plataforma = id_plataforma;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getRut_especialista() {
		return rut_especialista;
	}
	public void setRut_especialista(int rut_especialista) {
		this.rut_especialista = rut_especialista;
	}
	public int getRut_dueno() {
		return rut_dueno;
	}
	public void setRut_dueno(int rut_dueno) {
		this.rut_dueno = rut_dueno;
	}
	public char getBase_de_datos() {
		return base_de_datos;
	}
	public void setBase_de_datos(char base_de_datos) {
		this.base_de_datos = base_de_datos;
	}
	
	public char getLog_estado() {
		return log_estado;
	}
	public void setLog_estado(char log_estado) {
		this.log_estado = log_estado;
	}
	
	public DetalleApliVO(int id_det, int id_lenguaje, int id_aplicacion,
			int id_plataforma, String descripcion, int rut_especialista,
			int rut_dueno, char base_de_datos, char log_estado) {
		this.id_det = id_det;
		this.id_lenguaje = id_lenguaje;
		this.id_aplicacion = id_aplicacion;
		this.id_plataforma = id_plataforma;
		this.descripcion = descripcion;
		this.rut_especialista = rut_especialista;
		this.rut_dueno = rut_dueno;
		this.base_de_datos = base_de_datos;
		this.log_estado = log_estado;
	}

	public DetalleApliVO() {
	}
}
