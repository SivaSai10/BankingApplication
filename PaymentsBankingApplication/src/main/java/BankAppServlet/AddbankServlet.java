package BankAppServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BankAppClasses.bankinfo;
import DAO.BankAppDAO;

@WebServlet("/AddbankServlet")
public class AddbankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BankAppDAO dao = new BankAppDAO();
    public AddbankServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phno = request.getParameter("phno");
		String userid = request.getParameter("userid");
		String bname = request.getParameter("bname");
		String baccnum = request.getParameter("baccnum");
		String acctype = request.getParameter("acctype");
		String ifsccode = request.getParameter("ifsccode");
		String currbal = request.getParameter("currbal");
		String pin = request.getParameter("pin");
		
		if(dao.validphno(phno)) {
			bankinfo bi = new bankinfo();
			bi.setUserId(Integer.parseInt(userid));
			bi.setBankName(bname);
			bi.setBankAccnum(baccnum);
			bi.setAcctypeId(Integer.parseInt(acctype));
			bi.setBankIFSCcode(ifsccode);
			bi.setCurrAccBal(Double.parseDouble(currbal));
			bi.setPin(Integer.parseInt(pin));
			
			dao.insertBankdetails(bi);
				response.setContentType("text/html");
				response.getWriter().write("-----Bank Account Added Successfully----- ");
				RequestDispatcher rd =  request.getRequestDispatcher("/AddBankpage.jsp");
				rd.include(request, response);
		}else {
			response.setContentType("text/html");
			response.getWriter().write("-----Invalid Username and password----- ");
			RequestDispatcher rd =  request.getRequestDispatcher("/Loginpage.jsp");
			rd.include(request, response);
		}
		
		
		
		
		
		
	}

}
