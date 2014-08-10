<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link href="/resources/css/style.css" rel="stylesheet">
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".login").submit(function(e) {
                e.preventDefault();

                var m_method = $(this).attr("method");
                var m_action = $(this).attr("action");
                var m_data = $(this).serialize();

                $.ajax({
                    type: m_method,
                    url: m_action,
                    data: m_data,
                    success: function(result) {
                        alert(result);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <form class="login" method="post" action="/admin">
        <label for="login">Логин</label>
        <input type="text" id="login" name="login"/>
        <label for="password">Пароль</label>
        <input type="password" id="password" name="password"/>
        <input id="loginBtn" type="submit" value="Войти"/>
    </form>

</body>
</html>
