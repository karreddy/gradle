<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%=CafeteriaVendorManagementPortletKeys.VENDOR_STOCK_ENTRY_DETAILS%>" var="fetchVendorMasterDetailsURL"></portlet:resourceURL>

<div class="plng-accordion-cards step-card-width-20">
	<div class="card">
		<div class="align-items-center card-header d-flex justify-content-between">
			<h6 class="text-white mt-1">Details Entered Today</h6>
			<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>
		</div>
		<div class="card-body ">
			<div class="row md-4">
				<div class="col-md-12 table-responsive">
					<table id="cafe-vendor-master-table" class="cafe-vendor-master-table table" style="width:100%" aria-describedby="cafe-vendor-master-table-info"></table>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	

$.ajax({
	url: '${fetchVendorMasterDetailsURL}',
	type:'get',
	dataType:'json',
	success: function(data){
		console.log("data : ",data);
		vendorMasterDetailsDatatable(data, "#cafe-vendor-master-table");
	}
});
	
});
function vendorMasterDetailsDatatable(data,id){
	
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
		    	  					    "sTitle":'<span>Date</span>',
		    	  					    "defaultContent": "",					    
		    	  					    "render" : function(data, type, meta){
		    	  					    	var invoiceDate=meta.invoiceDate;
		    	  					    	var dateObject = new Date(invoiceDate);
		    	  					        
		    	  					    	var formattedDate = ('0' + dateObject.getDate()).slice(-2) + "-" +
		    	  				            ('0' + (dateObject.getMonth() + 1)).slice(-2) + "-" +
		    	  				            dateObject.getFullYear()
		    	  						    return '<span>' + formattedDate + '</span>';
		    	  					    }
		    	  					},
		    	  					{
		    	  					    "mData" : null,
		    	  					    "sTitle":'<span>Vendor Name</span>',
		    	  					    "defaultContent": "",					    
		    	  					    "render" : function(data, type, meta){
		    	  					    	var vendor=meta.vendor;
		    	  					    		return '<span>'+vendor+'</span>';
		    	  					    }
		    	  					},
		    	  					{
		    	  					    "mData" : null,
		    	  					    "sTitle": '<span>Item</span>',
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
		    	  					{
		    	  					    "mData" : null,
		    	  					    "sTitle":'<span>Amount</span>',
		    	  					    "defaultContent": "",					    
		    	  					    "render" : function(data, type, meta){
		    	  					    	var totalAmount=meta.totalAmount;
		    	  					    		return '<span>'+totalAmount+'</span>';
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
