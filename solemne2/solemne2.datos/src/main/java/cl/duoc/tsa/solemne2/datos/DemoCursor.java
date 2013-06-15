package cl.duoc.tsa.solemne2.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class DemoCursor {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver( new OracleDriver() );
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.105:1521:orcl","tsa","tsa");

		ServicioDatosImpl impl = new ServicioDatosImpl();
		List<LenguajeVO> lista = impl.getLenguajes(conn);
		for( LenguajeVO vo : lista )
		{
			System.out.println("Descripcion : " + vo.getDescripcion());
		}
		
		conn.close();
	}

}
