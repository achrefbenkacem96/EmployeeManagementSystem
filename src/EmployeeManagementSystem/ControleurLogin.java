package EmployeeManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class ControleurLogin implements ActionListener {
	DAO<User> userDAO;
	Login vue;
	public ControleurLogin(Login login) {
		super();
		this.vue = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		userDAO = DAOFactory.getEleveImpl();
		String email =  vue.email.getText() ;
		String password =  vue.password.getText() ;
		User res = userDAO.findUser(email, password);
		System.out.println("1 !");
		 if (res !=null) {
			 if (res.getRole() == "Admin") {
				 System.out.println("done !");
				 vue.setVisible(false);
				 AdmindDashboard frame = new AdmindDashboard();
				 frame.setVisible(true);
			} else {

				UserDashboard frame = new UserDashboard(res);
				 frame.setVisible(true);
			}
		  } else {
              JOptionPane.showMessageDialog(null, "Invalid username or password");
              vue.setVisible(false);
          }
		 System.out.println("null !");
	}
 
}
