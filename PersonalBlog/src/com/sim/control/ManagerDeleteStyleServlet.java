package com.sim.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sim.model.Style;
import com.sim.service.StyleService;

/**
 * Servlet implementation class ManagerDeleteStyleServlet
 */
@WebServlet("/deleteStyle")
public class ManagerDeleteStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteStyleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getStyle=request.getParameter("style");
		
		StyleService service=new StyleService();
		Style style=service.findStyle(getStyle);
		service.deleteStyle(style);
		
		List<Style> listStyle=service.findAll();
		request.setAttribute("listStyle", listStyle);
		request.getRequestDispatcher("/listStyle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
