package EmployeeManagementSystem;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SConge extends JFrame {
	DAO<Conge> congeDAO;
	public User user;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public SConge(User user) {
        this.user = user;
		congeDAO = DAOFactory.getCongeImpl();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ResultSet conges = congeDAO.getAllById(user.getId());
		table.setModel(DbUtils.resultSetToTableModel(conges));
	}
}
