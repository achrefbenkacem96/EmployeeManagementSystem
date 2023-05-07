package EmployeeManagementSystem;

import java.sql.Connection;

 

public class DAOFactory {
	static Connection con = Connexion.getInstance();
	public static DAO getEleveImpl() { return new UserImpl(con); }
	public static DAO getCongeImpl() { return new CongeImpl(con); }
}
