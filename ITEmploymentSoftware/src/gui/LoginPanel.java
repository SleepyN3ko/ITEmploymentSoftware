package gui;
import controller.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class LoginPanel extends JPanel{
	private MainFrame main;
	private JTextField textField;
	private JTextField textField_1;
	
	public LoginPanel(MainFrame main) {
		setLayout(null);
	    this.main=main;
	    
	    JLabel lblUsername = new JLabel("Username:");
	    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    lblUsername.setBounds(21, 73, 188, 46);
	    add(lblUsername);
	    
	    JLabel lblPassword = new JLabel("Password:");
	    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    lblPassword.setBounds(21, 140, 149, 50);
	    add(lblPassword);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    textField.setBounds(230, 84, 197, 35);
	    add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    textField_1.setBounds(230, 152, 197, 35);
	    add(textField_1);
	    textField_1.setColumns(10);
	}
}
