package EmployeeManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField password;
	public JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel emailTXT = new JLabel("email");
		emailTXT.setBounds(77, 60, 46, 14);
		contentPane.add(emailTXT);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(77, 116, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("login");
		
		btnNewButton.setBounds(150, 169, 89, 23);
		contentPane.add(btnNewButton);
		ControleurLogin c1 = new ControleurLogin(this);
		btnNewButton.addActionListener( c1);
		
		password = new JTextField();
		password.setBounds(150, 113, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		email = new JTextField();
		email.setBounds(153, 57, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
	}
}
