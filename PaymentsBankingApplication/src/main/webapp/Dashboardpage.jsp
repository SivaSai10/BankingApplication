<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="BankAppClasses.userinfo" %>
     <%@ page import="BankAppClasses.bankinfo" %>
     <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<center>
<%//userinfo suser = (userinfo)session.getAttribute("user");%>
      <h1> Banking Application</h1>
<table style = width:50%>
<tr>
<td><h4>Welcome : <%= ((userinfo)request.getAttribute("user")).getLastname() %></h4></td>
<td>
<form action="LogoutServlet" method="post">
     <input type="submit" value = "Logout">
</form>
</td>
</tr>
</table>
<% List<bankinfo> banklist = ( List<bankinfo>)request.getAttribute("banklist");%>
<div>
<table style = width:50%>
    <tr>
<%    
         
        	 
        %>
<td>
    Primary Account Number : <%=((bankinfo)request.getAttribute("bib")).getBankAccnum() %> </br>
    Account Balance :<%= ((bankinfo)request.getAttribute("bib")).getCurrAccBal() %>  </br>
    Wallet Balance : <%= ((userinfo)request.getAttribute("user")).getCurrWallBalance()  %>  <form action="" method="post"> <input type="submit" value="[+]"> </form></br>
     </td>
      <td>
<form action="SendMoneypage.jsp" method="post">
<input type="submit" value="Send Money">
</form>
</td>
      </tr>
      </table>
</div>
</br>
<div>
    
<table style = width:50%>
    <tr>
       <%    
          for(int i=0;i<banklist.size();i++){
        	bankinfo bi = banklist.get(i);
        %>
        <td> 	
        	Bank Name : <%= bi.getBankName() %></br>
        	Bank Account Number : <%= bi.getBankAccnum() %></br>
    	    Bank IFSC Code : <%= bi.getBankIFSCcode() %></br>
        	Current Balance : <%= bi.getCurrAccBal() %></br>
    	</td>
      <%   	
         }
      %>

        <td> 
            <form action="AddBankpage.jsp" method="post">
                <input type="submit" value = "Add Bank Account">
            </form>
       </td>
   </tr>
</table>
</div>
</center>
</body>
</html>