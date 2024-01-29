package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.model.CafeStockEntry;
import com.petronet.service.CafeInventoryLocalService;
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
		   "javax.portlet.name="+CafeteriaVendorManagementPortletKeys.CAFETERIAINVENTORY,
		    "mvc.command.name="+CafeteriaVendorManagementPortletKeys.CAFETERIA_INVENTORY
		   },
   service = {MVCActionCommand.class}
)
public class SaveInventoryMVCAction extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveInventoryMVCAction.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveInventoryMVCAction.doProcessAction()..... ");
      Date date = ParamUtil.getDate(actionRequest, "date",new SimpleDateFormat("yyyy-MM-dd"));
      String inventory = ParamUtil.getString(actionRequest, "inventory");
      String itemName = ParamUtil.getString(actionRequest, "item");
      long quantity = ParamUtil.getLong(actionRequest, "Qty");
      long currentQty1 = ParamUtil.getLong(actionRequest, "currentQty1");
      long currentQty2 = ParamUtil.getLong(actionRequest, "currentQty2");
      long unitPrice = ParamUtil.getLong(actionRequest, "unitPrice");
      boolean OneItemB = ParamUtil.getBoolean(actionRequest, "OneItemB");     
 
      _cafeInventoryLocalService.addInventoryDetails(date, inventory, itemName, quantity, currentQty1, currentQty2, unitPrice, OneItemB);
      List<CafeStockEntry> cafeStocksByItem = _cafeStockEntryLocalService.getCafeStocksByItemAndDate(itemName, date);
  	_log.info("cafeStocksByItem >>>>>>" + cafeStocksByItem);
      for (int i = 0; i < cafeStocksByItem.size(); i++) {
    	  if (cafeStocksByItem.get(i).getItem().trim().equalsIgnoreCase(itemName.trim())) {
    		  CafeStockEntry cafeStockEntry =cafeStocksByItem.get(i);
    		  long curquantity = cafeStockEntry.getCurrentStockQty();
    		  _log.info("curquantity >>>>>>" + curquantity);
    		  long orgQuantity = cafeStockEntry.getQuantity();
    		  _log.info("Orgquantity >>>>>>" + orgQuantity);
    		  cafeStockEntry.setCurrentStockQty(curquantity-quantity);
    		  cafeStockEntry.setQuantity(orgQuantity-quantity);
    		  _cafeStockEntryLocalService.updateCafeStockEntry(cafeStockEntry);
    		  break;
		}
		
	}
      
		_log.info("-->"+date+"-->"+inventory+"-->"+itemName+"-->"+quantity+"-->"+currentQty1+"-->"+currentQty2+"-->"+unitPrice+"-->"+OneItemB );
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
 @Reference private CafeInventoryLocalService _cafeInventoryLocalService;
 @Reference private CafeStockEntryLocalService _cafeStockEntryLocalService;

}
