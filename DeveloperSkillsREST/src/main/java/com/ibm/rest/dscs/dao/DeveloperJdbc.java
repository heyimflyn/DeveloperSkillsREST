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

//-----------------FIND DEVELOPERS----------------------------------	
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

//-----------------ADD DEVELOPER----------------------------------	
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
//-----------------DELETE DEVELOPER----------------------------------	
	@Override
	public void delDeveloper(int DEV_ID) {
		String sql = "DELETE FROM DEVELOPERS WHERE DEV_ID = ?";

		try (Connection con = JDBC.getConnection();
		     PreparedStatement ps = con.prepareStatement(sql))
			{ 
			ps.setInt(1, DEV_ID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}
}

