<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sumutella
  Date: 11/21/2019
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<head>
    <title>Non Instant Messaging</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Non Instant Messaging</a>
        </div>
        <ul class="nav navbar-nav">
            <li ><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/messages">Messages</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-4 col-sm-8 col-lg-3">
            <c:forEach var="entry" items="${messagesGroupedAndSorted}">
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <table>
                        <tr>
                            <td>${entry.key.username}</td>
                            <td rowspan="2">
                                <div style="display: flex; justify-content: flex-end" class="image-parent">
                                    <img src="${entry.key.imageSource}48.png" class="img-fluid" alt="quixote">
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td><hr>${entry.value.get(0).content}</td>
                        </tr>

                    </table>
                </li>
            </ul>
            </c:forEach>
        </div>
    </div>
</div>


</body>
</html>
