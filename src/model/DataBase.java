package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class DataBase {
	private List<Person> people;
	private java.sql.Connection con;

	public DataBase() {
		people = new LinkedList<Person>();
	}
	
	public void addPerson (Person person){
		people.add(person);
//		System.out.println("person added : "+ person.getName());
	}
	// remove Person
	public void removePerson(int index){
		people.remove(index);
	}
	// Connection To Sql Methods
	public void connect(){
		if(con!=null) return;
		
		String url = "jdbc:mysql://localhost";
		try {
			con = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("connection has been done : "+con);
	}
	public void disconnect(){
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Person> getPeople(){
		return Collections.unmodifiableList(people) ;
	}
	
	public void saveToFile(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutput oos = new ObjectOutputStream(fos);
		Person[] persons = (Person[]) people.toArray(new Person[people.size()]);
		oos.writeObject(persons);
		
		oos.close();
	}	

	public void loadFromFile(File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			Person[] persons = (Person[]) ois.readObject();
//			people.clear();
			people.addAll(Arrays.asList(persons));
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		ois.close();
	}
	
	// Delete Row
}
