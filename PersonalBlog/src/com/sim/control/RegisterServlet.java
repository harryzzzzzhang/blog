package com.sim.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sim.model.User;
import com.sim.service.UserService;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "Register", urlPatterns = { "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String email=request.getParameter("inputEmail");
		String password=request.getParameter("inputPassword");
		String nickname=request.getParameter("inputNickname");
		
		UserService service = new UserService();
		User registerUser = new User(null,null, null);
		
		registerUser.setUserEmail(email);
		registerUser.setUserPassword(password);
		registerUser.setUserNickname(nickname);
		
		if (service.exists(email)) {
			request.setAttribute("errorMessage", "电子邮箱已经存在！请直接登陆！");
			request.setAttribute("user",registerUser);
			request.setAttribute("nickname",nickname);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}else {
			service.addEmailAndNickname(registerUser);
			request.getRequestDispatcher("/RegisterSuccess.jsp").forward(request, response);
		}
		
	}
}

