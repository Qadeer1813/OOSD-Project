//	Author: Qadeer Hussain
//	Purpose: Delete Customer
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

public class delete_customer {

	private JFrame DeleteCustomer;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_customer window = new delete_customer();
					window.DeleteCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public delete_customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DeleteCustomer = new JFrame();
		DeleteCustomer.setTitle("Delete Screen");
		DeleteCustomer.setBounds(100, 100, 655, 410);
		DeleteCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteCustomer.getContentPane().setLayout(null);
		
//		Button to go back to Sub menu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_menu custSubmenu = new customer_menu();
				custSubmenu.main(null);
				DeleteCustomer.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		DeleteCustomer.getContentPane().add(BackButton);
		
//		Button to go to Add Customer Screen
		JButton AddCustomerScreenButton = new JButton("Add Customer");
		AddCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_customer addCust = new add_customer();
				addCust.main(null);
				DeleteCustomer.dispose();
			}
		});
		AddCustomerScreenButton.setBounds(130, 60, 118, 23);
		DeleteCustomer.getContentPane().add(AddCustomerScreenButton);
		
//		Button to go to Amend/View Customer Screen
		JButton AmendViewCustomerScreenButton = new JButton("Amend/View Customer");
		AmendViewCustomerScreenButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	amend_view_customer amendViewCust = new amend_view_customer();
		        amendViewCust.main(null);
		    	DeleteCustomer.dispose();
		    }
		});
		AmendViewCustomerScreenButton.setBounds(272, 60, 175, 23);
		DeleteCustomer.getContentPane().add(AmendViewCustomerScreenButton);
		
//		Button to go to Delete Customer Screen
		JButton DeleteCustomerScreenButton = new JButton("Delete Customer");
		DeleteCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_customer deleteCust = new delete_customer();
				deleteCust.main(null);
				DeleteCustomer.dispose();
			}
		});
		DeleteCustomerScreenButton.setBounds(473, 60, 132, 23);
		DeleteCustomer.getContentPane().add(DeleteCustomerScreenButton);
		
//		Table
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 100, 619, 201);
        DeleteCustomer.getContentPane().add(scrollPane);

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
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        final String DATABASE_URL = "jdbc:mysql://localhost/project";
		        Connection connection = null ;
				PreparedStatement pstat = null;
		        try {
		        	connection = DriverManager.getConnection(DATABASE_URL, "root", "");
		            pstat = connection.prepareStatement("DELETE FROM customer WHERE CustomerID = ?");
		            int row = table.getSelectedRow();
		            if (row != -1) {
		                int CustomerID = (int) table.getValueAt(row, 0);
		                // show a confirmation message before deleting
		                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?", "Confirmation", JOptionPane.YES_NO_OPTION);
		                if (response == JOptionPane.YES_OPTION) {
		                    pstat.setInt(1, CustomerID);
		                    pstat.executeUpdate();
		                    // show a message to indicate success
		                    JOptionPane.showMessageDialog(null, "Customer deleted successfully");
		                }
		                else {
		                	JOptionPane.showMessageDialog(null, "No Customer deleted");
		                }
		            } 
		            else {
		                // show a message to indicate no customer is selected
		                JOptionPane.showMessageDialog(null, "Please select a customer to delete");
		            }
		        } 
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		DeleteButton.setBounds(221, 312, 89, 23);
		DeleteCustomer.getContentPane().add(DeleteButton);
		
		JButton RefreshTable = new JButton("Refresh");
		RefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		RefreshTable.setBounds(346, 312, 89, 23);
		DeleteCustomer.getContentPane().add(RefreshTable);
	}
}
