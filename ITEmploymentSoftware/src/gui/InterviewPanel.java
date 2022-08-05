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
public class InterviewPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	
	public InterviewPanel(MainFrame main){
		setBackground(new Color(135, 206, 250));
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20, 0, 0,20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1.0,1.0,1, 0.0,1, 0.0, 0.0,1};
		gridBagLayout.rowWeights = new double[]{1, 0.0, 0.0,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		JLabel lblTimeForInterview = new JLabel("Time for Interview:");
		lblTimeForInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTimeForInterview = new GridBagConstraints();
		gbc_lblTimeForInterview.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeForInterview.gridx = 1;
		gbc_lblTimeForInterview.gridy = 3;
		add(lblTimeForInterview, gbc_lblTimeForInterview);
		
		JLabel lblDateForInterview = new JLabel("Date for Interview:");
		lblDateForInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDateForInterview = new GridBagConstraints();
		gbc_lblDateForInterview.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateForInterview.gridx = 1;
		gbc_lblDateForInterview.gridy = 5;
		add(lblDateForInterview, gbc_lblDateForInterview);
		
		
		
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		frame.add(datePicker);
	}
}
