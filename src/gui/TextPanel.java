package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TextPanel extends JPanel {
	private JTextArea textarea;
	private JTextField textfield;
	
	public TextPanel(){
		textarea = new JTextArea();
		textfield = new JTextField();
		Border b2 =BorderFactory.createLineBorder(Color.GRAY);
		textfield.setBorder(b2);
		textarea.setBorder(b2);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.white, Color.blue, Color.white));
		
		
		textfield.setFocusable(true);
		textfield.setBounds(30, 30, 30, 30);
		
		this.setLayout(new BorderLayout());
		
		add(textarea,BorderLayout.CENTER);
		add(textfield,BorderLayout.NORTH);
	}
	
	public void appendText(String text){
		textarea.append(text);
	}
}
