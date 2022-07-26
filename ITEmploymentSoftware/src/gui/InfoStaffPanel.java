package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;

import javax.swing.JLabel;
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

public class InfoStaffPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	
	public InfoStaffPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20, 0,20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1.0,1.0,1, 0.0,1, 0.0,1};
		gridBagLayout.rowWeights = new double[]{1, 1.0, 0.0,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		JLabel lblStaffInfoLabel = new JLabel("Showing Staffs Info");
		lblStaffInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStaffInfoLabel = new GridBagConstraints();
		gbc_lblStaffInfoLabel.gridwidth = 5;
		gbc_lblStaffInfoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffInfoLabel.gridx = 1;
		gbc_lblStaffInfoLabel.gridy = 0;
		add(lblStaffInfoLabel, gbc_lblStaffInfoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		this.table = new JTable();
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
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        String selectedUsername = rows[modelRow][0].toString();
		        main.getController().deleteStaff(selectedUsername);
		        main.showInfoStaffPanel();
		    }
		};
		ButtonColumn deleteColumn = new ButtonColumn(this.table,delete,2);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JButton btnRegisterStaffmanager = new JButton("Register Staff/Manager");
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 2;
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
