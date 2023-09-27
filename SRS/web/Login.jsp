<%-- 
    Document   : Login
    Created on : Apr 19, 2023, 8:33:19 AM
    Author     : razic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Form.css">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/Massege.css">
        <title>Login</title>
    </head>
    <body>
        <h1>Enter your cradentials</h1>
        <div class="in">
            <div>
            <form action="Login" method="post">
                <label>Enter UserName:</label><input type="text" value="<%=session.getAttribute("UserName")%>" name="usr"><br><br><!-- comment -->
                <label>Enter Password:</label><input type="password" name="pass"><br><br><!-- comment -->
                <input class="submit" type="submit" value="login"><br><br><!-- comment -->
            </form>
        </div>
        <div>
            <form action="Login" method="post">
                <input type="hidden" name="guest">
                <input class="submit" type="submit" name="usr" value="Login as guest"></<input><br><br><!-- comment -->
            </form>
        </div>
        </div>
    </body>
</html>
