package com.amgen.getResponse.serviceDelegate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.serviceLookup.ServiceLookup;
import com.amgen.getResponse.utility.UtilityService;

/**
 * Servlet implementation class getUser
 */
@WebServlet("/getUser")
public class getUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService serviceType;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getUser() {
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
		BusinessService bs = serviceDelegate(request.getParameter("serviceType"));
		String username=request.getParameter("USERNAME");
		HttpSession session = request.getSession();
		session.getAttribute("username");
		UtilityService.getUser(username);
		User us=UtilityService.getUser(username);
		//Iterator i = us.iterator();
		request.setAttribute("PASSWORD", us.getPassword());
		request.setAttribute("First_Name", us.getFirst_name());
		request.setAttribute("Last_Name", us.getLast_name());
		request.setAttribute("EMAIL", us.getEmail());
		request.setAttribute("PHONE", us.getPhone());
		request.setAttribute("USERNAME", us.getUsername());
		request.setAttribute("Address", us.getAddress());
		request.setAttribute("Fax", us.getFax());
		request.getRequestDispatcher("/update.jsp").forward(request, response);

		return;

	}

}
