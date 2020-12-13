package com.sim.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sim.model.User;
import com.sim.service.UserService;

/**
 * Servlet implementation class ManagerLoginServlet
 */
@WebServlet(name = "ManagerLogin", urlPatterns = { "/ManagerLogin" })
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.getRequestDispatcher("/ManagerLogin.jsp").forward(request, response);
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
		User manager = new User(null,null);
		
		manager.setUserEmail(email);
		manager.setUserPassword(password);
		
		if (service.existsManager(email)) {
			if (service.existsManager(email, password)) {
				List<User> list=service.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/listUser.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "密码和电子邮箱不匹配！请重新输入！");
				request.getRequestDispatcher("/ManagerLogin.jsp").forward(request, response);

			}
		}else {
			request.setAttribute("errorMessage", "电子邮箱不存在！无权登录！");
			request.getRequestDispatcher("/ManagerLogin.jsp").forward(request, response);
		}
	}

}
