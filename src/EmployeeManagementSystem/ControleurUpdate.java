package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class ControleurUpdate implements ActionListener {
	DAO<User> userDAO;
	EmployerManagement vue;
	public ControleurUpdate(EmployerManagement vue) {
		super();
		this.vue = vue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		userDAO = DAOFactory.getEleveImpl();
		String nom =  vue.lastName.getText() ;
		int id =  Integer.parseInt(vue.id.getText())  ;
		String prenom =  vue.firstName.getText() ;
		String password =  vue.password.getText() ;
		String email =  vue.email.getText() ;
		String role =  (String) vue.role.getSelectedItem();

		User obj = new User(id, nom, prenom, email, password, role);
		System.out.println(obj);
		boolean res = userDAO.update(obj);
		if (res) {
			JOptionPane.showMessageDialog(vue, "mise à jour réussie ");
			ResultSet users = userDAO.getAll();
			vue.table.setModel(DbUtils.resultSetToTableModel(users));
		}else {
			JOptionPane.showMessageDialog(vue, "mise à jour non effectué", nom, JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
