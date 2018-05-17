package com.ibm.training.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.pojo.Holiday;
import com.ibm.training.pojo.User;
import com.ibm.training.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService eservice;

	@RequestMapping("/profile")
	public User viewProfile(@PathParam("uname")String uname) {
		return eservice.viewprofile(uname);
	}

	@RequestMapping("/applyleave")
	public void applyLeave(@PathParam("id")int id,@PathParam("leave")int leave) {
		eservice.applyLeaves(id, leave);
	}

	/*@RequestMapping("/salarystatement")
	public User salaryStatement(@PathParam("uname")String uname) {
		 return eservice.salaryStat(uname);
	}*/

	@RequestMapping("/leaverecord")
	public List leaveRecord(String uname) {
		return eservice.leaveRecord(uname);
	}


}