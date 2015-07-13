<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String eventId = "";
	String eventName = "";
	String eventType = "";
	String eventVenue = "";
	String date = "";
	String time = "";

	eventId = (String) session.getAttribute("event_id");
	eventName = (String) session.getAttribute("event_name");
	eventType = (String) session.getAttribute("event_type");
	eventVenue = (String) session.getAttribute("event_venue");
	date = (String) session.getAttribute("event_date");
	time = (String) session.getAttribute("event_time");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendees List | UST Campus Life - The Happiest Place on
	the Thomasian Grounds</title>

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

<%@ include file="datatables.jsp"%>

<link rel="shortcut icon" href="favicon.ico" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">
	$(document).ready(function() {

		var table = $("#masterlist").DataTable({
			"bProcessing" : false,
			"bServerSide" : false,
			"sort" : "position",
			"sAjaxSource" : "./QueryAttendees",
			"aoColumns" : [ {
				"mData" : "studentNumber"
			}, {
				"mData" : "name"
			}, {
				"mData" : "college"
			}, {
				"mData" : "role"
			},

			]
		});
	});
</script>

</head>
<body>
	<div class="container">
		<div class="content">
			<form action="">
				<h1 class="page-header">Attendees List</h1>
				<div class="container-fluid">
					<h4 class="text-left">
						<strong>Event Information:</strong>
					</h4>

					<div class="row">
						<div class="col-sm-3">
							<h5 class="text-right">
								<strong>Event Number:</strong>
							</h5>
						</div>
						<div class="col-sm-9">
							<h5 class="text-left">
								<strong><%=eventId%></strong>
							</h5>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<h5 class="text-right">
								<strong>Event Name:</strong>
							</h5>
						</div>
						<div class="col-sm-9">
							<h5 class="text-left">
								<strong><%=eventName%></strong>
							</h5>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<h5 class="text-right">
								<strong>Event Venue:</strong>
							</h5>
						</div>
						<div class="col-sm-3">
							<h5 class="text-left"><%=eventVenue%></h5>
						</div>
						<div class="col-sm-1">
							<h5 class="text-right">
								<strong>Date:</strong>
							</h5>
						</div>
						<div class="col-sm-5">
							<h5 class="text-left"><%=date%></h5>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<h5 class="text-right">
								<strong>Event Type:</strong>
							</h5>
						</div>
						<div class="col-sm-3">
							<h5 class="text-left"><%=eventType%></h5>
						</div>
						<div class="col-sm-1">
							<h5 class="text-right">
								<strong>Time:</strong>
							</h5>
						</div>
						<div class="col-sm-5">
							<h5 class="text-left"><%=time%></h5>
						</div>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-md-offset-9 col-md-3">
						<a href="AttendanceMasterlistGenerator" target="_blank">
							<button type="button" class="btn btn-primary btn-block">
								<i class="glyphicon glyphicon-list-alt"></i> Generate List
							</button>
						</a>
					</div>
				</div>
				<br />
				<table width="100%" class="table-responsive">
					<tr>
						<td>
							<table id="masterlist"
								class="display table table-hover table-condensed"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Student Number</th>
										<th>Name</th>
										<th>College</th>
										<th>Status</th>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</table>
				<br />
				<div class="row">
					<div class="col-md-offset-9 col-md-3">
						<a href="AttendanceMasterlistGenerator" target="_blank">
							<button type="button" class="btn btn-primary btn-block">
								<i class="glyphicon glyphicon-list-alt"></i> Generate List
							</button>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>