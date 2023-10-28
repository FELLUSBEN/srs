<% if (session.getAttribute("UserName") == null){response.sendRedirect("index.jsp");} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="Model.*" %>
<%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>
        
        <div class="content" style="width: 70%">
            <%if(request.getAttribute("content") == null){%>
                <h1>Search</h1>
                <form method="POST" action="Search"> 
                    <input type="text" placeholder="restaurant name" name="name">
                    <input type="text" placeholder="restaurant type" name="type">
                    <br />

                    <button type="submit">search</button>            

                </form>

            <%}else if(request.getAttribute("content").equals("X")){%>
                <h1>no restaurants found :(</h1>
            <%}else{%>
                <div>
                    <% if (request.getAttribute("err") != null){ %>
                    <h2 style="color: red;"><%= request.getAttribute("err") %></h2>
                    <%}%>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Address</th>
                            <th>free seats</th>
                            <th>free private rooms</th>
                        </tr>
                        <%for(Restaurant a:(ArrayList<Restaurant>)request.getAttribute("content")){%>
                            <tr>
                                <td><%= a.getName()%></td>
                                <td><%= a.getType()%></td>
                                <td><%= a.getAddress()%></td>
                                <td><%= a.getFreeSeats()%></td>
                                <td><%= a.getFreePR()%></td>
                                <td><form action="Search" class="in"><input type="hidden" name="act" value="SEATS,<%= a.getName()%>"> <input type=number placeholder="0" id="count" required> <input type="submit" class="submit" value="Book"></form></td>
                                <td><form action="Search" class="in"><input type="hidden" name="act" value="PR,<%= a.getName()%>"> <input type=number placeholder="0" id="count" required> <input type="submit" class="submit" value="BookPR"></form></td>
                            </tr>
                        <%}%>
                    </table>
                </div>
            <%}%>
        </div>
    </body>
</html>
