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
	<div id="invalidType" class="content">
		<div class="alert alert-warning fade-in alert-box col-xs-12">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Oops!</strong> Please don't forget to choose your event type.
		</div>
	</div>
	<div id="invalidVenue" class="content">
		<div class="alert alert-warning fade-in alert-box col-xs-12">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Oops!</strong> Please don't forget to choose your event
			venue.
		</div>
	</div>
	<div class="text-vertical-center">
		<div class="container">
			<div class="panel panel-default">
				<!-- Panel Heading -->
				<div class="panel-heading">
					<h1 class="text-align-left panel-title">Organize Event</h1>
				</div>

				<!-- Panel Body -->
				<div class="panel-body">
					<!-- Start of Form -->
					<form class="form-horizontal" action="AddEvent"
						onsubmit="return eventVal()" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label">SAAF Event Number:</label>
							<div class="col-sm-2">
								<input id="saaf" name="saaf" type="text"class="form-control input-md">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">General
								Information:</label>
							<div class="col-sm-6">
								<input id="evtName" name="evtName" type="text"
									placeholder="Event Name" class="form-control input-md" required>
							</div>
							<div class="col-sm-3">
								<div id="eventInfoType" class="">
									<select id="eventType" name="eventType" class="form-control"
										onfocus="resetType()">
										<option value="0">-Choose Event Type-</option>
										<option value="1">General Assembly</option>
										<option value="2">Feast Gathering</option>
										<option value="3">Worship Night</option>
										<option value="4">Youth Gathering</option>
										<option value="5">Seminar</option>
										<option value="6">Light Groups</option>
										<option value="7">Camp Calye</option>
										<option value="8">ALAB</option>
										<option value="9">STEP</option>
										<option value="10">Others</option>
									</select><span id="typeInit" class="" aria-hidden="true"></span>
								</div>
							</div>
						</div>
						<hr />
						<div class="form-group">
							<label class="col-sm-3 control-label">Venue:</label>
							<div class="col-sm-6">
								<div id="eventInfoVenue" class="">
									<select id="eventVenue" name="eventVenue" class="form-control"
										onfocus="resetVenue()">
										<option value="0">-Choose Event Venue-</option>
										<option value="1">AMV-COA Multi-Purpose Hall (Whole)</option>
										<option value="2">AMV-COA Multi-Purpose Hall (Part A)</option>
										<option value="3">AMV-COA Multi-Purpose Hall (Part B)</option>
										<option value="4">AMV-COA Multi-Purpose Hall (Part C)</option>
										<option value="5">Beato Angelico AVR</option>
										<option value="6">Beato Angelico Gallery</option>
										<option value="7">Civil Law Auditorium</option>
										<option value="8">Civil Law Lobby</option>
										<option value="9">Covered Walk</option>
										<option value="10">Albertus Magnus Auditorium
											(Education Auditorium)</option>
										<option value="11">Engineering Conference Hall</option>
										<option value="12">Gazebo (In front of Medicine
											Building)</option>
										<option value="13">Martin de Porres Auditorium
											(Medicine Auditorium)</option>
										<option value="14">P. Noval Covered Court</option>
										<option value="15">Plaza Mayor</option>
										<option value="16">Quadricentennial Pavilion (Covered
											Court)</option>
										<option value="17">Quadricentennial Pavilion
											(Practice Gymnasium)</option>
										<option value="18">Quadricentennial Square</option>
										<option value="19">TARC Auditorium</option>
										<option value="20">UST Football Field/ UST Grandstand</option>
										<option value="21">UST Parade Grounds</option>
										<option value="22">UST Swimming Pool</option>
										<option value="23">UST Tan Yan Kee Lobby</option>
										<option value="24">UST Tan Yan Kee AVR</option>
										<option value="25">UST Tan Yan Kee Multi-Purpose Hall</option>
										<option value="26">UST Tan Yan Kee Chapel</option>
										<option value="27">In-Campus</option>
										<option value="28">Off-Campus</option>
									</select><span id="venueInit" class="" aria-hidden="true"></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Start Date:</label>
							<div class="col-sm-3">
								<div class="bfh-datepicker" data-format="y-m-d"
									data-date="today" data-name="startDate"></div>
							</div>
							<label class="col-sm-1 control-label">End Date:</label>
							<div class="col-sm-3">
								<div class="bfh-datepicker" data-format="y-m-d"
									data-date="today" data-name="endDate"></div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Start Time:</label>
							<div class="col-sm-3">
								<div class="bfh-timepicker" data-mode="12h" data-name="startTime"></div>
							</div>
							<label class="col-sm-1 control-label">End Time:</label>
							<div class="col-sm-3">
								<div class="bfh-timepicker" data-mode="12h" data-name="endTime"></div>
							</div>
						</div>
						<hr />
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-3">
								<button type="submit" class="btn btn-success btn-lg btn-block">Book
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

	<!-- Parallax.js -->
	<script src="js/parallax.js"></script>

	<!-- Bootstrap Form Helpers -->
	<script src="js/bootstrap-formhelpers.js"></script>

	<!-- Password Validation -->
	<script src="js/addEventValidation.js"></script>
</body>

</html>