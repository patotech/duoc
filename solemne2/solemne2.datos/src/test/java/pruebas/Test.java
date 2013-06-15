package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import oracle.jdbc.OracleDriver;
import cl.duoc.tsa.solemne2.datos.AplicacionesVO;
import cl.duoc.tsa.solemne2.datos.DetalleApliVO;
import cl.duoc.tsa.solemne2.datos.LenguajeVO;
import cl.duoc.tsa.solemne2.datos.PlataformasVO;
import cl.duoc.tsa.solemne2.datos.RegistroLogVO;
import cl.duoc.tsa.solemne2.datos.ServicioDatosImpl;
import cl.duoc.tsa.solemne2.datos.SistemasVO;
import cl.duoc.tsa.solemne2.datos.UsuariosVO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver( new OracleDriver() );
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.105:1521:orcl","tsa","tsa");

		ServicioDatosImpl impl = new ServicioDatosImpl();
		
		/*
		List<AplicacionesVO> lista1 = impl.getAplicaciones(conn);
		for( AplicacionesVO vo : lista1 )
		{
			System.out.println("ID Aplicacion: " + vo.getId_aplicacion() + " Descripcion : " + vo.getDescripcion() + " ID Sistema : " + vo.getId_sistema());
		}
		
		List<DetalleApliVO> lista2 = impl.getDetalleApli(conn);
		for( DetalleApliVO vo : lista2 )
		{
			System.out.println("ID Det : " + vo.getId_det() + " ID Lenguaje: " + vo.getId_lenguaje() + " ID Aplic: " + vo.getId_aplicacion() + " ID Plataf: " + vo.getId_plataforma() + " Descripcion : " + vo.getDescripcion() + " Rut Esp: " + vo.getRut_especialista() + " Rut Due: " + vo.getRut_dueno() + " BBDD: " + vo.getBase_de_datos() + " Log Est: " + vo.getLog_estado());
		}
		
		List<LenguajeVO> lista3 = impl.getLenguajes(conn);
		for( LenguajeVO vo : lista3 )
		{
			System.out.println("ID : " + vo.getId_lenguaje() + " Descripcion : " + vo.getDescripcion());
		}
		
		List<PlataformasVO> lista4 = impl.getPlataformas(conn);
		for( PlataformasVO vo : lista4 )
		{
			System.out.println("ID Plat: " + vo.getId_plataforma() + " Nombre Plat: " + vo.getNombre_plataforma() + " Descripcion : " + vo.getDescripcion() + " Log Est: " + vo.getLog_estado());
		}
		
		List<RegistroLogVO> lista5 = impl.getRegistroLog(conn);
		for( RegistroLogVO vo : lista5 )
		{
			System.out.println("ID : " + vo.getId() + " Rut : " + vo.getRut() + " Fecha : " +vo.getFecha() + " Detalle cambio : " + vo.getDetalle_cambio() + " Id Det: " + vo.getId_det());
		}
		
		List<SistemasVO> lista6 = impl.getSistemas(conn);
		for( SistemasVO vo : lista6 )
		{
			System.out.println("ID Sist: " + vo.getId_sistema() + " Descripcion : " + vo.getDescripcion());
		}
		
		List<UsuariosVO> lista7 = impl.getUsuarios(conn);
		for( UsuariosVO vo : lista7 )
		{
			System.out.println("Rut: " + vo.getRut() + " Nombre : " + vo.getNombre() + " Apellido pat: " + vo.getApellido_pat() + " Apellido mat: " + vo.getApellido_mat());
		}
		
		*/
		
		AplicacionesVO objAplicacion = new AplicacionesVO(
		102,"aplic modificada",141
		);
		
		DetalleApliVO objDetalleApli = new DetalleApliVO(
		910,200,100,500,"Nuevo detalle //////",-152445856,-132254698,'S','1'
		);
		
		boolean result = impl.insDetalleApli(conn, objAplicacion, objDetalleApli);
		System.out.println("Resultado insercion: " + result);
				
		conn.close();
	}
}
