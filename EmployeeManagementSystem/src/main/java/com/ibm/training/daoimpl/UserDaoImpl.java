package com.ibm.training.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.training.pojo.Holiday;
import com.ibm.training.pojo.User;

@Repository
public class UserDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addDetails(User user) {
		return jdbcTemplate.update("insert into user (e_name,d_id,hr_id,dob,c_no,address,gender,doj,loc,role,uname,pwd,sal,dpt)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",user.getE_name(),user.getD_id(),user.getHr_id(),user.getDob(),user.getC_no(),user.getAddress(),user.getGender(),user.getDoj(),user.getLoc(),user.getRole(),user.getUname(),user.getPwd(),user.getSal(),user.getDpt());
	}

	public Collection<User> findAllUsers(){
		return jdbcTemplate.query("select e_id,e_name,d_id,hr_id,dob,c_no,address,gender,doj,loc,role,sal,dpt from user",
				new BeanPropertyRowMapper<User>(User.class));
	}	

	public int removeUser(int id){
		return jdbcTemplate.update("delete from user where e_id=?",id);
	}

	public int editById(int e_id,String c_no,String address,String salary) {
		return jdbcTemplate.update("update user set c_no=?,address=?,sal=? where e_id=?",c_no,address,salary,e_id);
	}	

	public User viewProfile(String uname){
		return jdbcTemplate.queryForObject("select * from user where uname=?",
				new BeanPropertyRowMapper<User>(User.class),uname);
	}

	public Collection<User> viewEmpDetails(String uname){
		return jdbcTemplate.query("select * from user where role='Employee'or 'HR' and hr_id=(select e_id from user where uname=?)",
				new BeanPropertyRowMapper<User>(User.class),uname);
	}

	public void applyLeave(int id,int leave){
		jdbcTemplate.update("insert into holiday(e_id,no_of_leaves) values(?,?)",id,leave);
		//return jdbcTemplate.queryForObject("select no_of_leaves from holiday",new BeanPropertyRowMapper<Holiday>(Holiday.class));
	}

	/*public User salaryStmt(String uname) {
		
		return jdbcTemplate.queryForObject("select u.e_id,e_name,sal from holiday h,user u where hr_id=(select hr_id from user where uname=?) and u.e_id=h.e_id",
				new BeanPropertyRowMapper<User>(User.class),uname);
	}*/
	
	public List leaveRecord(String uname) {
		Connection con=null;
		List li=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","passwordadmin");
			String sql="select h.id,u.e_id,u.e_name,sum(h.no_of_leaves) from holiday h,user u where u.hr_id=(select e_id from user where uname=?) and  u.e_id=h.e_id and leavestatus='A' group by e_id";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, uname);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				li.add(rs.getInt(1));
				li.add(rs.getInt(2));
				li.add(rs.getString(3));
				li.add(rs.getInt(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return li;
		/*return jdbcTemplate.query("select h.id,u.e_id,u.e_name,h.no_of_leaves from holiday h,user u where u.hr_id=(select e_id from user where uname=?) and  u.e_id=h.e_id",
				new BeanPropertyRowMapper<Holiday>(Holiday.class),uname);*/
	}
}
