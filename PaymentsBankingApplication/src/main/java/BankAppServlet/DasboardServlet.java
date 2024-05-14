package BankAppServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankAppClasses.userinfo;

@WebServlet("/DasboardServlet")
public class DasboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DasboardServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		HttpSession session = request.getSession();
		userinfo suser = (userinfo)request.getAttribute("user");
		if(suser!= null) {
			request.setAttribute("uname", suser);
			RequestDispatcher rd =  request.getRequestDispatcher("/Dashboardpage.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");
			response.getWriter().write("-----Enter correct username and password----- ");
			RequestDispatcher rd =  request.getRequestDispatcher("/Loginpage.jsp");
			rd.include(request, response);
		}
		
	}

}
