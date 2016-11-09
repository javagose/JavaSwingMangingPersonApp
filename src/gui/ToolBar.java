package gui;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ActionListener {
	
	private JButton saveBtn;
	private JButton cancelBtn;
	private StringListner listner;
	private ToolBarAction btnListener;
	
	public ToolBar(){
		
		saveBtn = new JButton();
		saveBtn.setToolTipText("Save");
		saveBtn.setIcon(setImageIcon("/image/save-black.png"));
		
		cancelBtn = new JButton();
		cancelBtn.setToolTipText("refresh");
		cancelBtn.setIcon(setImageIcon("/image/refresh-black.png"));
		
		Border b1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(1,1,1,1),
				BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), 
						BorderFactory.createBevelBorder(BevelBorder.LOWERED)) ));
		
		saveBtn.setBorder(b1);
		cancelBtn.setBorder(b1);
		
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(saveBtn);
		//addSeparator();
		add(cancelBtn);
		//this.setBackground(Color.BLUE);
		
	}
	
	public void setStringListner (StringListner listner){
		this.listner=listner;
	}
	
	public void actionPerformed(ActionEvent e) {
	if ((JButton) e.getSource()== saveBtn) {
		if(btnListener != null) btnListener.saveOccured();
		
	} else if((JButton) e.getSource()== cancelBtn) {
		if(btnListener != null) btnListener.cancelOccured() ;
	}	
		
	}
	
	public void setBtnListener(ToolBarAction btnListener) {
		this.btnListener = btnListener;
	}

	public ImageIcon setImageIcon(String path){
		URL url= getClass().getResource(path);
		
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
