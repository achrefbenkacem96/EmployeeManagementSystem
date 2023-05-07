package EmployeeManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class DemandeConge extends JFrame {
	public User user;

	private JPanel contentPane;
	private JTextField textField;
	public JTextField id;
	public JDateChooser start_date;
	public JDateChooser end_date;
	public JTextPane description;
 
	public DemandeConge(User user) {
        this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idTxt = new JLabel("id");
		idTxt.setBounds(10, 25, 92, 14);
		contentPane.add(idTxt);
		
		JLabel lblNewLabel_1 = new JLabel("start date");
		lblNewLabel_1.setBounds(10, 50, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("end date");
		lblNewLabel_2.setBounds(10, 94, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("description");
		lblNewLabel_3.setBounds(10, 131, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(112, 22, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		id.setText(Integer.toString(user.getId()) );
		
		description = new JTextPane();
		description.setBounds(109, 125, 254, 53);
		contentPane.add(description);
		
		JButton btnNewButton = new JButton("submit");
		ControleurAddConge addConge = new ControleurAddConge(this);
		btnNewButton.addActionListener(addConge);
		btnNewButton.setBounds(109, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton retour = new JButton("retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard frame = new UserDashboard(user);
				frame.setVisible(true);
			}
		});
		retour.setBounds(274, 213, 89, 23);
		contentPane.add(retour);
		
		start_date = new JDateChooser();
		start_date.setBounds(112, 44, 86, 20);
		contentPane.add(start_date);
		
		end_date = new JDateChooser();
		end_date.setBounds(112, 88, 86, 20);
		contentPane.add(end_date);
		
 
	}
}
