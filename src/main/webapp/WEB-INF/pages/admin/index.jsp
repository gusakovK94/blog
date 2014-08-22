<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="/resources/css/index.min.css" rel="stylesheet">
    <title>Admin index page</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="navigation" class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/admin">Настройки блога</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/admin/posts">Посты</a></li>
                        <li><a href="/admin/tags">Тэги</a></li>
                        <li><a href="/admin/photos">Фотографии</a></li>
                        <li><a href="/admin/about">Обо мне</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="jumbotron">
        <h1>Здравствуй, админ!</h1>
        <p>Это главная страница настроек личного блога.
            Сверху располагается навигационная панель, в которой можно изменять каждую из категорий ваших личных записей.Удачи!
        </p>
        <p>По всем вопросам <a href="mailto:gusakovK94@gmail.com">gusakovK94@gmail.com</a></p>
        <p><a class="btn btn-primary btn-lg" href="/admin/posts" role="button">Редактировать</a></p>
    </div>
</div>
</body>
</html>