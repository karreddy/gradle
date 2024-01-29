<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.petronet.model.CafeStockEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.petronet.model.CafeInventory"%>
<%@ include file="/init.jsp" %>
<script src="<%=request.getContextPath() %>/plugins/jquery.validate.min.js"></script>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.cafeteria.constants.CafeteriaPortletKeys"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:actionURL name="<%= CafeteriaPortletKeys.CAFETERIA_REPORT_DETAILS%>" var="saveCafeteriaDetails"></portlet:actionURL>

<liferay-portlet:renderURL var="cafeteriaReportURL" plid="${plId}"  portletName="com_cafeteria_CafeteriaReportPortlet"  >
<liferay-portlet:param name="mvcRenderCommandName" value="<%= CafeteriaPortletKeys.CAFETERIA_QTY_REPORT_RE%>" />
</liferay-portlet:renderURL >

<%-- <%
 ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
long userId = themeDisplay.getUserId();
String userName=themeDisplay.getUser().getFullName();
%>  --%>
<%
Calendar calendar = Calendar.getInstance();
SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
String currentMonth = dateFormat.format(calendar.getTime());
%>
<div class="plng-accordion-cards step-card-width-30">
	<div class="card">
		<form action="${saveCafeteriaDetails}" autocomplete="off" method="post" id="cafeteriaDetails">
		<input type="hidden" name="empId" id="empId" value="${themeDisplay.getUserId()}">
		<input type="hidden" name="redirectURL" value="<%= PortalUtil.getCurrentURL(request)%>">
			
			
		<div class="align-items-center card-header d-flex justify-content-between">
			<h6 class="text-white mt-1">PLL Canteen Management System :Coupon Generation</h6>
			<a href="" class="text-decoration-none text-white btn-sm btn back-btn rounded-circle border-0 d-none"><i class="bi bi-arrow-left-circle-fill mr-2"></i> Back</a>
		</div>	
				
				
					<div class="card-body ">
								<div class="row mb-3">
									<div class="col-lg-12">
										<label for="">Employee Name</label>
										<input type="text" class="form-control" id="eName" name="eName" readonly  value="${themeDisplay.getUser().getFullName()}">
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-lg-12">									
									<label for="">Request For</label> 
										<select class="form-control" id="reqFor" name="reqFor" >
											<option value="Self">Self</option>
										</select>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-lg-12">
										<label  for="">Item </label> <select id="itemid" name="itemid" class="form-control">
											<option value="">Select ...</option>
											<% List<CafeInventory> cafeInventoryList = ( List<CafeInventory> ) request.getAttribute("cafeStockEntriesByDate");
												 System.out.println("cafeInventoryList in JSP: " + cafeInventoryList);
												if (cafeInventoryList != null) { %>
											    <% for (CafeInventory inventoryDetailsList : cafeInventoryList) { %>
											        <option value="<%= inventoryDetailsList.getItem() %>"><%= inventoryDetailsList.getItem() %></option>
											    <% } %>
											<% } else { %>
											    <option value="">No items available</option>
											<% } %> 
										</select>
									</div>
								</div>
							
								<div class="row mb-3" >
									<div class="col-lg-12">
										<label for="">Available Quantity </label>
										 <input type="number" class="form-control" id="availQty" name="availQty"  readonly>
									</div>

								</div>
								
							
								<div class="row mb-3">
								
									<div class="col-lg-12 ">
										<label for="">Requested Quantity</label>
										<div class="row ml-1">
											<input type="hidden" id="issuedQ" value="0"> 
											<label class="form-check-label">
											<input class="form-check-radio" type="radio" name="rq" id="rq1" value="1" > One (01) 
											</label>
										</div>
										<div class="row ml-1">
											<label class="form-check-label">
											<input class="form-check-radio" type="radio" name="rq" id="rq2" value="2"> Two (02) 
											</label>
										</div>
									</div>

							</div>
								<div class="row mb-2">
									<div class="col-lg-12 ">
										<label for="">Value for Quantity</label> <input class="form-control" id="val" name="val" type="hidden" value=""> 
										<input class="form-control" id="ItemVal" name="ItemVal" type="number"  readonly >
									</div>
								</div>
								
								<div class="row my-4">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<button type="submit" id="sub" class=" plng-btn" >Generate</button>
										<a href="${cafeteriaReportURL}" type="submit" class="plng-btn">Get Details</a>
									
									</div>
									
								</div>
							   
								<div class="row my-4">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label>Total Consumed Value For Self  <%= request.getAttribute("currentMonth")%> :</label> <b></b>&#x20B9; <%= request.getAttribute("totalAmount")%> (INR)
									<span id="amountExceedMessage" style="color: red;"></span>
									</div>
								</div>
								
					</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function() {
    $("#itemid").change(function() {
    	 console.log("on change func >>>");
    	getSelectedItemQty();
    });
    
    
    $('#cafeteriaDetails').validate({
	    rules: {
	    	itemid:{
			    required: true,
			},
	    	rq:{
			    required: true,
			},
	    },
	    messages: {
	    	itemid: 'Please Select A Item',
	    	rq:'Please Select Any Option'
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
    	 console.log(" getSelectedItemQty func >>>");
        var selectedItem = $("#item").val();
        var stockQuantityList = <%= (List<CafeInventory>)request.getAttribute("cafeStockEntriesByDate")%>;
        console.log("stockQuantityList >>>>>>>",stockQuantityList);
        var selectedStock = stockQuantityList.find(function(stock) {
            return stock.itemDesc === selectedItem;
        });

        if (selectedStock) {
            var itemQty = selectedStock.quantity;
            var itemUnitPrice = selectedStock.itemUnitPrice;
            
            
            $("#availQty").val(itemQty);
        } else {
            console.log("Item not found in stock list");
        }
    }
    
    $("input[name='rq']").on("click", function() {
        var selectedQuantity = $(this).val();
        var selectedItem = $("#item").val();
        var stockQuantityList = <%= (List<CafeInventory>)request.getAttribute("cafeStockEntriesByDate")%>;
        console.log("stockQuantityList >>>>>>>",stockQuantityList);
        var selectedStock = stockQuantityList.find(function(stock) {
            return stock.itemDesc === selectedItem;
        });
        var totalAmount = <%= request.getAttribute("totalAmount") %>;
        
        if (selectedStock) {
            if (selectedStock) {
                var itemUnitPrice = selectedStock.itemUnitPrice;
                var totalValue = selectedQuantity * itemUnitPrice;

                console.log("selectedQuantity: " + selectedQuantity);
                console.log("Selected itemUnitPrice: " + itemUnitPrice);
                console.log("Total Value: " + totalValue);
                console.log("Total totalAmount: " + totalAmount);
                $("#ItemVal").val(totalValue);
                
              var checkAmt=totalAmount+totalValue;
                const fixedAmt=3000;
                if (checkAmt > fixedAmt) {
                    $("#sub").prop("disabled", true);
                    $("#amountExceedMessage").text("Monthly Limit Exceeded.");
                } else {
                    $("#sub").prop("disabled", false);
                    $("#amountExceedMessage").text("");
                }
            } else {
                console.log("Item not found in stock list");
            }
        } else {
            console.log("Please select a quantity.");
        }
    });
    
    

    
    
</script> 