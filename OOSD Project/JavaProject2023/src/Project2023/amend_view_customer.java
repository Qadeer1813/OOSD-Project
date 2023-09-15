//	Author: Qadeer Hussain
//	Purpose: Amend/View Customer
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class amend_view_customer{

	private JFrame AmendViewCustomer;
	private JTable table;
	private JButton AmendViewCustomerScreenButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amend_view_customer window = new amend_view_customer();
					window.AmendViewCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public amend_view_customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AmendViewCustomer = new JFrame();
		AmendViewCustomer.setTitle("Amend/View Customer");
		AmendViewCustomer.setBounds(100, 100, 655, 410);
		AmendViewCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AmendViewCustomer.getContentPane().setLayout(null);
		
//		Button to go back to Sub menu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_menu custSubmenu = new customer_menu();
				custSubmenu.main(null);
				AmendViewCustomer.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		AmendViewCustomer.getContentPane().add(BackButton);
		
//		Button to go to Add Customer Screen
		JButton AddCustomerScreenButton = new JButton("Add Customer");
		AddCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_customer addCust = new add_customer();
				addCust.main(null);
				AmendViewCustomer.dispose();
			}
		});
		AddCustomerScreenButton.setBounds(130, 60, 118, 23);
		AmendViewCustomer.getContentPane().add(AddCustomerScreenButton);
		
//		Button to go to Amend/View Customer Screen
		AmendViewCustomerScreenButton = new JButton("Amend/View Customer");
		AmendViewCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_customer amendViewCust = new amend_view_customer();
		        amendViewCust.main(null);
		        AmendViewCustomer.dispose();
			}
		});
		AmendViewCustomerScreenButton.setBounds(272, 60, 175, 23);
		AmendViewCustomer.getContentPane().add(AmendViewCustomerScreenButton);
		
//		Button to go to Delete Customer Screen
		JButton DeleteCustomerScreenButton = new JButton("Delete Customer");
		DeleteCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_customer deleteCust = new delete_customer();
				deleteCust.main(null);
				AmendViewCustomer.dispose();
			}
		});
		DeleteCustomerScreenButton.setBounds(473, 60, 132, 23);
		AmendViewCustomer.getContentPane().add(DeleteCustomerScreenButton);
		
//		Table
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 100, 619, 201);
        AmendViewCustomer.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        // load the customer data into the table
        final String DATABASE_URL = "jdbc:mysql://localhost/project";
        Connection connection = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            // establish connection to database
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            // create Prepared Statement for selecting data from the table
            pstat = connection.prepareStatement("SELECT * FROM customer");
            rs = pstat.executeQuery();
            // create a new TableModel to hold the data
            DefaultTableModel customer = new DefaultTableModel();
            // add columns to the TableModel
            customer.addColumn("CustomerID");
            customer.addColumn("Forename");
            customer.addColumn("Surname");
            customer.addColumn("Street");
            customer.addColumn("Town");
            customer.addColumn("County");
            customer.addColumn("DateOfBirth");
            customer.addColumn("Email");
            // loop through the ResultSet and add rows to the TableModel
            while (rs.next()) 
            {
                customer.addRow(new Object[] {
                    rs.getInt("CustomerID"),
                    rs.getString("Forename"),
                    rs.getString("Surname"),
                    rs.getString("Street"),
                    rs.getString("Town"),
                    rs.getString("County"),
                    rs.getString("DateOfBirth"),
                    rs.getString("Email")
                });
            }
            // set the TableModel on the JTable
            table.setModel(customer);
        }
        catch(SQLException sqlException ) {
            sqlException.printStackTrace();
        }
        finally {
            try{
                if (rs != null) {
                    rs.close();
                }
                if (pstat != null) {
                    pstat.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch ( Exception exception ){
                exception.printStackTrace();
            }
        }
		
//     	Button to update information that has been edited in the table
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        final String DATABASE_URL = "jdbc:mysql://localhost/project";
		        Connection connection = null ;
				PreparedStatement pstat = null;
		        int row = table.getSelectedRow();
		        if (row == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a customer to update");
		            return;
		        }
		        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this customer?", "Confirmation", JOptionPane.YES_NO_OPTION); 
		        if (response == JOptionPane.YES_OPTION) {
		            try {
		            	connection = DriverManager.getConnection(DATABASE_URL, "root", "");
		                pstat = connection.prepareStatement("UPDATE customer SET Forename = ?, Surname = ?, Street = ?, Town = ?, County = ?, DateOfBirth = ?, Email = ? WHERE CustomerID = ?");
		                int CustomerID = (int) table.getValueAt(row, 0);
		                String Forename = (String) table.getValueAt(row, 1);
		                String Surname = (String) table.getValueAt(row, 2);
		                String Street = (String) table.getValueAt(row, 3);
		                String Town = (String) table.getValueAt(row, 4);
		                String County = (String) table.getValueAt(row, 5);
		                String DateOfBirth = (String) table.getValueAt(row, 6);
		                String Email = (String) table.getValueAt(row, 7);
		                pstat.setString(1, Forename);
		                pstat.setString(2, Surname);
		                pstat.setString(3, Street);
		                pstat.setString(4, Town);
		                pstat.setString(5, County);
		                pstat.setString(6, DateOfBirth);
		                pstat.setString(7, Email);
		                pstat.setInt(8, CustomerID);
		                pstat.executeUpdate();
		                // show a message to indicate success
		                JOptionPane.showMessageDialog(null, "Customer updated successfully");
		            } 
		            catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "No Customer Updated");
		        }
		    }
		});

		UpdateButton.setBounds(275, 312, 89, 23);
		AmendViewCustomer.getContentPane().add(UpdateButton);
	}
}
