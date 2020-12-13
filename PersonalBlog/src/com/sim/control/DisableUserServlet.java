package com.sim.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sim.model.User;
import com.sim.service.UserService;

/**
 * Servlet implementation class DisableUserServlet
 */
@WebServlet(name = "disableUser", urlPatterns = { "/disableUser" })
public class DisableUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisableUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userEmail=request.getParameter("userEmail");
		userEmail=new String(userEmail.getBytes("iso8859-1"),"utf-8");
		
		UserService service=new UserService();
		User user=service.findByUserEmail(userEmail);
		
		request.setAttribute("user", user);
		
		service.disableUser(user);

		request.getRequestDispatcher("ListUser").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
