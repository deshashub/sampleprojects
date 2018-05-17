package com.ibm.training.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.pojo.User;
import com.ibm.training.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addDetails(@RequestBody User user) {
		adminService.addDetails(user);
	}
	
	@RequestMapping(value="/update/{e_id}/{cno}/{address}/{salary}",method=RequestMethod.PUT)
	public void updateEmployee(@PathVariable("e_id") int e_id,@PathVariable("cno") String cno,@PathVariable("address") String address,@PathVariable("salary") String salary) {
		adminService.updateDetails(e_id,cno,address,salary);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") int e_id) {
		adminService.deleteUser(e_id);		
	}
	
	@RequestMapping(value="/viewAll",method=RequestMethod.GET)
	public Collection<User> viewEmployees() {
		Collection<User> employees=adminService.viewDetails();
		return employees;
	}
	
	@RequestMapping(value="/view/{uname}",method=RequestMethod.GET)
	public User viewAdmin(@PathVariable("uname") String uname) {
		return adminService.viewAdmin(uname);
	}
	
	
	/*@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ModelAndView updateEmployee(@RequestParam String e_id,@RequestParam String cno,@RequestParam String address,@RequestParam String salary) {
		ModelAndView mv=new ModelAndView();
		int status=adminService.updateDetails(e_id,cno,address,salary);
		if(status!=0) {
			mv.setViewName("viewadmin");
		}
		else{
			mv.setViewName("Update");
			mv.addObject("message", "Employee Details cannot be updated");
		}
		return mv;
	}
	*/
	/*@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public ModelAndView deleteEmployee(@RequestParam int e_id) {
		ModelAndView mv=new ModelAndView();
		int status=adminService.deleteUser(e_id);
		if(status!=0) {
			mv.setViewName("viewadmin");
		}
		else{
			mv.setViewName("delete");
			mv.addObject("message", "Record does not exist");
		}
		return mv;
	}*/
	
		
}
