package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class ControleurAddConge implements ActionListener{
	DAO<Conge> congeDAO;
	DemandeConge vue;
	public ControleurAddConge(DemandeConge vue) {
		super();
		this.vue = vue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		congeDAO = DAOFactory.getCongeImpl();
		int id =  Integer.parseInt(vue.id.getText()) ;
		Date start_date =  (Date) vue.start_date.getDate() ;
		java.sql.Date sqlStartDate = new java.sql.Date(start_date.getTime());

		Date end_date =  (Date) vue.end_date.getDate() ;
		java.sql.Date sqlEndDate = new java.sql.Date(end_date.getTime());

		String description =  vue.description.getText() ;
		Conge obj = new Conge(sqlStartDate, sqlEndDate, description,id);
		boolean res = congeDAO.create(obj);
		if (res) {
			JOptionPane.showMessageDialog(vue, "ajouter avec succés");
			ResultSet users = congeDAO.getAll();
 		}else {
			JOptionPane.showMessageDialog(vue, "ajout non effectué", null, JOptionPane.PLAIN_MESSAGE);
		}
	
		
	}

}
