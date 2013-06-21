package cl.duoc.tsa.solemne2.servicios;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import cl.duoc.tsa.solemne2.datos.AplicacionesVO;
import cl.duoc.tsa.solemne2.datos.DetalleApliVO;
import cl.duoc.tsa.solemne2.datos.ServicioDatos;
import cl.duoc.tsa.solemne2.datos.ServicioDatosImpl;


@Path("/aplicaciones")
public class AplicacionService {

	private static final ServicioDatos SERVICIO = new ServicioDatosImpl();

	@GET
	@Path("/listado")
	@Produces("application/json")
	public List<AplicacionDetalleVO> getAplicaciones()
	{
		final List<AplicacionDetalleVO> listaRetorno = new ArrayList<AplicacionDetalleVO>();

		final Connection conn = ConnectionHelper.getConnection();
		if( conn != null ){
			final List<AplicacionesVO> aplicaciones = SERVICIO.getAplicaciones(conn);
			final List<DetalleApliVO> detalles = SERVICIO.getDetalleApli(conn);
			
			for( DetalleApliVO detVo : detalles )
			{
				AplicacionDetalleVO appDetVo = new AplicacionDetalleVO();
				
				AplicacionesVO appVo = getAplicacion(detVo.getId_aplicacion(), aplicaciones);
				//Encabezado
				appDetVo.setIdAplicacion(appVo.getId_aplicacion());
				appDetVo.setDescripcion(appVo.getDescripcion());
				appDetVo.setIdSistema(appVo.getId_sistema());
				
				//Detalle
				appDetVo.setIdDetalle(detVo.getId_det());
				appDetVo.setIdLenguaje(detVo.getId_lenguaje());
				appDetVo.setIdPlataforma(detVo.getId_plataforma());
				appDetVo.setDescripcionDetalle(detVo.getDescripcion());
				appDetVo.setEspecialista(detVo.getRut_especialista());
				appDetVo.setDueno(detVo.getRut_dueno());
				appDetVo.setBaseDatos(detVo.getBase_de_datos() + "");
				appDetVo.setEstado(detVo.getLog_estado() + "");
				
				listaRetorno.add(appDetVo);
			}

			ConnectionHelper.releaseConnection(conn);
		}
		
		return listaRetorno;
	}
	
	@POST
	@Path("/grabar")
	@Produces("application/json")
	@Consumes("application/json")
	public ResponseStatus grabaAplicaciones( List<AplicacionDetalleVO> aplicaciones )
	{
		ResponseStatus allOk = new ResponseStatus();
		
		allOk.setSuccess(true);
		allOk.setMessage(null);
		final Connection conn = ConnectionHelper.getConnection();
		for( AplicacionDetalleVO appDetVo : aplicaciones )
		{
			AplicacionesVO appVo = appDetVo.getAplicacion();
			DetalleApliVO detVo = appDetVo.getDetalleApliVO();
			
			if( allOk.isSuccess() && ! SERVICIO.insDetalleApli(conn, appVo, detVo) )
			{
				allOk.setSuccess(false);
				allOk.setMessage("Error al grabar los datos");
			}
		}
		ConnectionHelper.releaseConnection(conn);
		return allOk;
	}

	@POST
	@Path("/borrar")
	@Produces("application/json")
	@Consumes("application/json")
	public ResponseStatus borrarAplicaciones( List<AplicacionDetalleVO> aplicaciones )
	{
		ResponseStatus allOk = new ResponseStatus();
		
		allOk.setSuccess(true);
		allOk.setMessage(null);
		final Connection conn = ConnectionHelper.getConnection();
		for( AplicacionDetalleVO appDetVo : aplicaciones )
		{
			DetalleApliVO detVo = appDetVo.getDetalleApliVO();
			
			if( allOk.isSuccess() && ! SERVICIO.eliDetalleApli(conn, detVo) )
			{
				allOk.setSuccess(false);
				allOk.setMessage("Error al grabar los datos");
			}
		}
		ConnectionHelper.releaseConnection(conn);
		return allOk;
	}
	
	private AplicacionesVO getAplicacion( int idAplicacion, List<AplicacionesVO> aplicaciones)
	{
		for( AplicacionesVO appVo : aplicaciones )
		{
			if( appVo.getId_aplicacion() == idAplicacion )
			{
				return appVo;
			}
		}
		return null;
	}
}
