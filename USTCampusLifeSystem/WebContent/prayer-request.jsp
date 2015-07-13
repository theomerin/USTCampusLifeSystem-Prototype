<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<!-- Bootstrap Form Helpers -->
<link href="css/bootstrap-formhelpers.min.css" rel="stylesheet"
	media="screen">

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

	<div class="text-vertical-center">
		<div class="container">
			<div class="panel panel-default">
				<!-- Panel Heading -->
				<div class="panel-heading">
					<h1 class="text-align-left panel-title">Prayer Request &amp;
						Intention</h1>
				</div>

				<!-- Panel Body -->
				<div class="panel-body">
					<!-- Start of Form -->
					<form class="form-horizontal" action="SendPrayerRequests"
						method="post">
						<div class="form-group">
							<h4 class="col-sm-12 text-left">Every prayer
								requests you send will be kept secret &amp; confidential. Just be open to
								God's grace and healing.<br/>Our Intercessory Ministry will surely be praying for and with you.</h4>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Name:</label>
							<div class="col-sm-5">
								<input id="name" name="name" type="text"
									placeholder="Enter your name, code name, or just leave this blank"
									class="form-control input-md">
							</div>
							<label class="col-sm-2 control-label">Prayer Concern:</label>
							<div class="col-sm-3">
								<select id="concern" name="concern" class="form-control"
									required>
									<option value="">-Choose your prayer concern-</option>
									<option value="Spiritual">Spiritual</option>
									<option value="Family">Family</option>
									<option value="Friends">Friends</option>
									<option value="Studies">Studies</option>
									<option value="Career">Career</option>
									<option value="Service">Service</option>
									<option value="Lovelife">Lovelife</option>
									<option value="Healing & Health">Healing &amp; Health</option>
									<option value="Intercession">Intercession</option>
									<option value="Others">Others</option>
								</select>
							</div>
						</div>
						<hr />
						<div class="container-fluid form-group">
							<label class="text-left">Prayer Request &amp; Intention</label>
							<textarea class="form-control" rows="7" id="prayer" name="prayer" required></textarea>
						</div>
						<hr />
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-3">
								<button type="submit" class="btn btn-info btn-lg btn-block">Send your prayers</button>
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

	<!-- Parallax.js -->
	<script src="js/parallax.js"></script>

	<!-- Bootstrap Form Helpers -->
	<script src="js/bootstrap-formhelpers.js"></script>
</body>

</html>
