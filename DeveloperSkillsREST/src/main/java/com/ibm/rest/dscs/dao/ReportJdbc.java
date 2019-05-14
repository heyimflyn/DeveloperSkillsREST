package com.ibm.rest.dscs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.rest.dscs.dao.DatabaseConnection;
import com.ibm.rest.dscs.domain.Report;

public class ReportJdbc implements ReportDao{
	
	DatabaseConnection JDBC;
	
	@Override
	public List<Report> getReport() {
		List<Report> reports = new ArrayList<Report>();
		try {
			Connection con = JDBC.getConnection(); 
			String query = "SELECT skill.SKILL_ID AS SKILL_ID, "
					+ "skill.SkillName AS SkillName,"
					+ "COUNT(skillassessment.AssessmentId) AS total,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 0 THEN 1 END) AS Trained,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 1 THEN 1 END) AS Novice,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 2 THEN 1 END) AS Proficient,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 3 THEN 1 END) AS Advanced,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 4 THEN 1 END) AS Expert,"
					+ "COUNT(CASE WHEN skillassessment.SkillLevel = 5 THEN 1 END) AS ThoughtLeader "
					+ "FROM skillassessment "
					+ "INNER JOIN skill "
					+ "ON skillassessment.SKILL_ID = skill.SKILL_ID "
					+ "GROUP BY skillassessment.SKILL_ID";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int SKILL_ID = rs.getInt("SKILL_ID");
				String SkillName = rs.getString("SkillName");
				int Trained = rs.getInt("Trained");
				int Novice = rs.getInt("Novice");
				int Proficient = rs.getInt("Proficient");
				int Advanced = rs.getInt("Advanced");
				int Expert = rs.getInt("Expert");
				int ThoughtLeader = rs.getInt("ThoughtLeader");
				int Total = rs.getInt("Total");
				Report report = new Report(SKILL_ID,SkillName,Trained,Novice,Proficient,Advanced,Expert,ThoughtLeader,Total);
				reports.add(report);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reports;		
	}

}
