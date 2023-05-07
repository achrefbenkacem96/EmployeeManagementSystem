package EmployeeManagementSystem;

import java.sql.ResultSet;
import java.util.List;

public interface DAO<T> {
	public boolean create(T obj);
	public ResultSet getAll();
	public ResultSet getAllById(int id);
	public T find(int id);
	public boolean delete(int id);
	public boolean update(T obj);
	public T findUser(String email, String password);
}
