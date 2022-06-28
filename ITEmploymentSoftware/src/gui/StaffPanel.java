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

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
	private JLabel lblGender;
	private JComboBox genderFilter;
	private JLabel lblTechnicalSkills;
	private JComboBox techSkillFilter;
	
	public StaffPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20,20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20,20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0};
		setLayout(gridBagLayout);
		
		this.welcomeLabel = new JLabel("Welcome HR Staff :)");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 10;
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 0;
		add(welcomeLabel, gbc_welcomeLabel);
		
		lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 1;
		add(lblGender, gbc_lblGender);
		
		String[] genderfilters = {"All","Male","Female"};
		genderFilter = new JComboBox(genderfilters);
		genderFilter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		genderFilter.addActionListener(new filterSelection());
		GridBagConstraints gbc_genderFilter = new GridBagConstraints();
		gbc_genderFilter.insets = new Insets(0, 0, 5, 5);
		gbc_genderFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderFilter.gridx = 2;
		gbc_genderFilter.gridy = 1;
		add(genderFilter, gbc_genderFilter);
		
		lblTechnicalSkills = new JLabel("Technical Skills:");
		lblTechnicalSkills.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTechnicalSkills = new GridBagConstraints();
		gbc_lblTechnicalSkills.anchor = GridBagConstraints.EAST;
		gbc_lblTechnicalSkills.insets = new Insets(0, 0, 5, 5);
		gbc_lblTechnicalSkills.gridx = 1;
		gbc_lblTechnicalSkills.gridy = 2;
		add(lblTechnicalSkills, gbc_lblTechnicalSkills);
		

		String[] technicalSkills = {"All","Python","C++","Java","Project Management","People Management"};
		techSkillFilter = new JComboBox(technicalSkills);
		techSkillFilter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		techSkillFilter.addActionListener(new filterSelection());
		GridBagConstraints gbc_techSkillFilter = new GridBagConstraints();
		gbc_techSkillFilter.insets = new Insets(0, 0, 5, 5);
		gbc_techSkillFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_techSkillFilter.gridx = 2;
		gbc_techSkillFilter.gridy = 2;
		add(techSkillFilter, gbc_techSkillFilter);
		
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 10;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		
		this.table = new JTable();
		table.setRowHeight(table.getRowHeight()+30);
		
		Object[][] rows = this.main.getController().getApplicants();
		String[] columns = {
				"ApplicantID", "Name","View Applicant","Update Applicant","Delete Applicant"
		};
		
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){
				if (column==2 || column==3 || column==4){
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
		        main.showViewApplicantPanel(selectedApplicantID,"staff");
		    }
		};
		Action update = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        String selectedApplicantID = rows[modelRow][0].toString();
		        main.showAddUpdateApplicantPanel(selectedApplicantID);
		    }
		};
		Action delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        String selectedApplicantID = rows[modelRow][0].toString();
		        main.getController().deleteApplicant(selectedApplicantID);
		        main.showStaffPanel();
		    }
		};
		ButtonColumn viewColumn = new ButtonColumn(this.table,view,2);
		ButtonColumn updateColumn = new ButtonColumn(this.table,update,3);
		ButtonColumn deleteColumn = new ButtonColumn(this.table,delete,4);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
				gbc_addApplicantButton.gridwidth = 4;
				gbc_addApplicantButton.insets = new Insets(0, 0, 5, 5);
				gbc_addApplicantButton.gridx = 1;
				gbc_addApplicantButton.gridy = 8;
				add(addApplicantButton, gbc_addApplicantButton);
				btnBack = new JButton("Back");
				btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.gridwidth = 5;
				gbc_btnBack.insets = new Insets(0, 0, 5, 5);
				gbc_btnBack.gridx = 6;
				gbc_btnBack.gridy = 8;
				add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
		
	}
	private class filterSelection implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> filters = new ArrayList<String>();
			filters.add("gender,"+genderFilter.getSelectedItem());//add selected gender filter to filters
			filters.add("tskill,"+techSkillFilter.getSelectedItem()); //add selected technical skill filter to filters
			Object[][] rows = main.getController().getApplicants(filters);
			String[] columns = {
					"ApplicantID", "Name","View Applicant","Update Applicant"
			};
			table.setModel(new DefaultTableModel(rows,columns) {
				@Override
				public boolean isCellEditable(int row,int column){
					if (column==2 || column==3 || column==4){
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
			        main.showViewApplicantPanel(selectedApplicantID,"staff");
			    }
			};
			Action update = new AbstractAction()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			        int modelRow = Integer.valueOf(e.getActionCommand());
			        String selectedApplicantID = rows[modelRow][0].toString();
			        main.showAddUpdateApplicantPanel(selectedApplicantID);
			    }
			};
			Action delete = new AbstractAction()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			        System.out.println("Delete is clicked");
			        int modelRow = Integer.valueOf(e.getActionCommand());
			        String selectedApplicantID = rows[modelRow][0].toString();
			        main.getController().deleteApplicant(selectedApplicantID);
			        main.showStaffPanel();
			    }
			};
			ButtonColumn viewColumn = new ButtonColumn(table,view,2);
			ButtonColumn updateColumn = new ButtonColumn(table,update,3);
			ButtonColumn deleteColumn = new ButtonColumn(table,delete,4);
		}
	}
	
}
