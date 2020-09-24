<%@page contentType="text/html" pageEncoding="UTF-8" import="pmj.bookstore.model.BookBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book-Show</title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
    <%
    	BookBean book = (BookBean) request.getAttribute("book");
    %>
    <h2>Book-Details</h2>
    <table class="gridtable">
        <tr><td>ISBN</td><td><%= book.getIsbn() %></td></tr>
        <tr><td>Title</td><td width="300"><%= book.getTitle() %></td></tr>
        <tr><td>Price</td><td><%= book.getPrice() %></td></tr>
        <tr><td>Stock</td><td><%= book.getStock()%></td></tr>
    </table>
    </body>
</html>
