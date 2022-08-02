package gui;
import controller.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.Color;
/*
 * This class is used generate the panel for the login.
 */
public class LoginPanel extends JPanel{
	private MainFrame main;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel panelTitle;
	private JLabel lblPosition;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnManager;
	private JRadioButton rdbtnStaff;
	private Image loginImage;
	private int passFlag = 0;
	
	public LoginPanel(MainFrame main) {
		setForeground(Color.WHITE);
		setBackground(new Color(135, 206, 250));
		
		
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 0, 0, 0, 20, 0, 20, 20, 0,20,20};
		gridBagLayout.rowHeights = new int[]{0, 20, 0, 0, 30, 30, 0, 30,30, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0,1, 0.0,1.0,1, 1.0,0.0,1};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0,0.0, 0.0,0.0,0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		lblItEmployment = new JLabel("IT EMPLOYMENT SOFTWARE");
		lblItEmployment.setForeground(Color.BLACK);
		lblItEmployment.setFont(new Font("Algerian", Font.BOLD, 45));
		GridBagConstraints gbc_lblItEmployment = new GridBagConstraints();
		gbc_lblItEmployment.fill = GridBagConstraints.VERTICAL;
		gbc_lblItEmployment.gridwidth = 13;
		gbc_lblItEmployment.insets = new Insets(0, 0, 5, 0);
		gbc_lblItEmployment.gridx = 0;
		gbc_lblItEmployment.gridy = 0;
		add(lblItEmployment, gbc_lblItEmployment);
		
		this.panelTitle = new JLabel("SIGN IN");
		panelTitle.setForeground(Color.WHITE);
		panelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 50));
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.gridwidth = 5;
		gbc_panelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_panelTitle.gridx = 7;
		gbc_panelTitle.gridy = 2;
		add(panelTitle, gbc_panelTitle);
		
		//logo image
		try {
			loginImage = this.main.getController().getImage("images/loginIcon.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BackgroundPanel imagePanel = new BackgroundPanel(loginImage);
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.gridwidth = 6;
		gbc_imagePanel.gridheight = 11;
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.insets = new Insets(0, 0, 0, 5);
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 1;
		add(imagePanel, gbc_imagePanel);
		ButtonGroup btnRoleGroup = new ButtonGroup();
		

		lblPosition = new JLabel("Login as:");
		lblPosition.setForeground(Color.BLACK);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.anchor = GridBagConstraints.WEST;
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 7;
		gbc_lblPosition.gridy = 4;
		add(lblPosition, gbc_lblPosition);
		rdbtnManager = new JRadioButton("Manager");
		
		rdbtnManager.setForeground(Color.BLACK);
		rdbtnManager.setBackground(new Color(135, 206, 235));
		rdbtnManager.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GridBagConstraints gbc_rdbtnManager = new GridBagConstraints();
		gbc_rdbtnManager.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnManager.gridwidth = 2;
		gbc_rdbtnManager.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnManager.gridx = 8;
		gbc_rdbtnManager.gridy = 4;
		add(rdbtnManager, gbc_rdbtnManager);
		btnRoleGroup.add(rdbtnManager);
		this.rdbtnManager.addActionListener(new RadioButtonListener());
		
		
		rdbtnStaff = new JRadioButton("HR Staff");
		rdbtnStaff.setForeground(Color.BLACK);
		rdbtnStaff.setBackground(new Color(135, 206, 235));
		rdbtnStaff.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GridBagConstraints gbc_rdbtnStaff = new GridBagConstraints();
		gbc_rdbtnStaff.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnStaff.gridwidth = 2;
		gbc_rdbtnStaff.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStaff.gridx = 10;
		gbc_rdbtnStaff.gridy = 4;
		add(rdbtnStaff, gbc_rdbtnStaff);
		btnRoleGroup.add(rdbtnStaff);
		this.rdbtnStaff.addActionListener(new RadioButtonListener());
		
		this.usernameField = new JTextField();
		usernameField.setForeground(Color.LIGHT_GRAY);
		usernameField.setText("Username:");
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.gridwidth = 5;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.fill = GridBagConstraints.BOTH;
		gbc_usernameField.gridx = 7;
		gbc_usernameField.gridy = 6;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		usernameField.addFocusListener( new FocusListener(){
			/*
			 * Change color when focused and out of focus for better design
			 * Contains placeholder text
			 */
            @Override
            public void focusGained(FocusEvent e){
            	if (usernameField.getText().equals("Username:")){
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
            	}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()){
                	usernameField.setText("Username:");
            		usernameField.setForeground(Color.LIGHT_GRAY);
                }

            }
        });
		
		
		this.passwordField = new JPasswordField("Password:");
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 5;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 7;
		gbc_passwordField.gridy = 8;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		passwordField.setEchoChar((char)0);
		passwordField.addFocusListener( new FocusListener(){
			/*
			 * Change color when focused and out of focus for better design
			 * Contains place holder text
			 */
            @Override
            public void focusGained(FocusEvent e){
            	if (passwordField.getText().equals("Password:")){
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar('*');
            	}
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()){
                	passwordField.setText("Password:");
                	passwordField.setForeground(Color.LIGHT_GRAY);
                	passwordField.setEchoChar((char)0);
                }

            }
        });
		this.loginButton = new JButton("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(0, 250, 154));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Check if a role is seleceted. If not, display error message.
				 * If yes, check if username and password are correct. If yes, login into corresponding panels.
				 * If no, display error message dialog.
				 */
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
		
		
		btnShow = new JButton("Show");
		btnShow.setBackground(Color.LIGHT_GRAY);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Togglable button to show or hide password.
				 */
				if (!passwordField.getText().equals("Password:")){
					if (passFlag == 0){
						passwordField.setEchoChar((char)0);
						passFlag = 1;
						btnShow.setText("Hide");
					}
					else if (passFlag == 1){
						passwordField.setEchoChar('*');
						passFlag = 0;
						btnShow.setText("Show");
					}
				}

				
		}});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow.gridx = 11;
		gbc_btnShow.gridy = 9;
		add(btnShow, gbc_btnShow);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 0, 5);
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.gridwidth = 5;
		gbc_loginButton.gridx = 7;
		gbc_loginButton.gridy = 11;
		add(loginButton, gbc_loginButton);
		

	}
			
	private String RoleButton = "";	
	private JButton btnShow;
	private JButton btnHide;
	private JLabel lblItEmployment;

	
	private class RadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent f)
		{
			/*
			 * Radio button listener to select role.
			 * If manager is selected, set the role button to manager.
			 * If staff is selected, set the role button to staff.
			 * Color of selected role is changed to improve user experience
			 */
			if(f.getSource() ==  rdbtnManager)
			{
				RoleButton = "Manager";
				rdbtnManager.setBackground(new Color(0, 191, 255));
				rdbtnStaff.setBackground(new Color(135, 206, 235));
				
			}
			else if (f.getSource() ==  rdbtnStaff)
			{
				RoleButton = "Staff";
				rdbtnManager.setBackground(new Color(135, 206, 235));
				rdbtnStaff.setBackground(new Color(0, 191, 255));
			}
		}			
	}
	
}
