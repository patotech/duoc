package cl.duoc.tsa.solemne2.datos;

import java.sql.Connection;
import java.util.List;

public interface ServicioDatos {

	public List<LenguajeVO> getLenguajes( Connection conn );
	public List<AplicacionesVO> getAplicaciones( Connection conn );
}
