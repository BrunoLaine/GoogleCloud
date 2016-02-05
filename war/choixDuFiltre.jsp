<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Boyot Cherruau Laine - Google Cloud Project</title>
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

		<!-- Header -->
		<div id="header"></div>

		<!-- Main -->
		<div id="main">
			
		    <form method="post" action="datastore">
		    	Selectionnez client (multi-tenancy):
		    	<select name="etablissement">
		    		<option value="etablissement1">Etablissement 1</option>
		    		<option value="etablissement2">Etablissement 2</option>
		    	</select>
			    <input type="submit">
		    </form>

		</div>
		<!-- Footer -->
		<div id="footer"></div>
	</div>


</body>
</html>
