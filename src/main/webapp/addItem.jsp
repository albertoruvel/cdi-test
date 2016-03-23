<%-- 
    Document   : addItem
    Created on : Feb 18, 2016, 2:25:19 PM
    Author     : jose.rubalcaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add item</title>
    </head>
    <body>
        <h1>Add a new item to ${person.name}!</h1>
        <form action="addItem" method="POST">
            Item name <input name="itemName">
            <input name="personId" value="${person.id}" type="hidden">
            <button type="submit">Submit</button>
        </form>
            <a href="persons">back to persons</a>
    </body>
</html>
