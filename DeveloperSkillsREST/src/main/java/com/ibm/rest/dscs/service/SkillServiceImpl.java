package com.ibm.rest.dscs.service;

import java.util.List;

//import org.apache.commons.lang3.StringUtils;

import com.ibm.rest.dscs.dao.SkillDao;
import com.ibm.rest.dscs.dao.SkillJdbc;
import com.ibm.rest.dscs.domain.Skill;

public class SkillServiceImpl implements SkillService{
	
	SkillDao skilldao;
	
	public SkillServiceImpl() {
		this.skilldao = SkillJdbc.getInstance();
	}
	
	@Override
	public List<Skill> findAll() {
		return skilldao.findAll();
	}

	@Override
	public void addSkill(Skill skill) {
			skilldao.addSkill(skill);
	}
	
}