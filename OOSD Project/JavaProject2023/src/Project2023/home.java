//	Author: Qadeer Hussain
//	Purpose: Home Screen
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class home {

	private JFrame Home;
	private JButton ProductButton;
	private JButton InvoiceButton;
	private JButton Exit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.Home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Home = new JFrame();
		Home.setTitle("Home");
		Home.setBounds(100, 100, 376, 235);
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Home.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Invoice Management System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 11, 292, 30);
		Home.getContentPane().add(lblNewLabel);
		
//		Button that goes to Customer Submenu
		JButton CustomerButton = new JButton("Customer");
		CustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_menu custSubmenu = new customer_menu();
				custSubmenu.main(null);
				Home.dispose();
			}
		});
		CustomerButton.setBounds(125, 52, 100, 23);
		Home.getContentPane().add(CustomerButton);
		
//		Button that goes to Product Submenu
		ProductButton = new JButton("Product");
		ProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_menu prodSubmenu = new product_menu();
				prodSubmenu.main(null);
				Home.dispose();
			}
		});
		ProductButton.setBounds(125, 87, 100, 23);
		Home.getContentPane().add(ProductButton);
		
//		Button that goes to Invoice Submenu
		InvoiceButton = new JButton("Invoice");
		InvoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice_menu invoiceSubmenu = new invoice_menu();
				invoiceSubmenu.main(null);
				Home.dispose();
			}
		});
		InvoiceButton.setBounds(125, 121, 100, 23);
		Home.getContentPane().add(InvoiceButton);
		
//		Button that exits the program
		Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Exit.setBounds(125, 155, 100, 23);
		Home.getContentPane().add(Exit);
		
	}
}
