<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%=CafeteriaVendorManagementPortletKeys.PANTRY_OFFICE_INVENTORY_DETAILS%>" var="fetchPantryDetailsURL"></portlet:resourceURL>
<div class="row">
	
	<div class="col-md-6">
		 <div class="plng-accordion-cards ">
			<div class="card">
				<div class="align-items-center card-header d-flex justify-content-between">
					<h6 class="text-white mt-1">Cafeteria Details Entered Today</h6>
					<!-- <a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>  -->
				</div>
				<div class="card-body ">
					<div class="row md-4">
						<div class="col-md-12 table-responsive">
							<table id="cafe-entry-table" class="cafe-entry-table table" style="width:100%" aria-describedby="cafe-entry-table-info"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<div class="col-md-6">
		<div class="plng-accordion-cards ">
			<div class="card">
				<div class="align-items-center card-header d-flex justify-content-between">
					<h6 class="text-white mt-1">MD Office/Pantry Details Entered Today</h6>
					<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>
				</div>
				<div class="card-body ">
					<div class="row md-4">
						<div class="col-md-12 table-responsive">
							<table id="pantry-entry-table" class="pantry-entry-table table" style="width:100%" aria-describedby="pantry-entry-table-info"></table>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
</div>


<script>
$(document).ready(function() {
	

$.ajax({
	url: '${fetchPantryDetailsURL}',
	type:'get',
	dataType:'json',
	success: function(data){
		console.log("data : ",data.Cafeteria);
		console.log("data : ",data.MDorPantry);
		inventoryDetailsDatatable(data.MDorPantry, "#pantry-entry-table");
		inventoryDetailsDatatable( data.Cafeteria, "#cafe-entry-table");
	}
});
	
});
function inventoryDetailsDatatable(data,id){
	
	var table = $(id).DataTable({
        "paging" : true,
		  "ordering" : false,
		  "searching" : true,
		// "scrollX":true,
		  "bLengthChange" : false,
		//  "pageLength" : 10,
		//  "lengthMenu": [[10, 20, 50], [10, 20, 50]], 
		  "destroy" : true,
		  "bInfo": true,
		  language: {
			  "search": "Search",
			  "emptyTable": "No Data Available...",
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
					    "sTitle": '<span>Sl No.</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, row, meta){
				    		return '<span>'+(meta.row + 1) +'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>For</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var inventory=meta.inventory;
					    		return '<span>'+inventory+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Date</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var date=meta.date;
					    	var dateObject = new Date(date);
					        
					    	var formattedDate = ('0' + dateObject.getDate()).slice(-2) + "-" +
				            ('0' + (dateObject.getMonth() + 1)).slice(-2) + "-" +
				            dateObject.getFullYear()
				            /* + " " +
				            ('0' + dateObject.getHours()).slice(-2) + ":" +
				            ('0' + dateObject.getMinutes()).slice(-2) + ":" +
				            ('0' + dateObject.getSeconds()).slice(-2);
						       */
						    return '<span>' + formattedDate + '</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Item</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var item=meta.item;
					    		return '<span>'+item+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Quantity</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var quantity=meta.quantity;
					    		return '<span>'+quantity+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Cost Per Unit</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var itemUnitPrice=meta.itemUnitPrice;
					    		return '<span>'+itemUnitPrice+'</span>';
					    }
					},
					
					
	        ],
	        "fnDrawCallback": function(oSettings) {
	        	
	        },
	        "fnRowCallback": function(row, data, iDisplayIndex, iDisplayIndexFull) {
	        }
	   });
	
} 


</script>
