<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% 
	String eventId = "";
	RequestDispatcher rd;
	if (!request.getAttribute("event_id").equals(null)) {
		eventId = (String) request.getAttribute("event_id");
	} else {
		rd = request.getRequestDispatcher("error-500.jsp");
		rd.forward(request, response);	
	}
	%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>UST Campus Life - The Happiest Place on the Thomasian
	Grounds</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<link rel="shortcut icon" href="favicon.ico" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<!-- Header -->
	<section id="top" class="header parallax-window" data-parallax="scroll">
	<div class="text-vertical-center">
		<h1>Oops! There has to be a problem</h1>
		<h2>Error Found: Unable to add information to the database. Please try again.</h2>
		<br />
		<form class="form-signin" action="AttendanceGateway" method="post">
		<% out.println("<input id=\"eventID\" name=\"eventID\" type=\"hidden\" value=\"" + eventId + "\">"); %>
		<button class="btn btn-success btn-lg" type="submit">Register Others...</button>
		<a href="EndAttendanceRegistration"><button class="btn btn-primary btn-lg" type="button">Home</button></a>
		</form>
		<br/>
		<h4>
			Still having a problem? Email us at&nbsp;<a class="text-yellow"
				href="mailto:ustcampusfeast@gmail.com">ustcampusfeast@gmail.com</a>
		</h4>
	</div>
	</section>

	<%@ include file="footer.jsp"%>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Parallax.js -->
	<script src="js/parallax.js"></script>
</body>

</html>
