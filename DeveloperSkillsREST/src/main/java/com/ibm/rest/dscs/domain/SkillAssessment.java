package com.ibm.rest.dscs.domain;

public class SkillAssessment{
	
	private String SkillName;
	private int MonthsExp;
	private int SkillLevel;
	private int DEV_ID;
	
	public SkillAssessment() {

	}
	
	//CONSTRUCTORS
	public SkillAssessment(String SkillName, int MonthsExp, int SkillLevel, int DEV_ID) {
		this.SkillName = SkillName;
		this.MonthsExp = MonthsExp;
		this.SkillLevel = SkillLevel;
		this.DEV_ID = DEV_ID;
	}
	
	//GETTERS & SETTERS
	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String SkillName) {
		this.SkillName = SkillName;
	}
	
	public int getMonthsExp() {
		return MonthsExp;
	}

	public void setMonthsExp(int MonthsExp) {
		this.MonthsExp = MonthsExp;
	}

	public int getSkillLevel() {
		return SkillLevel;
	}
	public void setSkillLevel(int SkillLevel) {
		this.SkillLevel = SkillLevel;
	}
	public int getDEV_ID() {
		return DEV_ID;
	}
	public void setDEV_ID(int DEV_ID) {
		this.DEV_ID = DEV_ID;
	}
	
}
