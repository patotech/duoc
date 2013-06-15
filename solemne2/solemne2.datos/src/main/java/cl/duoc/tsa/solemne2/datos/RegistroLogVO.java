package cl.duoc.tsa.solemne2.datos;

import java.util.Date;

public class RegistroLogVO {

	private int id;
	private int rut;
	private Date fecha;
	private String detalle_cambio;
	private int id_det;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle_cambio() {
		return detalle_cambio;
	}
	public void setDetalle_cambio(String detalle_cambio) {
		this.detalle_cambio = detalle_cambio;
	}
	public int getId_det() {
		return id_det;
	}
	public void setId_det(int id_det) {
		this.id_det = id_det;
	}
	
	public RegistroLogVO(int id, int rut, Date fecha, String detalle_cambio, int id_det) {
		this.id = id;
		this.rut = rut;
		this.fecha = fecha;
		this.detalle_cambio = detalle_cambio;
		this.id_det = id_det;
	}

	public RegistroLogVO() {
	}

	
}
