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
 * Servlet implementation class ManagerModifyPassageServlet
 */
@WebServlet(name = "managerModifyPassage", urlPatterns = { "/managerModifyPassage" })
public class ManagerModifyPassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerModifyPassageServlet() {
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
		
		String title=request.getParameter("title");
		
		Passage passage=servicePassage.findPassageByTitle(title);
		User user=serviceUser.findByUserEmail(passage.getUserEmail());
		
		session.setAttribute("passageSession", passage);
		session.setAttribute("userSession", user);
		
		request.setAttribute("passage", passage);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/ManagerModifyPassage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		
		String title=request.getParameter("inputPassageTitle");
		String style=request.getParameter("inputPassageStyle");
		String content=request.getParameter("inputPassageContent");
		String userEmail=request.getParameter("userEmail");
		
		PassageService service =new PassageService();
		UserService serviceUser=new UserService();
		
		Passage passage = new Passage();
		User user=serviceUser.findByUserEmail(userEmail);
		
		passage.setTitle(title);
		passage.setStyle(style);
		passage.setContent(content);
		passage.setUserEmail(userEmail);
	
		service.updatePassage(passage);
		
		session.setAttribute("userEmail", userEmail);
		session.setAttribute("title", title);
		
		session.setAttribute("passage", passage);
		session.setAttribute("userSession", user);
		
		request.setAttribute("title", title);
		request.setAttribute("user", user);
		request.setAttribute("passage", passage);

		request.getRequestDispatcher("/managerDisplayPassage").forward(request,response);
	}

}
