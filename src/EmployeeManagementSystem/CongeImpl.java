package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class CongeImpl implements DAO<Conge> {
	protected Connection cnx;

	public CongeImpl(Connection cnx) {
		super();
		this.cnx = cnx;
	}

	@Override
	public boolean create(Conge obj) {
	    try {
	        String query = "INSERT INTO conge (start_date, end_date, description, user_id) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = this.cnx.prepareStatement(query);
	        pstmt.setDate(1, (java.sql.Date) obj.getStartDate());
	        pstmt.setDate(2, (java.sql.Date) obj.getEndDate());
	        pstmt.setString(3, obj.getDescription());
	        pstmt.setInt(4, obj.getUserId());
	        int result = pstmt.executeUpdate();
	        if (result == 1) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public ResultSet getAll() {
		try {
	        PreparedStatement ps = this.cnx.prepareStatement("SELECT * FROM conge");
	        return ps.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public Conge find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Conge obj) {
		 boolean success = false;
		    try {
		        String query = "UPDATE conge SET status = ? WHERE id = ?";
		        PreparedStatement statement = this.cnx.prepareStatement(query);
		        statement.setString(1, obj.getStatus());
		        statement.setInt(2, obj.getId());
		        int rowsAffected = statement.executeUpdate();
		        if (rowsAffected > 0) {
		            success = true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return success;
	}

	@Override
	public Conge findUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getAllById(int id) {
		 try {
		        PreparedStatement ps = this.cnx.prepareStatement("SELECT * FROM conge WHERE user_id = ?");
		        ps.setInt(1, id);
		        return ps.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
	}

}
