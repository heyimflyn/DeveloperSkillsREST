package com.ibm.rest.dscs.service;

import java.util.List;

import com.ibm.rest.dscs.domain.Developer;

public interface DeveloperService {
	
    public List<Developer> findAll();
	
    public void addDeveloper(Developer dev);
}
