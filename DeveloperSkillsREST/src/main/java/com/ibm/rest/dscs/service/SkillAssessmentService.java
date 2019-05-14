package com.ibm.rest.dscs.service;

import java.util.List;

import com.ibm.rest.dscs.domain.SkillAssessment;

public interface SkillAssessmentService {
	
	public List<SkillAssessment> findAll();

	public void addSkillAssessment(SkillAssessment addSA);
		
	public void updateSkillAssessment(SkillAssessment upSA);

}
