package cl.duoc.tsa.solemne2.datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ServicioDatosImpl implements ServicioDatos {

	public List<LenguajeVO> getLenguajes( Connection conn ) {
		final List<LenguajeVO> lista = new ArrayList<LenguajeVO>();
		
		CallableStatement cstmt = null;
		ResultSet result = null;
		try
		{
			cstmt = conn.prepareCall("{call lista_lenguaje(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			result = ((OracleCallableStatement)cstmt).getCursor(1);
			while( result.next() )
			{
				final LenguajeVO objTemp = new LenguajeVO();
				objTemp.setId( result.getInt("id_lenguaje") );
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

	public List<AplicacionesVO> getAplicaciones(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
