package com.amgen.getResponse.service.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.exception.dao.DaoException;
import com.amgen.getResponse.dao.*;
public  class AdminManagerServiceImpl implements AdminManagerService {
	private UserDao userDAO;
		
	@Override
	public void service(String action,User user) throws FileNotFoundException, IOException {

		// TODO Auto-generated method stub
		if (action.equalsIgnoreCase("add")) {
			System.out.println("user");
			try {
				userDAO.addUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equalsIgnoreCase("userlogin"))
		{
			System.out.println("check user");
			String uname;
			String pword;
			User u=new User();
			uname=u.getUsername();
			pword=u.getPassword();
			userDAO.userLogin(uname, pword);
		}
		
		if(action.equalsIgnoreCase("delete"))
		{
			System.out.println("delete user");
		    String username;
			User u=new User();
			username=u.getUsername();
			userDAO.deleteUser(username);
		}

		if(action.equalsIgnoreCase("displayUser"))
	// TODO Auto-generated method stub
	System.out.println("check user");
		String uname1;
	//String uname;
	//String pword;
	User u=new User();
	uname1=u.getUsername();
	userDAO.displayUser(uname1);
}
		
		

	

	@Override
	public Integer addProducts(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addChannel(Channel channel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
}





