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
import java.awt.Color;
import javax.swing.border.LineBorder;

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
	private filterSelection filterListener = new filterSelection();
	private JLabel lblQualifications;
	private JComboBox qualificationFilter;
	private JLabel lblShortlisted;
	private JComboBox shortlistFilter;
	
	public StaffPanel(MainFrame main){
		setBackground(Color.WHITE);
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20, 0,20, 0,20, 0, 20, 20, 20, 0,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20,20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0, 1.0,1.0, 1.0,1.0, 0.0, 1.0, 0.0,1.0,1.0, 1.0, 0.0,1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0, 1.0,1.0,1.0};
		setLayout(gridBagLayout);
		
		this.welcomeLabel = new JLabel("Staff's Applicant Control Panel");
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 9;
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 0;
		add(welcomeLabel, gbc_welcomeLabel);
		btnBack = new JButton("Logout");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 13;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
		
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
		genderFilter.addActionListener(filterListener);
		GridBagConstraints gbc_genderFilter = new GridBagConstraints();
		gbc_genderFilter.insets = new Insets(0, 0, 5, 5);
		gbc_genderFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderFilter.gridx = 2;
		gbc_genderFilter.gridy = 1;
		add(genderFilter, gbc_genderFilter);
		
		lblQualifications = new JLabel("Qualifications");
		lblQualifications.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQualifications = new GridBagConstraints();
		gbc_lblQualifications.anchor = GridBagConstraints.EAST;
		gbc_lblQualifications.insets = new Insets(0, 0, 5, 5);
		gbc_lblQualifications.gridx = 4;
		gbc_lblQualifications.gridy = 1;
		add(lblQualifications, gbc_lblQualifications);
		
		String[] qualifications = {"All","ENG Diploma","IT Diploma","Business Diploma","Science Diploma","CS Degree","EEE Degree"};
		qualificationFilter = new JComboBox(qualifications);
		qualificationFilter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		qualificationFilter.addActionListener(filterListener);
		GridBagConstraints gbc_qualificationFilter = new GridBagConstraints();
		gbc_qualificationFilter.insets = new Insets(0, 0, 5, 5);
		gbc_qualificationFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_qualificationFilter.gridx = 5;
		gbc_qualificationFilter.gridy = 1;
		add(qualificationFilter, gbc_qualificationFilter);
		
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
		techSkillFilter.addActionListener(filterListener);
		GridBagConstraints gbc_techSkillFilter = new GridBagConstraints();
		gbc_techSkillFilter.insets = new Insets(0, 0, 5, 5);
		gbc_techSkillFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_techSkillFilter.gridx = 2;
		gbc_techSkillFilter.gridy = 2;
		add(techSkillFilter, gbc_techSkillFilter);
		
		lblShortlisted = new JLabel("Shortlisted:");
		lblShortlisted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblShortlisted = new GridBagConstraints();
		gbc_lblShortlisted.anchor = GridBagConstraints.EAST;
		gbc_lblShortlisted.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortlisted.gridx = 4;
		gbc_lblShortlisted.gridy = 2;
		add(lblShortlisted, gbc_lblShortlisted);
		
		String[] shortlist = {"All","Shortlisted","Not Shortlisted"};
		shortlistFilter = new JComboBox(shortlist);
		shortlistFilter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_shortlistFilter = new GridBagConstraints();
		shortlistFilter.addActionListener(filterListener);
		gbc_shortlistFilter.insets = new Insets(0, 0, 5, 5);
		gbc_shortlistFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortlistFilter.gridx = 5;
		gbc_shortlistFilter.gridy = 2;
		add(shortlistFilter, gbc_shortlistFilter);
		this.addApplicantButton = new JButton("Add New Applicant");
		addApplicantButton.setBackground(Color.GREEN);
		addApplicantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showAddUpdateApplicantPanel("new");
			}
		});
		addApplicantButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_addApplicantButton = new GridBagConstraints();
		gbc_addApplicantButton.anchor = GridBagConstraints.EAST;
		gbc_addApplicantButton.insets = new Insets(0, 0, 5, 0);
		gbc_addApplicantButton.gridx = 13;
		gbc_addApplicantButton.gridy = 2;
		add(addApplicantButton, gbc_addApplicantButton);
		
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		
		this.table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		    	int result = JOptionPane.showConfirmDialog(null, "Confirm to delete applicant?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		    	if (result==0){
			    	int modelRow = Integer.valueOf(e.getActionCommand());
			        String selectedApplicantID = rows[modelRow][0].toString();
			        main.getController().deleteApplicant(selectedApplicantID);
			        main.showStaffPanel();
		    	}
		    }
		};
		ButtonColumn viewColumn = new ButtonColumn(this.table,view,2,Color.YELLOW,"background");
		ButtonColumn updateColumn = new ButtonColumn(this.table,update,3,Color.GREEN,"background");
		ButtonColumn deleteColumn = new ButtonColumn(this.table,delete,4,Color.RED,"background");
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.table.setFillsViewportHeight(true);
		scrollPane.setViewportView(this.table);
		
	}
	private class filterSelection implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> filters = new ArrayList<String>();
			filters.add("gender,"+genderFilter.getSelectedItem());//add selected gender filter to filters
			filters.add("tskill,"+techSkillFilter.getSelectedItem()); //add selected technical skill filter to filters
			filters.add("qualification,"+qualificationFilter.getSelectedItem());
			if (shortlistFilter.getSelectedItem().equals("Shortlisted")){
				filters.add("shortlist,"+"true");
			}
			else if (shortlistFilter.getSelectedItem().equals("Not Shortlisted")){
				filters.add("shortlist,"+"false");
			}
			else {
				filters.add("shortlist,"+"All");
			}
			Object[][] rows = main.getController().getApplicants(filters); //use overloaded method to filter applicant on controller side
			String[] columns = {
					"ApplicantID", "Name","View Applicant","Update Applicant","Delete Applicants"
			};
			//remaking the table model
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
			    	int result = JOptionPane.showConfirmDialog(null, "Confirm to delete applicant?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			    	if (result==0){
				    	int modelRow = Integer.valueOf(e.getActionCommand());
				        String selectedApplicantID = rows[modelRow][0].toString();
				        main.getController().deleteApplicant(selectedApplicantID);
				        main.showStaffPanel();
			    	}
			    }
			};
			ButtonColumn viewColumn = new ButtonColumn(table,view,2,Color.YELLOW,"background");
			ButtonColumn updateColumn = new ButtonColumn(table,update,3,Color.GREEN,"background");
			ButtonColumn deleteColumn = new ButtonColumn(table,delete,4,Color.RED,"background");
		}
	}
	
}
