package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection connection;
	private  String bd ="db_alumnos";
    private String usuario = "root";
    private String contrasena = "yaque1993";
    private String host = "localhost";
    private String port = "3306";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + bd+ "?user=" + usuario + "&password=" + contrasena + "&useSSL=false";

	public Connection getConnection() {

		return connection;
	}
	public void setConnection(Connection connection) {

		this.connection = connection;
	}
	
	public void establecerConexion(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, usuario, contrasena);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
