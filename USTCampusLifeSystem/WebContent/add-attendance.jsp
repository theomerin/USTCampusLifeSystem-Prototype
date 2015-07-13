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
<%
	String eventId = "";
	String eventName = "";
	String eventType = "";
	String eventVenue = "";
	String date = "";
	String time = "";

	eventId = (String)session.getAttribute("event_id");  
	eventName = (String)session.getAttribute("event_name");
	eventType = (String)session.getAttribute("event_type");
	eventVenue = (String)session.getAttribute("event_venue");
	date = (String)session.getAttribute("event_date");
	time = (String)session.getAttribute("event_time");
%>
</head>
<body>
	<!-- Header -->
	<section id="top" class="header parallax-window" data-parallax="scroll"
		data-image-src="img/background.jpg">
	
	<div class="text-vertical-center">
		<div class="container">
			<div class="panel panel-default">
				<!-- Panel Heading -->
				<div class="panel-heading">
					<h1 class="text-align-left panel-title">Attendance Form</h1>
				</div>

				<!-- Panel Body -->
				<div class="panel-body">
					<!-- Start of Form -->
					<form class="form-horizontal" action="UserEventAttendance" method="post">
						<% out.println("<input id=\"eventID\" name=\"eventID\" type=\"hidden\" value=\"" + eventId + "\">"); %>
						<div class="form-group">
							<label class="col-sm-3 control-label">Student Number:</label>
							<div class="col-sm-3">
								<input id="studNo" name="studNo" type="text"
									placeholder="Student Number" class="form-control input-md" required>
							</div>
						</div>
						<hr />
						<h4 class="text-left"><strong>Event Information:</strong></h4>
						
						<div class="row">
							<div class="col-sm-3">
								<h5 class="text-right"><strong>Event Number:</strong></h5>
							</div>
							<div class="col-sm-9">
								<h5 class="text-left"><strong><%= eventId %></strong></h5>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-3">
								<h5 class="text-right"><strong>Event Name:</strong></h5>
							</div>
							<div class="col-sm-9">
								<h5 class="text-left"><strong><%= eventName %></strong></h5>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-3">
								<h5 class="text-right"><strong>Event Venue:</strong></h5>
							</div>
							<div class="col-sm-3">
								<h5 class="text-left"><%= eventVenue %></h5>
							</div>
							<div class="col-sm-1">
								<h5 class="text-right"><strong>Date:</strong></h5>
							</div>
							<div class="col-sm-5">
								<h5 class="text-left"><%= date %></h5>
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-3">
								<h5 class="text-right"><strong>Event Type:</strong></h5>
							</div>
							<div class="col-sm-3">
								<h5 class="text-left"><%= eventType %></h5>
							</div>
							<div class="col-sm-1">
								<h5 class="text-right"><strong>Time:</strong></h5>
							</div>
							<div class="col-sm-5">
								<h5 class="text-left"><%= time %></h5>
							</div>
						</div>
						<hr />
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-3">
								<button type="submit" class="btn btn-info btn-lg btn-block">Register
									Now!</button>
							</div>
						</div>
					</form>

				</div>
			</div>
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