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
<form action="LoginServlet" method="post"> 

<table> 
    <tr>
         <td><label>UserName</label></td>
         <td><input type="text" name="uname"></td>
    </tr>  
    <tr>
        <td> <label>Password</label></td>
        <td> <input type="password" name="upass"></td>
    </tr>
    <tr> 
        <td><input type="submit" value="Login"></td>
        </tr>
</table>
 </form>
    <form action="Registerpage.jsp">
    <input type="submit" value="Register">
    </form>
</body>
</html>