package com.ibm.rest.dscs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.rest.dscs.dao.DatabaseConnection;
import com.ibm.rest.dscs.dao.DeveloperDao;
import com.ibm.rest.dscs.domain.Developer;

public class DeveloperJdbc implements DeveloperDao{
	
	DatabaseConnection JDBC;
	private static DeveloperJdbc INSTANCE;

	static public DeveloperJdbc getInstance() {

		DeveloperJdbc instance;
		if (INSTANCE != null) {
			instance = INSTANCE;
		} else {
			instance = new DeveloperJdbc();
			INSTANCE = instance;
		}

		return instance;
	}
	
	public DeveloperJdbc() {
		JDBC = new DatabaseConnection();
	}
	
	@Override
	public List<Developer> findAll() {
		List<Developer> devs = new ArrayList<Developer>();

		String sql = "SELECT DEV_ID, Firstname, Middlename, Lastname, Birthdate, Position FROM DEVELOPERS ORDER BY Firstname, Middlename, Lastname";
		try (Connection con = JDBC.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			      ResultSet rs = ps.executeQuery())
		    {
		
			while (rs.next()) {
				int DEV_ID = rs.getInt("DEV_ID");
				String Firstname = rs.getString("Firstname");
				String Middlename = rs.getString("Middlename");
				String Lastname = rs.getString("Lastname");
				Date Birthdate = rs.getDate("Birthdate");
				String Position = rs.getString("Position");
				Developer dev = new Developer(DEV_ID, Firstname,Middlename,Lastname,(java.sql.Date) Birthdate,Position);
				devs.add(dev);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return devs;
	}
	
	@Override
	public void addDeveloper(Developer adddev) {
		
		String sql = "INSERT INTO DEVELOPERS (Firstname, Middlename, Lastname, Birthdate, Position) values (?,?,?,?,?)";
		
		try (Connection con = JDBC.getConnection(); 
			 PreparedStatement ps = con.prepareStatement(sql))
		    { 
			ps.setString(1, adddev.getFirstname());
			ps.setString(2, adddev.getMiddlename());
			ps.setString(3, adddev.getLastname());
			ps.setDate(4, adddev.getBirthdate());
			ps.setString(5, adddev.getPosition());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}
/*	@Override
	public Developer find(Long devID) {
		
		Developer dev = null;
		
		if (devID != null) {
			String sql = "SELECT * FROM DEVELOPERS WHERE DEV_ID = ?";
			try (Connection con = getConnection();
			     PreparedStatement ps = con.prepareStatement(sql))
			   
				{
				ps.setInt(1, devID.intValue()); 
				   ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					dev = new Developer(Long.valueOf(rs.getInt("devID")), 
							 rs.getString("firstname"),
			                 rs.getString("middlename"),
			                 rs.getString("lastname"),
			                 rs.getString("birthdate"),
	                         rs.getString("position"));

				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		return dev;
	}
	
	@Override
	public List<Developer> findByName(String firstname, String lastname) {
		List<Developer> devs = new ArrayList<>();

		String sql = "SELECT DEV_ID, FIRSTNAME, LASTNAME FROM DEVELOPERS WHERE FIRSTNAME LIKE ? AND LASTNAME LIKE ?";

		try (Connection con = getConnection();
			  PreparedStatement ps = con.prepareStatement(sql))
		    {
			ps.setString(1, createSearchValue(firstname));
			ps.setString(2, createSearchValue(lastname));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Developer dev = new Developer(Long.valueOf(rs.getInt("devID")), 
						                 rs.getString("firstname"),
						                 rs.getString("lastname"));
				                         devs.add(dev);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return devs;
	} 
	
	private String createSearchValue(String string) {
		
		String value;
		
		if (StringUtils.isBlank(string)) {
			value = "%";
		} else {
			value = string;
		}
		
		return value;
	}
	
*/

}

