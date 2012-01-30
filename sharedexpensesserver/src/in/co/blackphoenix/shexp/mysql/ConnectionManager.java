package in.co.blackphoenix.shexp.mysql;

import in.co.blackphoenix.shexp.utils.LoggingManager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;

import com.mysql.jdbc.Connection;

/**
 * ConnectionManager 
 * 
 * Singleton class for managing SQL connection.
 * - Sets up connection with remote MYSQL server
 * @author Manoj
 *
 */
public class ConnectionManager {

	private static String SQL_DB_URL = "//localhost";
	
	private static String SQL_DB_USERNAME = "root";
	
	private static String SQL_DB_PASSWORD = "";
	
	//SQL JDBC Connection
	private static Connection mySQLConnection = null;
	
	private ConnectionManager(){}
	
	/**
	 * access the connection to remote mysql server
	 * @return - MYSQL connection object 
	 */
	public static Connection getSQLConnection(){
		
		if(mySQLConnection == null){
			
			try {
				// This will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");
			
				// Setup the connection with the DB
				mySQLConnection = (Connection) DriverManager
						.getConnection("jdbc:mysql:" + SQL_DB_URL + "/feedback?"
								+ "user=" + SQL_DB_USERNAME + "&password=" + SQL_DB_PASSWORD);
				
			} catch (SQLException e) {

				LoggingManager.getMyLogger().log(Level.SEVERE, "Error Connecting to MYSQL Server \n" + e.getStackTrace());
				
			} catch (ClassNotFoundException e) {
	
				LoggingManager.getMyLogger().log(Level.SEVERE, "SQL JDBC Driver not found. \n" + e.getStackTrace());
			}
		}
		
		return mySQLConnection;
	}
}
