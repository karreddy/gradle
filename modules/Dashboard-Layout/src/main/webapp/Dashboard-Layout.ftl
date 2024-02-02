<div class="Dashboard-Layout" id="main-content" role="main">
	<div class="portlet-layout row">
		<div class="col-md-5 portlet-column portlet-column-first" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")}
		</div>
		<div class="col-md-5 portlet-column portlet-column-second" id="column-2">
			${processor.processColumn("column-2", "portlet-column-content portlet-column-content-second")}
		</div>
		<div class="col-md-2 portlet-column portlet-column-third" id="column-3">
			${processor.processColumn("column-3", "portlet-column-content portlet-column-content-third")}
		</div>
	</div>

	<div class="portlet-layout row">
		<div class="col-md-4 portlet-column portlet-column-first" id="column-4">
			${processor.processColumn("column-4", "portlet-column-content portlet-column-content-first")}
		</div>
		
		<div class="col-md-4 portlet-column portlet-column-second" id="column-5">
			${processor.processColumn("column-5", "portlet-column-content portlet-column-content-second")}
		</div>

		<div class="col-md-4 portlet-column portlet-column-third" id="column-6">
			${processor.processColumn("column-6", "portlet-column-content portlet-column-content-third")}
		</div>
	</div>
</div>