package com.sim.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sim.common.DbObject;
import com.sim.model.User;

public class UserDao {
	public UserDao(){
		
	}
	
	//用户相关
	public User add(User user){
		String sql="insert into userInformation(userEmail, userPassword) values(?,?);";
		DbObject.executeUpdate(sql, user.getUserEmail(), user.getUserPassword());
		return user;
	}
	
	public User modify(User user){
		String sql="update userInformation set userEmail=?, userNickname=?, userPassword=?, userName=?, userSex=?, userBriefIntroduction=? where userEmail=?";
		DbObject.executeUpdate(sql, user.getUserEmail(), user.getUserNickname(), user.getUserPassword(), user.getUserName(), user.getUserSex(), user.getUserBriefIntroduction(),user.getUserEmail());
		return user;
	}
	
	public User addEmailAndNickname(User registerUser) {
		String sql="insert into userInformation(userEmail, userPassword, userNickname) values(?,?,?);";
		DbObject.executeUpdate(sql, registerUser.getUserEmail(), registerUser.getUserPassword(),registerUser.getUserNickname());
		return registerUser;
	}
	
	public User deleteUser(User user) {
		String sql="delete userInformation where userEmail=?";
		DbObject.executeUpdate(sql, user.getUserEmail());
		return user;
	}
	
	
	public User findByUserEmail(String userEmail) {
		String sql = "select * from userInformation where userEmail=?";
		ResultSet rs = null;

		User user = null;
		try {
			rs = DbObject.executeQuery(sql, userEmail);
			if (rs.next()) {
				user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserNickname(rs.getString("userNickname"));
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBriefIntroduction(rs.getString("userBriefIntroduction"));
				user.setUserState(rs.getString("userState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return user;
	}
	
	public User findByUserNickname(String userNickname) {
		String sql = "select * from userInformation where userNickname=?";
		ResultSet rs = null;

		User user = null;
		try {
			rs = DbObject.executeQuery(sql, userNickname);
			if (rs.next()) {
				user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserNickname(rs.getString("userNickname"));
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBriefIntroduction(rs.getString("userBriefIntroduction"));
				user.setUserState(rs.getString("userState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return user;
	}
	
	public User findByEmailAndPassword(String userEmail, String userPassword){
		String sql="select * from userInformation where userEmail=? and userPassword=?";
		ResultSet rs=null;
		User user=null; 
		
		try {
			rs=DbObject.executeQuery(sql,userEmail, userPassword);
			if(rs.next()) {
				user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserNickname(rs.getString("userNickname"));
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBriefIntroduction(rs.getString("userBriefIntroduction"));
				user.setUserState(rs.getString("userState"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null,null,rs);
		}
		
		return user;
	}
	
	public List<User> findLikeUser(String likeUserName){
		String sql = "select * from userInformation where userName like '%"+likeUserName+"%'";
		ResultSet rs = null;

		User user = null;
		
		List<User> list=new ArrayList<User>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserNickname(rs.getString("userNickname"));
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBriefIntroduction(rs.getString("userBriefIntroduction"));
				user.setUserState(rs.getString("userState"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	//管理员相关
	public User findManagerByEmailAndPassword(String managerEmail, String managerPassword){
		String sql="select * from manager where managerEmail=? and managerPassword=?";
		ResultSet rs=null;
		User user=null; 
		
		try {
			rs=DbObject.executeQuery(sql,managerEmail, managerPassword);
			if(rs.next()) {
				user=new User(null, null);
				user.setUserEmail(rs.getString("managerEmail"));
				user.setUserPassword(rs.getString("managerPassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null,null,rs);
		}
		
		return user;
	}
	
	public User findManagerByEmail(String managerEmail){
		String sql="select * from manager where managerEmail=?";
		ResultSet rs=null;
		User user=null; 
		
		try {
			rs=DbObject.executeQuery(sql,managerEmail);
			if(rs.next()) {
				user=new User(null, null);
				user.setUserEmail(rs.getString("managerEmail"));
				user.setUserPassword(rs.getString("managerPassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null,null,rs);
		}
		
		return user;
	}
	
	public List<User> findAll(){
		String sql = "select * from userInformation";
		ResultSet rs = null;

		User user = null;
		
		List<User> list=new ArrayList<User>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserNickname(rs.getString("userNickname"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserState(rs.getString("userState"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public User findUserStateByEmail(String userEmail) {
		String sql="select userState from userInformation where userEmail=?";
		ResultSet rs=null;
		User user=null; 
		
		try {
			rs=DbObject.executeQuery(sql,userEmail);
			if(rs.next()) {
				user=new User(null, null);
				user.setUserState(rs.getString("userState"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null,null,rs);
		}
		
		return user;
	}
	
	public User disableUser(User user) {
		String sql="update userInformation set userState='0' where userEmail=?";
		DbObject.executeUpdate(sql, user.getUserEmail());
		return user;
	}
	
	public User activeUser(User user) {
		String sql="update userInformation set userState='1' where userEmail=?";
		DbObject.executeUpdate(sql, user.getUserEmail());
		return user;
	}
}
