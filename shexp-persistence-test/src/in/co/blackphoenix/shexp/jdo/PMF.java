package in.co.blackphoenix.shexp.jdo;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	public static PersistenceManager get(){
		Properties props = new Properties();
		props.setProperty("datanucleus.ConnectionDriverName","com.mysql.jdbc.Driver");
		props.setProperty("datanucleus.ConnectionURL","jdbc:mysql://localhost/jdotest");
		props.setProperty("datanucleus.ConnectionUserName","root");
		props.setProperty("datanucleus.ConnectionPassword","");
		props.setProperty("datanucleus.connectionPoolingType", "DBCP");
		props.setProperty("datanucleus.autoCreateSchema", "true");
		props.setProperty("datanucleus.validateTables", "false");
		props.setProperty("datanucleus.validateConstraints", "false");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(props);
		PersistenceManager pm = pmf.getPersistenceManager();
		return pm;
	}
}
