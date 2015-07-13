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
	<div id="invalidPass" class="content">
		<div class="alert alert-danger fade-in alert-box col-xs-12">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Error!</strong> The passwords provided does not match.
		</div>
	</div>
	<div id="invalidStudNo" class="content">
		<div class="alert alert-danger fade-in alert-box col-xs-12">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Error!</strong> Invalid student number entered.
		</div>
	</div>
	<div id="invalidCollege" class="content">
		<div class="alert alert-warning fade-in alert-box col-xs-12">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Oops!</strong> Please don't forget to choose your college.
		</div>
	</div>
	<div class="text-vertical-center">
		<div class="container">
			<div class="panel panel-default">
				<!-- Panel Heading -->
				<div class="panel-heading">
					<h1 class="text-align-left panel-title">Sign Up</h1>
				</div>

				<!-- Panel Body -->
				<div class="panel-body">
					<!-- Start of Form -->
					<form class="form-horizontal" action="AddUser" onsubmit="return userVal()" method="post">
						<div id="acadInfoStudNo" class="form-group">
							<label class="col-sm-3 control-label">Academic
								Information:</label>
							<div class="col-sm-3">
								<input id="studNo" name="studNo" type="text"
									placeholder="Student Number" class="form-control input-md" required onfocus="resetStudNo()"><span id="studNoInit" class=""
									aria-hidden="true"></span>
							</div>
						</div>
						<div id="acadInfoCollege" class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<select id="collegeAff" name="collegeAff" class="form-control" onfocus="resetCol()">
									<option value="0">-Choose Affiliated Faculty,
										College, or Institute-</option>
									<option value="1">Faculty of Sacred Theology</option>
									<option value="2">Faculty of Philosophy</option>
									<option value="3">Faculty of Canon Law</option>
									<option value="4">Graduate School</option>
									<option value="5">College of Architecture</option>
									<option value="6">AMV College of Accountancy</option>
									<option value="7">Faculty of Arts and Letters</option>
									<option value="8">Faculty of Civil Law</option>
									<option value="9">College of Commerce and Business
										Administration</option>
									<option value="10">College of Education</option>
									<option value="11">Faculty of Engineering</option>
									<option value="12">College of Fine Arts and Design</option>
									<option value="13">Institute of Information and
										Computing Sciences</option>
									<option value="14">Faculty of Medicine and Surgery</option>
									<option value="15">Conservatory of Music</option>
									<option value="16">College of Nursing</option>
									<option value="17">Faculty of Pharmacy</option>
									<option value="18">Institute of Physical Education and
										Athletics</option>
									<option value="19">College of Rehabilitation Sciences</option>
									<option value="20">College of Science</option>
									<option value="21">College of Tourism and Hospitality
										Management</option>
								</select><span id="collegeInit" class=""
									aria-hidden="true"></span>
							</div>
						</div>
						<hr />
						<div class="form-group">
							<label class="col-sm-3 control-label">Name:</label>
							<div class="col-sm-3">
								<input id="firstName" name="firstName" type="text"
									placeholder="First Name" class="form-control input-md" required>
							</div>
							<div class="col-sm-3">
								<input id="middleName" name="middleName" type="text"
									placeholder="Middle Name" class="form-control input-md">
							</div>
							<div class="col-sm-3">
								<input id="lastName" name="lastName" type="text"
									placeholder="Last Name" class="form-control input-md" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Contact Details:</label>
							<div class="col-sm-3">
								<input id="cellNo" name="cellNo" type="text"
									placeholder="Cellphone Number" class="form-control input-md">
							</div>
							<div class="col-sm-3">
								<input id="phoneNo" name="phoneNo" type="text"
									placeholder="Telephone Number" class="form-control input-md">
							</div>
							<div class="col-sm-3">
								<input id="email" name="email" type="text"
									placeholder="Email Address" class="form-control input-md">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Birthday:</label>
							<div class="col-sm-3">
								<div class="bfh-datepicker" data-format="y-m-d"
									data-date="today" data-name="birthday"></div>
							</div>
							<label class="col-sm-3 control-label">Gender:</label>
							<div class="col-sm-3">
								<div class="radio col-sm-6">
									<label> <input type="radio" name="gender"
										id="optionsRadios1" value="M" required> <i
										class="fa fa-male fa-lg"></i> Male
									</label>
								</div>
								<div class="radio col-sm-6">
									<label> <input type="radio" name="gender"
										id="optionsRadios2" value="F" required> <i
										class="fa fa-female fa-lg"></i> Female
									</label>
								</div>
							</div>
						</div>
						<hr />
						<div id="passField" class="form-group">
							<label class="col-sm-3 control-label">Password:</label>

							<div class="col-sm-3">
								<input id="password" name="password" type="password"
									placeholder="Input your password" class="form-control input-md"
									onfocus="resetPassInit()" required> <span id="passInit" class=""
									aria-hidden="true"></span>
							</div>
							<div class="col-sm-3">
								<input id="passwordRep" name="passwordRep" type="password"
									placeholder="Confirm your password"
									class="form-control input-md" onfocus="resetPassConf()" required>
								<span id="passConf" class="" aria-hidden="true"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Status:</label>
							<div class="col-sm-3">
								<select id="role" name="role" class="form-control" required>
									<option value="M">Student (Member)</option>
									<option value="L" disabled>Student (Servant-Leader)</option>
									<option value="A">Alumni</option>
								</select>
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

	<!-- Parallax.js -->
	<script src="js/parallax.js"></script>

	<!-- Bootstrap Form Helpers -->
	<script src="js/bootstrap-formhelpers.js"></script>

	<!-- Password Validation -->
	<script src="js/addUserValidation.js"></script>
</body>

</html>
