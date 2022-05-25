<%@ page import="test.dao.MemberDao" %>
<%@ page import="test.vo.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list.jsp</title>
</head>
<body>
<h1>회원전체목록</h1>
<table border="1" width="500">
    <%
        MemberDao dao = new MemberDao();

        ArrayList<Member> list = dao.selectAll();
        request.setAttribute("list", list);
    %>
    <c:forEach var="vo" items="${requestScope.list}">
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이메일</th>
            <th>나이</th>
            <th>가입일</th>
        </tr>
        <tr>
            <td>${vo.id}</td>
            <td>${vo.pwd}</td>
            <td>${vo.email}</td>
            <td>${vo.age}</td>
            <td>${vo.regdate}</td>
        </tr>
    </c:forEach>
</table>
<a href="<%=request.getContextPath()%>/home">메인페이지</a>
</body>
</html>
