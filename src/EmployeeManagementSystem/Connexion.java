package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String url= "jdbc:mysql:///employeemanagementsystem";
	private String user= "root";
	private String psw= "";
	private static Connection connect;
	private Connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url,user,psw);			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static Connection getInstance() {
		if (connect == null) {
			synchronized(Connexion.class) {
				if (connect == null) {
					new Connexion();
				}
			}
		}
		return connect;
	}
    
}
