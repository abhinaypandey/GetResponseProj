/**
 *
 * This comment is NOT a class level javadoc comment. 
 * 
 * @description: 
 * @author: singhda
 * @version: 
 *
 */
package com.amgen.getResponse.service.userProfileManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.amgen.getResponse.dao.UserDao;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.EntityManagerService;



public class UserProfileManagementServiceImpl implements UserProfileManagementService{
	private UserDao userDAO;

	public void service(String action,User user) throws FileNotFoundException, IOException {
		
			if(action.equalsIgnoreCase("displayUser"))
		// TODO Auto-generated method stub
		System.out.println("check user");
		//String uname;
		//String pword;
		User u=new User();
	String uname=u.getUsername();
		
		userDAO.displayUser(uname);
	}
	
	@Override
	public Integer saveUserProfile(User user) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	//public User updateUserProfile(String uname) {
	//	return null;
		// TODO Auto-generated method stub
		
	//}

	public void service() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(String str, Object obj) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public User updateUserProfile(String uname) {
		// TODO Auto-generated method stub
		return null;
	}
}
