package gui;

import javax.swing.JPanel;
import javax.swing.JTable;

import controller.MainFrame;
import data.Applicant;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class ViewApplicantPanel extends JPanel{
	private MainFrame main;
	private JTable table;
	private Applicant currentApplicant;
	private JLabel lblRole;
	private BackgroundPanel imagePanel;
	private BufferedImage profilePicture;
	public ViewApplicantPanel(MainFrame main, String ApplicantID, String parentPanelName){
		setBackground(new Color(135, 206, 250));
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20, 20, 20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20, 20, 20,20,20, 20, 20, 20,20, 20, 20,20,20, 20, 20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0, 1.0, 1.0,1.0};
		setLayout(gridBagLayout);
		
		currentApplicant = this.main.getController().getApplicant(ApplicantID);
		
		this.lblRole = new JLabel("");
		lblRole.setBackground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 35));
		GridBagConstraints gbc_lblRole = new GridBagConstraints();
		gbc_lblRole.gridwidth = 6;
		gbc_lblRole.insets = new Insets(0, 0, 5, 5);
		gbc_lblRole.gridx = 1;
		gbc_lblRole.gridy = 1;
		add(lblRole, gbc_lblRole);
		if (parentPanelName=="manager"){
			lblRole.setText("Manager's Applicant Details View");
		}
		else if (parentPanelName=="staff"){
			lblRole.setText("Staff's Applicant Details View");
		}
		JButton btnupdate = new JButton("Update Applicant");
		btnupdate.setBackground(Color.GREEN);
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnupdate = new GridBagConstraints();
		gbc_btnupdate.gridwidth = 2;
		gbc_btnupdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnupdate.gridx = 1;
		gbc_btnupdate.gridy = 6;
		add(btnupdate, gbc_btnupdate);
		btnupdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
	    {
	        main.showAddUpdateApplicantPanel(currentApplicant.getApplicantID());
	    }
		
		});
		
		JLabel lblImage = new JLabel("Profile Picture");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridwidth = 3;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 4;
		gbc_lblImage.gridy = 6;
		add(lblImage, gbc_lblImage);
		this.imagePanel = new BackgroundPanel(profilePicture);
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridheight = 10;
		gbc_imagePanel.gridwidth = 3;
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.gridx = 4;
		gbc_imagePanel.gridy = 7;
		add(imagePanel, gbc_imagePanel);

		try {
			String imagePath = currentApplicant.getImage();
			
			BufferedImage profilePicture = this.main.getController().getImage(imagePath);
			//TODO Autoresize if possible now cannot get width and prefered width of label for some reason
			imagePanel.setImage(profilePicture);
		}
		catch (Exception e){
			try {
				BufferedImage profilePicture;
				profilePicture = this.main.getController().getImage("noImage.png");
				//TODO Autoresize if possible now cannot get width and prefered width of label for some reason
				imagePanel.setImage(profilePicture);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (parentPanelName=="manager"){
			btnupdate.setVisible(false);
		}
		else if (parentPanelName=="staff"){
			btnupdate.setVisible(true);
		}
		
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 7;
		add(lblName, gbc_lblName);
		
		JTextPane namePane = new JTextPane();
		namePane.setEditable(false);
		namePane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_namePane = new GridBagConstraints();
		gbc_namePane.insets = new Insets(0, 0, 5, 5);
		gbc_namePane.fill = GridBagConstraints.HORIZONTAL;
		gbc_namePane.gridx = 2;
		gbc_namePane.gridy = 7;
		add(namePane, gbc_namePane);
		namePane.setText(currentApplicant.getName());
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 1;
		gbc_lblPhoneNumber.gridy = 8;
		add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		JTextPane phonePane = new JTextPane();
		phonePane.setEditable(false);
		phonePane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_phonePane = new GridBagConstraints();
		gbc_phonePane.insets = new Insets(0, 0, 5, 5);
		gbc_phonePane.fill = GridBagConstraints.HORIZONTAL;
		gbc_phonePane.gridx = 2;
		gbc_phonePane.gridy = 8;
		add(phonePane, gbc_phonePane);
		phonePane.setText(currentApplicant.getphoneNumber());
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 9;
		add(lblGender, gbc_lblGender);
		
		JTextPane genderPane = new JTextPane();
		genderPane.setEditable(false);
		genderPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_genderPane = new GridBagConstraints();
		gbc_genderPane.insets = new Insets(0, 0, 5, 5);
		gbc_genderPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderPane.gridx = 2;
		gbc_genderPane.gridy = 9;
		add(genderPane, gbc_genderPane);
		genderPane.setText(currentApplicant.getGender());
		
		JLabel lblWorkExperience = new JLabel("Work Experience:");
		lblWorkExperience.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblWorkExperience = new GridBagConstraints();
		gbc_lblWorkExperience.anchor = GridBagConstraints.WEST;
		gbc_lblWorkExperience.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkExperience.gridx = 1;
		gbc_lblWorkExperience.gridy = 10;
		add(lblWorkExperience, gbc_lblWorkExperience);
		
		JTextPane wEPane = new JTextPane();
		wEPane.setEditable(false);
		wEPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_wEPane = new GridBagConstraints();
		gbc_wEPane.insets = new Insets(0, 0, 5, 5);
		gbc_wEPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_wEPane.gridx = 2;
		gbc_wEPane.gridy = 10;
		add(wEPane, gbc_wEPane);
		wEPane.setText(currentApplicant.getWorkExperience());
		
		JLabel lblGenericSkill = new JLabel("Generic Skill:");
		lblGenericSkill.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblGenericSkill = new GridBagConstraints();
		gbc_lblGenericSkill.anchor = GridBagConstraints.WEST;
		gbc_lblGenericSkill.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenericSkill.gridx = 1;
		gbc_lblGenericSkill.gridy = 11;
		add(lblGenericSkill, gbc_lblGenericSkill);
		
		JTextPane gSkillPane = new JTextPane();
		gSkillPane.setEditable(false);
		gSkillPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_gSkillPane = new GridBagConstraints();
		gbc_gSkillPane.insets = new Insets(0, 0, 5, 5);
		gbc_gSkillPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_gSkillPane.gridx = 2;
		gbc_gSkillPane.gridy = 11;
		add(gSkillPane, gbc_gSkillPane);
		gSkillPane.setText(currentApplicant.getGenericSkill());
		
		JLabel lblTechnicalSkill = new JLabel("Technical Skill:");
		lblTechnicalSkill.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTechnicalSkill = new GridBagConstraints();
		gbc_lblTechnicalSkill.anchor = GridBagConstraints.WEST;
		gbc_lblTechnicalSkill.insets = new Insets(0, 0, 5, 5);
		gbc_lblTechnicalSkill.gridx = 1;
		gbc_lblTechnicalSkill.gridy = 12;
		add(lblTechnicalSkill, gbc_lblTechnicalSkill);
		
		JTextPane tSkillPane = new JTextPane();
		tSkillPane.setEditable(false);
		tSkillPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_tSkillPane = new GridBagConstraints();
		gbc_tSkillPane.insets = new Insets(0, 0, 5, 5);
		gbc_tSkillPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_tSkillPane.gridx = 2;
		gbc_tSkillPane.gridy = 12;
		add(tSkillPane, gbc_tSkillPane);
		tSkillPane.setText(currentApplicant.getTechnicalSkill());
		
		JLabel lblQualifications = new JLabel("Qualifications:");
		lblQualifications.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQualifications = new GridBagConstraints();
		gbc_lblQualifications.anchor = GridBagConstraints.WEST;
		gbc_lblQualifications.insets = new Insets(0, 0, 5, 5);
		gbc_lblQualifications.gridx = 1;
		gbc_lblQualifications.gridy = 13;
		add(lblQualifications, gbc_lblQualifications);
		
		JTextPane qualificationPane = new JTextPane();
		qualificationPane.setEditable(false);
		qualificationPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_qualificationPane = new GridBagConstraints();
		gbc_qualificationPane.insets = new Insets(0, 0, 5, 5);
		gbc_qualificationPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_qualificationPane.gridx = 2;
		gbc_qualificationPane.gridy = 13;
		add(qualificationPane, gbc_qualificationPane);
		qualificationPane.setText(currentApplicant.getQualification());
		
		JLabel lblAchievements = new JLabel("Achievements:");
		lblAchievements.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblAchievements = new GridBagConstraints();
		gbc_lblAchievements.anchor = GridBagConstraints.WEST;
		gbc_lblAchievements.insets = new Insets(0, 0, 5, 5);
		gbc_lblAchievements.gridx = 1;
		gbc_lblAchievements.gridy = 14;
		add(lblAchievements, gbc_lblAchievements);
		
		JTextPane achievementsPane = new JTextPane();
		achievementsPane.setEditable(false);
		achievementsPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_achievementsPane = new GridBagConstraints();
		gbc_achievementsPane.insets = new Insets(0, 0, 5, 5);
		gbc_achievementsPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_achievementsPane.gridx = 2;
		gbc_achievementsPane.gridy = 14;
		add(achievementsPane, gbc_achievementsPane);
		achievementsPane.setText(currentApplicant.getAchievement());
		
		JLabel lblShortlisted = new JLabel("Shortlisted:");
		lblShortlisted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblShortlisted = new GridBagConstraints();
		gbc_lblShortlisted.anchor = GridBagConstraints.WEST;
		gbc_lblShortlisted.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortlisted.gridx = 1;
		gbc_lblShortlisted.gridy = 15;
		add(lblShortlisted, gbc_lblShortlisted);
		
		
		JTextPane shortlistPane = new JTextPane();
		shortlistPane.setEditable(false);
		shortlistPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_shortlistPane = new GridBagConstraints();
		gbc_shortlistPane.insets = new Insets(0, 0, 5, 5);
		gbc_shortlistPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortlistPane.gridx = 2;
		gbc_shortlistPane.gridy = 15;
		add(shortlistPane, gbc_shortlistPane);
		shortlistPane.setText(Boolean.toString(currentApplicant.getShortlistStatus()));
		
		JLabel lblJobOffered = new JLabel("Job Offered:");
		lblJobOffered.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblJobOffered = new GridBagConstraints();
		gbc_lblJobOffered.anchor = GridBagConstraints.WEST;
		gbc_lblJobOffered.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobOffered.gridx = 1;
		gbc_lblJobOffered.gridy = 16;
		add(lblJobOffered, gbc_lblJobOffered);
		
		JTextPane jobOfferedPane = new JTextPane();
		jobOfferedPane.setEditable(false);
		jobOfferedPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_jobOfferedPane = new GridBagConstraints();
		gbc_jobOfferedPane.insets = new Insets(0, 0, 5, 5);
		gbc_jobOfferedPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_jobOfferedPane.gridx = 2;
		gbc_jobOfferedPane.gridy = 16;
		add(jobOfferedPane, gbc_jobOfferedPane);
		jobOfferedPane.setText(Boolean.toString(currentApplicant.getReceivedJobOffer()));
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setBackground(new Color(255,204,203));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 6;
		gbc_btnBack.gridy = 18;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parentPanelName=="manager"){
					main.showManagerPanel();
				}
				else if (parentPanelName=="staff"){
					main.showStaffPanel();
				}
			}
		});
		
		
	}
}