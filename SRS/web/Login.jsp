<%@ include file = "Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="bg"></div>
        <div class="bg bg2"></div>
        <div class="bg bg3"></div>
        <div class="content">
            <h1>Please enter your credentials</h1>    
            <% if (request.getAttribute("msg")!= null && request.getAttribute("msg").equals("error")) {%>
                <h2 style="color:red">invalid credentials</h2>
            <%}%>
            <form action="POST">
                <input type="text" placeholder="Enter Username" name="uname" required>
                <input type="password" placeholder="Enter Password" name="psw" required>              
                <button type="submit">Login</button>                    
            </form>
            <a href="Register">Dont have an Acount?</a>   
        </div>
    </body>
</html>
