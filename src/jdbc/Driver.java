/**
 * 2355 Sehai Fation
 * 2343 Rentas Nikolaoas
 * 2359 Spyrakhs Kwnstantinos
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	private static Connection theConnection;
	private boolean connected = true;

	/**
	 * Constructor gia class Driver.
	 */
	public Driver() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // load jdbc driver
			theConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/private_sector_schema", "root", ""); // get connection to database
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Connection Error");
			connected = false;
		}
	}

	/**
	 * Constructor gia class Driver me orismata twra.
	 */
	public Driver(String user, char[] password, String host, int port, String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // load jdbc driver
			String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
			String pass = "";
			for (char s: password) {
				pass += s;
			}
			theConnection = DriverManager.getConnection(url, user, pass); // get connection to database
		} catch (Exception e) {
			System.err.println("Connection Error");
			connected = false;
		}		
	}

	/**
	 * Auth h methodos epistrefei ama einai se sindesh.
	 */
	public boolean getStatus() {
		return connected;
	}

	/**
	 * Auth h methodos klinei to SQL connection
	 */
	public void closeConnection() {
		try {
			Driver.theConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auth h methodos ektelei ena aplo select query sth bash mas kai epistrefei tis xwres ths eurozonhs
	 */
	public void simpleQuery() {
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from countries";
		try {
			st = theConnection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString(1) + ": ");
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auth h methodos ektelei to query pou periexei to String querry pou to edwse o xrhsths apo to GUI
	 */
	public ResultSet executeQuerry(String query) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = theConnection.createStatement();
			rs = st.executeQuery(query);
			return rs;
		} catch (Exception e) {
			return null; // kati phge lathos sto SQL query
			//e.printStackTrace();
		}
	}

}
