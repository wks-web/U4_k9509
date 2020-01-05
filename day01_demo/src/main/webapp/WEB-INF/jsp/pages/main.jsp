<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17/0017
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>学生信息表</h1>
    <form action="${pageContext.request.contextPath}/queryStudent">
        <table cellpadding="5" cellspacing="0" width="80%">
            <tr>
                <th>编号</th>
                <th>年龄</th>
                <th>姓名</th>
                <th>电话</th>
            </tr>
        </table>
        <c:forEach items="${studentsList}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.age}</td>
                <td>${s.name}</td>
                <td>${s.phone}</td>
            </tr>
        </c:forEach>
    </form>

</center>
</body>
</html>
