<%@page contentType="text/html" pageEncoding="UTF-8" import="pmj.bookstore.model.BookBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book-Entry</title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
    <%
    	BookBean book = new BookBean();
    %>
    <h2>New Book</h2>
    <form method = "post" action="Controller">
    <input type="hidden" name="action" value="insert" />
    <table class="gridtable">
        <tr><td>ISBN</td><td><input type="text" name="isbn" value="<%= book.getIsbn() %>" /></td></tr>
        <tr><td>Title</td><td><input type="text" name="title" value="<%= book.getTitle()%>" size="50"/></td></tr>
        <tr><td>Price</td><td><input type="text" name="price" value="<%= book.getPrice() %>" /></td></tr>
        <tr><td>Stock</td><td><input type="text" name="stock" value="<%= book.getStock() %>" /></td></tr>
        <tr><td></td><td><input type="submit" value="Add Book" /></td></tr>
    </table>
    </form>
    </body>
</html>
