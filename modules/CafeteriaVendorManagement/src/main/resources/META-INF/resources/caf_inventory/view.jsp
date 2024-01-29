<%@page import="com.petronet.model.CafeItemMaster"%>

<%@page import="com.petronet.model.CafeStockEntry"%>
<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= CafeteriaVendorManagementPortletKeys.CAFETERIA_INVENTORY%>" var="saveVendorStockInventory"></portlet:actionURL>
<div id="multi-step-form-container" class="my-0 ">
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
<div class="plng-accordion-cards step-card-width-30">
	<div class="card">
		<form action="${saveVendorStockInventory}" autocomplete="off" method="post" id="systemEntryDetails">
		<input type="hidden" name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>">
						<div class="align-items-center card-header d-flex justify-content-between">
							<h6 class="text-white mt-1">Canteen Inventory Portal (Admin)-Inventory Daily Entry</h6>
							<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 d-none"><i class="bi bi-arrow-left-circle-fill mr-2"></i> Back
							</a>
						</div>
					
					<div class="card-body ">
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Date</label>
										 <input type="Date" class="form-control" id="date" name="date"  >
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Inventory Update For</label> 
										<select id="inventory" name="inventory" class="form-control">
											<option value="">Select ...</option>
											<option value="Cafeteria">Cafeteria</option>
											<option value="MD Office">MD Office</option>
											<option value="Pantry">Pantry</option>
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Item </label> 
										<select id="item" name="item" class="form-control">
											<option value="">Select ...</option>
											<% List<CafeItemMaster> cafeItemMasterList = (List<CafeItemMaster>) request.getAttribute("cafeItemMasterList");
												 System.out.println("cafeItemMasterList in JSP: " + cafeItemMasterList);
												if (cafeItemMasterList != null) { %>
											    <% for (CafeItemMaster itemMasterList : cafeItemMasterList) { %>
											        <option value="<%= itemMasterList.getItemDesc() %>"><%= itemMasterList.getItemDesc() %></option>
											    <% } %>
											<% } else { %>
											    <option value="">No items available</option>
											<% } %> 
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-lg-6">
										<label for="">Current Stock Quantity</label>
										<div class="d-flex">
											<input type="text" class="form-control mr-2" id="currentQty1" name="currentQty1" readonly>@
										</div> 
									</div>
									<div class="col-lg-6">
										<div class="d-flex mt-4">
											<input type="text" class="form-control" id="currentQty2" name="currentQty2" readonly>
										</div> 
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Quantity</label>
										 <input type="number" class="form-control" id="Qty" name="Qty"  min="1">
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Unit Price for Display</label>
										 <input type="number" class="form-control" id="unitPrice" name="unitPrice" min="1" >
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="vehicle1"></label>
												<input class="mr-2" type="checkbox" id="OneItemB" name="OneItemB">
												<label for="vehicle1">1 Item Block</label><br>
									</div>
								</div>
								<div class="row  my-4">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<button type="submit" id="sub" class="plng-btn" >Send</button>
										<button class="button plng-btn btn-navigate-form-step text-decoration-none" type="button" step_number="2" >Get Detais</button>
									</div>
								</div>
					</div>
	</form>
	</div>
</div>
</section>
		 <section id="step-2" class="form-step d-none">
			<%@ include file="/caf_inventory/systemInventoryEntry.jsp"%>	
		 </section>
</div>
 	 
<script>
var currentDate = new Date();
var formattedDate = currentDate.toISOString().split('T')[0];
document.getElementById("date").value = formattedDate;

$(document).ready(function() {
    $("#item").change(function() {
    	getSelectedItemQty();
    });
    
    $('#systemEntryDetails').validate({
	    rules: {
	    	inventory:{
			    required: true,
			},
			item:{
			    required: true,
			},
			Qty:{
			    required: true,
			    number: true,
			    maxlength:6,
	    		
			},
			unitPrice:{
			    required: true,
			    number: true,
			    maxlength:10,
			},
	    },
	    messages: {
	    	inventory: {
	    		required: "Please Select A Option",
	    	
	    	  },
	    	item:{
	    		required: "Please Select A Option",
	    	  },
	    	Qty:{
	    		required: "Please Enter The Quantity",
	    		number: "Accepts Only Numeric Values",
	    		 maxlength:"Characters Not More Than 6",
    			
	    	  },
	    	unitPrice:{
	    		required: "Please Enter The Unit Price",
	    		number: "Accepts Only Numeric Values",
	    		 maxlength:"Characters Not More Than 10",
	    	  },
	    },
	    errorPlacement:function( error, element ){
	    	error.appendTo(element.parent().after());
		  },
	    submitHandler: function(form) {
	        form.submit();
	    }
	});
});  
    function getSelectedItemQty() {
        var selectedItem = $("#item").val();
        var cafeStockEntryList = <%= (List<CafeStockEntry>)request.getAttribute("cafeStockEntryDetails")%>;
        console.log("cafeStockEntryList >>>>>>>",cafeStockEntryList);
        var selectedStock = cafeStockEntryList.find(function(stock) {
            return stock.item === selectedItem;
        });

        if (selectedStock) {
            var itemQty = selectedStock.quantity;
            $("#currentQty1").val(itemQty);
            var unitPrice = selectedStock.itemUnitPrice;
            $("#currentQty2").val(unitPrice);
        } else {
            console.log("Item not found in stock list");
        }
    }
    
</script>

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
