package com.ibm.training.controllers;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.pojo.Holiday;
import com.ibm.training.pojo.User;
import com.ibm.training.service.HRService;

@RestController
@RequestMapping("/hr")
public class HRController {
	
	@Autowired
	HRService hservice;

	@RequestMapping("/profile/{uname}")
	public User viewProfile(@PathVariable("uname") String uname) {
		return hservice.viewProfile(uname);
	}

	@RequestMapping("/view/{uname}")
	public Collection<User> viewEmpDetails(@PathVariable("uname") String uname) {
		return hservice.viewEmpDetails(uname);
	}

	@RequestMapping("/applyleave/{id}/{leave}")
	public void applyLeave(@PathVariable("id") int id,@PathVariable("leave") int leave) {
		hservice.applyLeave(id,leave);
	}

	@RequestMapping("/leaverecord/{uname}")
	public List leaveRecord(@PathVariable("uname") String uname) {
		return hservice.leaveRecord(uname);
	}

	/*@RequestMapping("/salstmt/{uname}")
	public User salaryStmt(@PathVariable("uname") String uname) {
		return hservice.salaryStmt(uname);
	}*/

}
