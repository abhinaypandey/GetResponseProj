package com.amgen.getResponse.service.admin;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;

public interface AdminManagerService extends BusinessService {

	
	public Integer addProducts(Product product);
	public Integer addChannel(Channel channel);
	
	
	void service(String action, User user) throws FileNotFoundException, IOException;



}
