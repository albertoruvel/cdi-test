<%-- 
    Document   : addPerson
    Created on : Feb 17, 2016, 3:16:02 PM
    Author     : jose.rubalcaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new person</title>
    </head>
    <body>
        <h1>Add a new person</h1>
        <form method="POST" action="addPerson">
            Name: <input name="name" type="text">
            Last name: <input name="last" type="text">
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
