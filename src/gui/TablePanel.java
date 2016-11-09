package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import model.Person;

public class TablePanel extends JPanel {
	
	private JTable table;
	private PersonTableModule tableModule;
	private JPopupMenu popupMenu;
	private PersonTableListner personTableListner;
	
	public TablePanel(){
		
		tableModule = new PersonTableModule();
		table = new JTable(tableModule);
		popupMenu = new JPopupMenu();
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.white, Color.blue, Color.white));
		
		JMenuItem delete = new JMenuItem("delete Row");
		popupMenu.add(delete);
		
		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				int row; 
				row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton()== MouseEvent.BUTTON3){
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				System.out.println(row);
				if(personTableListner!=null)
					personTableListner.rowDeleted(row);
					tableModule.fireTableRowsDeleted(row, row);
				
			}
		});
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	// SetData Method
	public void setData(List<Person> db){
		tableModule.setData(db);
	}
	// Refresh Method
	public void refresh(){
		tableModule.fireTableDataChanged();
	}
	// set TableListener
	public void SetPersonTableListner(PersonTableListner listener){
		this.personTableListner= listener;
	}
	

}
