//	Author: Qadeer Hussain
//	Purpose: Customer menu
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class customer_menu {

	private JFrame CustomerSubmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_menu window = new customer_menu();
					window.CustomerSubmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customer_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CustomerSubmenu = new JFrame();
		CustomerSubmenu.setTitle("Customer Submenu");
		CustomerSubmenu.setBounds(100, 100, 376, 235);
		CustomerSubmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CustomerSubmenu.getContentPane().setLayout(null);
		
		JLabel Customer = new JLabel("Customer Submenu");
		Customer.setHorizontalAlignment(SwingConstants.CENTER);
		Customer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Customer.setBounds(32, 11, 292, 30);
		CustomerSubmenu.getContentPane().add(Customer);
		
//		Button that goes to home screen
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home h = new home();
				h.main(null);
				CustomerSubmenu.dispose();
			}
		});
		BackButton.setBounds(96, 52, 169, 23);
		CustomerSubmenu.getContentPane().add(BackButton);
		
//		Button to go to Add Customer Screen
		JButton AddCustomerScreenButton = new JButton("Add Customer");
		AddCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_customer addCust = new add_customer();
				addCust.main(null);
				CustomerSubmenu.dispose();
			}
		});
		AddCustomerScreenButton.setBounds(96, 86, 169, 23);
		CustomerSubmenu.getContentPane().add(AddCustomerScreenButton);
		
//		Button to go to Amend/View Customer Screen
		JButton AmendViewScreenButton = new JButton("Amend/View Customer");
		AmendViewScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_customer amendViewCust = new amend_view_customer();
		        amendViewCust.main(null);
		    	CustomerSubmenu.dispose();
			}
		});
		AmendViewScreenButton.setBounds(96, 120, 169, 23);
		CustomerSubmenu.getContentPane().add(AmendViewScreenButton);
		
//		Button to go to Delete Customer Screen
		JButton DeleteCustomerScreenButton = new JButton("Delete Customer");
		DeleteCustomerScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_customer deleteCust = new delete_customer();
				deleteCust.main(null);
				CustomerSubmenu.dispose();
			}
		});
		DeleteCustomerScreenButton.setBounds(96, 154, 169, 23);
		CustomerSubmenu.getContentPane().add(DeleteCustomerScreenButton);
	}

}
