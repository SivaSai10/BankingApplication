package BankAppServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankAppClasses.bankinfo;
import BankAppClasses.userinfo;
import DAO.BankAppDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BankAppDAO dao = new BankAppDAO();
       
    public LoginServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		
		
		if(dao.validuser(uname, upass)) {
			
			userinfo user = dao.userbyphono(uname);
			request.setAttribute("user", user);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			List<bankinfo> banklist = dao.Bankbyuserid(user.getUserId());
			request.setAttribute("banklist", banklist);
			
			ServletContext context=getServletContext(); 
			context.setAttribute("banklist", banklist);
			
			bankinfo bib = dao.Bankdetailsbyuserid(user.getUserId());
			request.setAttribute("bib", bib);
		
		 RequestDispatcher rd =  request.getRequestDispatcher("/DasboardServlet");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");
			response.getWriter().write("-----Enter correct username and password----- ");
			RequestDispatcher rd =  request.getRequestDispatcher("/Loginpage.jsp");
			rd.include(request, response);
		}
		
	}

}
