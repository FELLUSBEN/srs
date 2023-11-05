
<%@page import="Model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Massege.css">
        <title>Exit Page</title>
    </head>
    <body>
        <body>
             <div class="content" style="width: 70%">
                <%User usr=((User)session.getAttribute("user"));%>
                <header>
                    <div><h1>Bye <%= usr.getUsr()%></h1></div>
                </header>
                <%session.invalidate();%>
                <button onclick="window.location.href = './index.jsp'">Exit</button>
             </div>
    </body>
    </body>
</html>
