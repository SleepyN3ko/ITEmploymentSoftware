package gui;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;




public class StaffPanel extends JPanel{
	private MainFrame main;
	private JLabel welcomeLabel;
	private JButton addApplicantButton;
	private JButton updateApplicantButton;
	private JButton selectApplicantButton;
	private JScrollPane scrollPane;
	private JTable table;
	JButton updateButton = new JButton();
	private JButton btnBack;
	
	public StaffPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1,1.0,1,1,1};
		gridBagLayout.rowWeights = new double[]{1,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		
		this.welcomeLabel = new JLabel("Welcome HR Staff :)");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 4;
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 0;
		add(welcomeLabel, gbc_welcomeLabel);
		
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		
		this.table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(table.getRowHeight()+30);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		
		Object[][] rows = this.main.getController().getApplicants();
		String[] columns = {
				"ApplicantID", "Name","Short Listed","Job Offer"
		};
		
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){
				return false;
			}
		});
		this.table.setFillsViewportHeight(true);
		scrollPane.setViewportView(this.table);


		
		
		this.addApplicantButton = new JButton("Add New Applicant");
		addApplicantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showAddUpdateApplicantPanel("new");
			}
		});
		addApplicantButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_addApplicantButton = new GridBagConstraints();
		gbc_addApplicantButton.insets = new Insets(0, 0, 0, 5);
		gbc_addApplicantButton.gridx = 1;
		gbc_addApplicantButton.gridy = 5;
		add(addApplicantButton, gbc_addApplicantButton);
		
		this.updateApplicantButton = new JButton("Update Existing Applicant");
		updateApplicantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					main.showAddUpdateApplicantPanel(selectedApplicantID);
				}
			}
		});
		updateApplicantButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_updateApplicantButton = new GridBagConstraints();
		gbc_updateApplicantButton.insets = new Insets(0, 0, 0, 5);
		gbc_updateApplicantButton.gridx = 2;
		gbc_updateApplicantButton.gridy = 5;
		add(updateApplicantButton, gbc_updateApplicantButton);
		
		this.selectApplicantButton = new JButton("Select Applicant For Interview");
		selectApplicantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
					selectedApplicant.setShortlistStatus(!selectedApplicant.getShortlistStatus());
					main.getController().updateApplicant(selectedApplicant);
					main.showStaffPanel();
				}
			}
		});
		selectApplicantButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_selectApplicantButton = new GridBagConstraints();
		gbc_selectApplicantButton.insets = new Insets(0, 0, 0, 5);
		gbc_selectApplicantButton.gridx = 3;
		gbc_selectApplicantButton.gridy = 5;
		add(selectApplicantButton, gbc_selectApplicantButton);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 5;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
	}
	
	
}
