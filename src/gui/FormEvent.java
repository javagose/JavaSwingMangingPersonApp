package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String Occ;
	private int age;
	private int empl ;
	private boolean isMoroccan;
	private String cin ;
	private String gender;

	
	public FormEvent(Object source) {
		super(source);
		
	}
	public FormEvent(Object source,String name,String Occ, int age, 
			int Empl, boolean isMoroccan, String cin ,String gender) {
		super(source);
		this.name=name;
		this.Occ=Occ;
		this.age=age;
		this.empl =Empl;
		this.isMoroccan=isMoroccan;
		this.cin = cin;
		this.gender=gender;
	}
	
	///// Setters and Getters
	
	public int getEmpl() {
		return empl;
	}
	public boolean isMoroccan() {
		return isMoroccan;
	}
	public void setMoroccan(boolean isMoroccan) {
		this.isMoroccan = isMoroccan;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public void setEmpl(int empl) {
		this.empl = empl;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOcc() {
		return Occ;
	}
	public void setOcc(String occ) {
		Occ = occ;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}

