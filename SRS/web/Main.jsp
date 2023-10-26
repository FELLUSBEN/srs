<%@ include file = "Header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.*" %>
<jsp:useBean id="user" class="Model.User" scope="session" />
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
            <% if(user instanceof Model.Restaurant){ %>
                <div class="button" id="button-1">
                <div id="underline"></div>
                <a href="Update">Update restaurant data</a>
                </div>
                
                <div class="button" id="button-1">
                <div id="underline"></div>
                <a href="Announce">Announce</a>
                </div>
                
            <%}else{%>
            <div class="button" id="button-1">
                <div id="underline"></div>
                <a href="Search">Search for restaurant</a>
            </div>
            <%}%>
            
            
            <h2>Announcements</h2>
            
            <%if(request.getAttribute("announcements") != null){%>
            <table style="width:100%;">
                <tr>
                    <% if(user instanceof Model.Restaurant){ %>
                    <th>User</th>
                    <%}else{%>
                    <th>Restaurant</th>
                    <%}%>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Date</th>
                </tr>
                <%for(Model.Announcement a:(ArrayList<Model.Announcement>)request.getAttribute("announcements")){%>
                <tr>
                    <td><%= a.getUsr()%></td>
                    <td><%= a.getTitel()%></td>
                    <td><%= a.getDesc()%></td>
                    <td><%= a.getDate()%></td>
                    <% if(user instanceof Model.Restaurant){ %>
                    <td><form action="?" class="in"><input type="hidden" name="act" value="SEATS,<%= a.getName()%>,<%= a.getTitel()%>,<%= a.getDesc()%>,<%= a.getDate()%>"><input type="submit" class="submit" value="Remove Entry"></form></td> <!--remove specific entry-->
                    <%}%>
                </tr>
                <%}%>
            </table>
            <%}else{%>
            <h2>there are no new announcemnts</h2>
            <%}%>
            
        </div>
    </body>
</html>
