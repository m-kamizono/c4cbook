<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>本登録画面</title>
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/top.css" media="screen">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">


<script src="https://kit.fontawesome.com/fdfc67613f.js" crossorigin="anonymous"></script>
</head>
<body>
    <section class="header">
        <h2 class="title">C4CBOOK</h2>
    </section>



    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-4 mt-4">
                <p>${message}</p>
            <h4>本登録</h4>
                <%--@elvariable id="registerBookForm" type=""--%>
                <form:form modelAttribute="registerBookForm" enctype="multipart/form-data" method="POST">
                    タイトル： <form:input class="form-control" type="text" path="title"/><form:errors path="title" />
                    タイトルかな： <form:input class="form-control" type="text" path="titleKana"/><form:errors path="titleKana" />
                    著者： <form:input class="form-control" type="text" path="author"/><form:errors path="author" />
                    著者かな： <form:input class="form-control" type="text" path="authorKana"/><form:errors path="authorKana" />
                    タグ：
                    <div class="col-12">
                        <input type="checkbox" value="1" id="tag1" path=""><label for="tag1">資格</label>
                        <input type="checkbox" value="2" id="tag2"><label for="tag2">入門書</label>
                        <input type="checkbox" value="3" id="tag3"><label for="tag3">WEB開発</label>
                    </div>
                    <div class="col-12">
                        <input type="checkbox" value="4" id="tag4"><label for="tag4">実用書</label>
                        <input type="checkbox" value="5" id="tag5"><label for="tag5">娯楽</label>
                    </div>
                    概要： <form:input class="form-control" type="text" path="outline"/>
                    画像： <form:input type="file" name="pic" path="bookImg"/>
                    <input class="form-control" type="hidden" value="1">
                    コメント <form:textarea class="form-control" path="offerMemComment"/>
                    <input type="submit" class="btn btn-primary btn-block mt-1">
                </form:form>
            </div>
        </div>

    </div>


</body>
</html>