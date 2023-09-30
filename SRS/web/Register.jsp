<%@ include file = "Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>

        <div class="content">
            <h1>Please fill the form below</h1>        
            <form>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <input type="email" placeholder="Enter Email" name="email" required>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <input type="password" placeholder="Retype Password" name="psw2" required>
                <button type="submit">Register</button>                    
            </form>
        </div>
    </body>
</html>
