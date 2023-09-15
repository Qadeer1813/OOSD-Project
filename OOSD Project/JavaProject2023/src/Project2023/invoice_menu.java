//	Author: Qadeer Hussain
//	Purpose: Invoice menu
//	Date: 06-04-2023
package Project2023;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class invoice_menu {

	private JFrame InvoiceSubmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invoice_menu window = new invoice_menu();
					window.InvoiceSubmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public invoice_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		InvoiceSubmenu = new JFrame();
		InvoiceSubmenu.setTitle("Invoice Submenu");
		InvoiceSubmenu.setBounds(100, 100, 376, 328);
		InvoiceSubmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InvoiceSubmenu.getContentPane().setLayout(null);
		
		JLabel Invoice = new JLabel("Invoice Submenu");
		Invoice.setHorizontalAlignment(SwingConstants.CENTER);
		Invoice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Invoice.setBounds(32, 11, 292, 30);
		InvoiceSubmenu.getContentPane().add(Invoice);
		
//		Button that goes to home screen
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home h = new home();
				h.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		BackButton.setBounds(85, 52, 187, 23);
		InvoiceSubmenu.getContentPane().add(BackButton);
		
//		Button to go to Add Invoice Screen
		JButton AddInvoiceScreenButton = new JButton("Add Invoice");
		AddInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_invoice addInvoice = new add_invoice();
				addInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		AddInvoiceScreenButton.setBounds(85, 86, 187, 23);
		InvoiceSubmenu.getContentPane().add(AddInvoiceScreenButton);
		
//		Button to go to Amend/View Invoice Screen
		JButton AmendViewInvoiceScreenButton = new JButton("Amend/View Invoice");
		AmendViewInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_invoice amendViewInvoice = new amend_view_invoice();
				amendViewInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		AmendViewInvoiceScreenButton.setBounds(85, 120, 187, 23);
		InvoiceSubmenu.getContentPane().add(AmendViewInvoiceScreenButton);
		
//		Button to go to Delete Invoice Screen
		JButton DeleteInvoiceScreenButton = new JButton("Delete Invoice");
		DeleteInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_invoice deleteInvoice = new delete_invoice();
				deleteInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		DeleteInvoiceScreenButton.setBounds(85, 154, 187, 23);
		InvoiceSubmenu.getContentPane().add(DeleteInvoiceScreenButton);
		
//		Button to go to Add products to Invoice screen
		JButton AddProductsToInvoiceScreenButton = new JButton("Add Products to Invoice");
		AddProductsToInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_products_to_invoice addProdToInvoice = new add_products_to_invoice();
				addProdToInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		AddProductsToInvoiceScreenButton.setBounds(85, 188, 187, 23);
		InvoiceSubmenu.getContentPane().add(AddProductsToInvoiceScreenButton);
		
//		Button to go to View products on Invoice screen
		JButton ViewProductsOnInvoiceScreenButton = new JButton("View Products on Invoice");
		ViewProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_products_on_invoice viewProdOnInvoice = new view_products_on_invoice();
				viewProdOnInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		ViewProductsOnInvoiceScreenButton.setBounds(85, 222, 187, 23);
		InvoiceSubmenu.getContentPane().add(ViewProductsOnInvoiceScreenButton);
		
//		Button to go to Delete products on Invoice screen
		JButton DeleteProductsOnInvoiceScreenButton = new JButton("Delete Products on Invoice");
		DeleteProductsOnInvoiceScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_products_on_invoice deleteProdOnInvoice = new delete_products_on_invoice();
				deleteProdOnInvoice.main(null);
				InvoiceSubmenu.dispose();
			}
		});
		DeleteProductsOnInvoiceScreenButton.setBounds(85, 255, 187, 23);
		InvoiceSubmenu.getContentPane().add(DeleteProductsOnInvoiceScreenButton);
	
	}
}
