package com.ibm.rest.dscs.domain;

public class Report {

	private int SKILL_ID;
	private String SkillName;
	private int Trained;
	private int Novice;
	private int Proficient;
	private int Advanced;
	private int Expert;
	private int ThoughtLeader;
	private int Total;
	
	public Report() {

	}
	
	//CONSTRUCTORS
	public Report(int SKILL_ID, String SkillName, int Trained, int Novice, int Proficient, int Advanced, int Expert,
			int ThoughtLeader, int Total) {
		this.SKILL_ID = SKILL_ID;
		this.SkillName = SkillName;
		this.Trained = Trained;
		this.Novice = Novice;
		this.Proficient = Proficient;
		this.Advanced = Advanced;
		this.Expert = Expert;
		this.ThoughtLeader = ThoughtLeader;
		this.Total = Total;
	}
	
	public String toString() {
		return "Skill ID: " + SKILL_ID 
				+ " Skill Name: " + SkillName 
				+ " Trained: " + Trained 
				+ " Novice: " + Novice
				+ " Proficient: " + Proficient 
				+ " Advanced: " + Advanced 
				+ " Expert " + Expert 
				+ " ThoughtLeader: " + ThoughtLeader
				+ " Total: " + Total;
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
	public int getTrained() {
		return Trained;
	}
	public void setTrained(int Trained) {
		this.Trained = Trained;
	}
	public int getNovice() {
		return Novice;
	}
	public void setNovice(int Novice) {
		this.Novice = Novice;
	}
	public int getProficient() {
		return Proficient;
	}
	public void setProficient(int Proficient) {
		this.Proficient = Proficient;
	}
	public int getAdvanced() {
		return Advanced;
	}
	public void setAdvanced(int Advanced) {
		this.Advanced = Advanced;
	}
	public int getExpert() {
		return Expert;
	}
	public void setExpert(int Expert) {
		this.Expert = Expert;
	}
	public int getThoughtLeader() {
		return ThoughtLeader;
	}
	public void setThoughtLeader(int ThoughtLeader) {
		this.ThoughtLeader = ThoughtLeader;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int Total) {
		this.Total = Total;
	}

	
	
	
}
