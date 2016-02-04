<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Liste des visiteurs :
	<table>
		<tr>
			<td>Prénom</td>
			<td>Nom</td>
		</tr>

		<%
			ArrayList<String> prenoms = (ArrayList) request.getAttribute("prenoms");
			ArrayList<String> noms = (ArrayList) request.getAttribute("noms");
			for(int i = 0; i < prenoms.size(); i++){
				out.println("<tr><td>" + prenoms.get(i) + "</td>");
			    out.println("<td>" + noms.get(i) + "</td></tr>");
			}
		%>
	</table>
</body>
</html>