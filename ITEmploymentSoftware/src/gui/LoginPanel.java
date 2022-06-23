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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginPanel extends JPanel{
	private MainFrame main;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton;
	private JButton registerButton;
	private JLabel panelTitle;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	public LoginPanel(MainFrame main) {
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1,1.0,1,1,1};
		gridBagLayout.rowWeights = new double[]{1,1,1,1,1,1};
		setLayout(gridBagLayout);
		
		this.panelTitle = new JLabel("Login Page");
		panelTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.gridwidth = 4;
		gbc_panelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_panelTitle.gridx = 1;
		gbc_panelTitle.gridy = 0;
		add(panelTitle, gbc_panelTitle);
		
		this.usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 1;
		gbc_usernameLabel.gridy = 1;
		add(usernameLabel, gbc_usernameLabel);
		
		this.usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.gridwidth = 3;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 2;
		gbc_usernameField.gridy = 1;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		this.passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 2;
		add(passwordLabel, gbc_passwordLabel);
		
		this.passwordField = new JTextField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		this.loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.gridwidth = 2;
		gbc_loginButton.insets = new Insets(0, 0, 5, 5);
		gbc_loginButton.gridx = 2;
		gbc_loginButton.gridy = 3;
		add(loginButton, gbc_loginButton);
		
		this.registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showRegisterPanel();
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.gridwidth = 2;
		gbc_registerButton.insets = new Insets(0, 0, 5, 5);
		gbc_registerButton.gridx = 2;
		gbc_registerButton.gridy = 4;
		add(registerButton, gbc_registerButton);
	}
}
