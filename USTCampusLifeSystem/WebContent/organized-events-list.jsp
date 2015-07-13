<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organized Events | UST Campus Life - The Happiest Place
	on the Thomasian Grounds</title>

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

			$("#eventslist").dataTable({
				"bProcessing" : false,
				"bServerSide" : false,
				"sort" : "position",
				"sAjaxSource" : "./QueryEvent",
				"aoColumns" : [ {
					"mData" : "eventID"
				}, {
					"mData" : "eventName"
				}, {
					"mData" : "eventTypeDesc"
				}, {
					"mData" : "eventVenueDesc"
				}, {
					"mData" : "eventStartDate"
				}, {
					"mData" : "eventEndDate"
				}, {
					"mData" : "eventStartTime"
				}, {
					"mData" : "eventEndTime"
				}, {
					"mData" : "status"
				}, {
					"mData" : "control"
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
				<h1 class="page-header">My Organized Events</h1>
				<br />
				<table width="100%" class="table-responsive">
					<tr>
						<td>
							<table id="eventslist"
								class="display table table-hover table-condensed"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Event ID</th>
										<th>Event Name</th>
										<th>Type</th>
										<th>Venue</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Status</th>
										<th>Controls</th>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</table>
				<br />
			</form>
		</div>
	</div>

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>


</body>
</html>