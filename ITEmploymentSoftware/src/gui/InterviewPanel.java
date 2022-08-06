package gui;

import java.awt.GridBagLayout;


import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;
import data.Interview;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

/*
 * This class is used to display the information of the staff.
 * It is a JPanel which is used to display the information of the staff.
 */
public class InterviewPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	private JDatePanelImpl datePickerPanel;
	private UtilDateModel datemodel;
	private String selectedDate; 
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	private LocalDate  todayDate;
	private LocalDate  SelectedDate;
	private JComboBox comboTime;
	private JComboBox comboStaff;
	private Interview currentInterview;
	private JButton btnBack;
	private JTextField textFieldDate;
	private JComboBox comboPosition;
	
	public InterviewPanel(MainFrame main,String interviewee, String parentPanelName){
		setBackground(new Color(135, 206, 250));
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 20,20, 20, 20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20, 20,20, 20, 20,20, 20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1.0, 1.0,1.0, 1.0, 1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0,1.0,1.0, 1.0,1.0, 1.0, 1.0,1.0, 1.0,1.0};
		setLayout(gridBagLayout);
		
		JLabel lblInterviewer = new JLabel("Interviewer:");
		lblInterviewer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblInterviewer = new GridBagConstraints();
		gbc_lblInterviewer.anchor = GridBagConstraints.EAST;
		gbc_lblInterviewer.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterviewer.gridx = 1;
		gbc_lblInterviewer.gridy = 1;
		add(lblInterviewer, gbc_lblInterviewer);
		
		this.comboStaff = new JComboBox(this.main.getController().getStaffForInterview());
		comboStaff.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_comboStaff = new GridBagConstraints();
		gbc_comboStaff.gridwidth = 4;
		gbc_comboStaff.insets = new Insets(0, 0, 5, 5);
		gbc_comboStaff.fill = GridBagConstraints.BOTH;
		gbc_comboStaff.gridx = 2;
		gbc_comboStaff.gridy = 1;
		add(comboStaff, gbc_comboStaff);
		
		JLabel lblDateForInterview = new JLabel("Date for Interview:");
		lblDateForInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDateForInterview = new GridBagConstraints();
		gbc_lblDateForInterview.anchor = GridBagConstraints.EAST;
		gbc_lblDateForInterview.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateForInterview.gridx = 1;
		gbc_lblDateForInterview.gridy = 3;
		add(lblDateForInterview, gbc_lblDateForInterview);
		this.datemodel = new UtilDateModel();
		Properties datemodelProperties = new Properties();
		datemodelProperties.put("text.today","Today");
		datemodelProperties.put("text.month","Month");
		datemodelProperties.put("text.year","Year");
		todayDate = LocalDate.now().plusDays(1);
		
		String[] timeSlots = {"","13:00","14:00","15:00","16:00"};
		
		JButton btnSetInterview = new JButton("Set Interview");
		btnSetInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if (main.getController().interviewExists(interviewee)){
					String errorMsg = main.getController().updateInterview(main.getController().getInterview(interviewee).getInterviewID(),interviewee,comboStaff.getSelectedItem().toString(),comboPosition.getSelectedItem().toString(),SelectedDate,comboTime.getSelectedItem().toString());
					if (!errorMsg.equals("")){
						JOptionPane.showMessageDialog(null,errorMsg,"Error Occured",JOptionPane.ERROR_MESSAGE);
					}
					else {
						if (parentPanelName=="manager"){
							main.showManagerPanel();
						}
						else if (parentPanelName=="staff"){
							main.showStaffPanel();
						}
					}
				}
				else {
					String errorMsg = main.getController().addInterview(interviewee,comboStaff.getSelectedItem().toString(),comboPosition.getSelectedItem().toString(),SelectedDate,comboTime.getSelectedItem().toString());
					if (!errorMsg.equals("")){
						JOptionPane.showMessageDialog(null,errorMsg,"Error Occured",JOptionPane.ERROR_MESSAGE);
					}
					else {
						if (parentPanelName=="manager"){
							main.showManagerPanel();
						}
						else if (parentPanelName=="staff"){
							main.showStaffPanel();
						}
					}
				}
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		this.datePickerPanel = new JDatePanelImpl(this.datemodel, datemodelProperties);
		datePickerPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SelectedDate =  LocalDate.parse((String.format("%02d-%02d-%04d",datemodel.getDay(),datemodel.getMonth()+1,datemodel.getYear())),dtf);
					textFieldDate.setText(SelectedDate.format(dtf));
					if (SelectedDate.isBefore(todayDate)){
						JOptionPane.showMessageDialog(null, "Date must be chosen atleast 1 day in advance","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		textFieldDate = new JTextField();
		textFieldDate.setEditable(false);
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_textFieldDate = new GridBagConstraints();
		gbc_textFieldDate.gridwidth = 4;
		gbc_textFieldDate.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDate.gridx = 2;
		gbc_textFieldDate.gridy = 3;
		add(textFieldDate, gbc_textFieldDate);
		textFieldDate.setColumns(10);
		GridBagConstraints gbc_datePickerPanel = new GridBagConstraints();
		gbc_datePickerPanel.gridwidth = 4;
		gbc_datePickerPanel.insets = new Insets(0, 0, 5, 5);
		gbc_datePickerPanel.fill = GridBagConstraints.BOTH;
		gbc_datePickerPanel.gridx = 2;
		gbc_datePickerPanel.gridy = 4;
		add(datePickerPanel, gbc_datePickerPanel);
		
		JLabel lblTimeForInterview = new JLabel("Time for Interview:");
		lblTimeForInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTimeForInterview = new GridBagConstraints();
		gbc_lblTimeForInterview.anchor = GridBagConstraints.EAST;
		gbc_lblTimeForInterview.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeForInterview.gridx = 1;
		gbc_lblTimeForInterview.gridy = 6;
		add(lblTimeForInterview, gbc_lblTimeForInterview);
		this.comboTime = new JComboBox(timeSlots);
		comboTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_comboTime = new GridBagConstraints();
		gbc_comboTime.gridwidth = 4;
		gbc_comboTime.insets = new Insets(0, 0, 5, 5);
		gbc_comboTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTime.gridx = 2;
		gbc_comboTime.gridy = 6;
		add(comboTime, gbc_comboTime);
		
		JLabel lblPosition = new JLabel("Position: ");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.anchor = GridBagConstraints.EAST;
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 1;
		gbc_lblPosition.gridy = 8;
		add(lblPosition, gbc_lblPosition);
		
		this.comboPosition = new JComboBox();
		comboPosition.setModel(new DefaultComboBoxModel(new String[] {"","Software Engineer", "IT Security", "Project Manager"}));
		comboPosition.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_comboPosition = new GridBagConstraints();
		gbc_comboPosition.gridwidth = 4;
		gbc_comboPosition.insets = new Insets(0, 0, 5, 5);
		gbc_comboPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPosition.gridx = 2;
		gbc_comboPosition.gridy = 8;
		add(comboPosition, gbc_comboPosition);
		btnSetInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnSetInterview = new GridBagConstraints();
		gbc_btnSetInterview.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSetInterview.gridheight = 2;
		gbc_btnSetInterview.gridwidth = 4;
		gbc_btnSetInterview.insets = new Insets(0, 0, 0, 5);
		gbc_btnSetInterview.gridx = 2;
		gbc_btnSetInterview.gridy = 9;
		add(btnSetInterview, gbc_btnSetInterview);
		try {
			if (main.getController().interviewExists(interviewee)){
				currentInterview = main.getController().getInterview(interviewee);
				comboStaff.setSelectedItem(currentInterview.getStaffName());
				comboPosition.setSelectedItem(currentInterview.getPosition());
				comboTime.setSelectedItem(currentInterview.getTime());
				LocalDate interviewDate = currentInterview.getInterviewDate();
				textFieldDate.setText(interviewDate.format(dtf));
				datemodel.setDate(interviewDate.getYear(), interviewDate.getMonthValue()-1, interviewDate.getDayOfMonth());
				SelectedDate =  LocalDate.parse(textFieldDate.getText(),dtf);
			}
			else {
				if (parentPanelName.equals("manager")){
					LocalDate interviewDate = LocalDate.now();
					textFieldDate.setText(interviewDate.format(dtf));
					datemodel.setDate(interviewDate.getYear(), interviewDate.getMonthValue()-1, interviewDate.getDayOfMonth());
					SelectedDate =  LocalDate.parse(textFieldDate.getText(),dtf);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridheight = 2;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 7;
		gbc_btnBack.gridy = 9;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//returns user back to the correct panel
				if (parentPanelName=="manager"){
					main.showManagerPanel();
				}
				else if (parentPanelName=="staff"){
					main.showStaffPanel();
				}
			}
		});
		if (parentPanelName.equals("staff")){
			btnSetInterview.setVisible(false);
			datePickerPanel.setVisible(false);
			comboPosition.setEnabled(false);
			comboTime.setEnabled(false);
			comboStaff.setEnabled(false);
			
		}
	}
}
