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
            <h1>Search</h1>
<<<<<<< HEAD
            <form method="POST">
=======
            <form method="POST"> 
>>>>>>> d448b38c8562525b7f7b16673de3b5a51cc56b1f
                <input type="text" placeholder="restaurant name" name="name">
                <input type="text" placeholder="restaurant type" name="type">
                <br />

                <button type="submit">search</button>            

            </form>
        </div>
    </body>
</html>
