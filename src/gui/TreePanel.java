package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;

public class TreePanel extends JPanel {
	private JTree serverTree;
	
	public TreePanel(){
		serverTree = new JTree();
		serverTree.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.white, Color.blue, Color.white));
		setLayout(new BorderLayout());
		add(serverTree, BorderLayout.CENTER);
		
	}

}
