<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store v2.1</title>
    </head>
    <%
        response.sendRedirect( application.getContextPath() + "/Controller?action=viewcat"); 
    %>
</html>
