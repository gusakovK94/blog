<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать посты</title>
    <link href="/resources/css/posts.min.css" rel="stylesheet">
    <link href="/resources/frontend-libs/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/resources/frontend-libs/jquery/dist/jquery.min.js"></script>
    <script src="/resources/frontend-libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/resources/frontend-libs/tinymce/tinymce.min.js"></script>
    <script src="/resources/js/posts.js"></script>
    <script>
        tinymce.init({
            selector: "textarea"
        });
    </script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div id="navigation" class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Настройки блога</a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Посты</a></li>
                            <li><a href="#">Тэги</a></li>
                            <li><a href="#">Фотографии</a></li>
                            <li><a href="#">Обо мне</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-2">
                <button id="post-button" type="button"
                        class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    Добавить пост
                </button>

                <!-- Modal window -->
                <div class="modal fade" id="myModal" tabindex="-1"
                     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Закрыть</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">Новый пост</h4>
                            </div>
                            <sf:form class="addPost" method="post" modelAttribute="post" enctype="multipart/form-data">
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <label for="photo">Фотография</label>
                                            <div>
                                                <img
                                                    width="100" height="100" id="image_preview" src="https://lh6.googleusercontent.com/-L17_eJqIsDI/UzbeiYk96RI/AAAAAAAASP4/SbOqhSuEyU4/s100-no/image-is-not-uploaded.jpg">
                                            </div>
                                            <div>
                                                <input type="file" id="photo" name="photo">
                                            </div>
                                        </div>
                                        <div class="col-lg-8">
                                            <sf:label path="topic">Тема</sf:label>
                                            <sf:input path="topic" cssClass="form-control"/>
                                            <sf:label path="author">Автор</sf:label>
                                            <sf:input path="author" cssClass="form-control"/>
                                            <label>Тэги</label>
                                            <br>
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle"
                                                    data-toggle="dropdown">
                                                    Добавить <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <div class="list-tags">
                                                        <li><input type="checkbox"><span class="tag">iPhone</span></li>
                                                        <li><input type="checkbox"><span class="tag">Android</span></li>
                                                    </div>
                                                    <li class="divider"></li>
                                                    <li>
                                                        <button type="button" class="save btn btn-primary">Сохранить</button>
                                                    </li>
                                                </ul>
                                            </div>
                                            <button type="button" class="btn btn-danger delete">Удалить</button>
                                            <div class="tags">

                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <sf:textarea path="content" id="post-text"/>
                                        <button type="button" class="btn btn-info">Предпросмотр</button>
                                        <button type="button" class="btn btn-default clear">Очистить</button>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                                    <input type="submit" class="btn btn-primary" value="Сохранить">
                                </div>
                            </sf:form>
                        </div>
                    </div>
                </div>
                <!-- Modal window -->
            </div>
        </div>

        <!-- Post -->
        <div class="row">
            <div class="col-lg-8">
                <div class="well">
                    <div class="post-block">
                        <div class="row">
                            <i class="remove post-settings fa fa-times fa-2x"></i>
                            <i class="edit post-settings fa fa-pencil fa-2x"></i>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <img src="http://devcolibri.com/cp/wp-content/uploads/2014/08/4784_logo.png" width="100" height="100">
                            </div>
                            <div class="col-lg-10 post-description">
                                <h3>Создание квадратных элементов</h3>
                                <small>Автор: Кирилл Гусаков</small>
                                <br>
                                <a class="tag">
                                    <span>Android</span>
                                </a>
                            </div>
                        </div>
                        <hr>
                        <p>В данном уроке мы посмотрим, что такое Android.</p>
                        <div class="post-info">
                            <div class="post-info-left">
                                <i class="fa fa-history"></i>
                                <span>09.08.2014</span>
                            </div>
                            <div class="post-info-right">
                                <i class="fa fa-eye"></i>
                                <span>4561</span>
                            </div>
                        </div>
                    </div>

                    <!-- Post Edit -->
                    <div class="post-edit">
                        <div class="row">
                            <div class="col-lg-4">
                                <img src="http://devcolibri.com/cp/wp-content/uploads/2014/08/4784_logo.png" width="100" height="100">
                                <input type="file">
                            </div>
                            <div class="col-lg-8">
                                <label for="post-name">Название</label>
                                <input id="post-name" type="text" class="form-control" placeholder="Название поста">
                                <label for="post-author">Автор</label>
                                <input id="post-author" type="text" class="form-control" placeholder="Автор">
                                <label>Тэги</label>
                                <br>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        Добавить <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <div class="list-tags">
                                            <li><input type="checkbox"><span class="tag">iPhone</span></li>
                                            <li><input type="checkbox"><span class="tag">Samsung</span></li>
                                        </div>
                                        <li class="divider"></li>
                                        <li>
                                            <button type="button" class="save btn btn-primary">Сохранить</button>
                                        </li>
                                    </ul>
                                </div>
                                <button type="button" class="btn btn-danger delete">Удалить</button>
                                <div class="tags">

                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <label>Содержание</label>
                            <form method="post">
                                <textarea class="post-text"></textarea>
                            </form>
                            <button type="button" class="btn btn-info">Предпросмотр</button>
                            <button type="button" class="btn btn-default clear">Очистить</button>
                        </div>
                        <hr>
                        <div class="row">
                            <button type="button" class="btn btn-primary save-edit">Сохранить изменения</button>
                            <button type="button" class="btn btn-default cancel-edit">Отменить</button>
                        </div>
                    </div>
                    <!-- Post Edit -->
                </div>
            </div>
            <div class="col-lg-4 text-center popular">
                <h4>Популярные тэги:</h4>
                <div class="row well">
                    <a href="#" class="tag">
                        Android
                    </a>
                    <a href="#" class="tag">
                        iPhone
                    </a>
                    <a href="#" class="tag">
                        Android
                    </a>
                    <a href="#" class="tag">
                        iPhone
                    </a>
                    <a href="#" class="tag">
                        Android
                    </a>
                    <a href="#" class="tag">
                        iPhone
                    </a>
                    <a href="#" class="tag">
                        Android
                    </a>
                    <a href="#" class="tag">
                        iPhone
                    </a>
                </div>
            </div>
        </div>
        <!--  Post -->
    </div>
</body>
</html>
