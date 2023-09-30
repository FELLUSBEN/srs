<%@ include file = "Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("UserName") == null){response.sendRedirect("index.jsp");} %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        
        <div class="content" style="width: 70%">
            <h1>Please select an option</h1>        
            
            <div class="button" id="button-1">
                <div id="underline"></div>
                <a href="Search">Search for restaurant</a>
            </div>
            <h2>Announcements</h2>
            <table style="width:100%;">
                <tr>
                    <th>restaurant</th>
                    <th>announcement</th>
                </tr>
                
                <tr>
                    
                </tr>
            </table>
        </div>
    </body>
</html>
