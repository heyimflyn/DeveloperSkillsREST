package com.ibm.rest.dscs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.lang3.StringUtils;

import com.ibm.rest.dscs.dao.DatabaseConnection;
import com.ibm.rest.dscs.dao.SkillDao;
import com.ibm.rest.dscs.domain.Skill;

public class SkillJdbc implements SkillDao {
	
	   DatabaseConnection JDBC;
	   private static SkillJdbc INSTANCE;

		static public SkillJdbc getInstance() {

			SkillJdbc instance;
			if (INSTANCE != null) {
				instance = INSTANCE;
			} else {
				instance = new SkillJdbc();
				INSTANCE = instance;
			}

			return instance;
		}

		private SkillJdbc() {
			JDBC = new DatabaseConnection();
		}
		public Connection getConnection() {
			Connection connection = null;
			
			try {
				Class.forName("org.mariadb.jdbc.Driver"); //load driver in the program
				DriverManager.setLoginTimeout(10); //optional
				                                         //constant                //port//database //username //password
				connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/dscs","root","root");
			    System.out.println("CONNECTION: " + connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return connection;
		}
		
	  /*  private String createSearchValue(String string) {
			
			String value;
			
			if (StringUtils.isBlank(string)) {
				value = "%";
			} else {
				value = string;
			}
			
			return value;
		}*/
		
		@Override
		public List<Skill> findAll() {
			List<Skill> skills = new ArrayList<Skill>();
			
			String sql = "SELECT * FROM SKILLS ORDER BY SKILLNAME";
			
			try (Connection con = JDBC.getConnection();
				 PreparedStatement ps = con.prepareStatement(sql);
			     ResultSet rs = ps.executeQuery();)
			   {
				while (rs.next()) {
					int SKILL_ID = rs.getInt("SKILL_ID");
					String SkillName = rs.getString("SkillName");
					Skill skill = new Skill(SKILL_ID, SkillName);
					skills.add(skill);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return skills;
		}
		
		@Override
		public void addSkill(Skill addskill) { 
			
		String sql = "INSERT INTO SKILLS (SkillName) values (?)";
		
			try (Connection con = JDBC.getConnection();
			     PreparedStatement ps = con.prepareStatement(sql))
			{ 
				ps.setString(1, addskill.getSkillName());
				ps.executeUpdate();
				
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		}

		
/*
		@Override
		public Skill find(Long skillID) {
			Skill skill = null;

			if (skillID != null) { 
				String sql = "SELECT SKILL_ID, SKILL FROM SKILLS where SKILL_ID = ?";
				
				try (Connection con = getConnection();
				     PreparedStatement ps = con.prepareStatement(sql))
	               {
					
	                ps.setInt(1, skillID.intValue());
					ResultSet rs = ps.executeQuery();

					if (rs.next()) {
						skill = new Skill(Long.valueOf(rs.getInt("skillID")), 
								          rs.getString("skill"));
					}

				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}

			return skill;
		}

		@Override
		public List<Skill> findByName(String skill) {
			List<Skill> skills = new ArrayList<>();

			String sql = "SELECT SKILL_ID, SKILL FROM SKILLS WHERE SKILL LIKE ?";

			try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql))
			   {

				ps.setString(1, createSearchValue(skill));
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Skill skillss = new Skill(Long.valueOf(rs.getInt("skillID")), 
							                             rs.getString("skill"));
					                                      skills.add(skillss);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			return skills;
		}		
		*/

}