package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Driver {
	private Connection connection;
	
	private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/shoppinglist";

	
	public Driver() throws SQLException, ClassNotFoundException {
		super();
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		
		Connection c = DriverManager.getConnection(CONNECTION, p);
		this.connection = c;
		
	}

	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnetion() throws SQLException{
		this.connection.close();
	}
}