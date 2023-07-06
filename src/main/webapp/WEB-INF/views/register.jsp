<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Register page  
</h1>


	<form action="./register" method="post">

      <div class="form-group">
        <label>Title</label>
        <input type="text" class="form-control" name="title" placeholder="Title">
      </div>
      <div class="form-group">
        <label>Content</label>
        <textarea class="form-control" rows="5" name="content"></textarea>
      </div>
      <div class="form-group">
        <label>Writer Email</label>
        <input type="email" class="form-control" name="writer" placeholder="Writer Email">
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>

    </form>	

</body>
</html>
