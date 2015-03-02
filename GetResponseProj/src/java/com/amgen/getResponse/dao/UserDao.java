package com.amgen.getResponse.dao;

import java.util.List;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.exception.dao.DaoException;

public interface UserDao { 
	public User addUser(User user) throws  DaoException;
	public User userLogin(String uname,String pword);
	public List<User> displayUser(String uname1);
	public void deleteUser(String uname);
	public User updateUser(User u);
	public User getUser(String username);
	public List<User> getUsers();
	
}


