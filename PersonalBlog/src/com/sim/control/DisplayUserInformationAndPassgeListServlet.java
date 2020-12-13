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
 * Servlet implementation class DisplayUserInformationAndPassgeListServlet
 */
@WebServlet("/displayUserInformationAndPassgeList")
public class DisplayUserInformationAndPassgeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserInformationAndPassgeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();

		UserService serviceUser = new UserService();
		PassageService servicePassage = new PassageService();
		
		String userIn = request.getParameter("userIn");
		User user2=serviceUser.findByUserNickname(userIn);
		
		String userEmail=null;
		if(request.getParameter("userEmail")!=null) {
			userEmail=request.getParameter("userEmail");
			User user=serviceUser.findByUserEmail(userEmail);
			session.setAttribute("userSession", user);
			request.setAttribute("user", user);
		} else {
			session.setAttribute("userSession", null);
		}

		List<Passage> list=servicePassage.findPassageByUserEmail(user2.getUserEmail());

		request.setAttribute("list", list);
		
		session.setAttribute("userSession2", user2);
		request.setAttribute("user2", user2);
		
		request.getRequestDispatcher("/DisplayUserInformationAndPassgeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
