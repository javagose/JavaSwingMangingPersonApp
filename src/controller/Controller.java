package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import gui.FormEvent;
import model.AgeList;
import model.DataBase;
import model.Employement;
import model.Gender;
import model.Person;

public class Controller {
	
	DataBase db = new DataBase();
	
	public List<Person> getData(){
		return db.getPeople();
	}
	
	public void addPerson(FormEvent ev){
		
		String name = ev.getName();
		String Occ = ev.getOcc();
		int age = ev.getAge();
		int Empl = ev.getEmpl();
		boolean isMoroccan = ev.isMoroccan();
		String cin = ev.getCin();
		String gendre = ev.getGender();
		
		//define Age List
		AgeList ageCat = null;
		switch (age) {
		case 0:
			ageCat = AgeList.child;
			break;
		case 1:
			ageCat = AgeList.adult;
			break;
		case 2:
			ageCat = AgeList.senior;
			break;

		default:
			break;
		}
		//Define Employment 
		Employement emp ; 
		
		switch (Empl) {
		case 0:
			emp = Employement.employed;
			break;
		case 1:
			emp = Employement.self_employed;
			break;
		case 2:
			emp = Employement.unemployed;
			break;

		default:
			emp = Employement.other;
			break;
		}
		
		// Define Gender
		Gender gender;
		if (gendre== "male") {
			gender = Gender.male;
		} else {
			gender = Gender.female;
		}
		
		System.out.println(emp);
		Person person = new Person(name, Occ, ageCat, emp, isMoroccan, cin, gender);
		db.addPerson(person);
		
	}//add Person Method
	
	// save and load File Methods 
	
	public void saveToFile(File file) throws IOException{
		db.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}
	
	// remove Person 
	public void removePerson(int index){
		db.removePerson(index);
	}

}
