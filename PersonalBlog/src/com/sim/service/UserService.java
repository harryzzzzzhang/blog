package com.sim.service;

import java.util.List;
import com.sim.Dao.UserDao;
import com.sim.model.User;

public class UserService {

	//普通用户相关
	public boolean loginVerify(String userEmail,String userPassword){
		UserDao dao=new UserDao();
		
		User user=dao.findByUserEmail(userEmail);
		
		if (user==null){
			return false;
		}else{
			if (user.getUserPassword().equals(userPassword)){
				return true;
			}else{
				return false;
			}
		}
		
	}

	public User addUser(User user){
		UserDao dao=new UserDao();
		User newUser=dao.add(user);
		return newUser;
	}
	
	public User addEmailAndNickname(User registerUser){
		UserDao dao=new UserDao();
		User newUser=dao.addEmailAndNickname(registerUser);
		return newUser;
	}
	
	public User findByUserEmail(String userEmail){
		UserDao dao=new UserDao();
		return dao.findByUserEmail(userEmail);
	}
	
	public User findByUserNickname(String userNickname){
		UserDao dao=new UserDao();
		return dao.findByUserNickname(userNickname);
	}
	
	public User findByEmailAndPassword(String email, String password) {
		UserDao dao=new UserDao();
		return dao.findByEmailAndPassword(email,password);
	}
	
	public boolean exists(String userEmail){
		User user=this.findByUserEmail(userEmail);
		if (user==null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean exists(String email, String password) {
		User user=this.findByEmailAndPassword(email,password);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public User modifyUser(User user){
		UserDao dao=new UserDao();
		User newUser=dao.modify(user);
		return newUser;
	}
	
	
	public List<User> findLikeUser(String likeUserName){
		UserDao dao=new UserDao();
		return dao.findLikeUser(likeUserName);
	}
	//管理员相关
	public List<User> findAll(){
		UserDao dao=new UserDao();
		return dao.findAll();
	}
	
	public User findManagerByEmailAndPassword(String email, String password) {
		UserDao dao=new UserDao();
		return dao.findManagerByEmailAndPassword(email,password);
	}
	
	public User findManagerByEmail(String email) {
		UserDao dao=new UserDao();
		return dao.findManagerByEmail(email);
	}
	
	public User deleteUser(User user) {
		UserDao dao=new UserDao();
		User newUser=dao.deleteUser(user);
		return newUser;
	}
	
	public boolean existsManager(String email, String password) {
		User user=this.findManagerByEmailAndPassword(email,password);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean existsManager(String userEmail){
		User user=this.findManagerByEmail(userEmail);
		if (user==null){
			return false;
		}else{
			return true;
		}
	}

	public User findUserStateByEmail(String userEmail) {
		UserDao dao=new UserDao();
		return dao.findUserStateByEmail(userEmail);
	}
	
	public boolean existsUserStateTrue(String userEmail) {
		User user=this.findUserStateByEmail(userEmail);
		if (user.getUserState().equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	public User disableUser(User user) {
		UserDao dao=new UserDao();
		User newUser=dao.disableUser(user);
		return newUser;
	}
	
	public User activeUser(User user) {
		UserDao dao=new UserDao();
		User newUser=dao.activeUser(user);
		return newUser;
	}
}
