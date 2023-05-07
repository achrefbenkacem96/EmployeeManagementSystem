package EmployeeManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDashboard extends JFrame {
	public User user;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the frame.
	 */
	public UserDashboard(User user) {
        this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("demande de congé");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemandeConge frame = new DemandeConge(user);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(62, 95, 154, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("suivi mon congé");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SConge frame = new SConge(user);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(226, 95, 127, 47);
		contentPane.add(btnNewButton_1);
	}

}
