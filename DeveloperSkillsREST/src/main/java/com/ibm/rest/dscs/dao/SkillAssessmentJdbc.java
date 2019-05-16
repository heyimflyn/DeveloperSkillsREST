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
    
//-----------------FIND SKILL ASSESSMENT----------------------------------		
	@Override
	public List<SkillAssessment> findAll() {
		List<SkillAssessment> skillAssess = new ArrayList<SkillAssessment>();
		
		String sql = "SELECT * FROM SKILLASSESSMENT";
		
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) 
		  {
			
			while (rs.next()) {
				int MonthsExp= rs.getInt("MonthsExp");
				int SkillLevel = rs.getInt("SkillLevel");
				int DEV_ID = rs.getInt("DEV_ID");
				int SKILL_ID = rs.getInt("SKILL_ID");
				int AssessmentID = rs.getInt("AssessmentID");
				SkillAssessment skillAssessment = new SkillAssessment(MonthsExp,
					SkillLevel,DEV_ID, SKILL_ID, AssessmentID);
				skillAssess.add(skillAssessment);
			}

		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return skillAssess;
	}

//-----------------ADD SKILL ASSESSMENT----------------------------------	
	@Override
	public void addSkillAssessment(SkillAssessment addSA) {
		
	String sql = "INSERT INTO SKILLASSESSMENT (MonthsExp, SkillLevel, DEV_ID, SKILL_ID) values (?,?,?,?)";
	
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) 
		   { 
			ps.setInt(1, addSA.getMonthsExp());
			ps.setInt(2, addSA.getSkillLevel());
			ps.setInt(3, addSA.getDEV_ID());
			ps.setInt(4, addSA.getSKILL_ID());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}
	
/*	public void SkillAlreadyExist(int DEV_ID, int SKILL_ID) {
		
		String sql = "SELECT * FROM skillassessments WHERE DEV_ID = ? AND SKILL_ID = ?";

		try (Connection con = JDBC.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, DEV_ID);
			ps.setInt(2, SKILL_ID);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void DevIDAlreadyExist(int DEV_ID) {
		
		String sql = "SELECT * FROM developers WHERE DEV_ID = ?";

		try (Connection con = JDBC.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, DEV_ID);
			
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} */

//-----------------UPDATE SKILL ASSESSMENT----------------------------------		
	@Override
	public void updateSkillAssessment(SkillAssessment upSA) {
		
		String sql = "UPDATE SKILLASSESSMENT SET MonthsExp = ?, SkillLevel = ? "
				+ "WHERE SKILL_ID = ? AND DEV_ID = ? AND AssessmentID = ?";
		
		try(Connection con = JDBC.getConnection();
			PreparedStatement ps = con.prepareStatement(sql))
		   { 
			ps.setInt(1, upSA.getMonthsExp());
			ps.setInt(2, upSA.getSkillLevel());
			ps.setInt(3,  upSA.getSKILL_ID());
			ps.setInt(4, upSA.getDEV_ID());
			ps.setInt(5, upSA.getAssessmentID());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
