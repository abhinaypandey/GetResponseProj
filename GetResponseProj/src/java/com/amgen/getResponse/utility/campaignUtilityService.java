package com.amgen.getResponse.utility;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



import com.amgen.getResponse.dao.campaignDao;
import com.amgen.getResponse.entity.campaign.Subscription;



public class campaignUtilityService {
	public static List<Subscription> fetchDetails(int id) throws IOException, SQLException {
	
		campaignDao DAO = new campaignDao();
		List<Subscription> s;
        	s =  DAO.findUser(id);
		return s;	
		}
	


}
