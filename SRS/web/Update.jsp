<% if (session.getAttribute("UserName") == null){response.sendRedirect("index.jsp");} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "Header.jsp" %>
<jsp:useBean id="user" class="Model.User" scope="session" />


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
                <label for="name">Restaurant Name:</label><br/>
                <input type="text" id="name" placeholder="Enter Restaurant Name" value="<%= user.getName() %>" name="name">
                <label for="address">Restaurant Address:</label><br/>
                <input type="text" id="address" placeholder="Enter Address" value="<%= user.getAddress() %> name="address">
                <label for="employees">Restaurant Employees:</label><br/>
                <input type="text" id="employees" placeholder="Enter employees seperated by [,]" value="<%= user.getEmployees() %> name="employees">
                <label for="seats">Restaurant Seats:</label><br/>
                <input type="number" id="seats" placeholder="Enter number of seats" value="<%= user.getSeats() %> name="seats">
                <label for="pr">Restaurant Private Rooms:</label><br/>
                <input type="number" id="pr" placeholder="Enter number of private rooms" value="<%= user.getPr() %> name="pr">
                <label for="type">Restaurant Type:</label><br/>
                <input type="text" id="type" placeholder="Enter restaurnat type" value="<%= user.getType() %> name="Ftype">
                <br />

                <button type="submit">update</button>            

            </form>
        </div>
    </body>
</html>
