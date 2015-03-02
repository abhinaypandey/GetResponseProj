package com.amgen.getResponse.serviceDelegate;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.serviceLookup.ServiceLookup;
import com.amgen.getResponse.utility.UtilityService;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/DisplayUser")
public class DisplayUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService serviceType;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayUser() {
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
		System.out.println("Dsiplay User class ..............");
		BusinessService bs = serviceDelegate(request.getParameter("serviceType"));
		UtilityService.getUsers();
		System.out.println("Returned from DOA ..............");
		List<User> us=UtilityService.getUsers();
		request.setAttribute("user", us);
		System.out.println("displatching to jsp ..............");
		request.getRequestDispatcher("/DisplayAll.jsp").forward(request, response);
		return;
	}

}
