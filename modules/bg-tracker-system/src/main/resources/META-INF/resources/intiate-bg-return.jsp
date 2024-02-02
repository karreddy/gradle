<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Initiate BG Return</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<form role="form">
	<div class="row">
		<div class="col-lg-6"><!--<label class='control-label input-group'>Select Report Type</label>-->
			<div class="btn-group" data-toggle="buttons">
				<!--<label class="btn btn-default" ><input value='file' type="radio" id='opt_file' name='opt' /> Proposal Movement History</label>
				<label class="btn btn-default"><input value='category' type="radio" id='opt_category' name='opt' /> Proposal Category</label>
				<label class="btn btn-default"><input value='date' type="radio" id='opt_date' name='opt' />Bills in Timeline</label>
				<!--<label class="btn btn-default"><input value='action' type="radio" id='opt_action' name='opt'/> Action Taken</label>
				<label class="btn btn-default"><input value='marked' type="radio" id='opt_marked' name='opt' />Proposals Assigned </label>-->
								<!--<label class="btn btn-default"><input value='location' type="radio" id='opt_location' name='opt' />Bills Initiated by location</label>
				<label class="btn btn-default"><input value='dept' type="radio" id='opt_dept' name='opt' />Bills by Department</label>-->
							
				<!--<label class='radio-inline'><input type="radio" id='opt_category' name='opt' /> File Category</label>
				<label class='radio-inline'><input type="radio" id='opt_date' name='opt' /> Initiation Date</label>
				<label class='radio-inline'><input type="radio" id='opt_action' name='opt'/> Action Taken</label>
				<label class='radio-inline'><input type="radio" id='opt_marked' name='opt' />File Marked To</label>-->
			</div>
		</div>
		<!--<div class='col-lg-6' style="float: right;">
			
		<div class='col-lg-3' style="float: right;"><a href="bws_summary.php" class="btn btn-primary" target="blank"  >BWS MIS</a></div>
		<div class="col-lg-3" style="float: right;"><label class="control-label">Summary Report - </label></div>
		</div>-->
	</div>
	<br><br>
	<div class="row">
		<div class="col-lg-6" style="display: block">
			<div id="dateDiv" class="col-lg-6"><label class="control-label required">Enter BG Tracker ID </label>
				<input id="bws" name="bws" type="number" class="form-control" required="true"> 
			</div>	
		</div>
		</div>
		<br>
		<div class="row">
		<div id="btnDiv" class="col-lg-2">
			<button id="btnView" name="btnpub" class="btn btn-info control-label">Check Status</button>
		</div>
	</div>
	<!-- /.row -->
	</form>
	
	<br>
	<!--<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List</h1>
		</div><!-- /.col-lg-12 
		<div class="">
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<tr>
							<th>Bill Watch ID</th>
							<th>Initiated By</th>
							<th>Date of Initiation</th>
							<th>Status</th>
							<th>Time Period since initiation</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
	 /.row -->
	<div class="row">
    	<div class="pull-right"><a href="index.php" class="btn btn-primary">Back to Dashboard</a></div>
    </div>
</div>