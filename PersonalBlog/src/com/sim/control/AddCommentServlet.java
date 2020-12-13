package com.sim.control;

import java.io.IOException;
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
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		
		PassageService servicePassage = new PassageService();
		UserService serviceUser=new UserService();
		CommentService serviceComment=new CommentService();
		
		String passageAuthor=(String) request.getAttribute("passageAuthor");
		String commentContent=request.getParameter("inputComment");
		String userEmail=request.getParameter("userEmail");
		String title=request.getParameter("title");
		
		Comment comment=new Comment();
		comment.setCommentContent(commentContent);
		comment.setTitle(title);
		comment.setUserEmail(userEmail);
		serviceComment.addComment(comment);
		
		Passage passage=servicePassage.findPassageByTitle(title);
		User user=serviceUser.findByUserEmail(userEmail);
		User userAuthor=serviceUser.findByUserNickname(passageAuthor);
		
		session.setAttribute("passageSession", passage);
		session.setAttribute("userSession", user);
		session.setAttribute("passage", passage);
		session.setAttribute("title", title);
		session.setAttribute("userEmail", userEmail);
		
		request.setAttribute("userAuthor", userAuthor);
		request.setAttribute("user", user);
		request.setAttribute("passage", passage);
		request.setAttribute("title", title);
		request.setAttribute("passageAuthor", request.getParameter("passageAuthor"));
		
		request.getRequestDispatcher("passageContent").forward(request, response);
	}

}
