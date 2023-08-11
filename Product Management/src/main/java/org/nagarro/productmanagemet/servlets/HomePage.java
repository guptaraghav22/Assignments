package org.nagarro.productmanagemet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "homepage", value = "/home")
public class HomePage extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request ,HttpServletResponse response)  throws IOException,ServletException {
        request.getRequestDispatcher("LoginAttempt.java").forward(request,response);
    }

}
