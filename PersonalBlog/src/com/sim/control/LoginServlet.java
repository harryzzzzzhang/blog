package com.sim.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sim.model.User;
import com.sim.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String email=request.getParameter("inputEmail");
		String password=request.getParameter("inputPassword");
		
		UserService service=new UserService();
		User user = new User(null,null);
		
		user.setUserEmail(email);
		user.setUserPassword(password);
		
		if (service.exists(email)) {
			if (service.exists(email, password)) {
				if(service.existsUserStateTrue(email)) {
					HttpSession session=request.getSession();
					session.setAttribute("userSession", user);
					
					user.setUserEmail(email);
					user.setUserNickname(service.findByUserEmail(email).getUserNickname());
					request.setAttribute("user", user);
			
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				request.setAttribute("errorMessage", "用户已被禁用！不允许登陆！");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			}else {
				request.setAttribute("errorMessage", "账号密码不匹配！请重新输入！");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("errorMessage", "电子邮箱不存在！请注册！");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

}
