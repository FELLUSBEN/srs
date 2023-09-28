<%@ include file = "Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.isNew()){ response.sendRedirect("index.jsp");}%>
<% if (session.getAttribute("userName") == null){response.sendRedirect("index.jsp");} %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <div class="bg"></div>
        <div class="bg bg2"></div>
        <div class="bg bg3"></div>
        <div class="content">
            <h1>Please enter your credentials</h1>        
            <form>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <input type="password" placeholder="Enter Password" name="psw" required>              
                <button type="submit">Login</button>                    
            </form>
            <a href="Register">Dont have an Acount?</a>   
        </div>
    </body>
</html>
