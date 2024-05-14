<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Banking Application</h1>
<form action="RegisterServlet" method="post"> 

<table> 
   
    <tr>
         <td><label>First Name</label></td>
         <td><input type="text" name="fname"></td>
    </tr>
    <tr>
         <td><label>Last Name</label></td>
         <td><input type="text" name="lname"></td>
    </tr>
    <tr>
        <td> <label>Phone Number</label></td>
        <td> <input type="text" name="Phone"></td>
    </tr>
    <tr>
        <td>  <label>Date of Birth</label></td>
        <td> <input type="text" name="DOB"></td>
    </tr>
    <tr> <td><label>Address</label></td>
        <td> <textarea rows="" cols="" name= "address"></textarea></td>
    </tr>
     <tr>
         <td><label>MailID</label></td>
         <td><input type="email" name="MailID"></td>
    </tr>
    <tr>
        <td> <label>Password</label></td>
        <td> <input type="password" name="Pword"></td>
    </tr>
    <tr> 
        <td><input type="submit" value="Register"></td>
        </tr>
</table>
 </form>
 <form action ="Loginpage.jsp">
      <input type = "submit" value = "Exsisting user">
 </form>
 
</body>
</html>