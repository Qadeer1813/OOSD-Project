//	Author: Qadeer Hussain
//	Purpose: Add Customer
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

public class add_customer{

	private JFrame AddCustomer;
	private JLabel Forename;
	private JTextField Forenametextfield;
	private JLabel Surname;
	private JTextField Surnametextfield;
	private JTextField Streettextfield;
	private JLabel Street;
	private JLabel Town;
	private JTextField Towntextfield;
	private JLabel County;
	private JLabel DateOfBirth;
	private JTextField DateOfBirthtextfield;
	private JLabel Email;
	private JButton AddButton;
	private JButton BackScreenButton;
	private JButton AddCustomerScreenButton;
	private JButton DeleteScreenButton;
	private JButton AmendViewCustomerScreenButton;
	private JButton ClearButton;
	private JComboBox<String> CountyDropdown;
	private JLabel Dateformat;
	private JTextField Emailtextfield;
	private JLabel EmailFormat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_customer window = new add_customer();
					window.AddCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public add_customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddCustomer = new JFrame();
		AddCustomer.setTitle("Add Customer");
		AddCustomer.setBounds(100, 100, 657, 390);
		AddCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 91, 20, 110, 20, 110, 20, 110, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 25, 0, 25, 0, 25, 0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddCustomer.getContentPane().setLayout(gridBagLayout);
		
//		Button to go back to Sub menu
		BackScreenButton = new JButton("Back");
		BackScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_menu custSubmenu = new customer_menu();
				custSubmenu.main(null);
				AddCustomer.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		AddCustomer.getContentPane().add(BackScreenButton, gbc_btnNewButton);
		
//		Button to go to Add Customer Screen
		AddCustomerScreenButton = new JButton("Add Customer");
		AddCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_customer addCust = new add_customer();
				addCust.main(null);
				AddCustomer.dispose();
			}
		});
		GridBagConstraints gbc_AddCustomerScreenButton = new GridBagConstraints();
		gbc_AddCustomerScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AddCustomerScreenButton.gridx = 3;
		gbc_AddCustomerScreenButton.gridy = 2;
		AddCustomer.getContentPane().add(AddCustomerScreenButton, gbc_AddCustomerScreenButton);
		
//		Button to go to Amend/View Customer Screen
		AmendViewCustomerScreenButton = new JButton("Amend/View Customer");
		GridBagConstraints gbc_AmendViewCustomerScreenButton = new GridBagConstraints();
		gbc_AmendViewCustomerScreenButton.insets = new Insets(0, 0, 5, 5);
		gbc_AmendViewCustomerScreenButton.gridx = 5;
		gbc_AmendViewCustomerScreenButton.gridy = 2;
		AddCustomer.getContentPane().add(AmendViewCustomerScreenButton, gbc_AmendViewCustomerScreenButton);
		AmendViewCustomerScreenButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        amend_view_customer amendViewCust = new amend_view_customer();
		        amendViewCust.main(null);
		    	AddCustomer.dispose();
		    }
		});
		
//		Button to go to Delete Customer Screen
		DeleteScreenButton = new JButton("Delete Customer");
		DeleteScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_customer deleteCust = new delete_customer();
				deleteCust.main(null);
				AddCustomer.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 7;
		gbc_btnNewButton_2.gridy = 2;
		AddCustomer.getContentPane().add(DeleteScreenButton, gbc_btnNewButton_2);
		
//		Forename
		Forename = new JLabel("Forename");
		Forename.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		AddCustomer.getContentPane().add(Forename, gbc_lblNewLabel_1);
		
//		Forename textfield
		Forenametextfield = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		AddCustomer.getContentPane().add(Forenametextfield, gbc_textField_1);
		Forenametextfield.setColumns(10);
		
//		County
		County = new JLabel("County");
		County.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 4;
		AddCustomer.getContentPane().add(County, gbc_lblNewLabel_5);
		
//		County dropdown
		CountyDropdown = new JComboBox<String>();
		CountyDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Armagh", 
				"Carlow ", 
				"Cavan ", 
				"Clare ", 
				"Cork", 
				"Derry", 
				"Donegal", 
				"Down ", 
				"Dublin", 
				"Fermanagh", 
				"Galway", 
				"Kerry", 
				"Kildare", 
				"Kilkenny", 
				"Laois", 
				"Leitrim", 
				"Limerick", 
				"Longford", 
				"Louth", 
				"Mayo", 
				"Meath", 
				"Monaghan", 
				"Offaly", 
				"Roscommon", 
				"Sligo", 
				"Tipperary", 
				"Tyrone", 
				"Waterford", 
				"Westmeath", 
				"Wexford", 
				"Wicklow"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 7;
		gbc_comboBox_1.gridy = 4;
		AddCustomer.getContentPane().add(CountyDropdown, gbc_comboBox_1);
		
//		Surname
		Surname = new JLabel("Surname");
		Surname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		AddCustomer.getContentPane().add(Surname, gbc_lblNewLabel_3);
		
//		Surname textfield
		Surnametextfield = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 6;
		AddCustomer.getContentPane().add(Surnametextfield, gbc_textField_3);
		Surnametextfield.setColumns(10);
		
//		Date of Birth
		DateOfBirth = new JLabel("Date of birth");
		DateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 5;
		gbc_lblDateOfBirth.gridy = 6;
		AddCustomer.getContentPane().add(DateOfBirth, gbc_lblDateOfBirth);
		
//		Date of Birth textfield
		DateOfBirthtextfield = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 7;
		gbc_textField_6.gridy = 6;
		AddCustomer.getContentPane().add(DateOfBirthtextfield, gbc_textField_6);
		DateOfBirthtextfield.setColumns(10);
		
//		Date format
		Dateformat = new JLabel("YYYY--MM--DD");
		Dateformat.setForeground(Color.RED);
		GridBagConstraints gbc_Dateformat = new GridBagConstraints();
		gbc_Dateformat.insets = new Insets(0, 0, 5, 5);
		gbc_Dateformat.gridx = 7;
		gbc_Dateformat.gridy = 7;
		AddCustomer.getContentPane().add(Dateformat, gbc_Dateformat);
		
//		Street
		Street = new JLabel("Street");
		Street.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		AddCustomer.getContentPane().add(Street, gbc_lblNewLabel_4);
		
//		Street textfield
		Streettextfield = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 8;
		AddCustomer.getContentPane().add(Streettextfield, gbc_textField_4);
		Streettextfield.setColumns(10);
		
//		Email
		Email = new JLabel("Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 8;
		AddCustomer.getContentPane().add(Email, gbc_lblNewLabel_6);
		
//		Email textfield
		Emailtextfield = new JTextField();
		GridBagConstraints gbc_Emailtextfield = new GridBagConstraints();
		gbc_Emailtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_Emailtextfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Emailtextfield.gridx = 7;
		gbc_Emailtextfield.gridy = 8;
		AddCustomer.getContentPane().add(Emailtextfield, gbc_Emailtextfield);
		Emailtextfield.setColumns(10);
		
//		Email format
		EmailFormat = new JLabel("test@gmail.com");
		EmailFormat.setForeground(Color.RED);
		GridBagConstraints gbc_EmailFormat = new GridBagConstraints();
		gbc_EmailFormat.insets = new Insets(0, 0, 5, 5);
		gbc_EmailFormat.gridx = 7;
		gbc_EmailFormat.gridy = 9;
		AddCustomer.getContentPane().add(EmailFormat, gbc_EmailFormat);
		
//		Town
		Town = new JLabel("Town");
		Town.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		AddCustomer.getContentPane().add(Town, gbc_lblNewLabel_2);
		
//		Town textfield
		Towntextfield = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 10;
		AddCustomer.getContentPane().add(Towntextfield, gbc_textField_2);
		Towntextfield.setColumns(10);
		
//		Button to add information to db table
		AddButton = new JButton("Add");
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton1.gridx = 5;
		gbc_btnNewButton1.gridy = 10;
		AddCustomer.getContentPane().add(AddButton, gbc_btnNewButton1);
		AddButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if any of the fields are empty
		        if (Forenametextfield.getText().isEmpty() && Surnametextfield.getText().isEmpty() && Streettextfield.getText().isEmpty() && Towntextfield.getText().isEmpty() && CountyDropdown.getSelectedIndex() == 0 && DateOfBirthtextfield.getText().isEmpty() && Emailtextfield.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter customer information.");
		        } 
		        else {
		            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this customer?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (response == JOptionPane.YES_OPTION) {
		                try {
		                    customerInsert(Forenametextfield, Surnametextfield, Streettextfield, Towntextfield, CountyDropdown, DateOfBirthtextfield, Emailtextfield);

		                    Forenametextfield.setText("");
		                    Surnametextfield.setText("");
		                    Streettextfield.setText("");
		                    Towntextfield.setText("");
		                    CountyDropdown.setSelectedIndex(0);
		                    DateOfBirthtextfield.setText("");
		                    Emailtextfield.setText("");

		                    JOptionPane.showMessageDialog(null, "New customer added.");
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

//		Button to clear the textfields
		ClearButton = new JButton("Clear");
		GridBagConstraints gbc_btnNewButton11 = new GridBagConstraints();
		gbc_btnNewButton11.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton11.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton11.gridx = 7;
		gbc_btnNewButton11.gridy = 10;
		AddCustomer.getContentPane().add(ClearButton, gbc_btnNewButton11);
		ClearButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear the text boxes
		    	Forenametextfield.setText("");
		    	Surnametextfield.setText("");
		    	Streettextfield.setText("");
		    	Towntextfield.setText("");
		    	CountyDropdown.setSelectedIndex(0);
		    	DateOfBirthtextfield.setText("");
		    	Emailtextfield.setText("");
		    }
		});
	}
	
//	Method for inserting data into table
	public static void customerInsert(JTextField Forenametextfield, JTextField Surnametextfield, JTextField Streettextfield, JTextField Towntextfield, JComboBox<String> CountyDropdown,
            JTextField DateOfBirthtextfield, JTextField Emailtextfield) 
		{
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost/project";
			Connection connection = null ;
			PreparedStatement pstat = null;
			String Forename = Forenametextfield.getText();
			String Surname = Surnametextfield.getText();
			String Street = Streettextfield.getText();
			String Town = Towntextfield.getText();
			String countyString = (String) CountyDropdown.getSelectedItem();
			String dobString = DateOfBirthtextfield.getText();
			Date DateOfBirth = java.sql.Date.valueOf(dobString);
			String Email = Emailtextfield.getText();
			int i=0;
			
			try {
				// establish connection to database
				connection = DriverManager.getConnection(DATABASE_URL, "root", "");
				// create Prepared Statement for inserting data into table
				pstat = connection.prepareStatement("INSERT INTO customer (Forename, Surname, Street, Town, County, DateOfBirth, Email)VALUES (?,?,?,?,?,?,?)");
				pstat.setString (1, Forename);
				pstat.setString (2, Surname);
				pstat.setString (3, Street);
				pstat.setString (4, Town);
				pstat.setString (5, countyString);
				pstat.setDate (6, DateOfBirth);
				pstat.setString (7, Email);
				
				// insert data into table
				i = pstat .executeUpdate();
				System.out. println ( i + " record successfully added to the table .");
			}
			catch(SQLException sqlException){
				sqlException . printStackTrace () ;
			}
			finally {	
				try {
					pstat.close () ;
					connection.close () ;
				}
				catch (Exception exception){
					exception.printStackTrace () ;
				}
			}	
		}
}
