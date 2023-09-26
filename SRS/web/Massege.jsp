<%-- 
    Document   : Massege
    Created on : Apr 19, 2023, 8:33:48 AM
    Author     : razic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Massage Page</title>
    </head>
    <body>
        <h1><%=request.getAttribute("massege")%></h1>
        <button onclick="history.go ( -1)">Return</button>
    </body>
</html>
