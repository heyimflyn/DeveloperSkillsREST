package com.ibm.rest.dscs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.ibm.rest.dscs.dao.DatabaseConnection;
import com.ibm.rest.dscs.dao.SkillAssessmentDao;
import com.ibm.rest.dscs.domain.SkillAssessment;

public class SkillAssessmentJdbc implements SkillAssessmentDao{
	
    DatabaseConnection JDBC;
	private static SkillAssessmentJdbc INSTANCE;

	static public SkillAssessmentJdbc getInstance() {

		SkillAssessmentJdbc instance;
		if (INSTANCE != null) {
			instance = INSTANCE;
		} else {
			instance = new SkillAssessmentJdbc();
			INSTANCE = instance;
		}

		return instance;
	}

	private SkillAssessmentJdbc() {
		JDBC = new DatabaseConnection();
	}
    
	@Override
	public List<SkillAssessment> findAll() {
		List<SkillAssessment> skillAssess = new ArrayList<SkillAssessment>();
		
		String sql = "SELECT * FROM SKILLASSESSMENT";
		
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) 
		  {
			
			while (rs.next()) {
				String SkillName = rs.getString("SkillName");
				int DEV_ID = rs.getInt("DEV_ID");
				int MonthsExp= rs.getInt("MonthsExp");
				int SkillLevel = rs.getInt("SkillLevel");
				SkillAssessment skillAssessment = new SkillAssessment(SkillName, MonthsExp,
					SkillLevel,DEV_ID);
				skillAssess.add(skillAssessment);
			}

		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return skillAssess;
	}

	@Override
	public void addSkillAssessment(SkillAssessment addSA) {
		
	String sql = "INSERT INTO SKILLASSESSMENT (SkillName, MonthsExp, SkillLevel, DEV_ID) values (?,?,?,?)";
	
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) 
		   { 
			ps.setString(1, addSA.getSkillName());
			ps.setInt(2, addSA.getMonthsExp());
			ps.setInt(3, addSA.getSkillLevel());
			ps.setInt(4, addSA.getDEV_ID());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}

	@Override
	public void updateSkillAssessment(SkillAssessment upSA) {
		
		String sql = "UPDATE SKILLASSESSMENT SET SkillName = ?, MonthsExp = ?, SkillLevel = ? WHERE  DEV_ID = ?";
		
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql))
		   { 
			ps.setString(1, upSA.getSkillName()); 
			ps.setInt(2, upSA.getMonthsExp());
			ps.setInt(3, upSA.getSkillLevel());
			ps.setInt(4, upSA.getDEV_ID());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
