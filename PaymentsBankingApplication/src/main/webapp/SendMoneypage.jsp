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
<body>
<% 
ServletContext context=getServletContext(); 
List<bankinfo> banklist = ( List<bankinfo>)context.getAttribute("banklist");%>
<h1>Send Money</h1>
<form action="" method="post">
<table>
<tr>
         <td><label>Enter Amount :</label></td>
         <td><input type="text" name="amount"></td>
</tr>

<tr>
<td><label>From :</label></td>
  <td> <select name="Accounts" id="Accounts">
<%    
          for(int i=0;i<banklist.size();i++){
        	bankinfo bi = banklist.get(i);
        %>    
        <option value = <%=bi.getBankName() %>><%= bi.getBankName() %></option> 
        <%} %>
         </select></td>
        </tr>
  <tr>
         <td><input type="radio" id="accnum" name="sendamount" value="accno">
         <label>To Account Number</label>
         <input type="text"> </td></br>
         
      
         
</tr>
<tr>
<td>   <input type="radio" id="wallet" name="sendamount" value="wallet">
         <label>To wallet</label>
         <input type="text">
         </td>
</tr>

<tr>
         <td><label></label></td>
         <td><input type="submit"></td>
</tr>
</table>

</form>


</body>
</html>