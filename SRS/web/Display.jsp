<%-- 
    Document   : Display
    Created on : May 28, 2023, 8:22:21 PM
    Author     : razic
--%>

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
<!--                <div>
                    <table>
                        <tr>
                            <th>Owner ID</th>
                            <th>Acount number</th>
                            <th>Balance</th>
                            <th>Description</th>
                            <th>Opening date</th>
                        </tr>
                        <%for(Acount a:(ArrayList<Acount>)request.getAttribute("content")){%>
                            <tr>
                                <td><%= a.getId()%></td>
                                <td><%= a.getNum()%></td>
                                <td><%= a.getBalance()%></td>
                                <td><%= a.getDesc()%></td>
                                <td><%= a.getDate()%></td>
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="D,<%= a.getNum()%>,<%= a.getBalance()%>"><input type="submit" class="submit" value="Delete"></form></td>
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="U,<%= a.getId()%>,<%= a.getNum()%>,<%= a.getBalance()%>,<%=a.getDesc()%>,<%= a.getDate()%>"><input type="submit" class="submit" value="Update"></form></td>
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="SP,<%= a.getId()%>,<%= a.getNum()%>,<%= a.getBalance()%>,<%=a.getDesc()%>,<%= a.getDate()%>"><input type="submit" class="submit" value="Split"><input type="number" min="2" name="num"></form></td>
                                <td><form action="Action" class="in"><input type="hidden" name="act" value="M,<%= a.getId()%>,<%= a.getNum()%>,<%= a.getBalance()%>,<%=a.getDesc()%>,<%= a.getDate()%>"><input type="submit" class="submit" value="Merge"></form></td>
                            </tr>
                        <%}%>
                    </table>
                </div>*********change to display table***********-->
            <%}%>
        </div>
        <button onclick="window.location.href = './Main'">Return to main page</button>
    </body>
</html>
