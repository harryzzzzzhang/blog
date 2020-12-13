package com.sim.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sim.model.Comment;
import com.sim.model.Passage;
import com.sim.model.User;
import com.sim.service.CommentService;
import com.sim.service.PassageService;
import com.sim.service.UserService;

/**
 * Servlet implementation class PassageContentServlet
 */
@WebServlet(name = "passageContent", urlPatterns = { "/passageContent" })
public class PassageContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassageContentServlet() {
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
		CommentService serviceComment=new CommentService();
		
		String passageAuthor=request.getParameter("passageAuthor");
		String title=request.getParameter("title");
		
		String userEmail=null;
		if(request.getParameter("userEmail")!=null) {
			userEmail=request.getParameter("userEmail");
			User user=serviceUser.findByUserEmail(userEmail);
			session.setAttribute("userSession", user);
			request.setAttribute("user", user);
		} else {
			session.setAttribute("userSession", null);
		}
		
		Passage passage=servicePassage.findPassageByTitle(title);
		User userAuthor=serviceUser.findByUserNickname(passageAuthor);
		
		if(serviceComment.existsComment(title)) {
			List<Comment> list=serviceComment.findCommentByTitle(title);
			request.setAttribute("list", list);
		} else {
			List<Comment> list= null;
			request.setAttribute("list", list);
		}
		session.setAttribute("passageSession", passage);
		
		request.setAttribute("passage", passage);
		request.setAttribute("userAuthor", userAuthor);
		request.setAttribute("passageAuthor", passageAuthor);
		
		request.getRequestDispatcher("/PassageContent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
