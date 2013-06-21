package cl.duoc.tsa.solemne2.servicios;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import cl.duoc.tsa.solemne2.datos.LenguajeVO;
import cl.duoc.tsa.solemne2.datos.PlataformasVO;
import cl.duoc.tsa.solemne2.datos.ServicioDatos;
import cl.duoc.tsa.solemne2.datos.ServicioDatosImpl;
import cl.duoc.tsa.solemne2.datos.SistemasVO;
import cl.duoc.tsa.solemne2.datos.UsuariosVO;

@Path("/info")
public class InformacionParametrica {

	private static final ServicioDatos SERVICIO = new ServicioDatosImpl();
	
	@GET
	@Path("/lenguajes")
	@Produces("application/json")
	public List<LenguajeVO> getLenguajes() {
		List<LenguajeVO> listaRetorno = null;

		Connection conn = ConnectionHelper.getConnection();
		if( conn != null ){
			listaRetorno = SERVICIO.getLenguajes(conn);
			ConnectionHelper.releaseConnection(conn);
		}
		
		return listaRetorno;
	}
	
	@GET
	@Path("/sistemas")
	@Produces("application/json")
	public List<SistemasVO> getSistemas() {
		List<SistemasVO> listaRetorno = null;

		Connection conn = ConnectionHelper.getConnection();
		if( conn != null ){
			listaRetorno = SERVICIO.getSistemas(conn);
			ConnectionHelper.releaseConnection(conn);
		}
		
		return listaRetorno;
	}

	@GET
	@Path("/plataformas")
	@Produces("application/json")
	public List<PlataformasVO> getPlataformas() {
		List<PlataformasVO> listaRetorno = null;

		Connection conn = ConnectionHelper.getConnection();
		if( conn != null ){
			listaRetorno = SERVICIO.getPlataforma(conn);
			ConnectionHelper.releaseConnection(conn);
		}
		
		return listaRetorno;
	}
	
	@GET
	@Path("/usuarios")
	@Produces("application/json")
	public List<UsuariosVO> getUsuarios() {
		List<UsuariosVO> listaRetorno = null;

		Connection conn = ConnectionHelper.getConnection();
		if( conn != null ){
			listaRetorno = SERVICIO.getUsuarios(conn);
			ConnectionHelper.releaseConnection(conn);
		}
		
		return listaRetorno;
	}
}
