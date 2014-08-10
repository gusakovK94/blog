<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>
    <form class="login" method="post" action="/admin">
        <label for="login">Логин</label>
        <input type="text" id="login" name="login"/>
        <label for="password">Пароль</label>
        <input type="password" id="password" name="password"/>
        <input type="submit" value="Войти"/>
    </form>
</body>
</html>
