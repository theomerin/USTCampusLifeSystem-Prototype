<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>
	<%
		HttpSession sessionName = request.getSession();
		String name;
		String role = (String) sessionName.getAttribute("role");
		if (sessionName != null) {
			if (!((String) sessionName.getAttribute("stud_no"))
					.equals("KERYGMA")) {
				name = (String) sessionName.getAttribute("fname") + " "
						+ (String) sessionName.getAttribute("lname");
				out.print(name);
			} else {
				name = (String) sessionName.getAttribute("lname");
				out.print(name);
			}
		}
	%> | UST Campus Life - The Happiest Place on the Thomasian Grounds
</title>

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

</head>
<body>
	<div id="home-height">
		<%@ include file="home-header.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<!-- left -->
					<h3>
						<i class="glyphicon glyphicon-briefcase"></i> Toolbox
					</h3>
					<hr>

					<%
						switch (role) {
						case "S":
					%>
					<jsp:include page="admin-tools.jsp" flush="true" />
					<%
						break;
						case "L":
					%>
					<jsp:include page="servant-tools.jsp" flush="true" />
					<%
						break;
						case "M":
					%>
					<jsp:include page="admin-tools.jsp" flush="true" />
					<%
						break;
						case "A":
					%>
					<jsp:include page="admin-tools.jsp" flush="true" />
					<%
						break;
						}
					%>

					<hr>
				</div>
				<!-- /span-3 -->
				<div class="col-sm-9">
					<!-- column 2 -->
					<h3>
						<i class="glyphicon glyphicon-dashboard"></i> Dashboard
					</h3>
					<hr>
					<h1>
						Welcome,
						<%
						if (sessionName != null) {
							if (!((String) sessionName.getAttribute("stud_no"))
									.equals("KERYGMA")) {
								name = (String) sessionName.getAttribute("fname") + " "
										+ (String) sessionName.getAttribute("lname");
								out.print(name);
							} else {
								name = (String) sessionName.getAttribute("lname");
								out.print(name);
							}
							switch (role) {
							case "S":
								out.print(" <span class=\"label label-danger\">Administrator</span>");
								break;
							case "L":
								out.print(" <span class=\"label label-primary\">Servant-Leader</span>");
								break;
							case "M":
								out.print(" <span class=\"label label-success\">Member</span>");
								break;
							case "A":
								out.print(" <span class=\"label label-info\">Alumni</span>");
								break;
							}
						}
					%>
					</h1>
					<div class="row">
						<%
							switch (role) {
							case "L":
						%>
						<jsp:include page="organized-events-home.jsp" flush="true" />
						<%
							break;
							default:
								break;
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr />
	<%@ include file="footer.jsp"%>

	<!-- script references -->
	<!-- <script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>  -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>