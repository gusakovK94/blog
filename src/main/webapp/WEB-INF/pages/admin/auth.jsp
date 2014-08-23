<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Авторизация</title>
    <link href="/resources/css/auth.min.css" rel="stylesheet">
    <script src="/resources/frontend-libs/jquery/dist/jquery.min.js"></script>
    <script src="/resources/js/auth.js"></script>
</head>
<body>
    <form class="login" method="post" action="/admin">
        <label for="login">Логин</label>
        <input type="text" id="login" name="login"/>
        <label for="password">Пароль</label>
        <input type="password" id="password" name="password"/>
        <input id="loginBtn" type="submit" value="Войти"/>
        <br>
        <div class="alert alert-danger" role="alert">
            Неверный логин и/или пароль
        </div>
    </form>

</body>
</html>
