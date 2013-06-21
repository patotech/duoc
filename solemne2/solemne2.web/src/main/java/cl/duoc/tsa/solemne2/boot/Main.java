package cl.duoc.tsa.solemne2.boot;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
        Server server = new Server();
        
        ServerConnector connector = new ServerConnector(server);
        connector.setPort( Integer.parseInt( System.getProperty("solemne2.port", "8080") ) );
        server.setConnectors(new Connector[] { connector });
        
        ProtectionDomain domain = Main.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
        server.setHandler(webapp);
        
        server.start();
        server.join();
	}

}
