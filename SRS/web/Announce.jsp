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
            <h1>Announce</h1>
            <form method="POST" action="Announce"> 
                <input type="text" placeholder="announcement title" name="title" required>
                <input type="text" placeholder="announcement description" name="type" required>
                <br />

                <button type="submit">announce</button>            

            </form>
        </div>
    </body>
</html>
