package gui;
import controller.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;

public class LoginPanel extends JPanel{
	private MainFrame main;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton registerButton;
	private JLabel panelTitle;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel lblPosition;
	private JRadioButton rdbtnManager;
	private JRadioButton rdbtnStaff;
	
	public LoginPanel(MainFrame main) {
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 0, 20,20, 0,20};
		gridBagLayout.columnWeights = new double[]{1.0,1,1.0,1, 0.0,1,1};
		gridBagLayout.rowWeights = new double[]{1,1,1, 0.0,1,1, 0.0,1};
		setLayout(gridBagLayout);
		
		this.panelTitle = new JLabel("Login Page");
		panelTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.gridwidth = 5;
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
		gbc_usernameField.gridwidth = 4;
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
		
		
		this.passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 4;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		passwordField.setEchoChar('*');
		
		
		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					passwordField.setEchoChar((char)0);
				
		}});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow.gridx = 4;
		gbc_btnShow.gridy = 3;
		add(btnShow, gbc_btnShow);
		
		btnHide = new JButton("Hide");
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					passwordField.setEchoChar('*');
				
		}});
		btnHide.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnHide = new GridBagConstraints();
		gbc_btnHide.insets = new Insets(0, 0, 5, 5);
		gbc_btnHide.gridx = 5;
		gbc_btnHide.gridy = 3;
		add(btnHide, gbc_btnHide);
		
		lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 1;
		gbc_lblPosition.gridy = 4;
		add(lblPosition, gbc_lblPosition);
		
		ButtonGroup btnRoleGroup = new ButtonGroup();
		rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnManager = new GridBagConstraints();
		gbc_rdbtnManager.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnManager.gridx = 2;
		gbc_rdbtnManager.gridy = 4;
		add(rdbtnManager, gbc_rdbtnManager);
		btnRoleGroup.add(rdbtnManager);
		this.rdbtnManager.addActionListener(new RadioButtonListener());
		
		rdbtnStaff = new JRadioButton("HR Staff");
		rdbtnStaff.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStaff = new GridBagConstraints();
		gbc_rdbtnStaff.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStaff.gridx = 3;
		gbc_rdbtnStaff.gridy = 4;
		add(rdbtnStaff, gbc_rdbtnStaff);
		btnRoleGroup.add(rdbtnStaff);
		this.rdbtnStaff.addActionListener(new RadioButtonListener());
		
		
		this.loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (RoleButton == "")
				{
					JOptionPane.showMessageDialog(null, "Please select a role", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (RoleButton == "Manager")
				{
					String errorMsg = main.getController().verifyManager(username, password,1);
					if (errorMsg == ""){
						main.showManagerPanel();
					}
					else {
						JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (RoleButton == "Staff")
				{
					String errorMsg = main.getController().verifyStaff(username, password,1);
					if (errorMsg == ""){
						main.showStaffPanel();
					}
					else {
						JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
				
				
				
				
				
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.gridwidth = 2;
		gbc_loginButton.insets = new Insets(0, 0, 5, 5);
		gbc_loginButton.gridx = 2;
		gbc_loginButton.gridy = 5;
		add(loginButton, gbc_loginButton);
		

	}
			
	private String RoleButton = "";	
	private JButton btnShow;
	private JButton btnHide;
	
	private class RadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent f)
		{
			
			if(f.getSource() ==  rdbtnManager)
			{
				RoleButton = "Manager";
			}
			else if (f.getSource() ==  rdbtnStaff)
			{
				RoleButton = "Staff";
			}
		}			
	}
}
