//	Author: Qadeer Hussain
//	Purpose: Add Product to Invoice
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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class add_products_to_invoice {

	private JFrame AddProductsToInvoice;
	private JTextField CustomerIDtextfield;
	private JTextField InvoiceIDtextfield;
	private JTextField Nametextfield;
	private JTextField ProductNametextfield;
	private JTextField ProductIDtextfield;
	private JTextField Pricetextfield;
	private JTextField Quantitytextfield;
	private JTextField Datetextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_products_to_invoice window = new add_products_to_invoice();
					window.AddProductsToInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public add_products_to_invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddProductsToInvoice = new JFrame();
		AddProductsToInvoice.setTitle("Add Products to Invoice");
		AddProductsToInvoice.setBounds(100, 100, 964, 550);
		AddProductsToInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 20, 0, 20, 0, 20, 0, 20, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 25, 0, 25, 0, 25, 0, 25, 0, 25, 0, 25, 0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddProductsToInvoice.getContentPane().setLayout(gridBagLayout);
		
//		Button to go to submenu
		JButton BackScreenButton = new JButton("Back");
		BackScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_BackScreenButton = new GridBagConstraints();
		gbc_BackScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_BackScreenButton.gridx = 1;
		gbc_BackScreenButton.gridy = 2;
		AddProductsToInvoice.getContentPane().add(BackScreenButton, gbc_BackScreenButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AddInvoiceScreenButton = new GridBagConstraints();
		gbc_AddInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AddInvoiceScreenButton.gridx = 3;
		gbc_AddInvoiceScreenButton.gridy = 2;
		AddProductsToInvoice.getContentPane().add(AddInvoiceScreenButton, gbc_AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AmendViewInvoiceScreenButton = new GridBagConstraints();
		gbc_AmendViewInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AmendViewInvoiceScreenButton.gridx = 5;
		gbc_AmendViewInvoiceScreenButton.gridy = 2;
		AddProductsToInvoice.getContentPane().add(AmendViewInvoiceScreenButton, gbc_AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen		
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_DeleteInvoiceScreenButton_1 = new GridBagConstraints();
		gbc_DeleteInvoiceScreenButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteInvoiceScreenButton_1.gridx = 7;
		gbc_DeleteInvoiceScreenButton_1.gridy = 2;
		AddProductsToInvoice.getContentPane().add(DeleteInvoiceScreenButton, gbc_DeleteInvoiceScreenButton_1);
		
//		Button to go to Add Products to Invoice Screen
		JButton AddProductsToInvoice_1 = new JButton("Add Products to Invoice");
		AddProductsToInvoice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_AddProductsToInvoice_1 = new GridBagConstraints();
		gbc_AddProductsToInvoice_1.insets = new Insets(0, 0, 5, 5);
		gbc_AddProductsToInvoice_1.gridx = 9;
		gbc_AddProductsToInvoice_1.gridy = 2;
		AddProductsToInvoice.getContentPane().add(AddProductsToInvoice_1, gbc_AddProductsToInvoice_1);
		
//		Button to go to View Products on Invoice Screen
		JButton ViewProductsOnInvoice = new JButton("View Product on Invoice");
		ViewProductsOnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_ViewProductsOnInvoice = new GridBagConstraints();
		gbc_ViewProductsOnInvoice.insets = new Insets(0, 0, 5, 5);
		gbc_ViewProductsOnInvoice.gridx = 3;
		gbc_ViewProductsOnInvoice.gridy = 4;
		AddProductsToInvoice.getContentPane().add(ViewProductsOnInvoice, gbc_ViewProductsOnInvoice);
		
//		Button to go to Delete Products on Invoice Screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete  Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				AddProductsToInvoice.dispose();
			}
		});
		GridBagConstraints gbc_DeleteProductsOnInvoiceScreenButton = new GridBagConstraints();
		gbc_DeleteProductsOnInvoiceScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteProductsOnInvoiceScreenButton.gridx = 7;
		gbc_DeleteProductsOnInvoiceScreenButton.gridy = 4;
		AddProductsToInvoice.getContentPane().add(DeleteProductsOnInvoiceScreenButton, gbc_DeleteProductsOnInvoiceScreenButton);
		
//		Invoice
		JLabel Invoice = new JLabel("Invoice");
		Invoice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Invoice = new GridBagConstraints();
		gbc_Invoice.insets = new Insets(0, 0, 5, 5);
		gbc_Invoice.gridx = 1;
		gbc_Invoice.gridy = 6;
		AddProductsToInvoice.getContentPane().add(Invoice, gbc_Invoice);
		
//		Invoice dropdown
		JComboBox InvoiceDropdown = new JComboBox();
		GridBagConstraints gbc_Invoicedropdown = new GridBagConstraints();
		gbc_Invoicedropdown.insets = new Insets(0, 0, 5, 5);
		gbc_Invoicedropdown.fill = GridBagConstraints.HORIZONTAL;
		gbc_Invoicedropdown.gridx = 3;
		gbc_Invoicedropdown.gridy = 6;
		AddProductsToInvoice.getContentPane().add(InvoiceDropdown, gbc_Invoicedropdown);
		
//		Code to get information from database into dropdown
		final String DATABASE_URL = "jdbc:mysql://localhost/project";
		Connection connection = null ;
		PreparedStatement pstat = null;
		ResultSet resultSet = null;
			try {
				connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			    pstat = connection.prepareStatement("SELECT invoice.InvoiceID, customer.CustomerID, customer.Forename\r\n"
			    		+ "FROM invoice\r\n"
			    		+ "JOIN customer\r\n"
			    		+ "ON invoice.CustomerID = customer.CustomerID");

			    resultSet = pstat.executeQuery();

			    while (resultSet.next()) 
			    {
			    	String InvoiceID = resultSet.getString("InvoiceID");
			        String CustomerID = resultSet.getString("CustomerID");
			        String Forename = resultSet.getString("Forename");

			        // Add the InvoiceID, CustomerID, Forename to the JComboBox
			        InvoiceDropdown.addItem(InvoiceID + " - " + CustomerID + " - " + Forename);
			    }

			    pstat.close () ;
				connection.close () ;
			} 
			catch (SQLException ex) {
			    ex.printStackTrace();
			}
			
			
			InvoiceDropdown.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Get the selected item from the JComboBox
			        String selectedInvoice = (String) InvoiceDropdown.getSelectedItem();
			        // Extract the InvoiceID, CustomerID, and Forename from the selected item
			        String[] parts = selectedInvoice.split(" - ");
			        String InvoiceID = parts[0];
			        String CustomerID = parts[1];
			        String Forename = parts[2];

			        // Set the InvoiceID, CustomerID, and Forename fields
			        InvoiceIDtextfield.setText(InvoiceID);
			        CustomerIDtextfield.setText(CustomerID);
			        Nametextfield.setText(Forename);
			        
			        try {
			            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			            PreparedStatement pstat = connection.prepareStatement("SELECT Date FROM invoice WHERE InvoiceID = ?");
			            pstat.setString(1, InvoiceID);
			            ResultSet resultSet = pstat.executeQuery();
			            if (resultSet.next()) {
			            	String Date = resultSet.getString("Date");
			                
			                // Set the Date field
			                Datetextfield.setText(Date);
			                
			            }
			            resultSet.close();
			            pstat.close();
			            connection.close();
			        } 
			        catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			        
			        // Set the fields to be uneditable
			        InvoiceIDtextfield.setEditable(false);
			        CustomerIDtextfield.setEditable(false);
			        Nametextfield.setEditable(false);
			        Datetextfield.setEditable(false);
			    }
			});
		
//		Product
		JLabel Product = new JLabel("Product");
		Product.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Product = new GridBagConstraints();
		gbc_Product.insets = new Insets(0, 0, 5, 5);
		gbc_Product.gridx = 7;
		gbc_Product.gridy = 6;
		AddProductsToInvoice.getContentPane().add(Product, gbc_Product);
		
//		Product dropdown
		JComboBox ProductDropdown = new JComboBox();
		GridBagConstraints gbc_Productdropdown = new GridBagConstraints();
		gbc_Productdropdown.insets = new Insets(0, 0, 5, 5);
		gbc_Productdropdown.fill = GridBagConstraints.HORIZONTAL;
		gbc_Productdropdown.gridx = 9;
		gbc_Productdropdown.gridy = 6;
		AddProductsToInvoice.getContentPane().add(ProductDropdown, gbc_Productdropdown);
		
//		Code to get information from database into dropdown
		final String DATABASE_URL1 = "jdbc:mysql://localhost/project";
		Connection connection1 = null ;
		PreparedStatement pstat1 = null;
		ResultSet resultSet1 = null;
			try {
				connection1 = DriverManager.getConnection(DATABASE_URL1, "root", "");
			    pstat1 = connection1.prepareStatement("SELECT ProductID, Name FROM Product");

			    resultSet1 = pstat1.executeQuery();

			    while (resultSet1.next()) 
			    {
			    	String ProductID = resultSet1.getString("ProductID");
			        String Name = resultSet1.getString("Name");

			        // Add the ProductID and name to the JComboBox
			        ProductDropdown.addItem(ProductID + " - " + Name);
			    }

			    pstat1.close () ;
				connection1.close () ;
			} 
			catch (SQLException ex) {
			    ex.printStackTrace();
			}
			
			
			ProductDropdown.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Get the selected item from the JComboBox
			        String selectedInvoice = (String) ProductDropdown.getSelectedItem();
			        // Extract the ProductID and name from the selected item
			        String[] parts = selectedInvoice.split(" - ");
			        String ProductID = parts[0];
			        String Name = parts[1];
			   
			        // Set the ProductID and name fields
			        ProductIDtextfield.setText(ProductID);
			        ProductNametextfield.setText(Name);
			        
			        try {
			            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			            PreparedStatement pstat = connection.prepareStatement("SELECT Price FROM product WHERE ProductID = ?");
			            pstat.setString(1, ProductID);
			            ResultSet resultSet = pstat.executeQuery();
			            if (resultSet.next()) {
			            	String Price = resultSet.getString("Price");
			                
			                // Set the Date field
			                Pricetextfield.setText(Price);
			                
			            }
			            resultSet.close();
			            pstat.close();
			            connection.close();
			        } 
			        catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			        
			        // Set the fields to be uneditable
			        ProductIDtextfield.setEditable(false);
			        ProductNametextfield.setEditable(false);
			        Pricetextfield.setEditable(false);
			    }
			});
		
//		InvoiceID
		JLabel InvoiceID = new JLabel("Invoice ID");
		InvoiceID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_InvoiceID = new GridBagConstraints();
		gbc_InvoiceID.insets = new Insets(0, 0, 5, 5);
		gbc_InvoiceID.gridx = 1;
		gbc_InvoiceID.gridy = 8;
		AddProductsToInvoice.getContentPane().add(InvoiceID, gbc_InvoiceID);
		
//		InvoiceID textfield
		InvoiceIDtextfield = new JTextField();
		GridBagConstraints gbc_InvoiceIDtextfield = new GridBagConstraints();
		gbc_InvoiceIDtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_InvoiceIDtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_InvoiceIDtextfield.gridx = 3;
		gbc_InvoiceIDtextfield.gridy = 8;
		AddProductsToInvoice.getContentPane().add(InvoiceIDtextfield, gbc_InvoiceIDtextfield);
		InvoiceIDtextfield.setColumns(10);
		
//		ProductID
		JLabel ProductID = new JLabel("Product ID");
		ProductID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_ProductID = new GridBagConstraints();
		gbc_ProductID.insets = new Insets(0, 0, 5, 5);
		gbc_ProductID.gridx = 7;
		gbc_ProductID.gridy = 8;
		AddProductsToInvoice.getContentPane().add(ProductID, gbc_ProductID);
		
//		ProductID textfield
		ProductIDtextfield = new JTextField();
		GridBagConstraints gbc_ProductIDtextfield = new GridBagConstraints();
		gbc_ProductIDtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_ProductIDtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_ProductIDtextfield.gridx = 9;
		gbc_ProductIDtextfield.gridy = 8;
		AddProductsToInvoice.getContentPane().add(ProductIDtextfield, gbc_ProductIDtextfield);
		ProductIDtextfield.setColumns(10);
		
//		CustomerID
		JLabel CustomerID = new JLabel("Customer ID");
		CustomerID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_CustomerID = new GridBagConstraints();
		gbc_CustomerID.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerID.gridx = 1;
		gbc_CustomerID.gridy = 10;
		AddProductsToInvoice.getContentPane().add(CustomerID, gbc_CustomerID);
		
//		CustomerID textfield
		CustomerIDtextfield = new JTextField();
		GridBagConstraints gbc_CustomerIDtextfield = new GridBagConstraints();
		gbc_CustomerIDtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerIDtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_CustomerIDtextfield.gridx = 3;
		gbc_CustomerIDtextfield.gridy = 10;
		AddProductsToInvoice.getContentPane().add(CustomerIDtextfield, gbc_CustomerIDtextfield);
		CustomerIDtextfield.setColumns(10);
		
//		Product name
		JLabel ProductName = new JLabel("Product Name");
		ProductName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_ProductName = new GridBagConstraints();
		gbc_ProductName.insets = new Insets(0, 0, 5, 5);
		gbc_ProductName.gridx = 7;
		gbc_ProductName.gridy = 10;
		AddProductsToInvoice.getContentPane().add(ProductName, gbc_ProductName);
		
//		Productname textfield
		ProductNametextfield = new JTextField();
		GridBagConstraints gbc_ProductNametextfield = new GridBagConstraints();
		gbc_ProductNametextfield.insets = new Insets(0, 0, 5, 5);
		gbc_ProductNametextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_ProductNametextfield.gridx = 9;
		gbc_ProductNametextfield.gridy = 10;
		AddProductsToInvoice.getContentPane().add(ProductNametextfield, gbc_ProductNametextfield);
		ProductNametextfield.setColumns(10);
		
//		Customer name
		JLabel CustomerName = new JLabel("Customer Name");
		CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_CustomerName = new GridBagConstraints();
		gbc_CustomerName.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerName.gridx = 1;
		gbc_CustomerName.gridy = 12;
		AddProductsToInvoice.getContentPane().add(CustomerName, gbc_CustomerName);
		
//		Name textfield
		Nametextfield = new JTextField();
		GridBagConstraints gbc_Nametextfield = new GridBagConstraints();
		gbc_Nametextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Nametextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Nametextfield.gridx = 3;
		gbc_Nametextfield.gridy = 12;
		AddProductsToInvoice.getContentPane().add(Nametextfield, gbc_Nametextfield);
		Nametextfield.setColumns(10);
		
//		Price
		JLabel Price = new JLabel("Price");
		Price.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Price = new GridBagConstraints();
		gbc_Price.insets = new Insets(0, 0, 5, 5);
		gbc_Price.gridx = 7;
		gbc_Price.gridy = 12;
		AddProductsToInvoice.getContentPane().add(Price, gbc_Price);
		
//		Price textfield
		Pricetextfield = new JTextField();
		Pricetextfield.setText("");
		GridBagConstraints gbc_Pricetextfield = new GridBagConstraints();
		gbc_Pricetextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Pricetextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Pricetextfield.gridx = 9;
		gbc_Pricetextfield.gridy = 12;
		AddProductsToInvoice.getContentPane().add(Pricetextfield, gbc_Pricetextfield);
		Pricetextfield.setColumns(10);
		
//		Date
		JLabel Date = new JLabel("Date");
		Date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Date = new GridBagConstraints();
		gbc_Date.insets = new Insets(0, 0, 5, 5);
		gbc_Date.gridx = 1;
		gbc_Date.gridy = 14;
		AddProductsToInvoice.getContentPane().add(Date, gbc_Date);
		
//		Date textfield
		Datetextfield = new JTextField();
		GridBagConstraints gbc_Datetextfield = new GridBagConstraints();
		gbc_Datetextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Datetextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Datetextfield.gridx = 3;
		gbc_Datetextfield.gridy = 14;
		AddProductsToInvoice.getContentPane().add(Datetextfield, gbc_Datetextfield);
		Datetextfield.setColumns(10);
		
//		Quantity
		JLabel Quantity = new JLabel("Quantity");
		Quantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Quantity = new GridBagConstraints();
		gbc_Quantity.insets = new Insets(0, 0, 5, 5);
		gbc_Quantity.gridx = 7;
		gbc_Quantity.gridy = 14;
		AddProductsToInvoice.getContentPane().add(Quantity, gbc_Quantity);
		
//		Quantity textfield
		Quantitytextfield = new JTextField();
		GridBagConstraints gbc_Quantitytextfield = new GridBagConstraints();
		gbc_Quantitytextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Quantitytextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Quantitytextfield.gridx = 9;
		gbc_Quantitytextfield.gridy = 14;
		AddProductsToInvoice.getContentPane().add(Quantitytextfield, gbc_Quantitytextfield);
		Quantitytextfield.setColumns(10);
		
//		Button to add data to table
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (InvoiceIDtextfield.getText().isEmpty() && ProductIDtextfield.getText().isEmpty() && Quantitytextfield.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter information.");
		        } 
		        else {
		            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this product to this invoice?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (response == JOptionPane.YES_OPTION) {
		                try {
		                    cartInsert(InvoiceIDtextfield, ProductIDtextfield, Quantitytextfield);

		                    InvoiceIDtextfield.setText("");
		    				CustomerIDtextfield.setText("");
		    				ProductIDtextfield.setText("");
		    				Nametextfield.setText("");
		    				ProductNametextfield.setText("");
		    		    	Quantitytextfield.setText("");
		    		    	Datetextfield.setText("");
		    		    	Pricetextfield.setText("");

		                    JOptionPane.showMessageDialog(null, "Product added to Invoice.");
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
		gbc_AddButton.gridy = 16;
		AddProductsToInvoice.getContentPane().add(AddButton, gbc_AddButton);
		
//		Button to clear textfields
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceIDtextfield.setText("");
				CustomerIDtextfield.setText("");
				ProductIDtextfield.setText("");
				Nametextfield.setText("");
				ProductNametextfield.setText("");
		    	Quantitytextfield.setText("");
		    	Datetextfield.setText("");
		    	Pricetextfield.setText("");
			}
		});
		
		GridBagConstraints gbc_ClearButton = new GridBagConstraints();
		gbc_ClearButton.anchor = GridBagConstraints.EAST;
		gbc_ClearButton.insets = new Insets(0, 0, 0, 5);
		gbc_ClearButton.gridx = 9;
		gbc_ClearButton.gridy = 16;
		AddProductsToInvoice.getContentPane().add(ClearButton, gbc_ClearButton);
	}
	
//	Method to add data to table
	public static void cartInsert(JTextField InvoiceIDtextfield, JTextField ProductIDtextfield, JTextField Quantitytextfield) {
	    // database URL
	    final String DATABASE_URL = "jdbc:mysql://localhost/project";
	    Connection connection = null;
	    PreparedStatement pstat = null;
	    int InvoiceID = Integer.parseInt(InvoiceIDtextfield.getText());
	    int ProductID = Integer.parseInt(ProductIDtextfield.getText());
	    int Quantity = Integer.parseInt(Quantitytextfield.getText());
	    int i = 0;

	    try {
	        // establish connection to database
	        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	        // create Prepared Statement for inserting data into table
	        pstat = connection.prepareStatement("INSERT INTO cart (InvoiceID, ProductID, Quantity) VALUES (?,?,?)");
	        pstat.setInt(1, InvoiceID);
	        pstat.setInt(2, ProductID);
	        pstat.setInt(3, Quantity);

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
