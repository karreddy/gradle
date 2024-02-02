<%@ include file="/init.jsp" %>
<portlet:renderURL var="bginitiation">
    <portlet:param name="jspPage" value="/initiate-bg.jsp" />
    </portlet:renderURL>
    <portlet:renderURL var="acknowlwedgebg">
    <portlet:param name="jspPage" value="/acknowledge-bg.jsp" />
    </portlet:renderURL>
    <portlet:renderURL var="takeaction">
    <portlet:param name="jspPage" value="/take-action.jsp" />
    </portlet:renderURL>
      <portlet:renderURL var="bgscreated">
    <portlet:param name="jspPage" value="/bgs-created.jsp" />
    </portlet:renderURL>
     <portlet:renderURL var="bgreturn">
    <portlet:param name="jspPage" value="/intiate-bg-return.jsp" />
    </portlet:renderURL>
<!-- BG Tracker Dashboard -->
<div class="bgtracker-db-div bg-white rounded">
	<div class="row mb-4">
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 border-right">
			<div class="analytics-blocks-parent">
				<a href="${bginitiation}" class="text-decoration-none text-dark">
					<div class="analytic-card d-flex align-items-center">
						<img alt="" class="mr-4" src="<%=request.getContextPath()%>/images/initiate-bg.png" />
						<h6 class="mb-0 text-dark">Initiate BG</h6> 
					</div> 
				</a> 
			</div>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 border-right">
			<div class="analytics-blocks-parent">
				<a href="${acknowlwedgebg}" class="text-decoration-none text-dark">
					<div class="analytic-card d-flex align-items-center">
						<img class="mr-4" alt="" src="<%=request.getContextPath()%>/images/reciept.png" />
						<h6 class="mb-0">Acknowledge Reciept</h6> 
					</div> 
				</a> 
			</div>
		</div>	
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 border-right">
			<div class="analytics-blocks-parent">
				<a href="${takeaction}" class="text-decoration-none text-dark">
					<div class="analytic-card d-flex align-items-center">
						<img class="mr-4" alt="" src="<%=request.getContextPath()%>/images/action.png" />
						<h6 class="mb-0">Action Taken</h6> 
					</div> 
				</a> 
			</div>
		</div>	
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="analytics-blocks-parent">
				<a href="${bgreturn}" class="text-decoration-none text-dark">
					<div class="analytic-card d-flex align-items-center">
						<img alt="" class="mr-4" src="<%=request.getContextPath()%>/images/return.png" />
						<h6 class="mb-0">Initiate BG Return</h6> 
					</div> 
				</a> 
			</div>
		</div>		
	</div>
</div>

<div class="bgtracker-db">
	<div class="row">
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="analytics-blocks">
				<a href="${bgscreated}" class="text-decoration-none text-white">
					<div class="analytic-card d-flex justify-content-between">
						<div class="analytic-values">
							<h2>10</h2>
							<h6 class="mb-0 text-white">BGs created</h6>
						</div> 						 
						<img alt="" src="<%=request.getContextPath()%>/images/creat.png" />
					</div> 
				</a> 
			</div>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="analytics-blocks">
				<a href="${acknowlwedgebg}" class="text-decoration-none text-white">
					<div class="analytic-card d-flex justify-content-between">
						<div class="analytic-values">
							<h2>25</h2>
							<h6 class="mb-0 text-white">BGs to accept</h6>
						</div> 
						<img alt="" src="<%=request.getContextPath()%>/images/accept.png" /> 
					</div> 
				</a> 
			</div>
		</div>	
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="analytics-blocks">
				<a href="${takeaction}" class="text-decoration-none text-white">
					<div class="analytic-card d-flex justify-content-between">
						<div class="analytic-values">
							<h2>15</h2>
							<h6 class="mb-0 text-white">Pending BGs</h6>
						</div> 
						<img alt="" src="<%=request.getContextPath()%>/images/pending.png" /> 
					</div> 
				</a> 
			</div>
		</div>	
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="analytics-blocks">
				<a href="" class="text-decoration-none text-white">
					<div class="analytic-card d-flex justify-content-between">
						<div class="analytic-values">
							<h2>120</h2>
							<h6 class="mb-0 text-white">Sent BGs</h6>
						</div> 
						<img alt="" src="<%=request.getContextPath()%>/images/sent.png" /> 
					</div> 
				</a> 
			</div>
		</div>		
	</div>
</div>