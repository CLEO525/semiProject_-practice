<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>join</title>
</head>
<body>
<form action="${cp}/join" method="post">
    회원아이디<input type="text" name="id"><br>
    비밀번호<input type="password" name="pwd"><br>
    이메일<input type="text" name="email"><br>
    나이<input type="text" name="age"><br>
    <input type="submit" value="가입"><br>
</form>
</body>
</html>
