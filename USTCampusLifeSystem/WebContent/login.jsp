<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("isUserLoggedIn") != null
			&& session.getAttribute("isUserLoggedIn").equals(true)) {
		response.sendRedirect("home.jsp");
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
	<section id="top" class="header parallax-window" data-parallax="scroll"
		data-image-src="img/background.jpg"> 
		
	<%
 		String invalid = ""; 
		invalid = invalid + (String) request.getAttribute("INVALID");
 			if (invalid.equals("INVALID_CREDENTIALS")) {%>
  				<jsp:include page="invalid-credentials.jsp" flush="true" /> <%
 			} else if (invalid.equals("NO_AUTHORIZATION")) {%>
				<jsp:include page="no-authorization.jsp" flush="true" /> <%
			}
 	%>

	<div class="text-vertical-center">
		<h1 class="text-white">Sign In</h1>
		<br />
		<div class="container">
			<form class="form-signin" action="UserLogin" method="post">
				<div class="form-group col-md-6 col-md-offset-3">
					<label for="inputStudentNumber" class="sr-only">Student
						Number</label> <input type="text" id="inputEmail"
						class="form-control input-lg" name="studentNumber"
						placeholder="Student Number" required>
				</div>
				<div class="form-group col-md-6 col-md-offset-3">
					<label for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="inputPassword" class="form-control input-lg"
						name="password" placeholder="Password" required>
				</div>
				<div class="col-md-6 col-md-offset-3 ">
					<button class="btn btn-outline btn-lg btn-block" type="submit">SIGN
						IN</button>
				</div>
				<div class="col-md-6 col-md-offset-3 ">
					<h4 class="text-white">
						Don't have an account? Email us at&nbsp;<a class="text-yellow"
							href="mailto:ustcampusfeast@gmail.com">ustcampusfeast@gmail.com</a>
					</h4>
				</div>
			</form>
		</div>
		<!-- /container -->
	</div>
	</section>

	<%@ include file="footer.jsp"%>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script>
		// Closes the sidebar menu
		$("#menu-close").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});

		// Opens the sidebar menu
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});

		// Scrolls to the selected menu item on the page
		$(function() {
			$('a[href*=#]:not([href=#])')
					.click(
							function() {
								if (location.pathname.replace(/^\//, '') == this.pathname
										.replace(/^\//, '')
										|| location.hostname == this.hostname) {

									var target = $(this.hash);
									target = target.length ? target
											: $('[name=' + this.hash.slice(1)
													+ ']');
									if (target.length) {
										$('html,body').animate({
											scrollTop : target.offset().top
										}, 1000);
										return false;
									}
								}
							});
		});
	</script>

	<!-- Parallax.js -->
	<script src="js/parallax.js"></script>
</body>

</html>
