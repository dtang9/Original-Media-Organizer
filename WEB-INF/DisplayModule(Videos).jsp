<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Original Media Organizer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="display.css">
</head>

<body>
    <!-- INSERT HTML/CSS/Bootstrap CODE BELOW -->
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Original Media Organizer</a>
    </nav>
    <div class="row justify-content-md-center">
        <div class="col">
            <ul class="list-group">
                <a href="DisplayModule" class="list-group-item list-group-item-action">Home Page</a>
            </ul>
        </div>
        <div class="col-8">
            <div class="jumbotron">
                <h2 class="text-center">Videos</h2>
                <c:forEach items="${videos}" var="video">
                    <div class="card">
                        <div class="card-header">
                            Video
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${video.name}</h5>
                            <p class="card-text"><a class="${video.name}" href="${video.url}">
                                    ${video.url}</a></p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Media Filter
                </div>
                <div class="card-body">
                    Video
                </div>
            </div>
        </div>
    </div>
</body>

</html>