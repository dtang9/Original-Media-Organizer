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
                <a href="#" class="list-group-item list-group-item-action">Home</a>
                <a href="#" class="list-group-item list-group-item-action">Edit Media</a>
                <a href="#" class="list-group-item list-group-item-action">Following</a>
            </ul>
        </div>
        <div class="col-8">
            <div class="jumbotron">
                <h2 class="text-center">Feed/Media</h2>
                <c:forEach items="${posts}" var="post">
                <div class="card">
                    <div class="card-header">
                        ${post.username}
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5> 
                        <h6 class="card-subtitle mb-2 text-muted">${post.date}</h6>
                        <p class="card-text">${post.text}</p>
                        <c:forEach items="${post.mediafiles}" var="mediafile">
                        ${mediafile.media_type}:
                        <a class="${mediafile.name}" href="${mediafile.url}">
                            ${mediafile.url}</a>
                            </c:forEach>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Media Filters
                </div>
                <form action="Filter" method="post">
                <div class="card-body">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="textfilter"
                            value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Text
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="imagefilter"
                            value="option2">
                        <label class="form-check-label" for="exampleRadios2">
                            Images
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="videofilter"
                            value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Videos
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="audiofilter"
                            value="option2">
                        <label class="form-check-label" for="exampleRadios2">
                            Audio
                        </label>
                    </div>
                        <input name="filter" type="submit" value="Filter">
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>