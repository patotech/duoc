package cl.duoc.tsa.solemne2.servicios;

import java.sql.Connection;

import javax.sql.DataSource;

import cl.duoc.tsa.solemne2.spring.SpringApplicationContext;

public class ConnectionHelper {

	public static final Connection getConnection()
	{
		Connection conn = null;
		try
		{
			final DataSource ds = (DataSource) SpringApplicationContext.getBean("dataSource");
			conn = ds.getConnection();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static final void releaseConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// Nada por ahora
			}
		}
	}
}
