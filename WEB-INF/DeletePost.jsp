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
                <a href="Display" class="list-group-item list-group-item-action">Home</a>
            </ul>
        </div>
        <div class="col-8">
            <div class="jumbotron">
                <h2 class="text-center">Are you sure you want to delete?</h2>
                <div class="card">
                    <div class="card-header">
                        ${post.user}
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5> 
                        <h6 class="card-subtitle mb-2 text-muted">${post.date}</h6>
                        <p class="card-text">${post.message}</p>
                        <c:forEach items="${post.mediafiles}" var="mediafile">
                        ${mediafile.media_file}:
                        <a class="${mediafile.name}" href="${mediafile.url}">
                            ${mediafile.url}</a>
                           </c:forEach><br>
                        <c:forEach items="${post.hashtags}" var="hashtag">
                            ${hashtag.word} </c:forEach>                            
                    </div>
                    <div class="card-footer">
                        <a href="DeletePost?id=${post.id}" class="btn btn-danger">Delete</a>
  					</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
