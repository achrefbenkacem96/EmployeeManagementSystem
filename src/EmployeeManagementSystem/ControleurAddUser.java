package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;


 

public class ControleurAddUser implements ActionListener {
	DAO<User> userDAO;
	EmployerManagement vue;
 
	public ControleurAddUser(EmployerManagement vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userDAO = DAOFactory.getEleveImpl();
		String nom =  vue.lastName.getText() ;
		String prenom =  vue.firstName.getText() ;
		String password =  vue.password.getText() ;
		String email =  vue.email.getText() ;
		String role =  (String) vue.role.getSelectedItem();
		User obj = new User(nom, prenom, email, password, role);
		boolean res = userDAO.create(obj);
		if (res) {
			JOptionPane.showMessageDialog(vue, "ajouter avec succés");
			ResultSet users = userDAO.getAll();
			vue.table.setModel(DbUtils.resultSetToTableModel(users));
		}else {
			JOptionPane.showMessageDialog(vue, "ajout non effectué", nom, JOptionPane.PLAIN_MESSAGE);
		}
	
		
	}

}
