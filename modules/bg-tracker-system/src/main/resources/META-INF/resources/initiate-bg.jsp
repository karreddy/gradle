<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.bg.tracker.constants.BgTrackerSystemPortletKeys"%>
<%@ include file="/init.jsp" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import ="pll_common_schema.model.BgInitiation" %> 
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<portlet:defineObjects />

<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_EMPLOYEE_DATA %>" var="fetchemployeedata" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_DEPARTMENT_DATA%>" var="fetchdepartmentdata" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_NAMES%>" var="fetchnames" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL id="<%= BgTrackerSystemPortletKeys.FETCH_BASIC_DETAILS%>" var="fetchbasicdetails" copyCurrentRenderParameters="false"/>

<portlet:actionURL name="<%= BgTrackerSystemPortletKeys.Submit_BG_INITIATION%>" var="submitbginitiation"></portlet:actionURL>


	 <div id="multi-step-form-container" class="mx-7 my-0">
           <!-- Form Steps / Progress Bar -->
                <ul class="form-stepper form-stepper-horizontal text-center mx-auto pl-0 w-50">
                    <!-- Step 1 -->
                    <li class="form-stepper-active text-center form-stepper-list" step="1">
                        <a class="mx-2">
                            <span class="form-stepper-circle">
                                <span>1</span>
                            </span>
                            <div class="text-decoration-none text-dard text-4 font-weight-bold">Step 1</div>
                        </a>
                    </li>
                    <!-- Step 2 -->
                    <li class="form-stepper-unfinished text-center form-stepper-list" step="2">
                        <a class="mx-2">
                            <span class="form-stepper-circle text-muted">
                                <span>2</span>
                            </span>
                            <div class="text-muted text-decoration-none text-dard text-4 font-weight-bold">Step 2</div>
                        </a>
                    </li>
                    <!-- Step 3 -->
                    <li class="form-stepper-unfinished text-center form-stepper-list" step="3">
                        <a class="mx-2">
                            <span class="form-stepper-circle text-muted">
                                <span>3</span>
                            </span>
                            <div class="text-decoration-none text-dard text-4 font-weight-bold text-muted">Step 3</div>
                        </a>
                    </li>
                </ul>
                <!-- Step Wise Form Content -->
          <%
    if (SessionMessages.contains(renderRequest, "bg-initiated-success")) {
        String bgTrackId = "";
        if (Validator.isNotNull(SessionMessages.get(renderRequest, "bgTrackId"))) {
            bgTrackId = (String) SessionMessages.get(renderRequest, "bgTrackId");
        }
%>
        <script>
            $(document).ready(function(){
                $("#bg-initiation-success-modal").addClass('modal').modal("show");
                var trackId='<%=bgTrackId%>';
                if(trackId!=null && trackId!='' && trackId!=undefined){
                	 var msg = 'Please keep this id for reference :<br><b>' + trackId + '</b>';
                    console.log("msg>>>>>>", msg);
                    $('#success-prg').html(msg);
                }
            });
        </script>
<%
    }
%>

               <form action="${submitbginitiation}" method="post" id="bgform">
               <input type="hidden" name="redirectURL"
			    value="<%=PortalUtil.getCurrentURL(request)%>">
                    <!-- Step 1 Content -->
                    <section id="step-1" class="form-step">
                        <!-- Step 1 input fields -->
                        <div class="mt-3">
                            <div class="plng-accordion-cards step-card-width-20">
                             <div class="card">
                                    <div class="align-content-center card-header d-flex justify-content-between">
                                        <h6 class="mb-0">
                                        BG Initiation 
                                        </h6>
                                                       
                                        <h6 class="mb-0">
                                       <%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>
                                        <input type="hidden" name="sentdate" value="<%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>">
                                        </h6>
                                    </div>			
                                     <div class="card-body">
								        <div class="row mb-4">
								        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								   				<label for="empId" >Employee Id</label>
                                               <input type="text" class="form-control" id="empId" name="empId"  readonly>
                                               
								   			</div>
								   			
								   			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								   				 <label for="initiatorName" >Initiator Name</label>
                                                 <input type="text" class="form-control" id="initiatorName" name="initiatorName" readonly>
								   			</div>
								   		 </div>
								           <div class="row mb-4">
								        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								        	<label for="bgType" >BG Type</label>
										                    <select class="form-control" id="bgType" name="bgType" >
										                        <option value="select">Select</option>
										                        <option value="emd">EMD</option>
										                        <option value="abg">ABG</option>
										                        <option value="pbg">PBG</option>
										                        <option value="sblc">SBLC</option>
										     </select>
								   			</div>
								   			
								   			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								   				
								   				<label for="amendment" >Amendment on Existing BG?</label>
									                    <select class="form-control" id="amendment" name="amendment" onchange="handleAmendmentChange()">
									                        <option value="select">Select</option>
									                        <option value="yes">Yes</option>
									                        <option value="no">No</option>
									                    </select>
								   			</div>
								   			
								   			
								   			
								   			
								   		</div>
								   		 <div class="row mb-4">
								        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								   				 <label for="bgIssuanceDate" >BG Issuance Date</label>
                                                  <input type="date" class="form-control" id="bgIssuanceDate" name="bgIssuanceDate" >
								   			</div>
								   			
								   			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								   				 <label for="bgClaimDate">BG Claim Date</label>
                                             <input type="date" class="form-control" id="bgClaimDate" name="bgClaimDate" >
								   			</div>
								   			
								   		  </div>
								   		   <div class="row mb-4"  >
								   		   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"  >
								   				<label for="" style="display: none;" id="oldrefno">Old Reference No.</label>
                                               <input type="text" class="form-control" id="oldReferenceNo" name="oldReferenceNo" style="display: none;" >
								   		   </div>
								   		  </div>
								   		  
							   			<div class="row text-right">
                                        <div class="col-md-12">
                                     		<button class="button plng-btn btn-navigate-form-step text-decoration-none" type="button" step_number="2" >Next</button>
                                        </div>
                                    </div>
							           </div>
                                </div>
                            </div>
                        </div>
                        
                    </section>
                    
                    <section id="step-2" class="form-step d-none">
                        <!-- Step 2 input fields -->
                        <div class="mt-3">
                            <div class="plng-accordion-cards step-card-width-20">
                                <div class="card">
                                    <div class="align-content-center card-header d-flex justify-content-between">
                                        <h6 class="mb-0">
                                        BG Initiation 
                                        </h6>
                                        <h6 class="mb-0">
                                       <%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>
                                        </h6>
                                    </div>		
                                    <div class="card-body">
                                         <div class="row mb-4">
									        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									        <label for="bgExpiryDate">BG Expiry Date</label>
                                              <input type="date" class="form-control" id="bgExpiryDate" name="bgExpiryDate" >
									   			</div>
									   			
									   			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									   		       <label for="vendorName">Vendor Name</label>
                                                   <input type="text" class="form-control" id="vendorName" name="vendorName" >
									   			</div>
								            </div>
									          <div class="row mb-4">
										        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
										         <label for="bankName">Bank Name</label>
                                                  <input type="text" class="form-control" id="bankName" name="bankName" >
										   	     </div>
																				   			
												
											 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"  >
								   				<label for="bgno"  id="bgno">BG no.</label>
                                               <input type="text" class="form-control" id="bgno" name="bgno" >
								   		   </div>
											</div>
											<div class="row mb-4">
											        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<label for="bgNoSFMS"> SFMS Attached</label>
									                    <select class="form-control" id="bgNoSFMS" name="bgNoSFMS" >
									                        <option value="select">Select</option>
									                        <option value="yes">Yes</option>
									                        <option value="no">No</option>
									                    </select>
											</div>

		   			                      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											         <label for="currency">Currency</label>
							                    <select class="form-control" id="currency" name="currency" >
							                        <option value="select">Select</option>
							                        <option value="rupees">Rupees</option>
							                        <option value="usDollar">US Dollar</option>
							                        <option value="euro">Euro</option>
							                        <option value="gbPound">GB Pound</option>
							                        <option value="qatariRial">Qatari Rial</option>
							                        <option value="singaporeDollar">Singapore Dollar</option>
							                    </select>
		   	                            </div>
		   			          </div>
		   			          				        
		   			           <div class="row mb-4">
		   			           
		   			           <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
													   		      <label for="totalAmount">Total Amount</label>
                                                <input type="text" class="form-control" id="totalAmount" name="totalAmount" >
		   			                 </div>
		                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		   		          <label class="form-label" for="customFile">BG Upload(pdf)</label>
                                         <input type="file" class="form-control" id="customFile"  name="customFile"/>
		   			</div>
		   			</div>
	                          
											
										          
							     <div class="row mb-4">
                                        <div class="col-md-12 d-flex justify-content-end align-items-center">
                                            <button class="button plng-btn btn-navigate-form-step text-decoration-none mr-3" type="button" step_number="1">Prev</button>
                                            <button class="button plng-btn btn-navigate-form-step text-decoration-none" type="button" step_number="3" onclick="validateStep2()">Next</button>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        
                        </div>
                    </section>
                    <!-- Step 3 Content, default hidden on page load. -->
                    <section id="step-3" class="form-step d-none">
                        <!-- Step 3 input fields -->
                        <div class="mt-3">
                            <div class="plng-accordion-cards step-card-width-20">
                                <div class="card">
                                    <div class="align-content-center card-header d-flex justify-content-between">
                                        <h6 class="mb-0">
                                        BG Initiation 
                                        </h6>
                                        <h6 class="mb-0">
                                       <%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>
                                        </h6>
                                    </div>			
                                    <div class="card-body">
                                               
		                <div class="row mb-4">
		                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		   		         <label for="remarks" >Remarks</label>
                       <textarea class="form-control" id="remarks" name="remarks" style="height: 59px;"></textarea>
		   			</div>
		   			
		   			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		   		     <label for="selectEIC">Select EIC</label>
								                    <select class="form-control" id="selectEIC" name="selectEIC" >
								                        <option value="select">Select</option>
								                        <option value="Delhi">Delhi</option>
								                        <option value="Dahej">Dahej</option>
								                        <option value="Kochi">Kochi</option>
								                    </select>
		   			</div>
	            </div>
	            
	            
                   
		                            <div class="row mb-4">
		        
							                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									        <label for="eicName" >EIC Name</label>
													 <select class="form-control" id="eicName" name="eicName" >
													 <option value="">Select</option></select></div>
		          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		   		     <label for="departmentlocation" >Forwarded To</label>
						                    <select class="form-control" id="fwrdto" name="fwrdto" >
						                        <option value="select">Select</option>
						                        <option value="1">Delhi</option>
						                        <option value="2">Dahej</option>
						                        <option value="3">Kochi</option>
						                    </select>
		   			</div>
		      </div>
		                          <div class="row mb-4">
		        
											        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											         <label for="department">Department</label>
									                   <select name="department"
																		class="form-control mb-0" id="department"
																		aria-label="label for the select">
																		<option value="">Select</option>
																	</select>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							   		        <label for="name" >Name</label>
									                    <select class="form-control" id="name" name="name" >
									                       <option value="">Select</option>
									                    </select>
		   			                  </div>
		   	                          </div>
		   			            <div class="row mb-4">
                                        <div class="col-md-12 d-flex justify-content-end align-items-center">
                                            <button class="button plng-btn btn-navigate-form-step text-decoration-none mr-3" type="button" step_number="2">Prev</button>
                                           <button class="button plng-btn submit-btn text-decoration-none" type="submit" >Submit</button>
                                        </div>
                                    </div>
                                    </div>
                               
                            </div>
                        </div>
                        </div>
                    </section>
                    
                </form>
            </div>
      <div class="fade" id="bg-initiation-success-modal" data-bs-backdrop="static" 
	   data-bs-keyboard="false" tabindex="-1" aria-labelledby="success-modalLabel" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-sm">
    <div class="modal-content text-center"> 
        <div class="modal-body">
       
        <h2 class="text-success mt-3"></h2>
        <p>Success</p>
        <i class="bi bi-check-circle-fill text-11 text-success"></i>
        <p id="success-prg"></p>
        <div></div>
        
        <button type="button" id="closeModal" class="plng-btn" data-bs-dismiss="modal" onclick="closeModal()">Close</button>
        </div> 
    </div>
    </div>
</div> 
<script>

$(document).ready(function () {
   
    $.ajax({
        url: '${fetchbasicdetails}', 
        type: 'get', 
        dataType: 'json',
        success: function (data) {
           
            $('#empId').val(data.empId);
            $('#initiatorName').val(data.empname);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });
});



$(document).ready(function() {
    console.log("Inside function");
    var selectEIC;

    $("#selectEIC").change(function() {
        console.log("Change event triggered.");
        selectEIC = $(this).val();
        console.log("selectEIC: ", selectEIC);
        $("#eicName").html('<option value="">Select</option>');
        $.ajax({
            url: '${fetchemployeedata}',
            type: 'get',
             dataType: 'json',
            data: {
                selectEIC: selectEIC
            },
            success: function(data) {
                console.log("Data received: ", data);
                for (var i = 0; i < data.length; i++) {
                    console.log("data.name: ", data[i].empId);
                    console.log("data.name: ", data[i].name);
                    $("#eicName").append('<option value="' + data[i].name + '">' + data[i].name + ' </option>');
                }
            },
          
        });
    });
});
$(document).ready(function() {
    console.log("Inside function");
    var fwrdto;

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
});
$(document).ready(function() {
    console.log("Inside function");
    var department;

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
});

document.querySelectorAll(".btn-navigate-form-step").forEach((formNavigationBtn) => {
    formNavigationBtn.addEventListener("click", () => {
        const stepNumber = parseInt(formNavigationBtn.getAttribute("step_number"));

        
        if (stepNumber === 2 && !validateStep1()) {
            
            return;
        }
        else if (stepNumber === 3 && !validateStep2()) {
           
            return;
        }
       

       
        const navigateToFormStep = (stepNumber) => {
            document.querySelectorAll(".form-step").forEach((formStepElement) => {
                formStepElement.classList.add("d-none");
            });

            document.querySelectorAll(".form-stepper-list").forEach((formStepHeader) => {
                formStepHeader.classList.add("form-stepper-unfinished");
                formStepHeader.classList.remove("form-stepper-active", "form-stepper-completed");
            });

            document.querySelector("#step-" + stepNumber).classList.remove("d-none");

            const formStepCircle = document.querySelector('li[step="' + stepNumber + '"]');

            formStepCircle.classList.remove("form-stepper-unfinished", "form-stepper-completed");
            formStepCircle.classList.add("form-stepper-active");

            for (let index = 0; index < stepNumber; index++) {
                const formStepCircle = document.querySelector('li[step="' + index + '"]');
                if (formStepCircle) {
                    formStepCircle.classList.remove("form-stepper-unfinished", "form-stepper-active");
                    formStepCircle.classList.add("form-stepper-completed");
                }
            }
        };

        navigateToFormStep(stepNumber);
    });
});

document.querySelector("#bgform").addEventListener("submit", function (event) {
   
    if (!validateStep3()) {
       
        event.preventDefault();
    }
});

function closeModal() {
    $("#bg-initiation-success-modal").modal('hide');
}

function validateStep1() {
    var empId = document.getElementById("empId").value;
    var initiatorName = document.getElementById("initiatorName").value;
    var bgType = document.getElementById("bgType").value;
    var amendment = document.getElementById("amendment").value;
    var oldReferenceNo = document.getElementById("oldReferenceNo").value;
    
    var bgIssuanceDate = document.getElementById("bgIssuanceDate").value;
    var bgClaimDate = document.getElementById("bgClaimDate").value;

   
  

    if (empId === "") {
        displayValidationMessage("empId", " Id is required.");
        return false;
    }

    
    if (!/^\d+$/.test(empId)) {
        displayValidationMessage("empId", " Enter Valid Id.");
        return false;
    }

    if (initiatorName === "") {
        displayValidationMessage("initiatorName", " Name is required.");
        return false;
    }

   
    if (/\d/.test(initiatorName)) {
        displayValidationMessage("initiatorName", "  Enter Valid Name.");
        return false;
    }
    if (bgType === "select") {
        displayValidationMessage("bgType", " Select BG Type.");
        return false;
    }
    if (amendment === "select") {
        displayValidationMessage("amendment", " Select Amendment.");
        return false;
    }
    if (amendment === "yes") {
        if (oldReferenceNo === "") {
            displayValidationMessage("oldReferenceNo", "Reference No. is required.");
            return false;
        }
        if (!/^\d+$/.test(oldReferenceNo)) {
            displayValidationMessage("oldReferenceNo", "Enter Valid No");
            return false;
        }
    }
   


   
    if (bgIssuanceDate === "") {
        displayValidationMessage("bgIssuanceDate", " Date is required.");
        return false;
    }
    if (bgClaimDate === "") {
        displayValidationMessage("bgClaimDate", " Date is required.");
        return false;
    }

    removeValidationMessages();

   
    return true;
}
function validateStep2() {
    var bgExpiryDate = document.getElementById("bgExpiryDate").value;
    var vendorName = document.getElementById("vendorName").value;
    var bankName = document.getElementById("bankName").value;
    var bgNoSFMS = document.getElementById("bgNoSFMS").value;
    var currency = document.getElementById("currency").value;
    var totalAmount = document.getElementById("totalAmount").value;
    var customFile = document.getElementById("customFile").value;
    var bgNo=document.getElementById("bgno").value;
   
    if (bgExpiryDate === "") {
        displayValidationMessage("bgExpiryDate", "  Date is required.");
        return false;
    }

   
    if (vendorName === "") {
        displayValidationMessage("vendorName", "  Name is required.");
        return false;
    }

    if (/\d/.test(vendorName)) {
        displayValidationMessage("vendorName", " Enter Valid Name.");
        return false;
    }

   
    if (bankName === "") {
        displayValidationMessage("bankName", " Bank Name is required.");
        return false;
    }
    if (bgNo === "") {
        displayValidationMessage("bgno", "  Required.");
        return false;
    }

   
    if (bgNoSFMS === "select") {
        displayValidationMessage("bgNoSFMS", " Please Select.");
        return false;
    } 
    if (currency === "select") {
        displayValidationMessage("currency", " Select  Currency.");
        return false;
    }

    
    if (totalAmount === "") {
        displayValidationMessage("totalAmount", "  Required.");
        return false;
    }

    
    if (!/^\d+$/.test(totalAmount)) {
        displayValidationMessage("totalAmount", " Enter Valid Amount.");
        return false;
    }
    
    if (!customFile) {
        displayValidationMessage("customFile", "  Select a file.");
        return false;
    }

    removeValidationMessages();

    return true;
}
function validateStep3() {
    var remarks = document.getElementById("remarks").value;
    var selectEIC = document.getElementById("selectEIC").value;
  /*   var eicName = document.getElementById("eicName").value; */
    var fwrdto = document.getElementById("fwrdto").value;
   /*  var department = document.getElementById("department").value;
    var name = document.getElementById("name").value; */

   
    if (remarks === "") {
        displayValidationMessage("remarks", " Remarks is required.");
        return false;
    }
    
    if (remarks.length > 500) {
        displayValidationMessage("remarks", " Should not exceed 500 characters.");
        return false;
    }


  
    if (selectEIC === "select") {
        displayValidationMessage("selectEIC", "  Select EIC.");
        return false;
    }

    
  /*   if (eicName === "") {
        displayValidationMessage("eicName", " Select Name.");
        return false;
    } */

    
    if (fwrdto === "select") {
        displayValidationMessage("fwrdto", " Please Select.");
        return false;
    }

    
   /*  if (department === "") {
        displayValidationMessage("department", " Department is required.");
        return false;
    }

    
    if (name === "") {
        displayValidationMessage("name", " Name is required.");
        return false;
    }
 */
    removeValidationMessages();

    return true;
}





function displayValidationMessage(elementId, message) {
    
    var errorMessageSpan = document.getElementById(elementId + "-error");
    if (!errorMessageSpan) {
        errorMessageSpan = document.createElement("span");
        errorMessageSpan.id = elementId + "-error";
        errorMessageSpan.style.color = "red";
        document.getElementById(elementId).parentNode.appendChild(errorMessageSpan);
    }
   
    errorMessageSpan.innerHTML = message;
}

function removeValidationMessages() {
    var errorSpans = document.querySelectorAll("[id$='-error']");
    errorSpans.forEach(function (span) {
        // Remove the error-border class from the corresponding input field
        var inputFieldId = span.id.replace("-error", "");
        var inputField = document.getElementById(inputFieldId);
        if (inputField) {
            inputField.classList.remove("error-border");
        }

        
        if (span.parentNode) {
            span.parentNode.removeChild(span);
        }
    });
}
function handleAmendmentChange() {
    var amendmentSelect = document.getElementById("amendment");
    var oldReferenceNoDiv = document.getElementById("oldReferenceNo");
   var  oldreflabel=document.getElementById("oldrefno");
    if (amendmentSelect.value === "yes") {
        oldReferenceNoDiv.style.display = "block";
        oldreflabel.style=display="block";
    } 
}



</script>





     
 
     <style>
       ul.form-stepper {
    counter-reset: section;
    margin-bottom: 3rem;
	}
	ul.form-stepper .form-stepper-circle {
	    position: relative;
	}
	ul.form-stepper .form-stepper-circle span {
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translateY(-50%) translateX(-50%);
	}
	.form-stepper-horizontal {
	    position: relative;
	    display: -webkit-box;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-box-pack: justify;
	    -ms-flex-pack: justify;
	    justify-content: space-between;
	}
	ul.form-stepper > li:not(:last-of-type) {
	    margin-bottom: 0.625rem;
	    -webkit-transition: margin-bottom 0.4s;
	    -o-transition: margin-bottom 0.4s;
	    transition: margin-bottom 0.4s;
	}
	.form-stepper-horizontal > li:not(:last-of-type) {
	    margin-bottom: 0 !important;
	}
	.form-stepper-horizontal li {
	    position: relative;
	    display: -webkit-box;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-box-flex: 1;
	    -ms-flex: 1;
	    flex: 1;
	    -webkit-box-align: start;
	    -ms-flex-align: start;
	    align-items: start;
	    -webkit-transition: 0.5s;
	    transition: 0.5s;
	}
	.form-stepper-horizontal li:not(:last-child):after {
        position: relative;
	    -webkit-box-flex: 1;
	    -ms-flex: 1;
	    flex: 1;
	    height: 1px;
	    content: "";
	    top: 30%;
	    left: -12px;
	}
	.form-stepper-horizontal li:after {
	    background-color: #0000003b;
	}
	.form-stepper-horizontal li.form-stepper-completed:after {
	    background-color: #4da3ff;
	}
	.form-stepper-horizontal li:last-child {
	    flex: unset;
	}
	ul.form-stepper li a .form-stepper-circle {
	    display: block;
	    width: 40px;
	    height: 40px;
	    margin-right: 0;
	    line-height: 1.7rem;
	    text-align: center;
	    background: rgba(0, 0, 0, 0.38);
	    border-radius: 50%;
	}
	.form-stepper .form-stepper-active .form-stepper-circle {
	    background-color: #393184 !important;
	    color: #fff;
	}
	.form-stepper .form-stepper-active .label {
	    color: #4361ee !important;
	}
	.form-stepper .form-stepper-active .form-stepper-circle:hover {
	    background-color: #4361ee !important;
	    color: #fff !important;
	}
	.form-stepper .form-stepper-unfinished .form-stepper-circle {
	    background-color: #f8f7ff;
	}
	.form-stepper .form-stepper-completed .form-stepper-circle {
	    background-color: #0e9594 !important;
	    color: #fff;
	}
	.form-stepper .form-stepper-completed .label {
	    color: #0e9594 !important;
	}
	.form-stepper .form-stepper-completed .form-stepper-circle:hover {
	    background-color: #0e9594 !important;
	    color: #fff !important;
	}
	.form-stepper .form-stepper-active span.text-muted {
	    color: #fff !important;
	}
	.form-stepper .form-stepper-completed span.text-muted {
	    color: #fff !important;
	}
	.form-stepper .label {
	    font-size: 1rem;
	    margin-top: 0.5rem;
	    border: 0px;
    font-weight: 600;
    font-size: 14px;
    cursor: pointer;
	}
	.form-stepper a {
	    cursor: default;
	}
	
}
</style>
       