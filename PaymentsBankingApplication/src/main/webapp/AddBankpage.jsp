<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="BankAppClasses.userinfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="AddbankServlet" method="post">
<h1>Add BankAccount  </h1>
<table>
<tr>
         <td><label>Phone Number</label></td>
         <td><input type="text" name="phno"></td>
    </tr>  
 <tr>
<tr>
         <td><label>User ID :</label></td>
         <td><input type="text" name="userid"></td>
    </tr>  
 <tr>
         <td><label>Bank Name :</label></td>
         <td><input type="text" name="bname"></td>
    </tr>  
     <tr>
         <td><label>Bank Account Number :</label></td>
         <td><input type="text" name="baccnum"></td>
    </tr>  
     <tr>
         <td><label>Account Type :</label></td>
         <td><input type="text" name="acctype"></td>
    </tr>  
     <tr>
         <td><label>IFSC Code :</label></td>
         <td><input type="text" name="ifsccode"></td>
    </tr>  
     <tr>
         <td><label>Current Balence :</label></td>
         <td><input type="text" name="currbal"></td>
    </tr>  
    
     <tr>
         <td><label>Pin :</label></td>
         <td><input type="text" name="pin"></td>
    </tr>  
     <tr>
         <td><label></label></td>
         <td><input type="submit" ></td>
    </tr>  

</table>
</form>
</center>
</body>
</html>