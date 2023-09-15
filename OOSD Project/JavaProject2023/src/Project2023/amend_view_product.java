//	Author: Qadeer Hussain
//	Purpose: Amend/View Product
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class amend_view_product {

	private JFrame AmendViewProduct;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amend_view_product window = new amend_view_product();
					window.AmendViewProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public amend_view_product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AmendViewProduct = new JFrame();
		AmendViewProduct.setTitle("Amend/View Product");
		AmendViewProduct.setBounds(100, 100, 655, 410);
		AmendViewProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AmendViewProduct.getContentPane().setLayout(null);
		
//		Button to back to submenu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_menu prodSubmenu = new product_menu();
				prodSubmenu.main(null);
				AmendViewProduct.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		AmendViewProduct.getContentPane().add(BackButton);
		
//		Table
		JScrollPane Producttable = new JScrollPane();
		Producttable.setBounds(10, 100, 619, 201);
		AmendViewProduct.getContentPane().add(Producttable);

		table = new JTable();
		Producttable.setViewportView(table);

		// load the product data into the table
		final String DATABASE_URL = "jdbc:mysql://localhost/project";
		Connection connection = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
		    // establish connection to database
		    connection = DriverManager.getConnection(DATABASE_URL, "root", "");
		    // create Prepared Statement for selecting data from the table
		    pstat = connection.prepareStatement("SELECT * FROM product");
		    rs = pstat.executeQuery();
		    // create a new TableModel to hold the data
		    DefaultTableModel product = new DefaultTableModel();
		    // add columns to the TableModel
		    product.addColumn("ProductID");
		    product.addColumn("Name");
		    product.addColumn("Description");
		    product.addColumn("Price");
		    product.addColumn("Stock");

		    // loop through the ResultSet and add rows to the TableModel
		    while (rs.next()) 
		    {
		        product.addRow(new Object[] {
		            rs.getInt("ProductID"),
		            rs.getString("Name"),
		            rs.getString("Description"),
		            rs.getDouble("Price"),
		            rs.getInt("Stock"),
		        });
		    }
		    // set the TableModel on the JTable
		    table.setModel(product);
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
		
//		Button to go to Add Product Screen
		JButton AddProductScreenButton = new JButton("Add Product");
		AddProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_product addProd = new add_product();
				addProd.main(null);
				AmendViewProduct.dispose();
			}
		});
		AddProductScreenButton.setBounds(132, 60, 118, 23);
		AmendViewProduct.getContentPane().add(AddProductScreenButton);
		
//		Button to go to Amend/View Product Screen
		JButton AmendViewProductScreenButton = new JButton("Amend/View Product");
		AmendViewProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_product amendViewProd = new amend_view_product();
				amendViewProd.main(null);
				AmendViewProduct.dispose();
			}
		});
		AmendViewProductScreenButton.setBounds(272, 60, 175, 23);
		AmendViewProduct.getContentPane().add(AmendViewProductScreenButton);
		
//		Button to go to Delete Product Screen
		JButton DeleteProductScreenButton = new JButton("Delete Product");
		DeleteProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_product deleteProd = new delete_product();
				deleteProd.main(null);
				AmendViewProduct.dispose();
			}
		});
		DeleteProductScreenButton.setBounds(473, 60, 132, 23);
		AmendViewProduct.getContentPane().add(DeleteProductScreenButton);
		
//		Button to update information on table
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 updateProduct(table);
		    }
		});
		UpdateButton.setBounds(275, 312, 89, 23);
		AmendViewProduct.getContentPane().add(UpdateButton);

	}
	
//	Method to update information in table
	public void updateProduct(JTable table) {
	    final String DATABASE_URL = "jdbc:mysql://localhost/project";
	    Connection connection = null;
	    PreparedStatement pstat = null;
	    try {
	        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	        int row = table.getSelectedRow();
	        if (row != -1) {
	            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this product?", "Confirmation", JOptionPane.YES_NO_OPTION);
	            if (response == JOptionPane.YES_OPTION) {
	                String query = "UPDATE product SET Name=?, Description=?, Price=?, Stock=? WHERE ProductID=?";
	                pstat = connection.prepareStatement(query);

	                int ProductID = (int) table.getValueAt(row, 0);
	                String Name = (String) table.getValueAt(row, 1);
	                String Description = (String) table.getValueAt(row, 2);
	                double Price = Double.parseDouble(table.getValueAt(row, 3).toString());
	                int Stock = Integer.parseInt(table.getValueAt(row, 4).toString());

	                pstat.setString(1, Name);
	                pstat.setString(2, Description);
	                pstat.setDouble(3, Price);
	                pstat.setInt(4, Stock);
	                pstat.setInt(5, ProductID);

	                pstat.executeUpdate();
	                JOptionPane.showMessageDialog(null, "Product updated successfully");
	            }
	            else {
	            	 JOptionPane.showMessageDialog(null, "No product updated");
	            }
	        } 
	        else {
	            JOptionPane.showMessageDialog(null, "Please select a product to update");
	        }
	    } 
	    catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
}
