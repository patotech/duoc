package pruebas;

import java.sql.*;

public class Conexion {
    public static Connection GetConexion() throws ConexionException{
	    Connection con=null;
	    try{
	        String driverClassName="com.oracle.odbc.Driver";
	        String urlDriver="odbc:oracle://192.168.1.105/Inventario_aplicaciones";
	        Class.forName(driverClassName);
	        con=DriverManager.getConnection(urlDriver,"tsa","tsa");
	    }catch(Exception e){
	        throw new ConexionException("Fallo en conexion a BD");
	    }
	    return con;
    }
}    
