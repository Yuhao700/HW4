<%-- 
    Document   : read
    Created on : Oct 16, 2015, 7:05:29 PM
    Author     : Drake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Database</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    <body>
        <h1>Member Database</h1>
        <%= table %>
    </body>
</html>
