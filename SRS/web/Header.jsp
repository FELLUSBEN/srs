<%-- 
    Document   : Header
    Created on : Apr 19, 2023, 8:35:26 AM
    Author     : razic
--%>

<%@page import="Model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Form.css">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Massege.css">
        <title>Header Page</title>
    </head>
    <body>
        <%User usr=((User)session.getAttribute("usr"));%>
        <header><div><h1>Hello <%= usr.getName()%></h1></div><div><h1><%=(session.getAttribute("LastSeen")==null)? "" : "Last seen: "+session.getAttribute("LastSeen")%></h1></div></header>
    </body>
</html>
