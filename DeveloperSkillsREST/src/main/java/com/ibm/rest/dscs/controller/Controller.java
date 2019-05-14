package com.ibm.rest.dscs.controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.rest.dscs.domain.Developer;
import com.ibm.rest.dscs.service.DeveloperService;
import com.ibm.rest.dscs.service.DeveloperServiceImpl;
import com.ibm.rest.dscs.domain.Skill;
import com.ibm.rest.dscs.service.SkillService;
import com.ibm.rest.dscs.service.SkillServiceImpl;
import com.ibm.rest.dscs.domain.SkillAssessment;
import com.ibm.rest.dscs.service.SkillAssessmentService;
import com.ibm.rest.dscs.service.SkillAssessmentServiceImpl;

@Path("/dscs")
public class Controller {
	
	@GET
	@Path("/findSkills")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Skill> findSkill() {
		
		try {
			SkillService skillservice = new SkillServiceImpl();
			return skillservice.findAll();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@POST
	@Path("/addSkill")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkill(Skill skill) {
		
		try {
			SkillService skillservice = new SkillServiceImpl();
			skillservice.addSkill(skill);
			String result = "Skill saved!" + "\nSkill Name: " 
			   + skill.getSkillName();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@GET
	@Path("/findDevelopers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Developer> findDeveloper(
			@QueryParam("DEV_ID") int DEV_ID,
			@QueryParam("Firstname") String Firstname,
			@QueryParam("Middlename") String Middlename,
			@QueryParam("Lastname") String Lastname,
			@QueryParam("Birthdate") Date Birthdate,
			@QueryParam("Position") String Position) {
		
		try {
			DeveloperService devservice = new DeveloperServiceImpl();
			return devservice.findAll();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@POST
	@Path("/addDeveloper")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDeveloper(Developer dev) {
		
		try {
			DeveloperService devservice = new DeveloperServiceImpl();
			devservice.addDeveloper(dev);
			String result = "Developer added!" +"\nName: " 
					+ dev.getFirstname() + " " 
					+ dev.getMiddlename() + " "
					+ dev.getLastname() + " \nBirthdate: " 
					+ dev.getBirthdate() + "\nPosition: "
					+ dev.getPosition();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@GET
	@Path("/findSA")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkillAssessment> findSkillAssessment() {
		
		try {
			SkillAssessmentService SAservice = new SkillAssessmentServiceImpl();
			return SAservice.findAll();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@POST
	@Path("/addSA")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkillAssessment(SkillAssessment addSA) {
		
		try {
			SkillAssessmentService SAservice = new SkillAssessmentServiceImpl();
			SAservice.addSkillAssessment(addSA);
			String result = "Skill Assessment saved!" + "\nSkill Name: " 
			    + addSA.getSkillName() + "\nMonths Experience: "
				+ addSA.getMonthsExp() + "\nSkill Level: "
			    + addSA.getSkillLevel() + "\nDeveloper ID: " 
				+ addSA.getDEV_ID();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}

	@PUT
	@Path("/updateSA")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkillAssessment(SkillAssessment upSA) {

		try {
			SkillAssessmentService SAservice = new SkillAssessmentServiceImpl();
			SAservice.updateSkillAssessment(upSA);
			String result = "Skill Assessment updated!" + "\nSkill Name:" 
			    + upSA.getSkillName() + "\nMonths Experience: "
				+ upSA.getMonthsExp() + "\nSkill Level: " 
			    + upSA.getSkillLevel() + "\nDeveloper ID: " 
				+ upSA.getDEV_ID();
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
}
