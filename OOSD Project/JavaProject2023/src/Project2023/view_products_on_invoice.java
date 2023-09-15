//	Author: Qadeer Hussain
//	Purpose: View Product on Invoice
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class view_products_on_invoice {

	private JFrame ViewProductsOnInvoice;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_products_on_invoice window = new view_products_on_invoice();
					window.ViewProductsOnInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public view_products_on_invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ViewProductsOnInvoice = new JFrame();
		ViewProductsOnInvoice.setTitle("View Products on Invoice");
		ViewProductsOnInvoice.setBounds(100, 100, 825, 385);
		ViewProductsOnInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewProductsOnInvoice.getContentPane().setLayout(null);
		
//		Button to go to submenu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		ViewProductsOnInvoice.getContentPane().add(BackButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		AddInvoiceScreenButton.setBounds(140, 60, 100, 23);
		ViewProductsOnInvoice.getContentPane().add(AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		AmendViewInvoiceScreenButton.setBounds(270, 60, 150, 23);
		ViewProductsOnInvoice.getContentPane().add(AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen	
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		DeleteInvoiceScreenButton.setBounds(450, 60, 120, 23);
		ViewProductsOnInvoice.getContentPane().add(DeleteInvoiceScreenButton);
		
//		Button to go to Add Products to Invoice Screen
		JButton AddProductsToInvoice = new JButton("Add Products to Invoice");
		AddProductsToInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		AddProductsToInvoice.setBounds(600, 60, 170, 23);
		ViewProductsOnInvoice.getContentPane().add(AddProductsToInvoice);
		
//		Button to go to View Products on Invoice Screen
		JButton ViewProductsOnInvoice_1 = new JButton("View Product on Invoice");
		ViewProductsOnInvoice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		ViewProductsOnInvoice_1.setBounds(120, 114, 170, 23);
		ViewProductsOnInvoice.getContentPane().add(ViewProductsOnInvoice_1);
		
//		Button to go to Delete Products on Invoice Screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete  Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				ViewProductsOnInvoice.dispose();
			}
		});
		DeleteProductsOnInvoiceScreenButton.setBounds(500, 114, 190, 23);
		ViewProductsOnInvoice.getContentPane().add(DeleteProductsOnInvoiceScreenButton);
		
//		Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 789, 160);
		ViewProductsOnInvoice.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load the cart data into the table
        final String DATABASE_URL = "jdbc:mysql://localhost/project";
        Connection connection = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            // establish connection to database
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            // create Prepared Statement for selecting data from the table
            pstat = connection.prepareStatement("SELECT CartID, InvoiceID, ProductID, Quantity FROM cart");
            rs = pstat.executeQuery();
            // create a new TableModel to hold the data
            DefaultTableModel cart = new DefaultTableModel();
            // add columns to the TableModel
            cart.addColumn("CartID");
            cart.addColumn("InvoiceID");
            cart.addColumn("ProductID");
            cart.addColumn("Quantity");
            
            // loop through the ResultSet and add rows to the TableModel
            while (rs.next()) 
            {
                cart.addRow(new Object[] {
                    rs.getInt("CartID"),
                    rs.getInt("InvoiceID"),
                    rs.getInt("ProductID"),
                    rs.getInt("Quantity"),
                });
            }
            // set the TableModel on the JTable
            table.setModel(cart);
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
}
