<%@page import="com.petronet.model.CafeQuantityMaster"%>
<%@page import="com.petronet.model.CafeStockEntry"%>
<%@page import="com.petronet.model.CafeItemMaster"%>
<%@page import="java.util.List"%>
<%@page import="com.petronet.model.CafeVendorMaster"%>
<%@page import="com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= CafeteriaVendorManagementPortletKeys.CAFETERIA_VENDOR_STOCK_INVENTORY%>" var="saveVendorStockInventory"></portlet:actionURL>

<%-- <%List<CafeVendorMaster> cafeVendorMastersList =(List<CafeVendorMaster>)request.getAttribute("cafeVendorMastersList"); %> --%>
 <div id="multi-step-form-container " class="my-0 ">
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
       <section id="step-1" class="form-step ">
<div class="plng-accordion-cards step-card-width-30">
<div class="card ">
		<form action="${saveVendorStockInventory}" autocomplete="off" method="post" id="stockDetails">
		<input type="hidden" name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>">
						
						<div class="align-items-center card-header d-flex justify-content-between">
							<h6 class="text-white mt-1">Canteen Vendor Stock Inventory Portal (Admin)</h6>
							<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 d-none"><i class="bi bi-arrow-left-circle-fill mr-2"></i> Back
							</a>
						</div>
						
					<div class="card-body ">
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Vendor</label> 
										<select id="vendor" name="vendor" class="form-control">
										<option value="">Select Vendor</option>
										<% List<CafeVendorMaster> cafeVendorMastersList= (List<CafeVendorMaster>) request.getAttribute("cafeVendorMastersList");
												 System.out.println("cafeVendorMastersList in JSP: " + cafeVendorMastersList);
												if (cafeVendorMastersList != null) { %>
											    <% for (CafeVendorMaster cafeVendorMaster : cafeVendorMastersList) { %>
											        <option value="<%= cafeVendorMaster.getVendorName() %>"><%= cafeVendorMaster.getVendorName() %></option>
											    <% } %>
											<% } else { %>
											    <option value="">No vendors available</option>
											<% } %> 
										</select>
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Item </label>
										 <select id="item" name="item" class="form-control">
										 <option value="">Select Item</option>
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
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Current Stock Quantity</label>
										 	<input type="number" class="form-control mr-2" id="currentQty" name="currentQty" readonly min="1" >
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Quantity</label>
										 <input type="number" class="form-control" id="Qty" name="Qty" min="1">
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Unit Price Of Item</label>
										 <input type="number" class="form-control" id="unitPrice" name="unitPrice" min="1" >
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Invoice No.</label>
										 <input type="text" class="form-control" id="invcNo" name="invcNo" >
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Invoice Date</label>
										 <input type="Date" class="form-control" id="invcDate" name="invcDate"  >
									</div>
								</div>
								<div class="row mb-3"  >
									<div class="col-lg-12">
										<label for="">Total Amount For This Item(In Rs.)</label>
										 <input type="number" class="form-control" id="totalAmt" name="totalAmt"  readonly min="1">
									</div>
								</div>
								
								<div class="row my-4">
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
			 <%@ include file="/caf_vendor_stock_inventory/vendorStockInventory.jsp"%>
		 </section>
</div>

<script>
var currentDate = new Date();
var formattedDate = currentDate.toISOString().split('T')[0];
document.getElementById("invcDate").value = formattedDate;

$("#Qty, #unitPrice").on("input", function() {
    calculateTotalAmount();
});

function calculateTotalAmount() {
    var qty = parseFloat($("#Qty").val()) || 0;
    var unitPrice = parseFloat($("#unitPrice").val()) || 0;

    var totalAmount = qty * unitPrice;
    $("#totalAmt").val(totalAmount);
}

$(document).ready(function() {
    $("#item").change(function() {
    	getSelectedItemQty();
    });
    
    $('#stockDetails').validate({
	    rules: {
	    	vendor:{
			    required: true,
			},
			item:{
			    required: true,
			},
			Qty:{
			    required: true,
			    number: true,
			    maxlength:6,
			    validateQuantity:true
			},
			unitPrice:{
			    required: true,
			    number: true,
			    maxlength:10,
			},
			invcNo:{
			    required: true,
			    maxlength:6,
	    		minlength:6,
	    		number: true
	    		
			},
	    },
	    messages: {
	    	vendor: {
	    		 required: "Please Select A Option",
	    	
	    	  },
	    	item:{
	    		required: "Please Select A Option",
	    		number: "Accepts Only Numeric Values"
	    	  },
	    	Qty:{
	    		required: "Please Enter The Quantity",
	    		number: "Accepts Only Numeric Values",
	    		 maxlength:"Characters Not More Than 6",
	    		 validateQuantity:"Entered Quantity Exceeds The Available Quantity"
	    	  },
	    	unitPrice:{
	    		required: "Please Enter The Unit Price",
	    		number: "Accepts Only Numeric Values",
	    		 maxlength:"Characters Not More Than 10",
	    	  },
	    	invcNo:{
	    		required: "Please Enter The Invoice Number",
	    		maxlength:"Characters Length Should Be 6",
		    	minlength:"Characters Length Should Be 6",
		    	number:  "Accepts Only Numeric Values"
	    	  },
	    },
	    errorPlacement:function( error, element ){
	    	error.appendTo(element.parent().after());
		  },
	    submitHandler: function(form) {
	        form.submit();
	    }
	});
    
    
    $.validator.addMethod("validateQuantity", function(value, element) {
		var curStockQty = parseFloat($('#currentQty').val());
		console.log("curStockQty >>>>"+curStockQty);
		var enteredQty = parseFloat(value);
   		 console.log("enteredQty >>>>"+enteredQty);
   		return enteredQty < curStockQty;
		}); 
    
    
    
    
    
    
    
    
});  
    function getSelectedItemQty() {
        var selectedItem = $("#item").val();
        console.log("selectedItem >>>>>>>",selectedItem);
        var stockQuantityList = <%= (List<CafeQuantityMaster>)request.getAttribute("cafeQtyMasterDetailsList")%>;
        console.log("stockQuantityList >>>>>>>",stockQuantityList);
        var selectedStock = stockQuantityList.find(function(stock) {
            return stock.itemDesc === selectedItem;
        });
        console.log("selectedStock >>>>>>>",selectedStock);
        if (selectedStock) {
            var itemQty = selectedStock.itemQuantity;
            console.log("itemQty >>>>>>>",itemQty);
            $("#currentQty").val(itemQty);
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