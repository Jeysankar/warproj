package edu.ucla.its.itademo.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.ucla.its.itademo.service.MessageService;
import edu.ucla.its.itademo.util.User;

@WebServlet(name = "SendTestEmail", urlPatterns = { "/SendTestEmail" })
public class SendTestEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(SendTestEmailServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");

		try {
				//Send email 
				MessageService messageService = (MessageService) getServletContext().getAttribute("MessageService");
				User user = new User(name, email, null, null ); //TODO
				messageService.sendMessage(user);
				
				logger.info("Sent email successful to: "+email);
							
				//forward to login page to login
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/emailsent.html");
				rd.include(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception:" + e.getLocalizedMessage());
				throw new ServletException("Exception:" + e.getLocalizedMessage());
			}
		}
	}