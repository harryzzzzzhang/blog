package com.sim.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sim.model.User;
import com.sim.service.UserService;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		
		UserService service = new UserService();
		
		String userEmail=request.getParameter("userEmail");
		
		String likeUserName=request.getParameter("searchUserKeyword");

		List<User> list = service.findLikeUser(likeUserName);

		User user=service.findByUserEmail(userEmail);
		
		session.setAttribute("userSession", user);
		session.setAttribute("userEmail", userEmail);
		request.setAttribute("user", user);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/SearchUser.jsp").forward(request, response);
	}

}
