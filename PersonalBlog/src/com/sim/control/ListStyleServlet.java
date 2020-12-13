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
 * Servlet implementation class ListStyleServlet
 */
@WebServlet("/ListStyle")
public class ListStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStyleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StyleService styleService=new StyleService();
		List<Style> listStyle=styleService.findAll();
		
		request.setAttribute("listStyle", listStyle);
		
		request.getRequestDispatcher("/listStyle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String inputStyle=request.getParameter("inputStyle");
		StyleService service=new StyleService();
		
		
		Style style=new Style();
		style.setStyle(inputStyle);
		service.addStyle(style);
		
		List<Style> listStyle=service.findAll();
		request.setAttribute("listStyle", listStyle);
		request.getRequestDispatcher("/listStyle.jsp").forward(request, response);
	}

}
