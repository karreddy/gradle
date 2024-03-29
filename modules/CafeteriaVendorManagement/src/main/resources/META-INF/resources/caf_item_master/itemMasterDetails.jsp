<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%=CafeteriaVendorManagementPortletKeys.ITEM_MASTER_DETAILS%>" var="fetchItemMasterDetailsURL"></portlet:resourceURL>

<div class="plng-accordion-cards ">
	<div class="card">
		<div class="align-items-center card-header d-flex justify-content-between">
			<h6 class="text-white mt-1">Master Item List </h6>
			<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>
		</div>
		<div class="card-body ">
			<div class="row md-4">
				<div class="col-md-12 table-responsive">
					<table id="cafe-item-master-table" class="cafe-item-master-table table" style="width:100%" aria-describedby="cafe-item-master-table-info"></table>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	

$.ajax({
	url: '${fetchItemMasterDetailsURL}',
	type:'get',
	dataType:'json',
	success: function(data){
		console.log("data : ",data);
		itemMasterDetailsDatatable(data, "#cafe-item-master-table");
	}
});
	
});
function itemMasterDetailsDatatable(data,id){
	
	var table = $(id).DataTable({
        "paging" : true,
		  "ordering" :  false,
		  "searching" : true,
		//  "scrollX":true,
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
					    "sTitle":'<span>Item Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var itemDesc=meta.itemDesc;
					    		return '<span>'+itemDesc+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Item Unit</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var itemUnits=meta.itemUnits;
					    		return '<span>'+itemUnits+'</span>';
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
