<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 		
   version="2.0">
	<jsp:directive.page contentType="text/html"/>   
	<jsp:output omit-xml-declaration="false"
	 doctype-root-element="html"
	 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
	 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
	 <html:html xhtml="true">
		<head>
		 	<link href="threeregion.css" rel="stylesheet" type="text/css" />
		<title>Consulta</title>
		</head>
		<body>
			<jsp:directive.include file="header.jsp" />
			<h1>Página de Consulta</h1>
			<html:link action="/fromconsulta.do">Volver al inicio</html:link>
			
			<jsp:directive.include file="footer.jsp" />
		</body>
	</html:html>
</jsp:root>