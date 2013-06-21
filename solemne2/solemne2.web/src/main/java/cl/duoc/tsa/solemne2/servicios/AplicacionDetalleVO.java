package cl.duoc.tsa.solemne2.servicios;

import cl.duoc.tsa.solemne2.datos.AplicacionesVO;
import cl.duoc.tsa.solemne2.datos.DetalleApliVO;

public class AplicacionDetalleVO {

	private String id;
	private int idAplicacion = 0;
	private String descripcion;
	private int idSistema;
	private int idDetalle = 0;
	private int idLenguaje;
	private int idPlataforma;
	private String descripcionDetalle;
	private int especialista;
	private int dueno;
	private String baseDatos;
	private String estado;

	public int getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
		this.id = idAplicacion + "." + idDetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
		this.id = idAplicacion + "." + idDetalle;
	}

	public int getIdLenguaje() {
		return idLenguaje;
	}

	public void setIdLenguaje(int idLenguaje) {
		this.idLenguaje = idLenguaje;
	}

	public int getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(int idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getDescripcionDetalle() {
		return descripcionDetalle;
	}

	public void setDescripcionDetalle(String descripcionDetalle) {
		this.descripcionDetalle = descripcionDetalle;
	}

	public int getEspecialista() {
		return especialista;
	}

	public void setEspecialista(int especialista) {
		this.especialista = especialista;
	}

	public int getDueno() {
		return dueno;
	}

	public void setDueno(int dueno) {
		this.dueno = dueno;
	}

	public String getBaseDatos() {
		return baseDatos;
	}

	public void setBaseDatos(String baseDatos) {
		this.baseDatos = baseDatos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setId( String id )
	{
		this.id = id;
	}

	public AplicacionesVO getAplicacion()
	{
		AplicacionesVO appVo = new AplicacionesVO();
		appVo.setId_aplicacion(idAplicacion);
		appVo.setId_sistema(idSistema);
		appVo.setDescripcion(descripcion);
		return appVo;
	}
	
	public DetalleApliVO getDetalleApliVO()
	{
		DetalleApliVO detVo = new DetalleApliVO();
		detVo.setId_det(idDetalle);
		detVo.setBase_de_datos(this.baseDatos.charAt(0));
		detVo.setDescripcion(descripcion);
		detVo.setId_aplicacion(this.idAplicacion);
		detVo.setId_lenguaje(this.idLenguaje);
		detVo.setId_plataforma(this.idPlataforma);
		detVo.setLog_estado(this.estado.charAt(0));
		detVo.setRut_dueno(this.dueno);
		detVo.setRut_especialista(this.especialista);
		
		return detVo;
	}
}
