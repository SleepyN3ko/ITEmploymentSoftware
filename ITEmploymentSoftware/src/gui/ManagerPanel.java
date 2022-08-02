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
import javax.swing.border.LineBorder;
import java.awt.Color;
/*
 * This class is used to display the information of applicant from a manager's perspective.
 */
public class ManagerPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	private JLabel lblCount;

	public ManagerPanel(MainFrame main){
		setBackground(new Color(135, 206, 250));
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 20, 20, 20, 20, 20,20, 20,20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0,1.0,1, 1.0, 1.0,1,1};
		gridBagLayout.rowWeights = new double[]{1, 0, 0,1.0, 1.0,1.0,1.0, 1.0,1.0, 1.0,1};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Manager Main Panel");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.gridwidth = 10;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		

		JButton btnBack = new JButton("Logout");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridheight = 2;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 12;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
		
		JButton btnViewStaffInfo = new JButton("View Staffs / Add Employee");
		btnViewStaffInfo.setBackground(Color.ORANGE);
		btnViewStaffInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnViewStaffInfo = new GridBagConstraints();
		gbc_btnViewStaffInfo.gridheight = 2;
		gbc_btnViewStaffInfo.fill = GridBagConstraints.BOTH;
		gbc_btnViewStaffInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewStaffInfo.gridx = 4;
		gbc_btnViewStaffInfo.gridy = 1;
		add(btnViewStaffInfo, gbc_btnViewStaffInfo);
		btnViewStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showInfoStaffPanel();
			}
		});
		
		JButton btnShowShortlisted = new JButton("Show Shortlisted");
		btnShowShortlisted.setBackground(new Color(72, 209, 204));
		btnShowShortlisted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets shortlisted applicants to display in table
				Object[][] rows = main.getController().getShortlistApplicants();
				lblCount.setText("Number of Applicants: "+rows.length);
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
						/*
						 * This method is used to view the applicant's profile.
						 */
				        int modelRow = Integer.valueOf(e.getActionCommand());
				        String selectedApplicantID = rows[modelRow][0].toString();
				        main.showViewApplicantPanel(selectedApplicantID,"manager");
				    }
				};
				ButtonColumn viewColumn = new ButtonColumn(table,view,4, Color.YELLOW,"background");
				TableColumn shortListColumn = table.getColumnModel().getColumn(2);
				TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
			}
		});
		
		
		btnShowShortlisted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnShowShortlisted = new GridBagConstraints();
		gbc_btnShowShortlisted.fill = GridBagConstraints.BOTH;
		gbc_btnShowShortlisted.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowShortlisted.gridx = 5;
		gbc_btnShowShortlisted.gridy = 1;
		add(btnShowShortlisted, gbc_btnShowShortlisted);
		
		
		JButton btnShowBoth = new JButton("Show Shortlisted & Job Offered");
		btnShowBoth.setBackground(Color.CYAN);
		btnShowBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * gets shortlisted applicants to display in table
				 */
				Object[][] rows = main.getController().getBothApplicants();
				lblCount.setText("Number of Applicants: "+rows.length);
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
						/*
						 * This method is used to view the applicant's profile.
						*/
				        int modelRow = Integer.valueOf(e.getActionCommand());
				        String selectedApplicantID = rows[modelRow][0].toString();
				        main.showViewApplicantPanel(selectedApplicantID,"manager");
				    }
				};
				ButtonColumn viewColumn = new ButtonColumn(table,view,4, Color.YELLOW,"background");
				TableColumn shortListColumn = table.getColumnModel().getColumn(2);
				TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
			}
		});
		
		JButton btnShowJobOffered = new JButton("Show Job Offered");
		btnShowJobOffered.setBackground(new Color(127, 255, 212));
		btnShowJobOffered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] rows = main.getController().getJobOfferedApplicants();
				lblCount.setText("Number of Applicants: "+rows.length);
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
				ButtonColumn viewColumn = new ButtonColumn(table,view,4, Color.YELLOW,"background");
				TableColumn shortListColumn = table.getColumnModel().getColumn(2);
				TableColumn jobOfferedColumn = table.getColumnModel().getColumn(3);
			}
		});
		btnShowJobOffered.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnShowJobOffered = new GridBagConstraints();
		gbc_btnShowJobOffered.fill = GridBagConstraints.BOTH;
		gbc_btnShowJobOffered.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowJobOffered.gridx = 6;
		gbc_btnShowJobOffered.gridy = 1;
		add(btnShowJobOffered, gbc_btnShowJobOffered);
		btnShowBoth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnShowBoth = new GridBagConstraints();
		gbc_btnShowBoth.fill = GridBagConstraints.BOTH;
		gbc_btnShowBoth.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowBoth.gridx = 5;
		gbc_btnShowBoth.gridy = 2;
		add(btnShowBoth, gbc_btnShowBoth);
		
		JButton btnRefresh = new JButton("Show All Applicants");
		btnRefresh.setBackground(Color.GREEN);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showManagerPanel();
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.fill = GridBagConstraints.BOTH;
		gbc_btnRefresh.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefresh.gridx = 6;
		gbc_btnRefresh.gridy = 2;
		add(btnRefresh, gbc_btnRefresh);
		
		this.lblCount = new JLabel("Number of Applicants");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCount = new GridBagConstraints();
		gbc_lblCount.gridwidth = 6;
		gbc_lblCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblCount.gridx = 7;
		gbc_lblCount.gridy = 2;
		add(lblCount, gbc_lblCount);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		this.table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(table.getRowHeight()+30);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		
		Object[][] rows = this.main.getController().getApplicantsManager();
		lblCount.setText("Number of Applicants: "+rows.length);
		String[] columns = {
				"ApplicantID", "Name","Short-listed","Job Offer","View Applicant"
		};
		
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){
				//makes sure certain columns can be clicked/edited
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
		ButtonColumn viewColumn = new ButtonColumn(this.table,view,4,Color.YELLOW,"background");
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
					//updates the short-listed column in the database
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
					//updates the job offer column in the database
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
	}
}
