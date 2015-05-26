package com.amgen.getResponse.service.dataExchange;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.amgen.getResponse.service.dataExchange.CronJob;

/**
 * Servlet implementation class CronInitializationServlet
 */
@WebServlet(description = "Initializes Cron Job", urlPatterns = { "/CronInitializationServlet" })
public class CronInitializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Scheduler sched;
	private CronJob cronJob;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() throws ServletException{
		try{
			System.out.println("cron schedular started now ");
			cronJob=new CronJob();
			cronJob.configureScheduler();
			cronJob.startScheduler();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
			
	}
	
	public void destroy() {
		
		cronJob.stopScheduler();
		
	}
	
    public CronInitializationServlet() {
    	
        super();
        System.out.println("schedular now initialized");
        sched=null;
        cronJob=null;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}
