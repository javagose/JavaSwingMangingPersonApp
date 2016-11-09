package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;

public class PrefsDialog extends JDialog {
	private JButton okBtn;
	private JButton cancelBtn;
	private JSpinner port;
	private JTextField user;
	private JPasswordField pass;
	
	private PrefsDialogListener listner;
	
	public PrefsDialog (JFrame parent){
		super(parent, "Prefereces Dialog", false);
		this.setSize(320, 240);
		this.setLocationRelativeTo(parent);
		
		
		okBtn = new JButton("Ok");
		cancelBtn = new JButton("cancel");
		SpinnerNumberModel spinnerModel = 
				new SpinnerNumberModel(2220, 0, 9990, 10);
		port = new JSpinner(spinnerModel);
		user = new JTextField(10);
		pass = new JPasswordField(10);
		
		layoutControls();
		
		//////// Add Listener 
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer value = (Integer) port.getValue();
				String userC= user.getText();
				String passC = new String(pass.getPassword());
				
				if(listner!=null)
					listner.PrefsDialogSetDefault(userC, passC, value);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}


	public void setListner(PrefsDialogListener listner) {
		this.listner = listner;
	}
	public void setDefault(String user, String pass,int port ) {
		this.user.setText(user);
		this.pass.setText(pass);
		this.port.setValue(port);
	}
	
	// Layou Controls Method
	
	public void layoutControls(){
		
		JPanel controlsPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		// set Borders
		int space = 10;
		controlsPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(space, space, space, space)
				,BorderFactory.createTitledBorder("User Preferces")
				));
		
		btnPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(space, space, space, space)
				,BorderFactory.createBevelBorder(BevelBorder.RAISED)
				));
		
		//controls Panel
		controlsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
			/////// First Row ////////////////
			Insets rightPading = new Insets(0, 0, 0, 15);
			Insets noPading = new Insets(0, 0, 0, 0);
 			gc.gridy =0 ;
			
			gc.weightx =1;
			gc.weighty=0.2;
			
			gc.gridx=0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPading;
			controlsPanel.add(new JLabel("user : "),gc);
			
			gc.gridx++;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPading;
			controlsPanel.add(user,gc);
			///////// Second Row ////////////
			gc.gridy++;
			
			gc.gridx=0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPading;
			controlsPanel.add(new JLabel("password : "),gc);
			
			gc.gridx++;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPading;
			controlsPanel.add(pass,gc);
			//////// third Row ////////////
			gc.gridy++;
			
			gc.gridx=0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPading;
			controlsPanel.add(new JLabel("Port : "),gc);
			
			gc.gridx++;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPading;
			controlsPanel.add(port,gc);
			
		///////// Button Panel ////////////
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		Dimension btnSize = cancelBtn.getPreferredSize();
		okBtn.setPreferredSize(btnSize);
		
		btnPanel.add(okBtn,gc);
		btnPanel.add(cancelBtn,gc);
		
		/// adding Panel to Dialog
		setLayout(new BorderLayout());
		add(controlsPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
	}
	
}
