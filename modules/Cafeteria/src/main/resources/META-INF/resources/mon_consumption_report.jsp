<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.cafeteria.constants.CafeteriaPortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%=CafeteriaPortletKeys.CAFETERIA_REPORT_MONTHLY_DETAILS%>" var="fetchCafeteriaReportURL"></portlet:resourceURL>
<div class="plng-accordion-cards step-card-width-10">
<div class="card">
		<form action="${saveCafeteriaDetails}" autocomplete="off" method="post" id="cafeteriaDetails">
			<input type="hidden" name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>">
		
      	<div class="align-items-center card-header d-flex justify-content-between">
	         <h6>Cafeteria Management System : Monthly Consumption Report (for January - 2024)</h6>
     		<a class="text-decoration-none back-btn" href="/cafetaria"><i class="bi bi-arrow-left-circle-fill text-white"></i> Back To Coupon Generation </a>
		</div>
		
				<div class="card-body ">
								<div class="row mb-5 mt-3">
									<div class="col-lg-3 ">
										<select id="month" name="month" class="form-control">
											<option value="1">Janaury</option>
											<option value="2">February</option>
											<option value="3">March</option>
											<option value="4">April</option>
											<option value="5">May</option>
											<option value="6">June</option>
											<option value="7">July</option>
											<option value="8">August</option>
											<option value="9">September</option>
											<option value="10">October</option>
											<option value="11">November</option>
											<option value="12">December</option>
										</select>
									</div>


									<div class="col-lg-3">
										<select id="year" name="year" class="form-control">
											<option value="2022">2020</option>
											<option value="2021">2021</option>
											<option value="2022">2022</option>
											<option value="2023">2023</option>
											<option value="2024">2024</option>
										</select>
									</div>

									<div class="col-lg-3 col-md-3col-sm-3 col-xs-3">
										<button id="sub" class="plng-btn" type="submit">Change Month</button>
									</div>
								
								</div>

					<div class="row md-4">
						<div class="col-md-12 table-responsive">
						<table id="cafeteria-report-table" class="cafeteria-report-table table" style="width:100%" aria-describedby="cafeteria-report-table-info"></table>
					</div>
			</div>
			</div>
	</form>
</div>
</div>
<script>

$(document).ready(function() {
   
    const currentDate = new Date();
    const currentMonth = currentDate.getMonth() + 1;
    const currentYear = currentDate.getFullYear();

    $('#month').val(currentMonth);
    $('#year').val(currentYear);
    
    function changeMonthFun(event) {
        event.preventDefault();

        var selectedMonth = $('#month').val();
        var selectedYear = $('#year').val();
        fetchCafeteriaReport(selectedMonth, selectedYear);
    }

$('#sub').on('click', changeMonthFun);
    fetchCafeteriaReport(currentMonth, currentYear);
});

function fetchCafeteriaReport(selectedMonth, selectedYear) {
    $.ajax({
        url: '${fetchCafeteriaReportURL}',
        type: 'get',
        dataType: 'json',
        data: {
            selectedMonth: selectedMonth,
            selectedYear: selectedYear
        },
        success: function(data) {
            cafeteriaReportDatatable(data, "#cafeteria-report-table");
        },
        error: function(xhr, status, error) {
            console.error("Ajax request failed:", status, error);
        }
    });
}

function cafeteriaReportDatatable(data, id){
	
	var table = $(id).DataTable({
        "paging" : true,
		  "ordering" :  false,
		  /*  "searching" : true,
		  "bLengthChange" : false,
		  "pageLength" : 10,
		  "lengthMenu": [[10, 20, 50], [10, 20, 50]],  */
		  "destroy" : true,
		  "bInfo": true,
	      "dom": 'lBfrtip',
	       "buttons": [
	    	   'print', 'excel'
	        ],
	        "sPaginationType": "full_numbers",
            "aaSorting": [[ 0, "asc" ]],
            "iDisplayLength": 10,
            "aLengthMenu": [[10, 25, 50, 100], [10, 25, 50, 100]],
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
					    "sTitle": '<span>#</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, row, meta){
				    		return '<span>'+(meta.row + 1) +'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle": '<span>Date</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var createDate=meta.createDate;
					    	var dateObject = new Date(createDate);
       
					    	var formattedDate = ('0' + dateObject.getDate()).slice(-2) + "-" +
				            ('0' + (dateObject.getMonth() + 1)).slice(-2) + "-" +
				            dateObject.getFullYear() 
						      
						    return '<span>' + formattedDate + '</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Item Name</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var item=meta.item;
					    		return '<span>'+item+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Requested For</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var reqFor=meta.reqFor;
					    		return '<span>'+reqFor+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Ordered Quantity</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var itemQuantity=meta.itemQuantity;
					    		return '<span>'+itemQuantity+'</span>';
					    }
					},
					{
					    "mData" : null,
					    "sTitle":'<span>Consumed Amount</span>',
					    "defaultContent": "",					    
					    "render" : function(data, type, meta){
					    	var itemValue=meta.itemValue;
					    		return '<span>'+itemValue+'</span>';
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


