<%@ include file="/init.jsp" %>
<%@page import="com.bg.tracker.constants.BgTrackerSystemPortletKeys"%>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_PENDING_ACTIONS%>" var="fetchpendingaction" copyCurrentRenderParameters="false"/>

    <portlet:renderURL var="actionform">
    <portlet:param name="jspPage" value="/action-taken.jsp" />
    </portlet:renderURL>
    <portlet:renderURL var="bgDetails">
    <portlet:param name="mvcRenderCommandName" value="<%= BgTrackerSystemPortletKeys.BG_DETAILS%>" />
    </portlet:renderURL>
    <portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
    

<div class="plng-accordion-cards ">
<div class="card">
<div class="align-items-center card-header d-flex justify-content-between">
<h6 class="text-white mt-1">Action Taken on BGs
</h6>          
<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>
</div>
<div class="card-body ">
<div class="row md-4">
<div class="col-md-12 table-responsive">
<table id="yet-to-actionpending-bg" class="bg-actionpending-table table" style="width:100%" aria-describedby="cafe-vendor-master-table-info"></table>
</div>
</div>
</div>
</div>
</div>
 

<script>
 $(document).ready(function() {

 
$.ajax({
	url: '${fetchpendingaction}',
	type:'get',
	dataType:'json',
	success: function(data){
		console.log("data : ",data);
		actionPendingDatatable(data, "#yet-to-actionpending-bg");
	}
});
});
function actionPendingDatatable(data,id){
	var table = $(id).DataTable({
		"scrollX": true,
        "paging" : true,
		 "ordering" : false,
		  "searching" : true,
		  "bLengthChange" : false,
		  "pageLength" : 10,
		  "lengthMenu": [[10, 20, 50], [10, 20, 50]],
		  "destroy" : true,
		  "bInfo": true,
		 /*  "order":orderArray, */
		  language: {
			  
			  "infoFiltered": "",
			   oPaginate: {
					  sNext: '<i class="fa fa-angle-right"></i>',
					    sPrevious: '<i class="fa fa-angle-left"></i>',
					    sFirst: '<i class="fa fa-angle-double-left"></i>',
					    sLast: '<i class="fa fa-angle-double-right"></i>',	   
				    }
		    },
		    
		    "aaData": data,
		  	"aoColumns" :
		      [
		    	  {
					    "mData" : null,
					    "sTitle": '<span>BG Tracker Id</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	 var bgUniqueId = meta.bgUniqueId;
					         return '<a href="${bgDetails}&bgUniqueId=' + bgUniqueId + '">' + bgUniqueId + '</a>';
					    	
					    	}
					    
					},
			    	  {
					    "mData" : null,
					    "sTitle": '<span>Initiator Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
								return meta.initiatorName;
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>EIC Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	
					    	return meta.eic;
					    	}
					    
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Vendor Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	
					    	return meta.vendorname;
					    	}
					    
					},
					{
					"mData" : null,
					    "sTitle":'<span>Issuance Date</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var invoiceDate=meta.issuedate;;
					    	var dateObject = new Date(invoiceDate);
					    	var formattedDate = ('0' + dateObject.getDate()).slice(-2) + "-" +
				            ('0' + (dateObject.getMonth() + 1)).slice(-2) + "-" +
				            dateObject.getFullYear()
				           
				            
						    return '<span>' + formattedDate + '</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Expiry Date</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var invoiceDate=meta.expirydate;
					    	var dateObject = new Date(invoiceDate);
					    	var formattedDate = ('0' + dateObject.getDate()).slice(-2) + "-" +
				            ('0' + (dateObject.getMonth() + 1)).slice(-2) + "-" +
				            dateObject.getFullYear()
				           
				            
						    return '<span>' + formattedDate + '</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Sent By</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	return meta.sentby;
					    	
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Sent for</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	return meta.sentfor;
					    	
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Comment</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	return meta.comments ;
					    	
					    }
					},
					
					
					{
					    "mData": null,
					    title: '<span>Action</span>',
					    render: function (data, type, meta) {
					    	 var actionUrl = '${actionform}&bgUniqueId=' + meta.bgUniqueId;
					    	 console.log("meta.bgUniqueId",meta.bgUniqueId)
                            return '<a href="' + actionUrl + '" class="plng-btn">Action</a>';
					    	 

					    }
					}

	        ],
	        "fnDrawCallback": function(oSettings) {
	        	
	        },
	        "fnRowCallback": function(row, data, iDisplayIndex, iDisplayIndexFull) {
	        
	        }
	   });
}

 


</script> 