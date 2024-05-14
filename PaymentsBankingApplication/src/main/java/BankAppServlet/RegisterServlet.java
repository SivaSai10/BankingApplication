package BankAppServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BankAppClasses.userinfo;
import DAO.BankAppDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BankAppDAO dao = new BankAppDAO();
     
    public RegisterServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String Phone = request.getParameter("Phone");
		String DOB = request.getParameter("DOB");
		String address = request.getParameter("address");
		String MailID = request.getParameter("MailID");
		String Pword = request.getParameter("Pword");
		
		if(dao.userexistswithphono(Phone)) {
			
			response.setContentType("text/html");
			response.getWriter().write("-----user with '"+Phone+"' is already exist. Login with new number----- ");
			RequestDispatcher rd =  request.getRequestDispatcher("/Registerpage.jsp");
			rd.include(request, response);
			
		}else {
			
		
		
		userinfo user = new userinfo();
	    user.setFirstname(fname);
	    user.setLastname(lname);
	    user.setPhno(Long.parseLong(Phone));
	    user.setDOB(DOB);
	    user.setAddress(address);
	    user.setEmail(MailID);
	    user.setPassword(Pword);
	    
	   dao.insertuser(user);
	   RequestDispatcher rd =  request.getRequestDispatcher("/Loginpage.jsp");
		rd.forward(request, response);
		}
		
	}

}
