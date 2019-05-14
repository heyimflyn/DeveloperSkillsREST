package com.ibm.rest.dscs.dao;

import java.util.List;

import com.ibm.rest.dscs.domain.Developer;

public interface DeveloperDao {

	public List<Developer> findAll();
	
	public void addDeveloper(Developer dev);
	
/*	public Developer find(Long devID);
	
	public List<Developer> findByName(String firstname, String lastname);
*/
	
}
