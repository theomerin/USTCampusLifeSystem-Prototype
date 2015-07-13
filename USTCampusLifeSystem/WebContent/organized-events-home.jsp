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
					"mData" : "status"
				},

				]
			});

		});
	</script>
	
		<div class="container col-sm-12">
			<form action="">
				<h1 class="page-header">Your Organized Events</h1>
				<div class="row">
					<div class="col-md-3">
					<a class="btn btn-default" href="organized-events-list.jsp" role="button" target="_blank"><i class="glyphicon glyphicon-list"></i> See details...</a>
				</div>
				</div>
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
										<th>Status</th>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</table>
				<br />
			</form>
		</div>