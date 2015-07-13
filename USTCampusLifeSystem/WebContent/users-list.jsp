<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Members Masterlist | UST Campus Life - The Happiest Place on the Thomasian
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
			"sAjaxSource" : "./QueryUser",
			"aoColumns" : [ {
				"mData" : "studentNumber"
			}, {
				"mData" : "name"
			}, {
				"mData" : "college"
			}, {
				"mData" : "role"
			}, {
				"mData" : "birthday"
			}, {
				"mData" : "cellNo"
			}, {
				"mData" : "phoneNo"
			}, {
				"mData" : "email"
			}, {
				"mData" : "gender"
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
				<h1 class="page-header">Members Masterlist</h1>
				<div class="row">
					<div class="col-md-offset-9 col-md-3">
					<a href="UsersMasterListGenerator" target="_blank">
						<button type="button" class="btn btn-primary btn-block">
							<i class="glyphicon glyphicon-list-alt"></i> Generate Members
							List
						</button></a>
				</div>
				</div>
				<br/>
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
										<th>Birthday</th>
										<th>Cellphone Number</th>
										<th>Phone Number</th>
										<th>Email Address</th>
										<th>Gender</th>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</table>
				<br />
				<div class="row">
					<div class="col-md-offset-9 col-md-3">
					<a href="UsersMasterListGenerator" target="_blank">
						<button type="button" class="btn btn-primary btn-block">
							<i class="glyphicon glyphicon-list-alt"></i> Generate Members
							List
						</button></a>
				</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>