package com.sim.control;

import java.io.IOException;
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
 * Servlet implementation class DisplayPassageServlet
 */
@WebServlet(name = "displayPassage", urlPatterns = { "/displayPassage" })
public class DisplayPassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPassageServlet() {
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
		
		String userEmail=request.getParameter("userEmail");
		String title=request.getParameter("title");
		
		Passage passage=servicePassage.findPassageByTitle(title);
		
		User user=serviceUser.findByUserEmail(userEmail);
		
		session.setAttribute("passageSession", passage);
		session.setAttribute("userSession", user);
		
		session.setAttribute("userEmail", userEmail);
		session.setAttribute("title",title);
		
		request.setAttribute("passage", passage);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/DisplayPassage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String userEmail=request.getParameter("userEmail");
		
		PassageService servicePassage = new PassageService();
		UserService serviceUser=new UserService();
		
		User user=serviceUser.findByUserEmail(userEmail);
		
		String title=null;
		
		if(session.getAttribute("userEmail")!=null) {
			title=(String) session.getAttribute("title");
			
			Passage passage=servicePassage.findPassageByTitle(title);
			session.setAttribute("passageSession", passage);
			session.setAttribute("userSession", user);
			
			session.setAttribute("userEmail", userEmail);
			
			request.setAttribute("passage", passage);
			request.setAttribute("user", user);
		}else {
			title=request.getParameter("title");
			Passage passage=servicePassage.findPassageByTitle(title);
			session.setAttribute("passageSession", passage);
			session.setAttribute("userSession", user);
			
			session.setAttribute("userEmail", userEmail);
			
			request.setAttribute("passage", passage);
			request.setAttribute("user", user);
		}

		request.getRequestDispatcher("/DisplayPassage.jsp").forward(request, response);
	}

}
