package com.amgen.getResponse.serviceLookup;


import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.service.admin.AdminManagerServiceImpl;
import com.amgen.getResponse.service.campaign.CampaignManagerServiceImpl;
//import com.amgen.getResponse.service.dataExchange.DataExchangeService;
import com.amgen.getResponse.service.dataExchange.DataExchangeServiceImpl;
import com.amgen.getResponse.service.userProfileManagement.UserProfileManagementServiceImpl;

public class ServiceLookup {
	private static ServiceLookup serviceLookup;

	public static ServiceLookup getInstance() /*throws ServiceLookupException*/ {
		if (serviceLookup == null) {
			serviceLookup = new ServiceLookup();
		}
		return serviceLookup;
	}
	
	public BusinessService getService(String serviceType) /*throws ServiceLocatorException*/ {
		if (serviceType == null || serviceType.equals("")) {
			//throw new ServiceLocatorException(...);
			return null;
		} else {
			if(serviceType.equals("admin")) {
				System.out.println("minakshi");
				return new AdminManagerServiceImpl(); 

			} else if (serviceType.equals("campaign")) {
				return new CampaignManagerServiceImpl(); 

			} else if (serviceType.equals("dataExchange")) {
				return new DataExchangeServiceImpl(); 

			} else if (serviceType.equals("userProfileManagement")) {
				return new UserProfileManagementServiceImpl(); 

			} else {
				return null;
			}
		}	
	}

}
