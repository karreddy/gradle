package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.service.CafeQuantityMasterLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
   immediate = true,
   property = {
		   "javax.portlet.name="+CafeteriaVendorManagementPortletKeys.CAFETERIAQUANTITYMASTER,
		    "mvc.command.name="+CafeteriaVendorManagementPortletKeys.QUANTITY_MASTER
		   },
   service = {MVCActionCommand.class}
)
public class SaveQuantityMasterMVCAction extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveQuantityMasterMVCAction.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveQuantityMasterMVCAction.doProcessAction()..... ");
      String itemDesc = ParamUtil.getString(actionRequest, "itemDesc");
     long  itemQty= ParamUtil.getLong(actionRequest, "itemQty" );
     
      _log.info("itemDesc :" + itemDesc + "--itemQty:" + itemQty);
      
      _cafeQuantityMasterLocalService.addCafeQtyMaster(itemDesc, itemQty);
   
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
  @Reference private CafeQuantityMasterLocalService _cafeQuantityMasterLocalService;


}
