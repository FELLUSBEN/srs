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
            <form method="POST">
                <input type="text" placeholder="restaurant name" name="name">
                <div class="select">
                    <select name="type" id="res_type">
                        <option value="italian">italian</option>
                        <option value="coffee">coffee</option>
                        <option value="asian">asian</option>
                        <option value="steakhouse">steakhouse</option>
                    </select>
                </div>
                <br />

                <button type="submit">search</button>            

            </form>
        </div>
    </body>
</html>
