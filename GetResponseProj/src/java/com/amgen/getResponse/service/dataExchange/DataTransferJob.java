package com.amgen.getResponse.service.dataExchange;
import org.quartz.*;
import com.amgen.getResponse.service.dataExchange.DataExchangeServiceImpl;

public class DataTransferJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		try {
			DataExchangeServiceImpl exchngObj=new DataExchangeServiceImpl();
			exchngObj.DataTransfer();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	}

}
