package com.ibm.training.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int e_id;
	private String e_name;
	private int d_id;
	private int hr_id;
	private String dob;
	private String c_no;
	private String address;
	private String gender;
	private String doj;
	private String loc;
	private String role;
	private String uname;
	private String pwd;
	private String sal;
	private String dpt;
	
	public User() {}
	
	public User(int e_id, String e_name, int d_id, int hr_id, String dob, String c_no, String address, String gender,
			String doj, String loc, String role, String uname, String pwd, String sal, String dpt, String pname) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.d_id = d_id;
		this.hr_id = hr_id;
		this.dob = dob;
		this.c_no = c_no;
		this.address = address;
		this.gender = gender;
		this.doj = doj;
		this.loc = loc;
		this.role = role;
		this.uname = uname;
		this.pwd = pwd;
		this.sal = sal;
		this.dpt = dpt;
	}
	
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getE_id() {
		return e_id;
	}
	
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getHr_id() {
		return hr_id;
	}
	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getC_no() {
		return c_no;
	}
	public void setC_no(String c_no) {
		this.c_no = c_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}

	
}

