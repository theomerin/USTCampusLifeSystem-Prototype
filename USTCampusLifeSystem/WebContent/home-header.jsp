
<script type="text/javascript">
	function changePass() {
		var initPass = document.getElementById("password").value;
		var confPass = document.getElementById("passwordRep").value;
		var returnValue = true;

		if (initPass != confPass) {
			document.getElementById("passField1").className += ' has-error has-feedback';
			document.getElementById("passField2").className += ' has-error has-feedback';
			document.getElementById("passInit").className += 'glyphicon glyphicon-remove form-control-feedback';
			document.getElementById("passConf").className += 'glyphicon glyphicon-remove form-control-feedback';
			returnValue = false;
		}

		return returnValue;
	}

	function resetPassCurr() {
		document.getElementById("passCur").className = "";
		document.getElementById("curr").className = "form-group";
	}

	function resetPassInit() {
		document.getElementById("passInit").className = "";
		document.getElementById("passField1").className = "form-group";
	}

	function resetPassConf() {
		document.getElementById("passConf").className = "";
		document.getElementById("passField2").className = "form-group";
	}
</script>

<!-- Password Modal -->
<form action="ChangePassword" onsubmit="return changePass()"
	method="post">
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title">Change Password</h2>
				</div>
				<div class="modal-body">

					<div id="curr" class="form-group">
						<div class="row">
							<div id="inputForm" class="col-sm-12">
								<input id="passwordCur" name="passwordCur" type="password"
									placeholder="Input your current password"
									class="form-control input-md" onfocus="resetPassCurr()"
									required>
							</div>
							<span id="passCur" class="" aria-hidden="true"></span>
						</div>
					</div>
					<hr />
					<div id="passField1" class="form-group">
						<div class="row">
							<div id="inputForm" class="col-sm-12">
								<input id="password" name="password" type="password"
									placeholder="Input your new password"
									class="form-control input-md" onfocus="resetPassInit()"
									required>
							</div>
							<span id="passInit" class="" aria-hidden="true"></span>
						</div>
						<br />
					</div>
					<div id="passField2" class="form-group">
						<div class="row">
							<div id="inputFormConf" class="col-sm-12">
								<input id="passwordRep" name="passwordRep" type="password"
									placeholder="Confirm your new password"
									class="form-control input-md" onfocus="resetPassConf()"
									required>
							</div>
							<span id="passConf" class="" aria-hidden="true"></span>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</form>

<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-toggle"></span>
			</button>
			<a class="navbar-brand" href="#">Control Panel</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a class="dropdown-toggle" role="button"
					data-toggle="dropdown" href="#"> <i
						class="glyphicon glyphicon-user"></i> <%
 	HttpSession sessionNameHeader = request.getSession();
 	String nameHeader;
 	if (sessionNameHeader != null) {
 		if (!((String) sessionNameHeader.getAttribute("stud_no"))
 				.equals("KERYGMA")) {
 			nameHeader = (String) sessionNameHeader
 					.getAttribute("fname")
 					+ " "
 					+ (String) sessionNameHeader.getAttribute("lname");
 			out.print(nameHeader);
 		} else {
 			nameHeader = (String) sessionNameHeader
 					.getAttribute("lname");
 			out.print(nameHeader);
 		}
 	}
 %> <span class="caret"></span></a>
					<ul id="g-account-menu" class="dropdown-menu" role="menu">
						<li><a href="#" data-toggle="modal"
							data-target=".bs-example-modal-sm">Change Password</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="LogoutController"><i
								class="glyphicon glyphicon-lock"></i> Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /container -->
</div>
<!-- /Header -->