
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div>
            <h1>search!</h1>
            <%if(request.getAttribute("content") == null){%>
<!--                <div class="in">
                    <form action="Action">
                        <label>Owner ID:</label><input type="text" name="id"><br><br>
                        <label>AND</label><input type="radio" name="or" value="false"><br>
                        <label>OR</label><input type="radio" name="or" value="true"><br>
                        <label>Acount number:</label><input type="number" min="0" name="num"><br><br>
                        <input type="hidden" name="act" value="S">
                        <input class="submit" type="submit" value="Search""><br><br> comment 
                    </form>
                </div> ********change to search form******-->
            <%}else if(request.getAttribute("content").equals("X")){%>
                <h1>no restaurants found :(</h1>
            <%}else{%>
                <div>
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
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="SEATS,<%= a.getName()%>"> <input type=number placeholder="0" id="count" required> <input type="submit" class="submit" value="Book"></form></td>
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="PR,<%= a.getName()%>"> <input type=number placeholder="0" id="count" required> <input type="submit" class="submit" value="BookPR"></form></td>
                            </tr>
                        <%}%>
                    </table>
                </div>
            <%}%>
        </div>
        <button onclick="window.location.href = './Main'">Return to main page</button>
    </body>
</html>
