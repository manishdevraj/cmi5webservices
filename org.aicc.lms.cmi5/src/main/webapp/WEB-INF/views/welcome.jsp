<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>LMS CMI5 Server</title>
</head>
<body>
<div class="container">  
	<h1>
		LMS CMI5 Server
	</h1>
	<p>
		Locale = ${pageContext.response.locale}
	</p>
	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>
	<ul>
		<li><a href="account">@Controller Example</a></li>
	</ul>
</div>
</body>
</html>