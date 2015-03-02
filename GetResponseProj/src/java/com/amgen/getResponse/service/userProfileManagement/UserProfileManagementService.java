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

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;

public interface UserProfileManagementService extends BusinessService {
	public Integer saveUserProfile(User user);
	public User updateUserProfile(String uname);
	

}
