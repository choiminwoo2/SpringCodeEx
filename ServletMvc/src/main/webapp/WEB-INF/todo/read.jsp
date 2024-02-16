<jsp:useBean id="dto" scope="request" type="org.zerock.servletmvc.todo.dto.TodoDTO"/>
<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-16
  Time: 오후 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>${dto.tno}</div>
    <div>${dto.title}</div>
    <div>${dto.dueDate}</div>
    <div>${dto.finished}</div>
</body>
</html>
