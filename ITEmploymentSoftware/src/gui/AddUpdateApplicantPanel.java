package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUpdateApplicantPanel extends JPanel{
	private MainFrame main;
	private Applicant currentApplicant;
	private JLabel panelTitle;
	private JTextField nameField;
	private JTextField phoneNumberField;
	private JTextField workExperienceField;
	private JTextField genericSkillField;
	private JTextField qualificationsField;
	private JTextField achievementsField;
	public AddUpdateApplicantPanel(MainFrame main,String ApplicantID){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1,1,1,1,1,1,1};
		gridBagLayout.rowWeights = new double[]{1,1,1,1,1,1,1,1};
		setLayout(gridBagLayout);
		this.panelTitle = new JLabel("");
		panelTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.gridwidth = 6;
		gbc_panelTitle.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitle.gridx = 0;
		gbc_panelTitle.gridy = 0;
		add(panelTitle, gbc_panelTitle);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 1;
		add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel genericSkillLabel = new JLabel("Generic Skill: ");
		genericSkillLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_genericSkillLabel = new GridBagConstraints();
		gbc_genericSkillLabel.anchor = GridBagConstraints.EAST;
		gbc_genericSkillLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genericSkillLabel.gridx = 2;
		gbc_genericSkillLabel.gridy = 1;
		add(genericSkillLabel, gbc_genericSkillLabel);
		
		genericSkillField = new JTextField();
		genericSkillField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_genericSkillField = new GridBagConstraints();
		gbc_genericSkillField.insets = new Insets(0, 0, 5, 5);
		gbc_genericSkillField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genericSkillField.gridx = 3;
		gbc_genericSkillField.gridy = 1;
		add(genericSkillField, gbc_genericSkillField);
		genericSkillField.setColumns(10);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 4;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 0);
		gbc_imageLabel.gridx = 4;
		gbc_imageLabel.gridy = 1;
		add(imageLabel, gbc_imageLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number: ");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
		gbc_phoneNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberLabel.gridx = 0;
		gbc_phoneNumberLabel.gridy = 2;
		add(phoneNumberLabel, gbc_phoneNumberLabel);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_phoneNumberField = new GridBagConstraints();
		gbc_phoneNumberField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNumberField.gridx = 1;
		gbc_phoneNumberField.gridy = 2;
		add(phoneNumberField, gbc_phoneNumberField);
		phoneNumberField.setColumns(10);
		
		JLabel technicalSkillLabel = new JLabel("Technical Skill: ");
		technicalSkillLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_technicalSkillLabel = new GridBagConstraints();
		gbc_technicalSkillLabel.anchor = GridBagConstraints.EAST;
		gbc_technicalSkillLabel.insets = new Insets(0, 0, 5, 5);
		gbc_technicalSkillLabel.gridx = 2;
		gbc_technicalSkillLabel.gridy = 2;
		add(technicalSkillLabel, gbc_technicalSkillLabel);
		
		String[] technicalSkills = {"Programming","Industrial"};
		JComboBox technicalSkillCombo = new JComboBox(technicalSkills);
		technicalSkillCombo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_technicalSkillCombo = new GridBagConstraints();
		gbc_technicalSkillCombo.insets = new Insets(0, 0, 5, 5);
		gbc_technicalSkillCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_technicalSkillCombo.gridx = 3;
		gbc_technicalSkillCombo.gridy = 2;
		add(technicalSkillCombo, gbc_technicalSkillCombo);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_genderLabel = new GridBagConstraints();
		gbc_genderLabel.anchor = GridBagConstraints.EAST;
		gbc_genderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genderLabel.gridx = 0;
		gbc_genderLabel.gridy = 3;
		add(genderLabel, gbc_genderLabel);
		
		String[] genders = {"Male","Female"};
		JComboBox genderCombo = new JComboBox(genders);
		genderCombo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_genderCombo = new GridBagConstraints();
		gbc_genderCombo.insets = new Insets(0, 0, 5, 5);
		gbc_genderCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderCombo.gridx = 1;
		gbc_genderCombo.gridy = 3;
		add(genderCombo, gbc_genderCombo);
		
		JLabel qualificationsLabel = new JLabel("Qualifications: ");
		qualificationsLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_qualificationsLabel = new GridBagConstraints();
		gbc_qualificationsLabel.anchor = GridBagConstraints.EAST;
		gbc_qualificationsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_qualificationsLabel.gridx = 2;
		gbc_qualificationsLabel.gridy = 3;
		add(qualificationsLabel, gbc_qualificationsLabel);
		
		qualificationsField = new JTextField();
		qualificationsField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_qualificationsField = new GridBagConstraints();
		gbc_qualificationsField.insets = new Insets(0, 0, 5, 5);
		gbc_qualificationsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_qualificationsField.gridx = 3;
		gbc_qualificationsField.gridy = 3;
		add(qualificationsField, gbc_qualificationsField);
		qualificationsField.setColumns(10);
		
		JLabel workExperienceLabel = new JLabel("Work Experience");
		workExperienceLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_workExperienceLabel = new GridBagConstraints();
		gbc_workExperienceLabel.anchor = GridBagConstraints.EAST;
		gbc_workExperienceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_workExperienceLabel.gridx = 0;
		gbc_workExperienceLabel.gridy = 4;
		add(workExperienceLabel, gbc_workExperienceLabel);
		
		workExperienceField = new JTextField();
		workExperienceField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_workExperienceField = new GridBagConstraints();
		gbc_workExperienceField.insets = new Insets(0, 0, 5, 5);
		gbc_workExperienceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_workExperienceField.gridx = 1;
		gbc_workExperienceField.gridy = 4;
		add(workExperienceField, gbc_workExperienceField);
		workExperienceField.setColumns(10);
		
		JLabel achievementsLabel = new JLabel("Achievements: ");
		achievementsLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_achievementsLabel = new GridBagConstraints();
		gbc_achievementsLabel.anchor = GridBagConstraints.EAST;
		gbc_achievementsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_achievementsLabel.gridx = 2;
		gbc_achievementsLabel.gridy = 4;
		add(achievementsLabel, gbc_achievementsLabel);
		
		achievementsField = new JTextField();
		achievementsField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_achievementsField = new GridBagConstraints();
		gbc_achievementsField.insets = new Insets(0, 0, 5, 5);
		gbc_achievementsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_achievementsField.gridx = 3;
		gbc_achievementsField.gridy = 4;
		add(achievementsField, gbc_achievementsField);
		achievementsField.setColumns(10);
		
		JButton selectImageButton = new JButton("Select Image");
		selectImageButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		selectImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_selectImageButton = new GridBagConstraints();
		gbc_selectImageButton.gridwidth = 4;
		gbc_selectImageButton.insets = new Insets(0, 0, 5, 0);
		gbc_selectImageButton.gridx = 4;
		gbc_selectImageButton.gridy = 4;
		add(selectImageButton, gbc_selectImageButton);
		
		JButton addUpdateButton = new JButton("");
		addUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 30));

		if (ApplicantID.equals("new")){
			//new user
			currentApplicant = new Applicant();
			this.panelTitle.setText("Create New Applicant");
			addUpdateButton.setText("Create");
		}
		else{
			currentApplicant = this.main.getController().getApplicant(ApplicantID);
			addUpdateButton.setText("Update");
			nameField.setText(currentApplicant.getName());
			phoneNumberField.setText(currentApplicant.getphoneNumber());
			workExperienceField.setText(currentApplicant.getWorkExperience());
			genericSkillField.setText(currentApplicant.getGenericSkill());
			qualificationsField.setText(currentApplicant.getQualification());
			achievementsField.setText(currentApplicant.getAchievement());
			genderCombo.setSelectedItem(currentApplicant.getGender());
			technicalSkillCombo.setSelectedItem(currentApplicant.getTechnicalSkill());
			this.panelTitle.setText("Update Applicant");
			try {
				ImageIcon profilePicture = this.main.getController().getImage(currentApplicant.getImage());
				imageLabel.setIcon(profilePicture);
			}
			catch (Exception e){
				System.out.println(e.getStackTrace());
			}
		}
		GridBagConstraints gbc_addUpdateButton = new GridBagConstraints();
		gbc_addUpdateButton.gridwidth = 4;
		gbc_addUpdateButton.insets = new Insets(0, 0, 0, 5);
		gbc_addUpdateButton.gridx = 1;
		gbc_addUpdateButton.gridy = 5;
		add(addUpdateButton, gbc_addUpdateButton);
	}

}