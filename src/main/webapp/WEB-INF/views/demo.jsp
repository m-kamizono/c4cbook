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
    <title>デモ画面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h2>デモ画面JS</h2>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-12 mb-2">
            <form method="get">
                あいうえお順<input class="checkbox" type="checkbox" value="1" name="param">
                お気に入り数順<input class="checkbox" type="checkbox" value="2" name="param">
                読まれた回数順<input class="checkbox" type="checkbox" value="3" name="param">
                <button id="sorting" type="button" class="btn btn-primary">並び替え</button>
            </form>
        </div>

        <div id="bookList" class="col-12">
<%--            <ul>--%>
<%--                <li>ID：${topAndDetail.bookId}</li>--%>
<%--                <li>タイトル：${topAndDetail.title}</li>--%>
<%--                <li>著者${topAndDetail.author}</li>--%>
<%--                <li>読まれた回数：${topAndDetail.lendCount}</li>--%>
<%--                <li>お気に入り回数：${topAndDetail.favCount}</li>--%>
<%--                <li>タグ：${topAndDetail.tagIds}</li>--%>
<%--            </ul>--%>
        </div>

        <div class="col-12">
            ID順<input class="checkbox" type="checkbox" value="1" name="param2">
            あいうえお順<input class="checkbox" type="checkbox" value="2" name="param2">
            <button id="sorting2" type="button" class="btn btn-primary">並び替え</button>
        </div>

        <div id="content" class="col-12">
            <ul>
                <li name="id">ID：1</li>
                <li name="productName">品名：りんご</li>
            </ul>
            <ul>
                <li name="id">ID：2</li>
                <li name="productName">品名：ばなな</li>
            </ul>
            <ul>
                <li name="id">ID：3</li>
                <li name="productName">品名：すいか</li>
            </ul>
        </div>


    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="resources/js/demo.js"></script>

</body>
</html>