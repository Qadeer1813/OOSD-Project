//	Author: Qadeer Hussain
//	Purpose: Amend/View Invoice
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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class amend_view_invoice {

	private JFrame AmendViewInvoice;
	private JTable table;
	private JTextField InvoiceIDtextfield;
	private JTextField CustomerIDtextfield;
	private JTextField Nametextfield;
	private JTextField TotalOwedtextfield;
	private JTextField Datetextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amend_view_invoice window = new amend_view_invoice();
					window.AmendViewInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public amend_view_invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AmendViewInvoice = new JFrame();
		AmendViewInvoice.setTitle("Amend/View Invoice");
		AmendViewInvoice.setBounds(100, 100, 828, 513);
		AmendViewInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AmendViewInvoice.getContentPane().setLayout(null);
		
//		Button to go back to submenu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				AmendViewInvoice.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		AmendViewInvoice.getContentPane().add(BackButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		AddInvoiceScreenButton.setBounds(140, 60, 100, 23);
		AmendViewInvoice.getContentPane().add(AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		AmendViewInvoiceScreenButton.setBounds(270, 60, 150, 23);
		AmendViewInvoice.getContentPane().add(AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		DeleteInvoiceScreenButton.setBounds(450, 60, 120, 23);
		AmendViewInvoice.getContentPane().add(DeleteInvoiceScreenButton);
		
//		Button to go to Add products to Invoice screen
		JButton AddProductsToInvoice = new JButton("Add Products to Invoice");
		AddProductsToInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		AddProductsToInvoice.setBounds(600, 60, 170, 23);
		AmendViewInvoice.getContentPane().add(AddProductsToInvoice);
		
//		Button to go to View products on Invoice screens
		JButton ViewProductsOnInvoice = new JButton("View Product on Invoice");
		ViewProductsOnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		ViewProductsOnInvoice.setBounds(120, 114, 170, 23);
		AmendViewInvoice.getContentPane().add(ViewProductsOnInvoice);
		
//		Button to go to Delete products on Invoice screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete  Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				AmendViewInvoice.dispose();
			}
		});
		DeleteProductsOnInvoiceScreenButton.setBounds(500, 114, 190, 23);
		AmendViewInvoice.getContentPane().add(DeleteProductsOnInvoiceScreenButton);
		
//		Table
		JScrollPane InvoiceTable = new JScrollPane();
		InvoiceTable.setBounds(10, 150, 792, 160);
		AmendViewInvoice.getContentPane().add(InvoiceTable);
		
		table = new JTable();
		InvoiceTable.setViewportView(table);
		
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
            
//      Invoice
        JLabel Invoice = new JLabel("Invoice");
        Invoice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Invoice.setBounds(40, 319, 46, 14);
        AmendViewInvoice.getContentPane().add(Invoice);
        
//      Invoice dropdown
        JComboBox InvoiceDropdown = new JComboBox();
        InvoiceDropdown.setBounds(155, 316, 135, 22);
        AmendViewInvoice.getContentPane().add(InvoiceDropdown);
        
//      Code to get data into dropdown
        final String DATABASE_URL1 = "jdbc:mysql://localhost/project";
		Connection connection1 = null ;
		PreparedStatement pstat1 = null;
		ResultSet resultSet = null;
			try {
				connection1 = DriverManager.getConnection(DATABASE_URL1, "root", "");
			    pstat1 = connection1.prepareStatement("SELECT invoice.InvoiceID, customer.CustomerID, customer.Forename\r\n"
			    		+ "FROM invoice\r\n"
			    		+ "JOIN customer\r\n"
			    		+ "ON invoice.CustomerID = customer.CustomerID");

			    resultSet = pstat1.executeQuery();

			    while (resultSet.next()) 
			    {
			    	String InvoiceID = resultSet.getString("InvoiceID");
			        String CustomerID = resultSet.getString("CustomerID");
			        String Forename = resultSet.getString("Forename");

			        // Add the InvoiceID, CustomerID, Forename to the JComboBox
			        InvoiceDropdown.addItem(InvoiceID + " - " + CustomerID + " - " + Forename);
			    }

			    pstat1.close () ;
				connection1.close () ;
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

			        // Retrieve the TotalOwed and Date fields for the selected invoice
			        try {
			            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			            PreparedStatement pstat = connection.prepareStatement("SELECT TotalOwed, Date FROM invoice WHERE InvoiceID = ?");
			            pstat.setString(1, InvoiceID);
			            ResultSet resultSet = pstat.executeQuery();
			            if (resultSet.next()) {
			                String TotalOwed = resultSet.getString("TotalOwed");
			                String Date = resultSet.getString("Date");
			                // Set the TotalOwed and Date fields
			                TotalOwedtextfield.setText(TotalOwed);
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
			        TotalOwedtextfield.setEditable(true);
			        Datetextfield.setEditable(true);
			    }
			});

//			InvoiceID 
            JLabel InvoiceID = new JLabel("Invoice ID");
            InvoiceID.setFont(new Font("Tahoma", Font.PLAIN, 12));
            InvoiceID.setBounds(40, 365, 87, 14);
            AmendViewInvoice.getContentPane().add(InvoiceID);
            
//          InvoiceID textfield
            InvoiceIDtextfield = new JTextField();
            InvoiceIDtextfield.setBounds(155, 361, 135, 20);
            AmendViewInvoice.getContentPane().add(InvoiceIDtextfield);
            InvoiceIDtextfield.setColumns(10);
            
//          CustomerID
            JLabel CustomerID = new JLabel("Customer ID");
            CustomerID.setFont(new Font("Tahoma", Font.PLAIN, 12));
            CustomerID.setBounds(40, 410, 87, 14);
            AmendViewInvoice.getContentPane().add(CustomerID);
            
//          CustomerID textfield
            CustomerIDtextfield = new JTextField();
            CustomerIDtextfield.setBounds(155, 408, 135, 20);
            AmendViewInvoice.getContentPane().add(CustomerIDtextfield);
            CustomerIDtextfield.setColumns(10);
            
//          Customer name
            JLabel CustomerName = new JLabel("Customer Name");
            CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 12));
            CustomerName.setBounds(450, 320, 105, 14);
            AmendViewInvoice.getContentPane().add(CustomerName);
            
//          Name textfield
            Nametextfield = new JTextField();
            Nametextfield.setBounds(590, 317, 135, 20);
            AmendViewInvoice.getContentPane().add(Nametextfield);
            Nametextfield.setColumns(10);
            
//          Total owed
            JLabel TotalOwed = new JLabel("Total Owed");
            TotalOwed.setFont(new Font("Tahoma", Font.PLAIN, 12));
            TotalOwed.setBounds(450, 366, 105, 14);
            AmendViewInvoice.getContentPane().add(TotalOwed);
            
//          Total owed textfield
            TotalOwedtextfield = new JTextField();
            TotalOwedtextfield.setBounds(590, 363, 135, 20);
            AmendViewInvoice.getContentPane().add(TotalOwedtextfield);
            TotalOwedtextfield.setColumns(10);
            
//			Date
            JLabel Date = new JLabel("Date");
            Date.setFont(new Font("Tahoma", Font.PLAIN, 12));
            Date.setBounds(450, 411, 105, 14);
            AmendViewInvoice.getContentPane().add(Date);
            
//			Date textfield
            Datetextfield = new JTextField();
            Datetextfield.setBounds(590, 408, 135, 20);
            AmendViewInvoice.getContentPane().add(Datetextfield);
            Datetextfield.setColumns(10);
            
//          Date format
            JLabel DateFormat = new JLabel("YYYY--MM--DD");
            DateFormat.setForeground(Color.RED);
            DateFormat.setBounds(620, 439, 87, 14);
            AmendViewInvoice.getContentPane().add(DateFormat);
            
//          Button to update information edited in textfields
            JButton UpdateButton = new JButton("Update");
            UpdateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    final String DATABASE_URL = "jdbc:mysql://localhost/project";
                    Connection connection = null;
                    PreparedStatement pstat = null;
                    try {
                        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
                        if (InvoiceDropdown.getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(null, "Please select an invoice to update");
                            return;
                        }
                        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this invoice?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            String query = "UPDATE invoice SET TotalOwed=?, Date=? WHERE InvoiceID=?";
                            pstat = connection.prepareStatement(query);

                            String TotalOwed = TotalOwedtextfield.getText();
                            String Date = Datetextfield.getText();
                            int InvoiceID = Integer.parseInt(InvoiceIDtextfield.getText());

                            pstat.setString(1, TotalOwed);
                            pstat.setString(2, Date);
                            pstat.setInt(3, InvoiceID);

                            pstat.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Invoice updated successfully");
                            
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No invoice updated");
                        }
                    } 
                    catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            UpdateButton.setBounds(38, 439, 89, 23);
            AmendViewInvoice.getContentPane().add(UpdateButton);
            
//          Button to refresh table after updating table
            JButton RefreshButton = new JButton("Refresh");
            RefreshButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		// load the invoice data and customer datainto the table
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
                    InvoiceIDtextfield.setText("");
                    CustomerIDtextfield.setText("");
    				Nametextfield.setText("");
    		    	TotalOwedtextfield.setText("");
    		    	Datetextfield.setText("");
            	}
            });
            RefreshButton.setBounds(201, 439, 89, 23);
            AmendViewInvoice.getContentPane().add(RefreshButton);
	}
}
