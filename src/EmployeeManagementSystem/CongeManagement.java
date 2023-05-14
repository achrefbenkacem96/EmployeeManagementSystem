package EmployeeManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CongeManagement extends JFrame {
	DAO<Conge> congeDAO;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CongeManagement frame = new CongeManagement();
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
	public CongeManagement() {
		congeDAO = DAOFactory.getCongeImpl();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 35, 492, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ResultSet conges = congeDAO.getAll();
		table.setModel(DbUtils.resultSetToTableModel(conges));
		JButton accepter = new JButton("accepter");
		accepter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
				    TableModel model = table.getModel();
				    int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
				    Date startDate = (Date) model.getValueAt(selectedRow, 1);
				    Date endDate = (Date) model.getValueAt(selectedRow, 2);
				    String description = model.getValueAt(selectedRow, 3).toString();
				    String status = model.getValueAt(selectedRow, 4).toString();
				    int userId = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
				    
				    Conge selectedConge = new Conge(id, startDate, endDate, description, "Accepté", userId);
				    boolean res = congeDAO.update(selectedConge);
					if (res) {
						ResultSet users = congeDAO.getAll();
						table.setModel(DbUtils.resultSetToTableModel(users));
					}else {
					}
				}
			}
		});
		accepter.setBounds(10, 65, 89, 23);
		contentPane.add(accepter);
		
		JButton refuser = new JButton("refuser");
		refuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
				    TableModel model = table.getModel();
				    int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
				    Date startDate = (Date) model.getValueAt(selectedRow, 1);
				    Date endDate = (Date) model.getValueAt(selectedRow, 2);
				    String description = model.getValueAt(selectedRow, 3).toString();
				    String status = model.getValueAt(selectedRow, 4).toString();
				    int userId = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
				    
				    Conge selectedConge = new Conge(id, startDate, endDate, description, "Refusé", userId);
				    boolean res = congeDAO.update(selectedConge);
					if (res) {
						ResultSet conge = congeDAO.getAll();
						table.setModel(DbUtils.resultSetToTableModel(conge));
					}else {
					}
				}
			}
		});
		refuser.setBounds(10, 99, 89, 23);
		contentPane.add(refuser);
		
		JButton btnretour = new JButton("Retour");
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdmindDashboard frame = new AdmindDashboard();
				frame.setVisible(true);
			}
		});
		btnretour.setBounds(10, 133, 89, 23);
		contentPane.add(btnretour);
	}
}
