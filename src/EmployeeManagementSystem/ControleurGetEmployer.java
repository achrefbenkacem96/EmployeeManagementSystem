package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class ControleurGetEmployer implements ActionListener {
	DAO<User> userDAO;
	EmployerManagement vue;
	public ControleurGetEmployer(EmployerManagement vue) {
		super();
		this.vue = vue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		userDAO = DAOFactory.getEleveImpl();
		ResultSet users = userDAO.getAll();
		vue.table.setModel(DbUtils.resultSetToTableModel(users));
	}
}
