package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModule extends AbstractTableModel {

	private List<Person> db;
	private String[] colNames = {"ID", "Name", "Occupation", "Age Categorie",
			"Employement", "is Moroccain", "Cin", "Gendre"};
	
	public void setData(List<Person> db){
		this.db = db;
	}
	public List<Person> getData(){
		return db;
	}
	
	// generate the the colomn names with scrollpane in table
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	@Override
	public int getColumnCount() {
		return 8;
	}
	@Override
	public int getRowCount() {
		return db.size();
	}
	@Override
	public Object getValueAt(int row, int col) {
		Person person = db.get(row);
		switch (col) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOcc();
		case 3:
			return person.getAge();
		case 4:
			return person.getEmployement();
		case 5:
			return person.isMorocitezen();
		case 6:
			return person.getCin();	
		case 7:
			return person.getSex();
		default:
			break;
		}
		return null;
	}

}
