<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
 "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
  		<title>DisplayLogin</title>
 		 <link href="threeregion.css" rel="stylesheet" type="text/css" />
 	</head>
 	<body>
		<jsp:directive.include file="header.jsp" />
		<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
    
  			<h1>display login</h1>
  			<p>Usuario registrado en nuestra base de datos</p>
			<h2>Nombre de usuario:</h2>
			<p>
			<jsp:getProperty property="userName" name="loginBean"/>
			
			</p>
			<h2>Contraseña:</h2>
			<p>
			<jsp:getProperty property="password" name="loginBean"/>
			
			</p>
				
			<a href="homePage.jsp">Pulsa para volver</a>
  	
   		<jsp:directive.include file="footer.jsp" />
  </body>
</html>