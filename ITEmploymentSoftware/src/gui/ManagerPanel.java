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

public class ManagerPanel extends JPanel{
	private MainFrame main;
	private JTable table;

	public ManagerPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20,20};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1.0,1.0,1, 0.0,1,1};
		gridBagLayout.rowWeights = new double[]{1, 0.0,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome Manager :D");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.gridwidth = 5;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		
		JButton btnShowShortlisted = new JButton("Show Shortlisted");
		btnShowShortlisted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] rows = main.getController().getShortlistApplicants();
				String[] columns = {
						"ApplicantID", "Name","Short-listed","Job Offer","View Applicant"
				};
				table.setModel(new DefaultTableModel(rows,columns) {
					@Override
					public boolean isCellEditable(int row,int column){
						if (column==4){
							return true;
						}
						return false;
					}
				});
				Action view = new AbstractAction()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				        int modelRow = Integer.valueOf(e.getActionCommand());
				        String selectedApplicantID = rows[modelRow][0].toString();
				        main.showViewApplicantPanel(selectedApplicantID,"manager");
				    }
				};
				ButtonColumn viewColumn = new ButtonColumn(table,view,4);
				TableColumn shortListColumn = table.getColumnModel().getColumn(2);
				TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
			}
		});
		btnShowShortlisted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnShowShortlisted = new GridBagConstraints();
		gbc_btnShowShortlisted.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowShortlisted.gridx = 1;
		gbc_btnShowShortlisted.gridy = 1;
		add(btnShowShortlisted, gbc_btnShowShortlisted);
		
		JButton btnShowJobOffered = new JButton("Show Job Offered");
		btnShowJobOffered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] rows = main.getController().getJobOfferedApplicants();
				String[] columns = {
						"ApplicantID", "Name","Short-listed","Job Offer","View Applicant"
				};
				table.setModel(new DefaultTableModel(rows,columns) {
					@Override
					public boolean isCellEditable(int row,int column){
						if (column==4){
							return true;
						}
						return false;
					}
				});
				Action view = new AbstractAction()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				        int modelRow = Integer.valueOf(e.getActionCommand());
				        String selectedApplicantID = rows[modelRow][0].toString();
				        main.showViewApplicantPanel(selectedApplicantID,"manager");
				    }
				};
				ButtonColumn viewColumn = new ButtonColumn(table,view,4);
				TableColumn shortListColumn = table.getColumnModel().getColumn(2);
				TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
			}
		});
		btnShowJobOffered.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnShowJobOffered = new GridBagConstraints();
		gbc_btnShowJobOffered.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowJobOffered.gridx = 2;
		gbc_btnShowJobOffered.gridy = 1;
		add(btnShowJobOffered, gbc_btnShowJobOffered);
		
		JButton btnViewStaffInfo = new JButton("View Staff Info");
		btnViewStaffInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnViewStaffInfo = new GridBagConstraints();
		gbc_btnViewStaffInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewStaffInfo.gridx = 5;
		gbc_btnViewStaffInfo.gridy = 1;
		add(btnViewStaffInfo, gbc_btnViewStaffInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		this.table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(table.getRowHeight()+30);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		
		Object[][] rows = this.main.getController().getApplicantsManager();
		String[] columns = {
				"ApplicantID", "Name","Short-listed","Job Offer","View Applicant"
		};
		
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){
				if (column==2||column==3||column==4){
					return true;
				}
				return false;
			}
		});
		Action view = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        String selectedApplicantID = rows[modelRow][0].toString();
		        main.showViewApplicantPanel(selectedApplicantID,"manager");
		    }
		};
		ButtonColumn viewColumn = new ButtonColumn(this.table,view,4);
		TableColumn shortListColumn = table.getColumnModel().getColumn(2);
		TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
		
		JComboBox comboBoxShort = new JComboBox();
		comboBoxShort.addItem("true");
		comboBoxShort.addItem("false");
		comboBoxShort.setFont(new Font("Tahoma", Font.PLAIN, 30));
		shortListColumn.setCellEditor(new DefaultCellEditor(comboBoxShort));
		comboBoxShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					if (comboBoxShort.getSelectedIndex()==0){
						String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
						Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
						selectedApplicant.setShortlistStatus(true);
						main.getController().updateApplicant(selectedApplicant);
						
					}
					else if (comboBoxShort.getSelectedIndex()==1){
						String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
						Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
						selectedApplicant.setShortlistStatus(false);
						main.getController().updateApplicant(selectedApplicant);
												
					}
				}
			}
		});
		
		JComboBox comboBoxJob = new JComboBox();
		comboBoxJob.addItem("true");
		comboBoxJob.addItem("false");
		comboBoxJob.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jobOfferedColumn.setCellEditor(new DefaultCellEditor(comboBoxJob));
		comboBoxJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					if (comboBoxJob.getSelectedIndex()==0){
						String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
						Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
						selectedApplicant.setReceivedJobOffer(true);
						main.getController().updateApplicant(selectedApplicant);
						
					}
					else if (comboBoxJob.getSelectedIndex()==1){
						String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
						Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
						selectedApplicant.setReceivedJobOffer(false);
						main.getController().updateApplicant(selectedApplicant);
												
					}
				}
			}
		});
		
		this.table.setFillsViewportHeight(true);
		scrollPane.setViewportView(this.table);
		
		JButton btnInterview = new JButton("Select Applicant For Interview");
		btnInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
					selectedApplicant.setShortlistStatus(!selectedApplicant.getShortlistStatus());
					main.getController().updateApplicant(selectedApplicant);
					main.showManagerPanel();
				}
			}
		});
		btnInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnInterview = new GridBagConstraints();
		gbc_btnInterview.insets = new Insets(0, 0, 0, 5);
		gbc_btnInterview.gridx = 1;
		gbc_btnInterview.gridy = 6;
		add(btnInterview, gbc_btnInterview);
		
		JButton btnJobOffer = new JButton("Give Job Offer");
		btnJobOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
					selectedApplicant.setReceivedJobOffer(!selectedApplicant.getReceivedJobOffer());
					main.getController().updateApplicant(selectedApplicant);
					main.showManagerPanel();
				}
			}
		});
		btnJobOffer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnJobOffer = new GridBagConstraints();
		gbc_btnJobOffer.insets = new Insets(0, 0, 0, 5);
		gbc_btnJobOffer.gridx = 2;
		gbc_btnJobOffer.gridy = 6;
		add(btnJobOffer, gbc_btnJobOffer);
		

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 6;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
	}
}
