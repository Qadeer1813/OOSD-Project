//	Author: Qadeer Hussain
//	Purpose: Product menu
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

public class product_menu {

	private JFrame ProductSubmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_menu window = new product_menu();
					window.ProductSubmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public product_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ProductSubmenu = new JFrame();
		ProductSubmenu.setTitle("Product Submenu");
		ProductSubmenu.setBounds(100, 100, 376, 235);
		ProductSubmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ProductSubmenu.getContentPane().setLayout(null);
		
		JLabel Product = new JLabel("Product Submenu");
		Product.setHorizontalAlignment(SwingConstants.CENTER);
		Product.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Product.setBounds(32, 11, 292, 30);
		ProductSubmenu.getContentPane().add(Product);
		
//		Button to go back to home screen
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home h = new home();
				h.main(null);
				ProductSubmenu.dispose();
			}
		});
		BackButton.setBounds(96, 52, 169, 23);
		ProductSubmenu.getContentPane().add(BackButton);
		
//		Button to go to Add Product Screen
		JButton AddProductScreenButton = new JButton("Add Product");
		AddProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_product addProd = new add_product();
				addProd.main(null);
				ProductSubmenu.dispose();
			}
		});
		AddProductScreenButton.setBounds(96, 86, 169, 23);
		ProductSubmenu.getContentPane().add(AddProductScreenButton);
		
//		Button to go to Amend/View Product Screen
		JButton AmendViewProductScreenButton = new JButton("Amend/ViewProduct");
		AmendViewProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amend_view_product amendViewProd = new amend_view_product();
		        amendViewProd.main(null);
		    	ProductSubmenu.dispose();
			}
		});
		AmendViewProductScreenButton.setBounds(96, 120, 169, 23);
		ProductSubmenu.getContentPane().add(AmendViewProductScreenButton);
		
//		Button to go to Delete Product Screen
		JButton DeleteProductScreenButton = new JButton("Delete Product");
		DeleteProductScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_product deleteProd = new delete_product();
				deleteProd.main(null);
				ProductSubmenu.dispose();
			}
		});
		DeleteProductScreenButton.setBounds(96, 154, 169, 23);
		ProductSubmenu.getContentPane().add(DeleteProductScreenButton);
	}
}
