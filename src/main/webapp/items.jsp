<%-- 
    Document   : items
    Created on : Feb 18, 2016, 2:22:19 PM
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
        <h1>${person.name} ${person.last}'s items!</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${person.items ne null}">
                    <c:forEach items="${person.items}" var="item" varStatus="status">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                
            </tbody>
        </table>
        <a href="persons">back to persons</a>
    </body>
</html>
