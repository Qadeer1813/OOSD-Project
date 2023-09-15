//	Author: Qadeer Hussain
//	Purpose: Delete Invoice
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class delete_invoice {

	private JFrame DeleteInvoice;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_invoice window = new delete_invoice();
					window.DeleteInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public delete_invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DeleteInvoice = new JFrame();
		DeleteInvoice.setTitle("Delete Invoice");
		DeleteInvoice.setBounds(100, 100, 828, 400);
		DeleteInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteInvoice.getContentPane().setLayout(null);
		
//		Button to go back to submenu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				DeleteInvoice.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		DeleteInvoice.getContentPane().add(BackButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		AddInvoiceScreenButton.setBounds(140, 60, 100, 23);
		DeleteInvoice.getContentPane().add(AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		AmendViewInvoiceScreenButton.setBounds(270, 60, 150, 23);
		DeleteInvoice.getContentPane().add(AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		DeleteInvoiceScreenButton.setBounds(450, 60, 120, 23);
		DeleteInvoice.getContentPane().add(DeleteInvoiceScreenButton);
		
//		Button to go to Add products to Invoice screen
		JButton AddProductsToInvoice = new JButton("Add Products to Invoice");
		AddProductsToInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		AddProductsToInvoice.setBounds(600, 60, 170, 23);
		DeleteInvoice.getContentPane().add(AddProductsToInvoice);
		
//		Button to go to View products on Invoice screen
		JButton ViewProductsOnInvoice = new JButton("View Product on Invoice");
		ViewProductsOnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		ViewProductsOnInvoice.setBounds(120, 114, 170, 23);
		DeleteInvoice.getContentPane().add(ViewProductsOnInvoice);
		
//		Button to go to Delete products on Invoice screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete  Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				DeleteInvoice.dispose();
			}
		});
		DeleteProductsOnInvoiceScreenButton.setBounds(500, 114, 190, 23);
		DeleteInvoice.getContentPane().add(DeleteProductsOnInvoiceScreenButton);
		
//		Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 792, 160);
		DeleteInvoice.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load the invoice data and customer data into the table
        final String DATABASE_URL = "jdbc:mysql://localhost/project";
        Connection connection = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            // establish connection to database
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            // create Prepared Statement for selecting data from the table
            pstat = connection.prepareStatement("SELECT invoice.InvoiceID, invoice.TotalOwed, invoice.Date, customer.CustomerID, customer.Forename \r\n"
            		+ "FROM invoice \r\n"
            		+ "INNER JOIN customer \r\n"
            		+ "ON invoice.CustomerID = customer.CustomerID;");
            rs = pstat.executeQuery();
            // create a new TableModel to hold the data
            DefaultTableModel invoice = new DefaultTableModel();
            // add columns to the TableModel
            invoice.addColumn("InvoiceID");
            invoice.addColumn("CustomerID");
            invoice.addColumn("Forename");
            invoice.addColumn("TotalOwed");
            invoice.addColumn("Date");
            
            // loop through the ResultSet and add rows to the TableModel
            while (rs.next()) 
            {
                invoice.addRow(new Object[] {
                    rs.getInt("InvoiceID"),
                    rs.getInt("CustomerID"),
                    rs.getString("Forename"),
                    rs.getString("TotalOwed"),
                    rs.getString("Date")
                });
            }
            // set the TableModel on the JTable
            table.setModel(invoice);
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
		
//      Button to delete whatever row you choose in the table
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String DATABASE_URL = "jdbc:mysql://localhost/project";
				Connection connection = null ;
				PreparedStatement pstat = null;
		        try { 
		        	connection = DriverManager.getConnection(DATABASE_URL, "root", "");
		            pstat = connection.prepareStatement("DELETE FROM invoice WHERE InvoiceID = ?");
		            int row = table.getSelectedRow();
		            if (row != -1) {
		                int InvoiceID = (int) table.getValueAt(row, 0);
		                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this invoice?", "Confirmation", JOptionPane.YES_NO_OPTION);
		                if (response == JOptionPane.YES_OPTION) {
		                    pstat.setInt(1, InvoiceID);
		                    pstat.executeUpdate();

		                    JOptionPane.showMessageDialog(null, "Invoice deleted successfully");
		                }
		                else {
		                	JOptionPane.showMessageDialog(null, "No Invoice deleted");
		                }
		            } 
		            else {
		                JOptionPane.showMessageDialog(null, "Please select a invoice to delete");
		            }
		        } 
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		DeleteButton.setBounds(285, 321, 89, 23);
		DeleteInvoice.getContentPane().add(DeleteButton);
		
//		Button to refresh table after deleting
		JButton RefreshTable = new JButton("Refresh");
		RefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load the invoice data and customer data into the table
		        final String DATABASE_URL = "jdbc:mysql://localhost/project";
		        Connection connection = null;
		        PreparedStatement pstat = null;
		        ResultSet rs = null;
		        try {
		            // establish connection to database
		            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
		            // create Prepared Statement for selecting data from the table
		            pstat = connection.prepareStatement("SELECT invoice.InvoiceID, invoice.TotalOwed, invoice.Date, customer.CustomerID, customer.Forename \r\n"
		            		+ "FROM invoice \r\n"
		            		+ "INNER JOIN customer \r\n"
		            		+ "ON invoice.CustomerID = customer.CustomerID;");
		            rs = pstat.executeQuery();
		            // create a new TableModel to hold the data
		            DefaultTableModel invoice = new DefaultTableModel();
		            // add columns to the TableModel
		            invoice.addColumn("InvoiceID");
		            invoice.addColumn("CustomerID");
		            invoice.addColumn("Forename");
		            invoice.addColumn("TotalOwed");
		            invoice.addColumn("Date");
		            
		            // loop through the ResultSet and add rows to the TableModel
		            while (rs.next()) 
		            {
		                invoice.addRow(new Object[] {
		                    rs.getInt("InvoiceID"),
		                    rs.getInt("CustomerID"),
		                    rs.getString("Forename"),
		                    rs.getString("TotalOwed"),
		                    rs.getString("Date")
		                });
		            }
		            // set the TableModel on the JTable
		            table.setModel(invoice);
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
		RefreshTable.setBounds(440, 321, 89, 23);
		DeleteInvoice.getContentPane().add(RefreshTable);
	}

}
