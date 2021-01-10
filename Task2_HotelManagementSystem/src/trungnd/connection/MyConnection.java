/**
 * 
 */
package trungnd.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author HOME
 *
 */
public class MyConnection {
	private static String databaseURL = "jdbc:mysql://localhost:2504/hotelmanagement";
	private static String username = "root";
	private static String password = "Trungtyty25112504";
	
	public static Connection getMyConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
//            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!!!");
            ex.printStackTrace();
        }
        return conn;
    }
}
