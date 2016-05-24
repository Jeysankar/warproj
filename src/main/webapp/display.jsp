<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edu.ucla.its.itademo.util.User"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
</head>
<body>
<table>
<%List<User> usersList = (ArrayList<User>) request.getAttribute("Users");
Iterator<User> iter = usersList.iterator();


while(iter.hasNext())
{
    User user = iter.next();
%>
<tr> 
<td> <%=user.getName() %></td> <td> <%=user.getEmail() %></td> <td> <%=user.getCountry() %></td>
</tr>
<%
}
%>

</table>

</body>
</html>