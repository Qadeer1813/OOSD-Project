//	Author: Qadeer Hussain
//	Purpose: Delete Product
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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delete_product {

	private JFrame DeleteProduct;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_product window = new delete_product();
					window.DeleteProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public delete_product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DeleteProduct = new JFrame();
		DeleteProduct.setTitle("Delete Product");
		DeleteProduct.setBounds(100, 100, 655, 410);
		DeleteProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteProduct.getContentPane().setLayout(null);
		
//		Button to back to submenu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_menu prodSubmenu = new product_menu();
				prodSubmenu.main(null);
				DeleteProduct.dispose();
			}
		});
		BackButton.setBounds(40, 60, 70, 23);
		DeleteProduct.getContentPane().add(BackButton);
		
//		Button to go to Add Product Screen
		JButton AddProductScreenButton = new JButton("Add Product");
		AddProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_product addProd = new add_product();
				addProd.main(null);
				DeleteProduct.dispose();
			}
		});
		AddProductScreenButton.setBounds(132, 60, 118, 23);
		DeleteProduct.getContentPane().add(AddProductScreenButton);
		
//		Button to go to Amend/View Product Screen
		JButton AmendViewProductScreenButton = new JButton("Amend/View Product");
		AmendViewProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_product amendViewProd = new amend_view_product();
				amendViewProd.main(null);
				DeleteProduct.dispose();
			}
		});
		AmendViewProductScreenButton.setBounds(272, 60, 175, 23);
		DeleteProduct.getContentPane().add(AmendViewProductScreenButton);
		
//		Button to go to Delete Product Screen
		JButton DeleteProductScreenButton = new JButton("Delete Product");
		DeleteProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_product deleteProd = new delete_product();
				deleteProd.main(null);
				DeleteProduct.dispose();
			}
		});
		DeleteProductScreenButton.setBounds(473, 60, 132, 23);
		DeleteProduct.getContentPane().add(DeleteProductScreenButton);
		
//		Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 619, 201);
		DeleteProduct.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		    while (rs.next()) {
		        product.addRow(new Object[] {
		            rs.getString("ProductID"),
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
		
//		Button to delete whatever row has been selected
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProduct(table);
			}
		});
		DeleteButton.setBounds(221, 312, 89, 23);
		DeleteProduct.getContentPane().add(DeleteButton);
		
//		Button to refresh table after deleting
		JButton RefreshTable = new JButton("Refresh");
		RefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		RefreshTable.setBounds(346, 312, 89, 23);
		DeleteProduct.getContentPane().add(RefreshTable);
	}
	
//	Method to deleting products on table
	public void deleteProduct(JTable table) {
	    final String DATABASE_URL = "jdbc:mysql://localhost/project";
	    Connection connection = null;
	    PreparedStatement pstat = null;
	    try {
	        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	        String query = "DELETE FROM product WHERE ProductID =?";
	        pstat = connection.prepareStatement(query);
	        int row = table.getSelectedRow();
	        if (row != -1) {
	            int ProductID = (int) table.getValueAt(row, 0);
	            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?" , "Confirmation", JOptionPane.YES_NO_OPTION);
	            if (confirmation == JOptionPane.YES_OPTION) {
	                pstat.setInt(1, ProductID);
	                pstat.executeUpdate();
	                JOptionPane.showMessageDialog(null, "Product deleted successfully");
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "No Product deleted");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a product to delete");
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	}
}
