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
                <a href="Display" class="list-group-item list-group-item-action">Home</a>
            </ul>
        </div>
        <div class="col-10">
            <div class="jumbotron">
                <h2 class="text-center">Post</h2>
                <form action="MakePost" method="post">
  <div class="form-group">
    <label for="user">User's name</label>
    <input type="text" class="form-control" name="user">
  </div>
    <div class="form-group">
    <label for="title">Post title</label>
    <input type="text" class="form-control" name="title">
  </div>
  <div class="form-group">
    <label for="message">Message</label>
    <textarea class="form-control" id="message" name="message" rows="3"></textarea>
  </div>
  <div class="form-group">
    <label for="message">Hashtag</label>
    <input type="text" class="form-control" name="word" placeholder="#word">
  </div>
  <h3 class="text-center">Create/Upload Media</h3>
  <div class="form-group">
    <label for="name">Name of media</label>
    <input type="text" class="form-control" name="medianame">
  </div>
    <div class="form-group">
    <label for="mediafile">Media File</label>
      <select name="mediafile" class="form-control">
        <option value="image">Image</option>
        <option value="video">Video</option>
        <option value="audio">Audio</option>
      </select>
  </div>
    <div class="form-group">
    <label for="url">Media URL</label>
    <input type="text" name="url" class="form-control" placeholder="URL">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
            </div>
        </div>
        
    </div>
</body>
</html>