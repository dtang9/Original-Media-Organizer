<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Original Media Organizer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
        <div class="col-10">
            <div class="jumbotron">
                <h2 class="text-center">Edit Post</h2>
                <form action="EditModule" method="post">
                	<input type="hidden" name="id" value="${post.id}"/>
                    <div class="form-group">
                        <label for="user">Username</label>
                        <input type="text" class="form-control" name="user" value="${post.user}">
                    </div>
                    <div class="form-group">
                        <label for="title">Post title</label>
                        <input type="text" class="form-control" name="title" value="${post.title}">
                    </div>
                    <div class="form-group">
                        <label for="message">Message</label>
                        <textarea class="form-control" id="message" name="message" rows="3">${post.message}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="message">Hashtag</label>
                        <c:forEach items="${post.hashtags}" var="hashtag">
                            <input type="text" class="form-control" name="word" value="${hashtag.word}">
                        </c:forEach>
                    </div>
                    <h3 class="text-center">Edit Media</h3>
                    <c:forEach items="${post.mediafiles}" var="mediafile">
                        <div class="form-group">
                            <label for="name">Media Name</label>
                            <input type="text" class="form-control" name="medianame" value="${mediafile.name}">
                        </div>
                        <div class="form-group">
                            <label for="mediafile">Media File</label>
                            <input type="text" class="form-control" name="mediafile" value="${mediafile.media_file}">
                        </div>
                        <div class="form-group">
                            <label for="url">Media URL</label>
                            <input type="text" name="url" class="form-control" placeholder="URL"
                                value="${mediafile.url}">
                        </div>
                    </c:forEach>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    </div>
</body>

</html>