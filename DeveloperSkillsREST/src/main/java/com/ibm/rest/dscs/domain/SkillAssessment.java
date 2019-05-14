package com.ibm.rest.dscs.domain;

public class SkillAssessment{
	
	//private String SkillName;
	private int MonthsExp;
	private int SkillLevel;
	private int DEV_ID;
	private int SKILL_ID;
	
	public SkillAssessment() {

	}
	
	//CONSTRUCTORS
	public SkillAssessment(/*String SkillName,*/ int MonthsExp, int SkillLevel, int DEV_ID, int SKILL_ID) {
	//	this.SkillName = SkillName;
		this.MonthsExp = MonthsExp;
		this.SkillLevel = SkillLevel;
		this.DEV_ID = DEV_ID;
		this.SKILL_ID = SKILL_ID;
	}
	
	//GETTERS & SETTERS
/*	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String SkillName) {
		this.SkillName = SkillName;
	}*/

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

	public int getSKILL_ID() {
		return SKILL_ID;
	}

	public void setSKILL_ID(int SKILL_ID) {
		this.SKILL_ID = SKILL_ID;
	}
	
	
}
