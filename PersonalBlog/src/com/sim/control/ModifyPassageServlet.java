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
 * Servlet implementation class ModifyPassageServlet
 */
@WebServlet(name = "modifyPassage", urlPatterns = { "/modifyPassage" })
public class ModifyPassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPassageServlet() {
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
		
		request.setAttribute("passage", passage);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/modifyPassage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		
		String title=request.getParameter("inputPassageTitle");
		String content=request.getParameter("inputPassageContent");
		String userEmail=request.getParameter("userEmail");
		
		PassageService service =new PassageService();
		UserService serviceUser=new UserService();
		
		Passage passage = new Passage();
		User user=serviceUser.findByUserEmail(userEmail);
		
		passage.setTitle(title);
		passage.setContent(content);
		passage.setUserEmail(userEmail);
	
		service.updatePassage(passage);
		
		session.setAttribute("userEmail", userEmail);
		
		session.setAttribute("passageSession", passage);
		session.setAttribute("userSession", user);
		
		request.setAttribute("user", user);
		request.setAttribute("passage", passage);
		
		request.getRequestDispatcher("/MyPassage").forward(request,response);
	}

}
