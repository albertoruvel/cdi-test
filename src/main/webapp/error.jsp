<%-- 
    Document   : error
    Created on : Feb 17, 2016, 4:10:56 PM
    Author     : jose.rubalcaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <h1>There has been an error :(</h1>
        <p>${exception.errorMessage}</p>
    </body>
</html>
