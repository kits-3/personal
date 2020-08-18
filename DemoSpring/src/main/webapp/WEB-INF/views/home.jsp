<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  The country on the server is ${timeLocale}. </P>
usage folder of spring
/src/main/java             :  java source <br/>
/src/main/resources		   :  config files<br/>
/src/main/webapp     	   :  web content <br/>
/src/main/webapp/resources :  *.css, *.js ,*.html, image  <- static files <br/>
/src/main/webapp/WEB-INF   :  *.classes,  *.jsp , config xml <- dynamic files <br/>
</body>
</html>
