package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.model.CafeQuantityMaster;
import com.petronet.service.CafeQuantityMasterLocalService;
import com.petronet.service.CafeStockEntryLocalService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
   immediate = true,
   property = {
		   "javax.portlet.name="+CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORSTOCKINVENTORY,
		    "mvc.command.name="+CafeteriaVendorManagementPortletKeys.CAFETERIA_VENDOR_STOCK_INVENTORY
		   },
   service = {MVCActionCommand.class}
)
public class SaveVendorStockEntryMVCAction extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveVendorStockEntryMVCAction.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveItemMasterMVCAction.doProcessAction()..... ");
      String vendorName = ParamUtil.getString(actionRequest, "vendor");
      String itemName = ParamUtil.getString(actionRequest, "item");
      long currentQty = ParamUtil.getLong(actionRequest, "currentQty");
      long quantity = ParamUtil.getLong(actionRequest, "Qty");
      long unitPrice = ParamUtil.getLong(actionRequest, "unitPrice");
      String invoiceNo = ParamUtil.getString(actionRequest, "invcNo");
      Date invoiceDate = ParamUtil.getDate(actionRequest, "invcDate",new SimpleDateFormat("yyyy-MM-dd"));
      long totalAmount = ParamUtil.getLong(actionRequest, "totalAmt");
     
      _cafeStockEntryLocalService.addStockEntryDetails(vendorName, itemName, currentQty, quantity, unitPrice, invoiceNo, invoiceDate, totalAmount);
		_log.info("vendorName-->vendorName >>"+vendorName+"-->itemName >>"+itemName+"-->currentQty >>"+currentQty+"-->quantity >>"+quantity+"-->unitPrice >>"+unitPrice+"-->invoiceNo >>"+invoiceNo+"-->invoiceDate >>"+invoiceDate+"-->totalAmount >>"+totalAmount );
		
		List<CafeQuantityMaster> cafeQtyBYItem = _cafeQuantityMasterLocalService.getCafeQtyBYItem(itemName);
		 for (int i = 0; i < cafeQtyBYItem.size(); i++) {
	    	  if (cafeQtyBYItem.get(i).getItemDesc().trim().equalsIgnoreCase(itemName.trim())) {
	    		  CafeQuantityMaster cafeQuantityMaster =cafeQtyBYItem.get(i);
	    		  long curquantity = cafeQuantityMaster.getItemQuantity();
	    		  cafeQuantityMaster.setItemQuantity(curquantity-quantity);
	    		  _cafeQuantityMasterLocalService.updateCafeQuantityMaster(cafeQuantityMaster);
	    		  break;
			}
			
		}
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
 @Reference private CafeStockEntryLocalService _cafeStockEntryLocalService;
 @Reference private CafeQuantityMasterLocalService _cafeQuantityMasterLocalService;

}
