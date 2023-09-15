//	Author: Qadeer Hussain
//	Purpose: Add Invoice
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class add_invoice {

	private JFrame AddInvoice;
	private JTextField CustomerIDtextfield;
	private JTextField Nametextfield;
	private JTextField Datetextfield;
	private JTextField TotalOwedtextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_invoice window = new add_invoice();
					window.AddInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public add_invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddInvoice = new JFrame();
		AddInvoice.setTitle("Add Invoice");
		AddInvoice.setBounds(100, 100, 902, 390);
		AddInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 20, 0, 20, 0, 20, 0, 20, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 25, 0, 25, 0, 25, 0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddInvoice.getContentPane().setLayout(gridBagLayout);
		
//		Button to go back to submenu
		JButton BackScreenButton = new JButton("Back");
		BackScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_BackScreenButton = new GridBagConstraints();
		gbc_BackScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_BackScreenButton.gridx = 1;
		gbc_BackScreenButton.gridy = 2;
		AddInvoice.getContentPane().add(BackScreenButton, gbc_BackScreenButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AddInvoiceScreenButton = new GridBagConstraints();
		gbc_AddInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AddInvoiceScreenButton.gridx = 3;
		gbc_AddInvoiceScreenButton.gridy = 2;
		AddInvoice.getContentPane().add(AddInvoiceScreenButton, gbc_AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AmendViewInvoiceScreenButton = new GridBagConstraints();
		gbc_AmendViewInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AmendViewInvoiceScreenButton.gridx = 5;
		gbc_AmendViewInvoiceScreenButton.gridy = 2;
		AddInvoice.getContentPane().add(AmendViewInvoiceScreenButton, gbc_AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_DeleteInvoiceScreenButton = new GridBagConstraints();
		gbc_DeleteInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteInvoiceScreenButton.gridx = 7;
		gbc_DeleteInvoiceScreenButton.gridy = 2;
		AddInvoice.getContentPane().add(DeleteInvoiceScreenButton, gbc_DeleteInvoiceScreenButton);
		
//		Button to go to Add products to Invoice screen
		JButton AddProductsToInvoice = new JButton("Add Products to Invoice");
		AddProductsToInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AddProductsToInvoice = new GridBagConstraints();
		gbc_AddProductsToInvoice.insets = new Insets(0, 0, 5, 5);
		gbc_AddProductsToInvoice.gridx = 9;
		gbc_AddProductsToInvoice.gridy = 2;
		AddInvoice.getContentPane().add(AddProductsToInvoice, gbc_AddProductsToInvoice);
		
//		Button to go to View products on Invoice screen
		JButton ViewProductsOnInvoice = new JButton("View Product on Invoice");
		ViewProductsOnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_ViewProductsOnInvoice = new GridBagConstraints();
		gbc_ViewProductsOnInvoice.insets = new Insets(0, 0, 5, 5);
		gbc_ViewProductsOnInvoice.gridx = 3;
		gbc_ViewProductsOnInvoice.gridy = 4;
		AddInvoice.getContentPane().add(ViewProductsOnInvoice, gbc_ViewProductsOnInvoice);
		
//		Button to go to Delete products on Invoice screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete  Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				AddInvoice.dispose();
			}
		});
		GridBagConstraints gbc_DeleteProductsOnInvoiceScreenButton = new GridBagConstraints();
		gbc_DeleteProductsOnInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteProductsOnInvoiceScreenButton.gridx = 7;
		gbc_DeleteProductsOnInvoiceScreenButton.gridy = 4;
		AddInvoice.getContentPane().add(DeleteProductsOnInvoiceScreenButton, gbc_DeleteProductsOnInvoiceScreenButton);
		
//		Customer
		JLabel Customer = new JLabel("Customer");
		Customer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Customer = new GridBagConstraints();
		gbc_Customer.insets = new Insets(0, 0, 5, 5);
		gbc_Customer.gridx = 1;
		gbc_Customer.gridy = 6;
		AddInvoice.getContentPane().add(Customer, gbc_Customer);
		
//		Customer dropdown
		JComboBox CustomerDropdown = new JComboBox();
		GridBagConstraints gbc_CustomerDropdown = new GridBagConstraints();
		gbc_CustomerDropdown.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerDropdown.fill = GridBagConstraints.HORIZONTAL;
		gbc_CustomerDropdown.gridx = 3;
		gbc_CustomerDropdown.gridy = 6;
		AddInvoice.getContentPane().add(CustomerDropdown, gbc_CustomerDropdown);
		
//		Code to get the information to put in the dropdown box
		final String DATABASE_URL = "jdbc:mysql://localhost/project";
		Connection connection = null ;
		PreparedStatement pstat = null;
			try {
				connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			    pstat = connection.prepareStatement("SELECT CustomerID, Forename FROM customer");

			    ResultSet resultSet = pstat.executeQuery();

			    while (resultSet.next()) 
			    {
			        String CustomerID = resultSet.getString("CustomerID");
			        String Forename = resultSet.getString("Forename");

			        // Add the CustomerID, Forename to the JComboBox
			        CustomerDropdown.addItem(CustomerID + " - " + Forename);
			    }

			    pstat . close () ;
				connection. close () ;
			} 
			catch (SQLException ex) {
			    ex.printStackTrace();
			}
			
		CustomerDropdown.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected item from the JComboBox
		        String selectedCustomer = (String) CustomerDropdown.getSelectedItem();
		        // Extract the CustomerID and Forename from the selected item
		        String[] parts = selectedCustomer.split(" - ");
		        String CustomerID = parts[0];
		        String Forename = parts[1];
		        // Set the CustomerIDtextfield and Nametextfield to the extracted values
		        CustomerIDtextfield.setText(CustomerID);
		        Nametextfield.setText(Forename);
		        // Set the fields to be uneditable
		        CustomerIDtextfield.setEditable(false);
		        Nametextfield.setEditable(false);
		    }
		});
		
//		Total Owed
		JLabel TotalOwed = new JLabel("Total Owed");
		GridBagConstraints gbc_TotalOwed = new GridBagConstraints();
		gbc_TotalOwed.insets = new Insets(0, 0, 5, 5);
		gbc_TotalOwed.gridx = 7;
		gbc_TotalOwed.gridy = 6;
		AddInvoice.getContentPane().add(TotalOwed, gbc_TotalOwed);
		
//		Total Owed textfield
		TotalOwedtextfield = new JTextField();
		GridBagConstraints gbc_TotalOwedtextfield = new GridBagConstraints();
		gbc_TotalOwedtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_TotalOwedtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_TotalOwedtextfield.gridx = 9;
		gbc_TotalOwedtextfield.gridy = 6;
		AddInvoice.getContentPane().add(TotalOwedtextfield, gbc_TotalOwedtextfield);
		TotalOwedtextfield.setColumns(10);
		
//		CustomerID
		JLabel CustomerID = new JLabel("Customer ID");
		CustomerID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_CustomerID = new GridBagConstraints();
		gbc_CustomerID.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerID.gridx = 1;
		gbc_CustomerID.gridy = 8;
		AddInvoice.getContentPane().add(CustomerID, gbc_CustomerID);
		
//		CustomerID textfield
		CustomerIDtextfield = new JTextField();
		GridBagConstraints gbc_CustomerIDtextfield = new GridBagConstraints();
		gbc_CustomerIDtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerIDtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_CustomerIDtextfield.gridx = 3;
		gbc_CustomerIDtextfield.gridy = 8;
		AddInvoice.getContentPane().add(CustomerIDtextfield, gbc_CustomerIDtextfield);
		CustomerIDtextfield.setColumns(10);
		
//		Date
		JLabel Date = new JLabel("Date");
		GridBagConstraints gbc_Date = new GridBagConstraints();
		gbc_Date.insets = new Insets(0, 0, 5, 5);
		gbc_Date.gridx = 7;
		gbc_Date.gridy = 8;
		AddInvoice.getContentPane().add(Date, gbc_Date);
		
//		Date textfield
		Datetextfield = new JTextField();
		GridBagConstraints gbc_Datetextfield = new GridBagConstraints();
		gbc_Datetextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Datetextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Datetextfield.gridx = 9;
		gbc_Datetextfield.gridy = 8;
		AddInvoice.getContentPane().add(Datetextfield, gbc_Datetextfield);
		Datetextfield.setColumns(10);
		
//		Date format
		JLabel DateFormat = new JLabel("YYYY--MM--DD");
		DateFormat.setForeground(Color.RED);
		GridBagConstraints gbc_DateFormat = new GridBagConstraints();
		gbc_DateFormat.insets = new Insets(0, 0, 5, 5);
		gbc_DateFormat.gridx = 9;
		gbc_DateFormat.gridy = 9;
		AddInvoice.getContentPane().add(DateFormat, gbc_DateFormat);
		
//		Button to Clear textfields
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear the text boxes
				CustomerIDtextfield.setText("");
				Nametextfield.setText("");
		    	TotalOwedtextfield.setText("");
		    	Datetextfield.setText("");
			}
		});
		GridBagConstraints gbc_ClearButton = new GridBagConstraints();
		gbc_ClearButton.insets = new Insets(0, 0, 0, 5);
		gbc_ClearButton.gridx = 9;
		gbc_ClearButton.gridy = 10;
		AddInvoice.getContentPane().add(ClearButton, gbc_ClearButton);
		
//		Button to Add data to db
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (CustomerIDtextfield.getText().isEmpty() && TotalOwedtextfield.getText().isEmpty() && Datetextfield.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter invoice information.");
		        } 
		        else {
		            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this invoice?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (response == JOptionPane.YES_OPTION) {
		                try {
		                    invoiceInsert(CustomerIDtextfield, TotalOwedtextfield, Datetextfield);

		                    CustomerIDtextfield.setText("");
		                    Nametextfield.setText("");
		                    TotalOwedtextfield.setText("");
		                    Datetextfield.setText("");

		                    JOptionPane.showMessageDialog(null, "New invoice added.");
		                } 
		                catch (Exception ex) {
		                    JOptionPane.showMessageDialog(null, "Error in input.");
		                    ex.printStackTrace();
		                }
		            } 
		            else {
		                JOptionPane.showMessageDialog(null, "Nothing has been added.");
		            }
		        }
			}
		});
		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.insets = new Insets(0, 0, 0, 5);
		gbc_AddButton.gridx = 7;
		gbc_AddButton.gridy = 10;
		AddInvoice.getContentPane().add(AddButton, gbc_AddButton);
		
//		Customer Name
		JLabel CustomerName = new JLabel("Customer Name");
		CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_CustomerName = new GridBagConstraints();
		gbc_CustomerName.insets = new Insets(0, 0, 0, 5);
		gbc_CustomerName.gridx = 1;
		gbc_CustomerName.gridy = 10;
		AddInvoice.getContentPane().add(CustomerName, gbc_CustomerName);
		
//		Name textfield
		Nametextfield = new JTextField();
		GridBagConstraints gbc_Nametextfield = new GridBagConstraints();
		gbc_Nametextfield.insets = new Insets(0, 0, 0, 5);
		gbc_Nametextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Nametextfield.gridx = 3;
		gbc_Nametextfield.gridy = 10;
		AddInvoice.getContentPane().add(Nametextfield, gbc_Nametextfield);
		Nametextfield.setColumns(10);
		
	}
//	Method to add data into table
	public static void invoiceInsert(JTextField CustomerIDtextfield, JTextField TotalOwedtextfield, JTextField Datetextfield) {
	    // database URL
	    final String DATABASE_URL = "jdbc:mysql://localhost/project";
	    Connection connection = null;
	    PreparedStatement pstat = null;
	    int CustomerID = Integer.parseInt(CustomerIDtextfield.getText());
	    double TotalOwed = Double.parseDouble(TotalOwedtextfield.getText());
	    String dString = Datetextfield.getText();
	    Date Date = java.sql.Date.valueOf(dString);
	    int i = 0;

	    try {
	        // establish connection to database
	        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	        // create Prepared Statement for inserting data into table
	        pstat = connection.prepareStatement("INSERT INTO invoice (CustomerID, TotalOwed, Date) VALUES (?,?,?)");
	        pstat.setInt(1, CustomerID);
	        pstat.setDouble(2, TotalOwed);
	        pstat.setDate(3, Date);

	        // insert data into table
	        i = pstat.executeUpdate();
	        System.out.println(i + " record successfully added to the table.");
	    } 
	    catch (SQLException sqlException) {
	        sqlException.printStackTrace();
	    }
	    finally {
	        try {
	            pstat.close();
	            connection.close();
	        } 
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
