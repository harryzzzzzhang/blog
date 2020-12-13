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
 * Servlet implementation class DeletePassageServlet
 */
@WebServlet(name = "deletePassage", urlPatterns = { "/deletePassage" })
public class DeletePassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePassageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String title=request.getParameter("title");

		String userEmail=request.getParameter("userEmail");
		
		PassageService service=new PassageService();
		UserService serviceUser=new UserService();

		Passage passage=service.findPassageByTitle(title);
		User user=serviceUser.findByUserEmail(userEmail);

		request.setAttribute("passage", passage);
		request.setAttribute("user", user);
		session.setAttribute("title",title);
		
		session.setAttribute("userSession", user);
		session.setAttribute("passageSession", passage);
		
		service.deletePassage(passage);
		

		

		request.getRequestDispatcher("MyPassage").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
