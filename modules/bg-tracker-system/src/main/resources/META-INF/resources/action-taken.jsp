<%@ include file="/init.jsp" %>
<%@page import="com.bg.tracker.constants.BgTrackerSystemPortletKeys"%>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_BG_DETAILS%>" var="fectchbgdetails" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_DEPARTMENT_DATA%>" var="fetchdepartmentdata" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_CUSTODIAN%>" var="fetchCustodian" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_NAMES%>" var="fetchnames" copyCurrentRenderParameters="false"/>
<portlet:actionURL name="<%= BgTrackerSystemPortletKeys.SAVEACTIONTAKEN%>" var="saveaction"></portlet:actionURL>
 <portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
 
               <form action="${saveaction}" method="post" id="bgform">
              <div class="mt-3">
                            <div class="plng-accordion-cards ">
                             <div class="card">
                                    <div class="align-content-center card-header d-flex justify-content-between">
                                        <h6 class="mb-0">
                                       Action On BGs
                                        <input type="hidden" name="sentdate" value="<%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>">
                                        </h6>
                                                        
                                       
                                    </div>			
                                     <div class="card-body">
								        <div class="row mb-4">
								        	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				<label for="bgtid" >BG Tracker Id</label>
                                               <input type="text" class="form-control" id="bgtid" name="bgtid"  readonly>
                                               
								   			</div>
								   			
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="initiatorname" >Initiator Name</label>
                                                 <input type="text" class="form-control" id="initiatorname" name="initiatorname" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="bgtype" >BG Type</label>
                                                 <input type="text" class="form-control" id="bgtype" name="bgtype" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="issuncedate" >BG Issuance Date</label>
                                                 <input type="text" class="form-control" id="issuncedate" name="issuncedate" readonly>
								   			</div>
								   		 </div>
								   		  <div class="row mb-4">
								        	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				<label for="expdate" >BG Expiry Date</label>
                                               <input type="text" class="form-control" id="expdate" name="expdate"  readonly>
                                               
								   			</div>
								   			
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="claimdate" >BG Claim Date</label>
                                                 <input type="text" class="form-control" id="claimdate" name="claimdate" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="vendorname" >Vendor Name</label>
                                                 <input type="text" class="form-control" id="vendorname" name="vendorname" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="bankname" >Bank Name</label>
                                                 <input type="text" class="form-control" id="bankname" name="bankname" readonly>
								   			</div>
								   		 </div>
								   		  <div class="row mb-4">
								        	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				<label for="bgno" >BG No</label>
                                               <input type="text" class="form-control" id="bgno" name="bgno"  readonly>
                                               
								   			</div>
								   			
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="sfms" >SFMS Attached</label>
                                                 <input type="text" class="form-control" id="sfms" name="sfms" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="amount" >Total Amount</label>
                                                 <input type="text" class="form-control" id="amount" name="amount" readonly>
								   			</div>
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="currency" >Currency</label>
                                                 <input type="text" class="form-control" id="currency" name="currency" readonly>
								   			</div>
								   			
								   		 </div>
								   		  <div class="row mb-4">
								        	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				<label for="remarks" >Remarks</label>
                                               <input type="text" class="form-control" id="remarks" name="remarks"  readonly>
                                               
								   			</div>
								   		   <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
											<label for="uploadedFile"><a href="" id="uploadedFile" target="_blank">Uploaded BG</a></label>
											</div> 
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								   				<label for="action" >Take Action</label>
						                    <select class="form-control" id="action" name="action" onchange="handleActionChange()">
						                        <option value="select">Select</option>
						                        <option value="processing">Forward for Processing</option>
						                        <option value="custody">Forward for Custody</option>
						                        <option value="encashment">Recommanded for Encashment</option>
						                         <option value="bgreturn">Original BG Return</option>
						                          <option value="vendor">Release to Vendor</option>
						                           <option value="encashmentprocess">Encashment Process</option>
						                    </select>
								   			</div>
								   			
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="comments" >Your Comments</label>
                                                 <input type="text" class="form-control" id="comments" name="comments" >
								   			</div>
								   			
								   		 </div>
								          <div class="row mb-4">
								        	
								   			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   				 <label for="fwrdto" >Forwarded To</label>
						                    <select class="form-control" id="fwrdto" name="fwrdto" >
						                        <option value="select">Select</option>
						                        <option value="1">Delhi</option>
						                        <option value="2">Dahej</option>
						                        <option value="3">Kochi</option>
						                    </select>
								   			</div>
								   			 <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" id="departmentdiv">
								   				 <label for="department">Department</label>
									                   <select name="department"
																		class="form-control mb-0" id="department"
										
																		aria-label="label for the select">
																		<option value="">Select</option>
																	</select>
								   			</div> 
								   			 <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
								   		  <label for="name" >Name</label>
									                    <select class="form-control" id="name" name="name" >
									                       <option value="">Select</option>
									                    </select>
								   		  </div>
								   			
								   		 </div>
								   		 
								   		  
								         
								   		  
							   			<div class="row text-right">
                                        <div class="col-md-12">
                                     		<button class="plng-btn " type="submit" >Submit</button>
                                        </div>
                                    </div>
							           </div>
                                </div>
                            </div>
                        </div>
               </form>
      
 <script>
  $(document).ready(function () {
	  var fwrdto;
	  var department;
	   var urlParams = new URLSearchParams(window.location.search);
	    var bgUniqueId = urlParams.get('bgUniqueId');
	  console.log("bgUniqueId>>>>>>>>>>>"+bgUniqueId)
	    $.ajax({
	        url: '${fectchbgdetails}', 
	        type: 'get', 
	        dataType: 'json',
	        data: {
                bgUniqueId:bgUniqueId
            },
	        success: function (data) {
	           console.log("data>>>>>>>>>>>>"+data);
	           console.log("file>>>>>>>>>>>"+data.file)
	        	 $('#bgtid').val(data.bgtid);
                 $('#initiatorname').val(data.initiatorname);
                 $('#bgtype').val(data.bgtype);
                 $('#issuncedate').val(data.issuancedate);
                 $('#expdate').val(data.expirydate);
                 $('#claimdate').val(data.claimdate);
                 $('#vendorname').val(data.vendorname);
                 $('#bankname').val(data.bankname);
                 $('#bgno').val(data.bgno);
                 $('#sfms').val(data.sfms);
                 $('#amount').val(data.amount);
                 $('#currency').val(data.currancy);
                 $('#uploadedFile').attr('href', data.file);
                 $('#uploadedFile').text('Uploaded BG');
	              $('#remarks').val(data.remarks);
	                
	        },
	        error: function (xhr, status, error) {
	            console.error('Error fetching data:', error);
	        }
	    });
	  $("#fwrdto").change(function() {
	        console.log("Change event triggered.");
	        fwrdto = $(this).val();
	        console.log("fwrdto: ", fwrdto);
	        $("#department").html('<option value="">Select</option>');
	        $.ajax({
	            url: "${fetchdepartmentdata}",
	            type: 'get',
	             dataType: 'json',
	            data: {
	            	fwrdto:fwrdto
	            },
	            success: function(data) {
	                console.log("Data received: ", data);
	                for (var i = 0; i < data.length; i++) {
	                    console.log("data.deptId: ", data[i].deptId);
	                    console.log("data.deptname: ", data[i].deptname);
	                    $("#department").append('<option value="' + data[i].deptname + '">' + data[i].deptname + ' </option>');
	                }
	            },
	          
	        });
	    });
	  $("#department").change(function() {
	        console.log("Change event triggered.");
	        department = $(this).val();
	        console.log("department: ", department);
	        $("#name").html('<option value="">Select</option>');
	        $.ajax({
	            url: "${fetchnames}",
	            type: 'get',
	             dataType: 'json',
	            data: {
	            	department:department
	            },
	            success: function(data) {
	                console.log("Data received: ", data);
	                for (var i = 0; i < data.length; i++) {
	                    console.log("data.empId: ", data[i].empId);
	                    console.log("data.empname: ", data[i].empname);
	                    $("#name").append('<option value="' + data[i].empId + '">' + data[i].empname + ' </option>');
	                }
	            },
	          
	        });
	    });
	  $("#fwrdto").change(function() {
	        console.log("Change event triggered.");
	        fwrdto = $(this).val();
	        console.log("fwrdto: ", fwrdto);
	        $("#name").html('<option value="">Select</option>');
	        $.ajax({
	            url: "${fetchCustodian}",
	            type: 'get',
	             dataType: 'json',
	            data: {
	            	fwrdto:fwrdto
	            },
	            success: function(data) {
	                console.log("Data received: ", data);
	                for (var i = 0; i < data.length; i++) {
	                    console.log("data.cusId: ", data[i].cusId);
	                    console.log("data.cusname: ", data[i].cusname);
	                    $("#name").append('<option value="' + data[i].cusId + '">' + data[i].cusname + ' </option>');
	                }
	            },
	          
	        });
	    });	
	});
  function handleActionChange() {
	    var actionSelect = document.getElementById("action");
	    var departmentContainer = document.getElementById("departmentdiv");

	 
	    if (actionSelect.value === "custody") {
	       
	        departmentContainer.style.display = "none";
	    }
	    else{
	    	 departmentContainer.style.display = "block";
	    }
	    }
	
	 
 </script>      
     