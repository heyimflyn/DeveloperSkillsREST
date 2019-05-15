package com.ibm.rest.dscs.service;

import java.util.List;

import com.ibm.rest.dscs.dao.ReportDao;
import com.ibm.rest.dscs.dao.ReportJdbc;
import com.ibm.rest.dscs.domain.Report;

public class ReportServiceImpl implements ReportService{

	ReportDao reportdao = new ReportJdbc();
	
	public ReportServiceImpl() {
		
		this.reportdao = ReportJdbc.getInstance();
	}


	@Override
	public List<Report> getReport() {
		
		return reportdao.getReport();
	}


}
