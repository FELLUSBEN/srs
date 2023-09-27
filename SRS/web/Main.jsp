<%@ include file = "Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.isNew()){ response.sendRedirect("index.jsp");}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
