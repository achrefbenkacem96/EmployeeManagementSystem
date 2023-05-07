package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class ControleurDelete implements ActionListener {
	DAO<User> userDAO;
	EmployerManagement vue;
	public ControleurDelete(EmployerManagement vue) {
		super();
		this.vue = vue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		userDAO = DAOFactory.getEleveImpl();
		int id =  Integer.parseInt(vue.id.getText())  ;

		boolean res = userDAO.delete(id);
		if (res) {
			JOptionPane.showMessageDialog(vue, "utilisateur supprimé " );
			ResultSet users = userDAO.getAll();
			vue.table.setModel(DbUtils.resultSetToTableModel(users));
		}else {
			JOptionPane.showMessageDialog(vue, "mise à jour non effectué", null, JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
