package cl.duoc.tsa.solemne2.datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ServicioDatosImpl implements ServicioDatos {

	/* Listado de tablas */
	
	public List<UsuariosVO> getUsuarios(Connection conn) {
		final List<UsuariosVO> lista = new ArrayList<UsuariosVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_usuarios(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final UsuariosVO objTemp = new UsuariosVO();
				objTemp.setRut( result.getInt("rut") );
				objTemp.setNombre( result.getString("nombre") );
				objTemp.setApellido_pat( result.getString("apellido_pat") );
				objTemp.setApellido_mat( result.getString("apellido_mat") );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar usuarios");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<PlataformasVO> getPlataformas(Connection conn) {
		final List<PlataformasVO> lista = new ArrayList<PlataformasVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_plataforma(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final PlataformasVO objTemp = new PlataformasVO();
				objTemp.setId_plataforma( result.getInt("id_plataforma") );
				objTemp.setNombre_plataforma( result.getString("nombre_plataforma") );
				objTemp.setDescripcion( result.getString("descripcion") );
				objTemp.setLog_estado( result.getString("log_estado").charAt(0) );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar plataformas");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<LenguajeVO> getLenguajes( Connection conn ) {
		final List<LenguajeVO> lista = new ArrayList<LenguajeVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_lenguaje(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final LenguajeVO objTemp = new LenguajeVO();
				objTemp.setId_lenguaje( result.getInt("id_lenguaje") );
				objTemp.setDescripcion( result.getString("descripcion") );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar lenguajes");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<SistemasVO> getSistemas(Connection conn) {
		final List<SistemasVO> lista = new ArrayList<SistemasVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_sistema(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final SistemasVO objTemp = new SistemasVO();
				objTemp.setId_sistema( result.getInt("id_sistema") );
				objTemp.setDescripcion( result.getString("descripcion") );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar sistemas");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<AplicacionesVO> getAplicaciones(Connection conn) {
		final List<AplicacionesVO> lista = new ArrayList<AplicacionesVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_aplicaciones(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final AplicacionesVO objTemp = new AplicacionesVO();
				objTemp.setId_aplicacion( result.getInt("id_aplicacion") );
				objTemp.setDescripcion( result.getString("descripcion") );
				objTemp.setId_sistema( result.getInt("id_sistema") );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar aplicaciones");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<DetalleApliVO> getDetalleApli(Connection conn) {
		final List<DetalleApliVO> lista = new ArrayList<DetalleApliVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_detalle_apli(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final DetalleApliVO objTemp = new DetalleApliVO();
				objTemp.setId_det( result.getInt("id_det") );
				objTemp.setId_lenguaje( result.getInt("id_lenguaje") );
				objTemp.setId_aplicacion( result.getInt("id_aplicacion") );
				objTemp.setId_plataforma( result.getInt("id_plataforma") );
				objTemp.setDescripcion( result.getString("descripcion") );
				objTemp.setRut_especialista( result.getInt("rut_especialista") );
				objTemp.setRut_dueno( result.getInt("rut_dueno") );
				objTemp.setBase_de_datos( result.getString("base_de_datos").charAt(0) );
				objTemp.setLog_estado( result.getString("log_estado").charAt(0) );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar detalle de aplicaciones");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	public List<RegistroLogVO> getRegistroLog(Connection conn) {
		final List<RegistroLogVO> lista = new ArrayList<RegistroLogVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call p_lista_registro_log(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final RegistroLogVO objTemp = new RegistroLogVO();
				objTemp.setId( result.getInt("id") );
				objTemp.setRut( result.getInt("rut") );
				objTemp.setFecha( result.getDate("fecha") );
				objTemp.setDetalle_cambio( result.getString("detalle_cambio") );
				objTemp.setId_det( result.getInt("id_det") );
				lista.add(objTemp);
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al recuperar registros de log");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( result != null ) try { result.close(); } catch (Exception e) {}
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}
		
		return lista;
	}

	/* Insercion de tablas */
	
	public boolean insUsuarios(Connection conn, UsuariosVO objUsuario) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_usuarios(?,?,?,?)}");
			cstmt.setInt(1, objUsuario.getRut());
			cstmt.setString(2, objUsuario.getNombre());
			cstmt.setString(3, objUsuario.getApellido_pat());
			cstmt.setString(4, objUsuario.getApellido_mat());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar usuarios");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar usuarios");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	public boolean insPlataformas(Connection conn, PlataformasVO objPlataforma) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_plataformas(?,?,?)}");
			cstmt.setInt(1, objPlataforma.getId_plataforma());
			cstmt.setString(2, objPlataforma.getNombre_plataforma());
			cstmt.setString(3, objPlataforma.getDescripcion());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar plataforma");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar plataforma");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	public boolean insLenguajes(Connection conn, LenguajeVO objLenguaje) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_lenguaje(?,?)}");
			cstmt.setInt(1, objLenguaje.getId_lenguaje());
			cstmt.setString(2, objLenguaje.getDescripcion());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar lenguaje");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar lenguaje");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	public boolean insSistemas(Connection conn, SistemasVO objSistema) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_sistema(?,?)}");
			cstmt.setInt(1, objSistema.getId_sistema());
			cstmt.setString(2, objSistema.getDescripcion());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar sistema");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar sistema");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	public boolean insAplicaciones(Connection conn, AplicacionesVO objAplicacion) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_aplicacion(?,?,?)}");
			cstmt.setInt(1, objAplicacion.getId_aplicacion());
			cstmt.setString(2, objAplicacion.getDescripcion());
			cstmt.setInt(3, objAplicacion.getId_sistema());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar aplicacion");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar aplicacion");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	/* Inserta en tabla Aplicaciones y Detalle_aplicacion */
	public boolean insDetalleApli(Connection conn, AplicacionesVO objAplicacion, DetalleApliVO objDetalleApli) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call P_ingresa_o_actualiza(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(1, objAplicacion.getId_aplicacion());
			cstmt.setString(2, objAplicacion.getDescripcion());
			cstmt.setInt(3, objAplicacion.getId_sistema());
			cstmt.setInt(4, objDetalleApli.getId_det());
			cstmt.setInt(5, objDetalleApli.getId_lenguaje());
			cstmt.setInt(6, objDetalleApli.getId_aplicacion());
			cstmt.setInt(7, objDetalleApli.getId_plataforma());
			cstmt.setString(8, objDetalleApli.getDescripcion());
			cstmt.setInt(9, objDetalleApli.getRut_especialista());
			cstmt.setInt(10, objDetalleApli.getRut_dueno());
			cstmt.setString(11, ""+(objDetalleApli.getBase_de_datos()));
			cstmt.setString(12, ""+objDetalleApli.getLog_estado());
			try
			{
				cstmt.executeUpdate();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar detalle de aplicación");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar detalle de aplicacion");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	public boolean insRegistroLog(Connection conn, RegistroLogVO objRegistroLog) {
		boolean result = false;
		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall("{call inserta_registro_log(?,?,?,?,?)}");
			cstmt.setInt(1, objRegistroLog.getId());
			cstmt.setInt(2, objRegistroLog.getRut());
			java.sql.Date fecha = java.sql.Date.valueOf(objRegistroLog.getFecha().toString());
			cstmt.setDate(3, fecha);
			cstmt.setString(4, objRegistroLog.getDetalle_cambio());
			cstmt.setInt(5, objRegistroLog.getId_det());
			try
			{
				cstmt.execute();
				result = true;
			}
			catch( Exception e )
			{
				System.out.println("Error al insertar registro de log");
				e.printStackTrace( System.out );
			}
		}
		catch( Exception e )
		{
			System.out.println("Error al insertar registro de log");
			e.printStackTrace( System.out );
		}
		finally
		{
			if( cstmt != null ) try { cstmt.close(); } catch (Exception e) {}
		}

		return result;
	}

	
}
