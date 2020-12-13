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
import com.sim.model.Style;
import com.sim.model.User;
import com.sim.service.PassageService;
import com.sim.service.StyleService;
import com.sim.service.UserService;

/**
 * Servlet implementation class PostPassageServlet
 */
@WebServlet("/PostPassage")
public class PostPassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPassageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();	
		
		StyleService styleService=new StyleService();
		List<Style> listStyle=styleService.findAll();
		
		String userEmail=request.getParameter("userEmail");
		userEmail=new String(userEmail.getBytes("iso8859-1"),"utf-8");
		
		UserService service=new UserService();
		User user=service.findByUserEmail(userEmail);
		
		session.setAttribute("userSession", user);
		
		request.setAttribute("listStyle", listStyle);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/PostPassage.jsp").forward(request, response);
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
		User user=serviceUser.findByUserEmail(userEmail);
		
		Passage passage = new Passage();
		passage.setTitle(title);
		passage.setStyle(style);
		passage.setContent(content);
		passage.setUserEmail(userEmail);
		service.addPassage(passage);
		
		session.setAttribute("userEmail", userEmail);
		session.setAttribute("title", title);
		
		session.setAttribute("passageSession", passage);
		session.setAttribute("userSession", user);
		
		request.setAttribute("user", user);
		request.setAttribute("passage", passage);
		
		request.getRequestDispatcher("/displayPassage").forward(request,response);
	}

}
