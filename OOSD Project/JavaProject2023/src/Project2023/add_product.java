//	Author: Qadeer Hussain
//	Purpose: Add Product
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class add_product {

	private JFrame AddProduct;
	private JTextField Nametextfield;
	private JTextField Pricetextfield;
	private JTextField Stocktextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_product window = new add_product();
					window.AddProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public add_product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddProduct = new JFrame();
		AddProduct.setTitle("Add Product");
		AddProduct.setBounds(100, 100, 606, 331);
		AddProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 20, 0, 20, 0, 20, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 25, 0, 25, 0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddProduct.getContentPane().setLayout(gridBagLayout);
		
//		Button to back to submenu
		JButton BackScreenButton = new JButton("Back");
		BackScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_menu prodSubmenu = new product_menu();
				prodSubmenu.main(null);
				AddProduct.dispose();
			}
		});
		GridBagConstraints gbc_BackScreenButton = new GridBagConstraints();
		gbc_BackScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_BackScreenButton.gridx = 1;
		gbc_BackScreenButton.gridy = 2;
		AddProduct.getContentPane().add(BackScreenButton, gbc_BackScreenButton);
		
//		Button to go to Add Product Screen
		JButton AddProductScreenButton = new JButton("Add Product");
		AddProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_product addProd = new add_product();
				addProd.main(null);
				AddProduct.dispose();
			}
		});
		GridBagConstraints gbc_AddProductScreenButton = new GridBagConstraints();
		gbc_AddProductScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AddProductScreenButton.gridx = 3;
		gbc_AddProductScreenButton.gridy = 2;
		AddProduct.getContentPane().add(AddProductScreenButton, gbc_AddProductScreenButton);
		
//		Button to go to Amend/View Product Screen
		JButton AmendViewProductButton = new JButton("Amend/View Product");
		AmendViewProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_product amendViewProd = new amend_view_product();
				amendViewProd.main(null);
				AddProduct.dispose();
			}
		});
		GridBagConstraints gbc_AmendViewProductButton = new GridBagConstraints();
		gbc_AmendViewProductButton.insets = new Insets(0, 0, 5, 5);
		gbc_AmendViewProductButton.gridx = 5;
		gbc_AmendViewProductButton.gridy = 2;
		AddProduct.getContentPane().add(AmendViewProductButton, gbc_AmendViewProductButton);
		
//		Button to go to Delete Product Screen
		JButton DeleteProductButton = new JButton("Delete Product");
		DeleteProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_product deleteProd = new delete_product();
				deleteProd.main(null);
				AddProduct.dispose();
			}
		});
		GridBagConstraints gbc_DeleteProductButton = new GridBagConstraints();
		gbc_DeleteProductButton.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteProductButton.gridx = 7;
		gbc_DeleteProductButton.gridy = 2;
		AddProduct.getContentPane().add(DeleteProductButton, gbc_DeleteProductButton);
		
//		Name
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 4;
		AddProduct.getContentPane().add(Name, gbc_Name);
		
//		Name textfield
		Nametextfield = new JTextField();
		GridBagConstraints gbc_Nametextfield = new GridBagConstraints();
		gbc_Nametextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Nametextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Nametextfield.gridx = 3;
		gbc_Nametextfield.gridy = 4;
		AddProduct.getContentPane().add(Nametextfield, gbc_Nametextfield);
		Nametextfield.setColumns(10);
		
//		Description
		JLabel Description = new JLabel("Description");
		Description.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Description = new GridBagConstraints();
		gbc_Description.insets = new Insets(0, 0, 5, 5);
		gbc_Description.gridx = 5;
		gbc_Description.gridy = 4;
		AddProduct.getContentPane().add(Description, gbc_Description);
		
//		Description textfield
		JTextArea Descriptiontextarea = new JTextArea();
		GridBagConstraints gbc_Descriptiontextarea = new GridBagConstraints();
		gbc_Descriptiontextarea.gridheight = 3;
		gbc_Descriptiontextarea.insets = new Insets(0, 0, 5, 5);
		gbc_Descriptiontextarea.fill = GridBagConstraints.BOTH;
		gbc_Descriptiontextarea.gridx = 7;
		gbc_Descriptiontextarea.gridy = 4;
		AddProduct.getContentPane().add(Descriptiontextarea, gbc_Descriptiontextarea);
		
//		Price
		JLabel Price = new JLabel("Price");
		Price.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_Price = new GridBagConstraints();
		gbc_Price.insets = new Insets(0, 0, 5, 5);
		gbc_Price.gridx = 1;
		gbc_Price.gridy = 6;
		AddProduct.getContentPane().add(Price, gbc_Price);
		
//		Price textfield
		Pricetextfield = new JTextField();
		GridBagConstraints gbc_Pricetextfield = new GridBagConstraints();
		gbc_Pricetextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Pricetextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Pricetextfield.gridx = 3;
		gbc_Pricetextfield.gridy = 6;
		AddProduct.getContentPane().add(Pricetextfield, gbc_Pricetextfield);
		Pricetextfield.setColumns(10);
		
//		Stock
		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		AddProduct.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
//		Stock textfield
		Stocktextfield = new JTextField();
		GridBagConstraints gbc_Stocktextfield = new GridBagConstraints();
		gbc_Stocktextfield.insets = new Insets(0, 0, 0, 5);
		gbc_Stocktextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Stocktextfield.gridx = 3;
		gbc_Stocktextfield.gridy = 8;
		AddProduct.getContentPane().add(Stocktextfield, gbc_Stocktextfield);
		Stocktextfield.setColumns(10);
		
//		Button to add data to table
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (Nametextfield.getText().isEmpty() && Descriptiontextarea.getText().isEmpty() && Pricetextfield.getText().isEmpty() && Stocktextfield.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter product information.");
		        } 
		        else {
		            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this product?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (response == JOptionPane.YES_OPTION) {
		                try {
		                    productInsert(Nametextfield, Descriptiontextarea, Pricetextfield, Stocktextfield);

		                    Nametextfield.setText("");
		                    Descriptiontextarea.setText("");
		                    Pricetextfield.setText("");
		                    Stocktextfield.setText("");

		                    JOptionPane.showMessageDialog(null, "New product added.");
		                } 
		                catch (Exception ex) {
		                    JOptionPane.showMessageDialog(null, "Error in input..");
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
		gbc_AddButton.gridx = 5;
		gbc_AddButton.gridy = 8;
		AddProduct.getContentPane().add(AddButton, gbc_AddButton);
		
//		Button to clear textfields
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nametextfield.setText("");
	            Descriptiontextarea.setText("");
	            Pricetextfield.setText("");
	            Stocktextfield.setText("");
			}
		});
		GridBagConstraints gbc_ClearButton = new GridBagConstraints();
		gbc_ClearButton.anchor = GridBagConstraints.EAST;
		gbc_ClearButton.insets = new Insets(0, 0, 0, 5);
		gbc_ClearButton.gridx = 7;
		gbc_ClearButton.gridy = 8;
		AddProduct.getContentPane().add(ClearButton, gbc_ClearButton);
	}
	
//	Method to add products to table
	public static void productInsert(JTextField ProductNametextfield, JTextArea Descriptiontextarea, JTextField Pricetextfield, JTextField Stocktextfield) 
		{
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost/project";
			Connection connection = null ;
			PreparedStatement pstat = null;
			String Name = ProductNametextfield.getText();
			String Description = Descriptiontextarea.getText();
			double Price = Double.parseDouble(Pricetextfield.getText());
			int Stock = Integer.parseInt(Stocktextfield.getText());
			int i=0;
			
			try {
				// establish connection to database
				connection = DriverManager.getConnection(DATABASE_URL, "root", "");
				// create Prepared Statement for inserting data into table
				pstat = connection.prepareStatement("INSERT INTO product (Name, Description, Price, Stock)VALUES (?,?,?,?)");
				pstat . setString (1, Name);
				pstat . setString (2, Description);
				pstat . setDouble (3, Price);
				pstat . setInt (4, Stock);
				
				// insert data into table
				i = pstat .executeUpdate();
				System.out. println ( i + " record successfully added to the table .");
			}
			catch(SQLException sqlException){
				sqlException . printStackTrace () ;
			}
			finally {	
				try {
					pstat . close () ;
					connection. close () ;
				}
				catch (Exception exception){
					exception . printStackTrace () ;
				}
			}	
		}
}
