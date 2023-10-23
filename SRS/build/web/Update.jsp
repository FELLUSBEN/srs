<% if (session.getAttribute("UserName") == null){response.sendRedirect("index.jsp");} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "Header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <div class="content" style="width: 70%">
            <h1>Update</h1>
            <form method="POST" action="Update"> 
                <input type="text" placeholder="Enter Address" name="address">
                <input type="text" placeholder="Enter employees seperated by [,]" name="employees">
                <input type="number" placeholder="Enter number of seats" name="seats">
                <input type="number" placeholder="Enter number of private rooms" name="pr">
                <input type="text" placeholder="Enter restaurnat type" name="Ftype">
                <br />

                <button type="submit">update</button>            

            </form>
        </div>
    </body>
</html>
