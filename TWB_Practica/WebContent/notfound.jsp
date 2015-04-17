<?xml version="1.0"?>
<!-- File: notfound.jsp -->

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 		
   xmlns:bean="http://struts.apache.org/tags-bean"
   version="2.0">
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />

<html:html xhtml="true" lang="true">
  <head>
  	<link href="threeregion.css" rel="stylesheet" type="text/css" />
    <title><bean:message key="notfound.title" /></title>
  </head>
  <body>
  	<jsp:directive.include file="header.jsp" />
  	<h1><bean:message key="notfound.title"/></h1>
    <bean:message key="label.userName" />
    <bean:write name="loginBean" property="userName" />
    <bean:message key="notfound.message" />
  <hr />
  <html:link action="home"><bean:message key="tohome.link" /></html:link>
  <jsp:directive.include file="footer.jsp" />
  </body>
</html:html>
</jsp:root>
