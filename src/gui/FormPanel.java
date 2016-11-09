package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel OccLabel;
	private JTextField OccField;
	private JButton okBtn;
	private JButton ConcelBtn;
	private FormAction formAction;
	private JList ageList;
	private JComboBox empCombo;
	private JCheckBox citizenCheck;
	private JLabel cinLabel;
	private JTextField cinField;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup genderGroup;

	public FormPanel() {
		Dimension dim = new Dimension();
		dim.width = 270;
		setPreferredSize(dim);
		setMinimumSize(dim);

		Border ineerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createEmptyBorder(1,1,1,1),
						BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), 
								BorderFactory.createBevelBorder(BevelBorder.LOWERED)) ),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)) ;
		this.setBorder(BorderFactory.createCompoundBorder(outerBorder, ineerBorder));

		nameLabel = new JLabel("Name : ");
		nameField = new JTextField(10);
		OccLabel = new JLabel("Occupation : ");
		OccField = new JTextField(10);
		
		nameLabel.setLabelFor(nameField);
		OccLabel.setLabelFor(OccField);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		OccLabel.setDisplayedMnemonic(KeyEvent.VK_C);

		/////// age List
		ageList = new JList();
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement("under 18");
		ageModel.addElement("18 to 65");
		ageModel.addElement( "over 65");
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(115, 65));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);

		////// Employment Combo

		empCombo = new JComboBox();
		DefaultComboBoxModel empModule = new DefaultComboBoxModel();
		empModule.addElement("Employed");
		empModule.addElement("Self-Employed");
		empModule.addElement("Unemployed");
		empCombo.setModel(empModule);
		empCombo.setSelectedIndex(1);
		empCombo.setEditable(true);

		////// Check Box
		citizenCheck = new JCheckBox();
		cinLabel = new JLabel("CIN : ");
		cinField = new JTextField(10);
		cinLabel.setEnabled(false);
		cinField.setEnabled(false);
		citizenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = citizenCheck.isSelected();
				cinLabel.setEnabled(isChecked);
				cinField.setEnabled(isChecked);
			}
		});
		/////////// Gender Radio Button Group
		
		male = new JRadioButton("male");
		female= new JRadioButton("female");
		genderGroup= new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		male.setActionCommand("male");
		female.setActionCommand("female");
		male.setSelected(true);

		// Button submit and Cancel
		okBtn = new JButton("Submit");
		ConcelBtn = new JButton("Cancel");
		
		// set up mnemonics 
		okBtn.setMnemonic(KeyEvent.VK_O);
	
		
		
		ConcelBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				nameField.disable();
				OccField.disable();

			}
		});
		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String Occ = OccField.getText();
				int age =  ageList.getSelectedIndex();
				int Empl =  empCombo.getSelectedIndex();
				boolean isMoroccan = citizenCheck.isSelected();
				String cin = (String)cinField.getText();
				String gendre = genderGroup.getSelection().getActionCommand();

				
				FormEvent formEvent = new FormEvent(this, name, Occ, age, Empl,isMoroccan,cin,gendre);
				if (formEvent != null)
					formAction.formoccured(formEvent);

			}
		});

		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		/////////// First Row /////////////
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		//////// Second Row ////////////////
		gc.gridy++;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		add(OccLabel, gc);

		gc.gridx = 1;

		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(OccField, gc);
		//////////////// Third Row //////////
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age : "), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);

		///////////// forth Row ///////////
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment : "), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(empCombo, gc);
		///////////// Fifth Row ///////////////
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Moroccan Citizen : "), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheck, gc);

		//////////// Sixth Row /////////////////:
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(cinLabel, gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(cinField, gc);
		
		////////// Seventh Row ////////////////
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Gendre : "), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(male, gc);
		
		/////////////// eight Row //////////
		
		gc.gridy++;

		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(female, gc);

		////////// Last Row ///////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;
		gc.gridwidth=2;
		
		gc.gridx = 0;
		gc.insets = new Insets(10, 50, 0, 50);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.BASELINE;
				;
		add(okBtn, gc);

//		gc.gridx = 1;
//		gc.anchor = GridBagConstraints.FIRST_LINE_END;
//		add(ConcelBtn, gc);

		/////////////////////////////////////

	}// constructor

	public void setFormAction(FormAction formAction) {
		this.formAction = formAction;
	}

}// FormPanel Class End

//class AgeCategorie {
//	private int id;
//	private String text;
//
//	public AgeCategorie(int id, String text) {
//		this.id = id;
//		this.text = text;
//	}
//
//	public String toString() {
//		return this.text;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//}
