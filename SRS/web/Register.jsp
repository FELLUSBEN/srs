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
            <div id="customer-form" class="signup-form">
            <form>
                <input type="text" name="type" value="customer" hidden>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <input type="email" placeholder="Enter Email" name="email" required>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <input type="password" placeholder="Retype Password" name="psw2" required>
                <button type="submit">Register</button>                    
            </form>
            </div>
            
            <div id="restaurant-form" class="signup-form" style="display: none">
            <form>
                <input type="text" name="type" value="restaurant" hidden>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <input type="text" placeholder="Enter restaurant name" name="name" required>
                <input type="text" placeholder="Enter Address" name="address" required>
                <input type="text" placeholder="Enter employees seperated by [,]" name="employees" required>
                <input type="number" placeholder="Enter number of seats" name="seats" required>
                <input type="number" placeholder="Enter number of private rooms" name="pr" required>
                <input type="text" placeholder="Enter restaurnat type" name="Ftype" required>

                <input type="password" placeholder="Enter Password" name="psw" required>
                <input type="password" placeholder="Retype Password" name="psw2" required>
                <button type="submit">Register</button>                    
            </form>
            </div>
            <button id="toggle-form-button">Switch to Restaurant Signup</button>

            
        </div>
    </body>
</html>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function() {
        // When the button is clicked, toggle the visibility of the forms
        $("#toggle-form-button").click(function() {
            $("#customer-form").toggle();
            $("#restaurant-form").toggle();
        });
    });
</script> 

