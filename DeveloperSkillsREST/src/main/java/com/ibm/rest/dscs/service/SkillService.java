package com.ibm.rest.dscs.service;

import java.util.List;

import com.ibm.rest.dscs.domain.Skill;

public interface SkillService {

	public List<Skill> findAll();
	
	public void addSkill(Skill SkillName);
	
	/*
	public Skill find(int SKILL_ID);
	
	public List<Skill> findByName(String SkillName);
	*/
}
