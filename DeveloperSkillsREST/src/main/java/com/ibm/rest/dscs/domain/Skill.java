package com.ibm.rest.dscs.domain;

public class Skill {
	
	private int SKILL_ID;
	private String SkillName;
	
	public Skill() {
		
	}
	
    // CONSTRUCTORS
	public Skill(int SKILL_ID, String SkillName) {
		this.SKILL_ID = SKILL_ID;
		this.SkillName = SkillName;
	}
    
	//GETTERS & SETTERS
	public int getSKILL_ID() {
		return SKILL_ID;
	}

	public void setSKILL_ID(int SKILL_ID) {
		this.SKILL_ID = SKILL_ID;
	}

	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String SkillName) {
		this.SkillName = SkillName;
	}


	
}