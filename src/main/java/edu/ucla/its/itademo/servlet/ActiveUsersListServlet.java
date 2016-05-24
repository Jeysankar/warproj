package edu.ucla.its.itademo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.ucla.its.itademo.bao.UserBao;
import edu.ucla.its.itademo.util.User;

@WebServlet(name = "ActiveUsersList", urlPatterns = { "/GetActiveUsers" })
public class ActiveUsersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(ActiveUsersListServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
				UserBao userBao =  (UserBao) getServletContext().getAttribute("UserBao");
				List<User> userList = userBao.filterUsersList();
			
				if( userList != null && userList.size() > 0 ) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/display.jsp");
				request.setAttribute("Users", userList);
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				PrintWriter out= response.getWriter();
				logger.error("No users found!");
				out.println("<font color=red>No user found.</font>");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception : " + e.getLocalizedMessage() );
			throw new ServletException("Exception : " + e.getLocalizedMessage());
		}
		}
}