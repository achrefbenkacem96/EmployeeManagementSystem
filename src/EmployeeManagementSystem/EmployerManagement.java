package EmployeeManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class EmployerManagement extends JFrame {
	DAO<User> userDAO;
 	private JPanel contentPane;
	public JTable table;
	public JTextField lastName;
	public JTextField firstName;
	public JTextField password;
	public JTextField email;
	public JComboBox role;
	public JTextField id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployerManagement frame = new EmployerManagement();
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
	public EmployerManagement() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 27, 496, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
			        TableModel model = table.getModel();
			        id.setText(model.getValueAt(i, 0).toString());
			        firstName.setText(model.getValueAt(i, 1).toString());
			        lastName.setText(model.getValueAt(i, 2).toString());
			        password.setText(model.getValueAt(i, 3).toString());
			        email.setText(model.getValueAt(i, 4).toString());
			        
			        String selectedRole = model.getValueAt(i, 5).toString();
			        int roleIndex = role.getItemCount() - 1; // initialize to the last item in the combo box
			        for (int j = 0; j < role.getItemCount(); j++) {
			            if (role.getItemAt(j).equals(selectedRole)) {
			                roleIndex = j;
			                break;
			            }
			        }
			        role.setSelectedIndex(roleIndex);
			    }
			}
		});
		userDAO = DAOFactory.getEleveImpl();
		ResultSet users = userDAO.getAll();
		table.setModel(DbUtils.resultSetToTableModel(users));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(10, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("email");
		lblNewLabel_3.setBounds(10, 129, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("role");
		lblNewLabel_4.setBounds(10, 154, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lastName = new JTextField();
		lastName.setBounds(140, 48, 86, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		firstName = new JTextField();
		firstName.setBounds(140, 73, 86, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		password = new JTextField();
		password.setBounds(140, 98, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		email = new JTextField();
		email.setBounds(140, 123, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnRefrech = new JButton("Refrech");
		ControleurGetEmployer c1 = new ControleurGetEmployer(this);
 		btnRefrech.addActionListener(c1);
		btnRefrech.setBounds(10, 226, 92, 23);
		contentPane.add(btnRefrech);
		
		JButton update = new JButton("Update");
		ControleurUpdate updateUser = new ControleurUpdate(this);
		update.addActionListener(updateUser);
		update.setBounds(10, 271, 92, 23);
		contentPane.add(update);
		
		JButton btn_Add = new JButton("Ajouter");
		ControleurAddUser c2 = new ControleurAddUser(this);

		btn_Add.addActionListener(c2);
		btn_Add.setBounds(112, 226, 114, 23);
		contentPane.add(btn_Add);
		
		JButton btn_delete = new JButton("Delete");
		ControleurDelete delete = new ControleurDelete(this);
		btn_delete.addActionListener(delete);
		btn_delete.setBounds(112, 271, 114, 23);
		contentPane.add(btn_delete);
		
		role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		role.setBounds(140, 150, 86, 22);
		contentPane.add(role);
		
		JLabel lblNewLabel_5 = new JLabel("id");
		lblNewLabel_5.setBounds(10, 28, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(140, 25, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btn_retour = new JButton("retour");
		btn_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 AdmindDashboard frame = new AdmindDashboard();
					frame.setVisible(true);
			}
		});
		btn_retour.setBounds(10, 323, 89, 23);
		contentPane.add(btn_retour);
	}
}
