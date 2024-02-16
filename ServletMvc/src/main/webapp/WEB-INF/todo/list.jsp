<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-16
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <P>list Pages</P>
    <ul>
        <v:forEach var="todo" items="${list}">
            <li>${todo}</li>
        </v:forEach>
    </ul>
    <button type="submit">삭제</button>
</body>
</html>
