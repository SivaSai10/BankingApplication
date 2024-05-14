package BankAppServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BankAppClasses.userinfo;

@WebServlet("/AddbankServlet1")
public class AddbankServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddbankServlet1() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userinfo suser = (userinfo)request.getAttribute("user1");
		if(suser!= null) {
			request.setAttribute("uname", suser);
			RequestDispatcher rd =  request.getRequestDispatcher("/Addbankpage.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");
			response.getWriter().write("-----Enter correct username and password----- ");
			RequestDispatcher rd =  request.getRequestDispatcher("/Loginpage.jsp");
			rd.include(request, response);
		}
		
	}

}
