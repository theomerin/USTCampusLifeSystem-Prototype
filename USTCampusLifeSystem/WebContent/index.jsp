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

	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i
		class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i
			class="fa fa-times"></i></a>
		<li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click(); >UST
				Campus Life</a></li>
		<li><a href="#top" onclick=$("#menu-close").click(); >Home</a></li>
		<li><a href="#about" onclick=$("#menu-close").click(); >About</a>
		</li>
		<li><a href="#services" onclick=$("#menu-close").click(); >Mission
				&amp; Vision</a></li>
		<li><a href="#portfolio" onclick=$("#menu-close").click(); >Links &amp; Resources</a></li>
		<li><a href="#login" onclick=$("#menu-close").click(); >Sign
				In</a></li>
		<li><a href="#contact" onclick=$("#menu-close").click(); >Contact</a>
		</li>
	</ul>
	</nav>

	<!-- Header -->
	<header id="top" class="header parallax-window" data-parallax="scroll"
		data-image-src="img/background.jpg">
	<div class="text-vertical-center">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<img class="img-responsive" src="img/ucl-logo-white-shadow.png"></img>
				<br> <a href="#about" class="btn btn-outline btn-lg">FIND
					OUT MORE</a> <br>
			</div>
		</div>

	</div>
	</header>

	<!-- About -->
	<section id="about" class="about bg-dark-grey">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="text-yellow">UST Campus Life</h2>
				<hr class="small">
				<p class="text-white lead">
					Also known as UST Campus Feast. <br> Part of the LIGHT OF
					JESUS FAMILY (LOJF), specifically to its campus ministry and an
					extension of Light of Jesus' Youth Missions, Campus Life. <br /> <br />This
					organization will hold the event that shall be called &ldquo;CAMPUS
					FEAST&rdquo; which shall be comprised of the celebration of the
					Holy Mass, worship and preaching. It will also initiate, sustain
					and nurture a light group (LG) culture within the event, within the
					organization, and the university.
				</p>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>

	<!-- Services -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<section id="services" class="services bg-primary">
	<div class="container">
		<div class="row text-center">
			<div class="col-lg-10 col-lg-offset-1">
				<h2>Mission &amp; Vision</h2>
				<hr class="small">
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="service-item">
							<span class="fa-stack fa-4x"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-life-ring fa-stack-1x text-primary"></i>
							</span>
							<h3>
								<strong>Mission</strong>
							</h3>
							<p class="lead">Leading and Discipling Thomasians through the
								Light Groups which nurtures a Christ-centered relationship.</p>

						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="service-item">
							<span class="fa-stack fa-4x"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-compass fa-stack-1x text-primary"></i>
							</span>
							<h3>
								<strong>Vision</strong>
							</h3>
							<p class="lead">Having Dynamic Thomasian Disciple-makers and
								Servant-leaders at every institution who will lead others to
								Jesus instilling the values of Competence, Commitment, and
								Compassion.</p>

						</div>
					</div>
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.col-lg-10 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>

	<!-- Portfolio -->
	<section id="portfolio" class="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 text-center">
				<h2>Links &amp; Resources</h2>
				<hr class="small">
				<div class="row">
					<div class="col-md-6">
						<div class="portfolio-item">
							<a href="http://www.lightfam.com/" target="_blank"> <img class="img-portfolio img-responsive"
								src="img/link-lightfam.jpg">
							</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="portfolio-item">
							<a href="http://kerygmaconference.com/" target="_blank"> <img class="img-portfolio img-responsive"
								src="img/link-kcon.jpg">
							</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="portfolio-item">
							<a href="#" target="_blank"> <img class="img-portfolio img-responsive"
								src="img/link-worship.jpg">
							</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="portfolio-item">
							<a href="prayer-request.jsp" target="_blank"> <img class="img-portfolio img-responsive"
								src="img/link-prayer.jpg">
							</a>
						</div>
					</div>
				</div>
				<!-- /.row (nested) -->
				<!-- <a href="#" class="btn btn-lg btn-dark">View More Items</a> -->
			</div>
			<!-- /.col-lg-10 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>

	<!-- Login -->
	<section id="login" class="login parallax-window"
		data-parallax="scroll" data-image-src="img/login.jpg">
	<div class="text-vertical-center">
		<h1>Sign In</h1>
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
					<h4>
						Don't have an account? Email us at&nbsp;<a class="text-yellow"
							href="mailto:ustcampusfeast@gmail.com">ustcampusfeast@gmail.com</a>
					</h4>
				</div>
			</form>
		</div>
		<!-- /container -->
	</div>
	</section>

	<!-- Map -->
	<section id="contact" class="map"> <iframe width="100%"
		height="100%" frameborder="0" scrolling="no" marginheight="0"
		marginwidth="0"
		src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3860.806379501661!2d120.98923099999999!3d14.610102999999995!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3397c99022f8f01f%3A0x1a1986c3b4fb34cf!2sUniversity+of+Santo+Tomas!5e0!3m2!1sen!2sph!4v1430930089621"></iframe>
	<br />
	<small> <a
		href="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3860.806379501661!2d120.98923099999999!3d14.610102999999995!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3397c99022f8f01f%3A0x1a1986c3b4fb34cf!2sUniversity+of+Santo+Tomas!5e0!3m2!1sen!2sph!4v1430930089621"></a>
	</small> </iframe> </section>

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
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
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
