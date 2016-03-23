<%-- 
    Document   : persons
    Created on : Feb 17, 2016, 3:16:13 PM
    Author     : jose.rubalcaba
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Persons</h1>
        <table style="cell-padding: 8px;padding: 8px; margin: 0px 4px 0px 4px">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Last name</th>
                    <th>Items</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${persons}" varStatus="status">
                    <tr>
                        <td>${p.name}</td>
                        <td>${p.last}</td>
                        <td><a href="items?personId=${p.id}">View items</a></td>
                        <td><a href="addItem?personId=${p.id}">Add items</a></td>
                    </tr>    
                </c:forEach>    
            </tbody>
        </table>
        
    </body>
</html>
