//author : Walid Benjehd 
//email : Walidbenjehd@gmail.com
package model;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -852122811480759698L;
	private static int contor =0;
	private int id;
	private String name;
	private String Occ;
	private AgeList age;
	private Employement employement;
	private boolean Morocitezen;
	private String cin;
	private Gender sex;
	
	//constructor
	public Person( String name, String occ, AgeList age, Employement employement
			, boolean morocitezen, String cin, Gender sex) {
		
		this.id = contor;
		this.name = name;
		Occ = occ;
		this.age = age;
		this.employement = employement;
		Morocitezen = morocitezen;
		this.cin=cin;
		this.sex = sex;
		contor++;
	}
	public Person (){
		this.id = contor;
		System.out.println(contor);
		contor++;
	}
	
	//Getters and Setters
	public static int getContor() {
		return contor;
	}
	public static void setContor(int contor) {
		Person.contor = contor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public AgeList getAge() {
		return age;
	}
	public void setAge(AgeList age) {
		this.age = age;
	}
	public Employement getEmployement() {
		return employement;
	}
	public void setEmployement(Employement employement) {
		this.employement = employement;
	}
	public boolean isMorocitezen() {
		return Morocitezen;
	}
	public void setMorocitezen(boolean morocitezen) {
		Morocitezen = morocitezen;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	
	
	

}
