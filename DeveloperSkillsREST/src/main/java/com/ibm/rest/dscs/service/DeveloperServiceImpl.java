package com.ibm.rest.dscs.service;

import java.util.List;

//import org.apache.commons.lang3.StringUtils;

import com.ibm.rest.dscs.dao.DeveloperDao;
import com.ibm.rest.dscs.dao.DeveloperJdbc;
import com.ibm.rest.dscs.domain.Developer;
import com.ibm.rest.dscs.service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {
	
	DeveloperDao devdao;
	
	public DeveloperServiceImpl() {
		this.devdao = DeveloperJdbc.getInstance();
	}

	@Override
	public List<Developer> findAll() {
		return devdao.findAll();
	}


	@Override
	public void addDeveloper(Developer dev) {
        devdao.addDeveloper(dev);
	}
	
}

