package com.ibm.rest.dscs.domain;

import java.sql.Date;

public class Developer {

    private int  DEV_ID;
	private String Firstname;
	private String Middlename;
	private String Lastname;
	private Date Birthdate;
	private String Position;
	
	public Developer() {
		
	}
	
   //CONSTRUCTORS
	public Developer( String Firstname, String Middlename, String Lastname, Date Birthdate, String Position) {
		this.Firstname = Firstname;
		this.Middlename = Middlename;
		this.Lastname = Lastname;
		this.Birthdate = Birthdate;
		this.Position = Position;
	}


	public Developer(int DEV_ID, String Firstname, String Middlename, String Lastname, Date Birthdate,
			String Position) {
		this.DEV_ID = DEV_ID;
		this.Firstname = Firstname;
		this.Middlename = Middlename;
		this.Lastname = Lastname;
		this.Birthdate = Birthdate;
		this.Position = Position;
	}

    //GETTERS & SETTERS
	public int getDEV_ID() {
		return DEV_ID;
	}

	public void setDEV_ID(int DEV_ID) {
		this.DEV_ID = DEV_ID;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public String getMiddlename() {
		return Middlename;
	}

	public void setMiddlename(String Middlename) {
		this.Middlename = Middlename;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date Birthdate) {
		this.Birthdate = Birthdate;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String Position) {
		this.Position = Position;
	}

}
