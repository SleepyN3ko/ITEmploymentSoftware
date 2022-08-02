package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
/*
 * This class is used to display the information of the staff.
 * It is a JPanel which is used to display the information of the staff.
 */
public class InfoStaffPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	
	public InfoStaffPanel(MainFrame main){
		setBackground(new Color(135, 206, 250));
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20, 0, 0,20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1.0,1.0,1, 0.0,1, 0.0, 0.0,1};
		gridBagLayout.rowWeights = new double[]{1, 1.0, 0.0,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		JLabel lblStaffInfoLabel = new JLabel("Manager Employee Control Panel");
		lblStaffInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		GridBagConstraints gbc_lblStaffInfoLabel = new GridBagConstraints();
		gbc_lblStaffInfoLabel.gridwidth = 5;
		gbc_lblStaffInfoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffInfoLabel.gridx = 1;
		gbc_lblStaffInfoLabel.gridy = 0;
		add(lblStaffInfoLabel, gbc_lblStaffInfoLabel);
		
		JButton button = new JButton("Logout");
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setBackground(Color.RED);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 0;
		add(button, gbc_button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		this.table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setRowHeight(table.getRowHeight()+30);
		Object[][] rows = this.main.getController().getStaffs();
		String[] columns = {
				"Username", "Password","Delete Staff"
		};
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){

				return true;
			}
		});
		scrollPane.setViewportView(table);
		Action delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
				/*
				 * This method is used to delete the staff.
				 * It asks for confirmation before deleting the staff
				 */
		    	int result = JOptionPane.showConfirmDialog(null, "Confirm to delete Staff?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		        if (result==0){
			    	int modelRow = Integer.valueOf(e.getActionCommand());
			        String selectedUsername = rows[modelRow][0].toString();
			        main.getController().deleteStaff(selectedUsername);
			        main.showInfoStaffPanel();
		        }
		    }
		};
		// sets up the deleteColumn
		ButtonColumn deleteColumn = new ButtonColumn(this.table,delete,2, Color.RED,"background"); 
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JButton btnRegisterStaffmanager = new JButton("Add Staff/Manager");
		btnRegisterStaffmanager.setBackground(Color.GREEN);
		btnRegisterStaffmanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showRegisterPanel();
			}
		});
		btnRegisterStaffmanager.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnRegisterStaffmanager = new GridBagConstraints();
		gbc_btnRegisterStaffmanager.gridwidth = 3;
		gbc_btnRegisterStaffmanager.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegisterStaffmanager.gridx = 1;
		gbc_btnRegisterStaffmanager.gridy = 7;
		add(btnRegisterStaffmanager, gbc_btnRegisterStaffmanager);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255,204,203));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 4;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 7;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showManagerPanel();
			}
		});
	}
}
