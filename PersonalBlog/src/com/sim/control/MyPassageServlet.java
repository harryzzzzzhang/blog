package com.sim.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sim.model.Passage;
import com.sim.model.User;
import com.sim.service.PassageService;
import com.sim.service.UserService;

/**
 * Servlet implementation class MyPassage
 */
@WebServlet("/MyPassage")
public class MyPassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPassageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		PassageService servicePassage = new PassageService();
		UserService serviceUser=new UserService();
		
		String userEmail=null;
		
		if(session.getAttribute("userEmail")!=null) {
			userEmail=(String) session.getAttribute("userEmail");
		}else {
			userEmail=request.getParameter("userEmail");
		}
		
		List<Passage> list=servicePassage.findPassageByUserEmail(userEmail);
		User user=serviceUser.findByUserEmail(userEmail);

		session.setAttribute("userSession", user);
		
		request.setAttribute("list", list);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/MyPassage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		PassageService servicePassage = new PassageService();
		UserService serviceUser=new UserService();
		
		String userEmail=null;
		
		if(session.getAttribute("userEmail")!=null) {
			userEmail=(String) session.getAttribute("userEmail");
		}else {
			userEmail=request.getParameter("userEmail");
		}
		
		List<Passage> list=servicePassage.findPassageByUserEmail(userEmail);
		User user=serviceUser.findByUserEmail(userEmail);
		
		session.setAttribute("userSession", user);
		
		request.setAttribute("list", list);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/MyPassage.jsp").forward(request, response);
	}

}
