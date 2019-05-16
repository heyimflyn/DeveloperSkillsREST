package com.ibm.rest.dscs.service;

import java.util.List;

import com.ibm.rest.dscs.dao.DeveloperDao;
import com.ibm.rest.dscs.dao.SkillAssessmentDao;
import com.ibm.rest.dscs.dao.SkillAssessmentJdbc;
import com.ibm.rest.dscs.domain.SkillAssessment;

public class SkillAssessmentServiceImpl implements SkillAssessmentService {

	SkillAssessmentDao skillAssessdao;
	DeveloperDao devdao;
	SkillAssessmentJdbc SAJdbc;
	
	public SkillAssessmentServiceImpl() {
		this.skillAssessdao = SkillAssessmentJdbc.getInstance();
	}
	
	@Override
	public List<SkillAssessment> findAll() {
		return skillAssessdao.findAll();
	}

	@Override
	public void addSkillAssessment(SkillAssessment addSA) {
		skillAssessdao.addSkillAssessment(addSA);
		
	}

	@Override
	public void updateSkillAssessment(SkillAssessment upSA) {
		skillAssessdao.addSkillAssessment(upSA);
	}


}
