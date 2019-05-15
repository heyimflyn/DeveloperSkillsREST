package com.ibm.rest.dscs.dao;

import java.util.List;

import com.ibm.rest.dscs.domain.SkillAssessment;

public interface SkillAssessmentDao {
	
	public List<SkillAssessment> findAll();
		
	public void addSkillAssessment(SkillAssessment addSA);
		
	public void updateSkillAssessment(SkillAssessment upSA);
	
	public void SkillAlreadyExist(int DEV_ID, int SKILL_ID);
		
}
