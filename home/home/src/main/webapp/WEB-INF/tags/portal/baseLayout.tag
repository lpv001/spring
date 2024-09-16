<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="content"  fragment="true" %>

<%@ attribute name="head" fragment="true" %>
<%@ attribute name="styles" fragment="true" %>
<%@ attribute name="scripts" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${ title }</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

		<jsp:invoke fragment="head"/>
		<jsp:invoke fragment="styles"/>
	</head>
	<body>
		<header>
		  <nav class="navbar navbar-light bg-light p-2">
        <a class="navbar-brand" href="#">
          <img src="https://cdn-icons-png.flaticon.com/512/5968/5968671.png" width="30" height="30" class="d-inline-block align-top" alt="">
          Bootstrap
        </a>
      </nav>
		</header>
		
		<div class="body">
		  
		  <jsp:invoke fragment="content"></jsp:invoke>
		  
		</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
	</body>
</html>