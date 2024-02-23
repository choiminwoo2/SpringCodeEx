<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-23
  Time: 오후 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body class="bg-gray-100">
<div class="max-w-lg mx-auto my-8">
    <div class="bg-white rounded-lg shadow-md p-8">
        <h1 class="text-3xl font-bold mb-4">게시글 상세</h1>
        <div>
            <p><strong>게시물 번호:</strong> <c:out value="${dto.tno}" /></p>
            <p><strong>타이틀명:</strong> <c:out value="${dto.title}" /></p>
            <p><strong>작성자:</strong> <c:out value="${dto.writer}" /></p>
            <p><strong>작성일:</strong> <c:out value="${dto.dueDate}" /></p>
            <p><strong>상태:</strong> <c:out value="${dto.finished}" /></p>
        </div>
        <div class="mt-4">
            <a href="/posts/{{ dto.postId }}/edit" class="inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2">수정</a>
            <form action="/posts/{{ dto.postId }}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');" class="inline-block">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">삭제</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
