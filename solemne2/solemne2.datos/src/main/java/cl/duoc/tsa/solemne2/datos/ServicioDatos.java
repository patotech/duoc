package cl.duoc.tsa.solemne2.datos;

import java.sql.*;
import java.util.*;

public interface ServicioDatos {

	
	public List<LenguajeVO> getLenguajes( Connection conn );
	public List<AplicacionesVO> getAplicaciones( Connection conn );
	public List<DetalleApliVO> getDetalleApli( Connection conn );
	public List<PlataformasVO> getPlataforma( Connection conn );
	public List<RegistroLogVO> getRegistroLog( Connection conn );
	public List<SistemasVO> getSistemas( Connection conn );
	public List<UsuariosVO> getUsuarios( Connection conn );
	public boolean insDetalleApli(Connection conn, AplicacionesVO objAplicacion, DetalleApliVO objDetalleApli);
	public boolean eliDetalleApli(Connection conn, DetalleApliVO objDetalleApli);
}
