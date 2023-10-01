<%-- 
    Document   : Exit
    Created on : May 28, 2023, 8:21:48 PM
    Author     : razic
--%>
<%@page import="Model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Massege.css">
        <title>Exit Page</title>
    </head>
    <body>
        <body>
        <%User usr=((User)session.getAttribute("usr"));%>
        <header>
            <div><h1>Hello <%= usr.getUsr()%></h1></div>
        </header>
        <%session.invalidate();%>
        <button onclick="window.location.href = './index.html'">Exit</button>
    </body>
    </body>
</html>
