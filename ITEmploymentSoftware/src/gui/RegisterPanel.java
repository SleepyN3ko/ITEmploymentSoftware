package gui;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
public class RegisterPanel extends JPanel {
	private MainFrame main;
	
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel panelTitle;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton registerButton;
	private JButton backButton;
	private JComboBox roleCombo;
	private JLabel roleLabel;
	public RegisterPanel(MainFrame main) {
		setBackground(new Color(135, 206, 250));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1,1,1};
		gridBagLayout.rowWeights = new double[]{1,1,1,1,1,1};
		setLayout(gridBagLayout);
		
		this.panelTitle = new JLabel("Manager Add Employee");
		panelTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
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
		
		this.roleLabel = new JLabel("Role: ");
		roleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_roleLabel = new GridBagConstraints();
		gbc_roleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roleLabel.anchor = GridBagConstraints.EAST;
		gbc_roleLabel.gridx = 1;
		gbc_roleLabel.gridy = 3;
		add(roleLabel, gbc_roleLabel);
		
		String[] roles = {"Manager","HR Staff"};
		this.roleCombo = new JComboBox(roles);
		roleCombo.setBackground(Color.WHITE);
		roleCombo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_roleCombo = new GridBagConstraints();
		gbc_roleCombo.gridwidth = 3;
		gbc_roleCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_roleCombo.insets = new Insets(0, 0, 5, 5);
		gbc_roleCombo.gridx = 2;
		gbc_roleCombo.gridy = 3;
		add(roleCombo, gbc_roleCombo);
		
		this.registerButton = new JButton("Add");
		registerButton.setBackground(Color.GREEN);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (roleCombo.getSelectedIndex()==0){
					String errorMsg = main.getController().verifyManager(username, password,0);
					if (errorMsg == ""){
						main.getController().registerManager(username, password);
						usernameField.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "Manager has been successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (roleCombo.getSelectedIndex()==1){
					String errorMsg = main.getController().verifyStaff(username, password,0);
					if (errorMsg == ""){
						main.getController().registerStaff(username, password);
						usernameField.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "Staff has been successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
					
					}
					else {
						JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.gridwidth = 2;
		gbc_registerButton.insets = new Insets(0, 0, 5, 5);
		gbc_registerButton.gridx = 2;
		gbc_registerButton.gridy = 4;
		add(registerButton, gbc_registerButton);
		
		this.backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBackground(new Color(255,204,203));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridwidth = 2;
		gbc_backButton.gridx = 4;
		gbc_backButton.gridy = 5;
		add(backButton, gbc_backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showInfoStaffPanel();
			}
		});
	}

}
