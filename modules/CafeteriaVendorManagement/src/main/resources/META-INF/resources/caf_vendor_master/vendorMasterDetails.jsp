<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%=CafeteriaVendorManagementPortletKeys.VENDOR_MASTER_DETAILS%>" var="fetchVendorMasterDetailsURL"></portlet:resourceURL>

<div class="plng-accordion-cards ">
	<div class="card">
		<div class="align-items-center card-header d-flex justify-content-between">
			<h6 class="text-white mt-1">Master Vendor List</h6>
			<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 "><i class="bi bi-arrow-left-circle-fill mr-2" step_number="1"></i> Back</a>
		
		</div>
		<div class="card-body ">
			<div class="row md-4">
				<div class="col-md-12 table-responsive">
					<table id="cafe-vendor-master-table" class="cafe-vendor-master-table table" aria-describedby="cafe-vendor-master-table-info" style="width:100%"></table>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.print.min.js"></script> -->

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
					    "sTitle":'<span>Vendor Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var vendorName=meta.vendorName;
					    		return '<span>'+vendorName+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Vendor Address</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var vendorAddress=meta.vendorAddress;
					    		return '<span>'+vendorAddress+'</span>';
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
