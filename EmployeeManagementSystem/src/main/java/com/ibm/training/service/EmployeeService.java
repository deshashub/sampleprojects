package com.ibm.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.UserDaoImpl;
import com.ibm.training.pojo.Holiday;
import com.ibm.training.pojo.User;


@Service
public class EmployeeService {

	@Autowired
	UserDaoImpl userdaoimpl;

	public User viewprofile(String uname) {
		return userdaoimpl.viewProfile(uname);
	}

	public void applyLeaves(int id,int leave) {
		userdaoimpl.applyLeave(id,leave);
	}

	/*public User salaryStat(String uname) {
		return userdaoimpl.salaryStmt(uname);
	}*/
	
	public List leaveRecord(String uname) {
		return userdaoimpl.leaveRecord(uname);
	}
}