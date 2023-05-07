package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements DAO<User> {
	protected Connection cnx;

	public UserImpl(Connection cnx) {
		super();
		this.cnx = cnx;
	}

	@Override
	public boolean create(User obj) {
		boolean res = false;
		try {
			
			String req= "insert into users ( nom, prenom, password, email, role) values(?,?,?,?,?)";
			PreparedStatement pst = this.cnx.prepareStatement(req);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getPrenom());
			pst.setString(3, obj.getPassword());
			pst.setString(4, obj.getEmail());
			pst.setString(5, obj.getRole());
			int r = pst.executeUpdate();
			if (r>0) {
				res = true;
			} 
			return res;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return res;
	}

	@Override
	public ResultSet getAll() {
		 ResultSet rs = null;
		    String query = "SELECT * FROM users";
		    try {
		        PreparedStatement statement = this.cnx.prepareStatement(query);
		        rs = statement.executeQuery();
		         
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rs;
		}
	 

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public User findUser(String email, String password) {
		User u = null; 
		try {
			System.out.println(email);
			System.out.println(password);
			ResultSet res = this.cnx.createStatement().executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
			System.out.println(res);

			System.out.println("select * from users where email='"+email+"' and password='"+password+"'");
			while(res.next()) {
				 u = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
			 }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return u;
	}

	@Override
	public boolean update(User obj) {
		 try {
			 System.out.println("update");
		        String query = "UPDATE users SET nom=?, prenom=?, password=?, email=?, role=? WHERE id=?";
		        PreparedStatement stmt = cnx.prepareStatement(query);
		        stmt.setString(1, obj.getNom());
		        stmt.setString(2, obj.getPrenom());
		        stmt.setString(3, obj.getPassword());
		        stmt.setString(4, obj.getEmail());
		        stmt.setString(5, obj.getRole());
		        stmt.setInt(6, obj.getId());
		        int result = stmt.executeUpdate();
		        return result > 0; // returns true if the query updates at least one row
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}

	@Override
	public boolean delete(int id) {
		try {
	        String query = "DELETE FROM users WHERE id=?";
	        PreparedStatement stmt = cnx.prepareStatement(query);
	        stmt.setInt(1, id);
	        int result = stmt.executeUpdate();
	        return result > 0; // returns true if the query deletes at least one row
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public ResultSet getAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

 
 
}
