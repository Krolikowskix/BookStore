<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th><a href = "/book/add">Dodaj</a></th>

    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href = "/book/edit/<c:out value="${book.id}"/>">Edytuj</a></td>
            <td><a href = "/book/delete/<c:out value="${book.id}"/>">Usuń</a></td>
            <td><a href = "/book/show/<c:out value="${book.id}"/>">Szczegóły</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


