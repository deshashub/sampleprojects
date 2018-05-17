package com.ibm.training.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.UserDaoImpl;
import com.ibm.training.pojo.Holiday;
import com.ibm.training.pojo.User;

@Service
public class HRService {

	@Autowired
	UserDaoImpl userDaoImpl;

	public User viewProfile(String uname) {
		return userDaoImpl.viewProfile(uname);
	}

	public Collection<User> viewEmpDetails(String uname) {
		return userDaoImpl.viewEmpDetails(uname);
	}

/*	public Collection<Holiday> leaveRequests(String uname) {
		return hrDaoImpl.leaveRequests(uname);
	}*/

	public void applyLeave(int id, int leave) {
		userDaoImpl.applyLeave(id, leave);
	}

	/*public User salaryStmt(String uname) {
		return userDaoImpl.salaryStmt(uname);
	}*/
	
	public List leaveRecord(String uname) {
		return userDaoImpl.leaveRecord(uname);
	}
}
