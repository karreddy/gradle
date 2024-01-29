<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp" %>
<script src="<%=request.getContextPath()%>/plugins/jquery.validate.min.js"></script>


<portlet:actionURL name="<%= CafeteriaVendorManagementPortletKeys.VENDOR_MASTER%>" var="saveVendorMaster"></portlet:actionURL>
 <div id="multi-step-form-container " class="my-0 step-card-width-30">
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
     </ul>
     <!-- Step 1 Content -->
       <section id="step-1" class="form-step">
           <!-- Step 1 input fields -->
			<div class="plng-accordion-cards ">
				<form action="${saveVendorMaster}" autocomplete="off" method="post" id="cafeteriaDetails">
				<input type="hidden" name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>">
					<div class="card">
						
						<div class="align-items-center card-header d-flex justify-content-between">
								<h6 class="text-white mt-1">PLL Canteen Management System : Vendor Master - Master Entry</h6>
						</div>	
					
						<div class="card-body ">
							<div class="row mb-3">
								<div class="col-lg-12">
									<label for="">Vendor Name</label>
									<input type="text" class="form-control" id="vendorName" name="vendorName"  >
								</div>
						</div>
						<div class="row mb-3">
								<div class="col-lg-12">
									<label for="">Address</label>
									<input type="text" class="form-control" id="vendorAddr" name="vendorAddr" >
								</div>
							</div>
							
							<div class="row my-4">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<button type="submit" id="sub" class=" plng-btn"  >Save</button>
										<button class="button plng-btn btn-navigate-form-step text-decoration-none" type="button" step_number="2" >Get Detais</button>
									</div>
							</div>
							
						</div>
					</div>
				</form>
			</div>
		</section>
		 <section id="step-2" class="form-step d-none">
			 <%@ include file="/caf_vendor_master/vendorMasterDetails.jsp"%>
		 </section>
</div>
 
<script>
//stepper config
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
document.querySelectorAll(".btn-navigate-form-step").forEach((formNavigationBtn) => {
    formNavigationBtn.addEventListener("click", () => {
        const stepNumber = parseInt(formNavigationBtn.getAttribute("step_number"));
        navigateToFormStep(stepNumber);
    });
});
</script>

 
 
 <script>
$(document).ready(function() {
    
    $('#cafeteriaDetails').validate({
	    rules: {
	    	vendorName:"required",
			vendorAddr:"required",
	    },
	    messages: {
	    	vendorName: 'Please Enter A Name',
	    	vendorAddr:'Please Enter The Address'
	    },
	    errorPlacement:function( error, element ){
	    	error.appendTo(element.parent().after());
		  },
	    submitHandler: function(form) {
	        form.submit();
	    }
	});
});


</script>