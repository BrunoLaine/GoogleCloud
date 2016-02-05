<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Liste des Visiteurs</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.html");
		$("#footer").load("footer.html");
	});
</script>
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<div id="header"></div>
		<!-- Main -->
		<div id="main">

			<h1>Liste des visiteurs :</h1>

			<table>
				<tr>
					<td>Pr�nom</td>
					<td>Nom</td>
				</tr>

				<%
					ArrayList<String> prenoms = (ArrayList<String>) request
							.getAttribute("prenoms");
					ArrayList<String> noms = (ArrayList<String>) request
							.getAttribute("noms");

					for (int i = 0; i < prenoms.size(); i++) {
						out.println("<tr><td>" + prenoms.get(i) + "</td>");
						out.println("<td>" + noms.get(i) + "</td></tr>");
					}
				%>
			</table>

		</div>
		<div id="footer"></div>
	</div>

</body>
</html>