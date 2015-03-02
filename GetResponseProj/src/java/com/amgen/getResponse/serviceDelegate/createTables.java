package com.amgen.getResponse.serviceDelegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.serviceLookup.ServiceLookup;
import com.amgen.getResponse.utility.EntityManagerService;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/createTables")
public class createTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService serviceType;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createTables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessService getServiceType() {
		return serviceType;
	}


	public void setServiceType(BusinessService serviceType) {
		this.serviceType = serviceType;
	}
	public BusinessService serviceDelegate(String serviceType) /*throws ServiceException*/{
		ServiceLookup.getInstance().getService(serviceType).service();
		System.out.println("serviceType"+serviceType);

		return this.getServiceType();
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
		EntityManagerService em = new EntityManagerService();
		try {
			em.createtables();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

}
