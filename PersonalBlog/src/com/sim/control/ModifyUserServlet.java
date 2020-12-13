package com.sim.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sim.model.User;
import com.sim.service.UserService;

/**
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/modifyUser")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		String userEmail=request.getParameter("userEmail");
		userEmail=new String(userEmail.getBytes("iso8859-1"),"utf-8");
		
		UserService service=new UserService();
		User user=service.findByUserEmail(userEmail);
		
		session.setAttribute("userSession", user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/modifyUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		String userEmail=request.getParameter("inputUserEmail");
		String userNickname=request.getParameter("inputUserNickname");
		String userPassword=request.getParameter("inputUserPassword");
		String userName=request.getParameter("inputUserName");
		String userSex=request.getParameter("inputUserSex");
		String userBriefIntroduction=request.getParameter("inputUserBriefIntroduction");

		UserService service =new UserService();
		
		User user = new User();
		
		user.setUserEmail(userEmail);
		user.setUserNickname(userNickname);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setUserBriefIntroduction(userBriefIntroduction);
	
		service.modifyUser(user);
		
		request.getRequestDispatcher("ListUser").forward(request,response);
	}

}
