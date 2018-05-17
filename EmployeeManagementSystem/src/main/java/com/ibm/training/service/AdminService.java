package com.ibm.training.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.training.daoimpl.UserDaoImpl;
import com.ibm.training.pojo.User;

@Service
public class AdminService {

	@Autowired
	UserDaoImpl userdaoimpl;

	public int addDetails(User user) {
		return userdaoimpl.addDetails(user);
	}
	public int updateDetails(int e_id,String c_no,String address,String salary) {
		return userdaoimpl.editById(e_id,c_no,address,salary);
	}
	public int deleteUser(int id) {
		return userdaoimpl.removeUser(id);
	}

	public Collection<User> viewDetails(){
		return userdaoimpl.findAllUsers();
	}
	public User viewAdmin(String uname){
		return userdaoimpl.viewProfile(uname);
	}

}