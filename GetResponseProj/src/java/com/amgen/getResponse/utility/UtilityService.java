package com.amgen.getResponse.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.amgen.getResponse.dao.UserDao;
import com.amgen.getResponse.dao.UserDaoImpl;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.exception.dao.DaoException;


public class UtilityService {
	//private static final List<com.amgen.getResponse.entity.userProfileManagement.User> User = null;

	
	public static boolean addUser(User user) throws Exception{
	UserDao DAO = new UserDaoImpl();
			DAO.addUser(user);
		return false;
		}
		
	
	public static boolean userLogin(String uname,String pword) throws Exception{
		UserDao DAO = new UserDaoImpl();
				DAO.userLogin(uname, pword);
				return true;
			}

	
    public static boolean deleteUser(String uname){
	UserDao DAO = new UserDaoImpl();
	DAO.deleteUser(uname);
        return true;
}
    
    public static User updateUser(User u){
    	UserDao DAO = new UserDaoImpl();
    	DAO.updateUser(u);
            return u;
    }
    public static User getUser(String username){
		UserDao DAO = new UserDaoImpl();
		User u;
		u = DAO.getUser(username);
	        return u;
	}
	
	public static List<User> getUsers(){
		System.out.println("hello user");
		UserDao DAO = new UserDaoImpl();
		List<User> s;
    	s =  DAO.getUsers();
		return s;
		}
	public static List<User> displayUser(String uname1){
		UserDao DAO = new UserDaoImpl();
		List<User> u;
		u = DAO.displayUser(uname1);
	        return u;
	}
	

	
		


}
