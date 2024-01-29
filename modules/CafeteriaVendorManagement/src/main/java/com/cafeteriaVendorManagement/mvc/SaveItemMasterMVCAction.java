package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.service.CafeItemMasterLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
   immediate = true,
   property = {
		   "javax.portlet.name="+CafeteriaVendorManagementPortletKeys.CAFETERIAITEMMASTERMANAGEMENT,
		    "mvc.command.name="+CafeteriaVendorManagementPortletKeys.ITEM_MASTER
		   },
   service = {MVCActionCommand.class}
)
public class SaveItemMasterMVCAction extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveItemMasterMVCAction.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveItemMasterMVCAction.doProcessAction()..... ");
      String itemDesc = ParamUtil.getString(actionRequest, "itemDesc");
      String itemUnits = ParamUtil.getString(actionRequest, "itemUnits");
     
      _log.info("itemDesc :" + itemDesc + "--itemUnits:" + itemUnits);
      
      _cafeItemMasterLocalService.addCafeItemMaster(itemDesc, itemUnits);
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
  @Reference private CafeItemMasterLocalService _cafeItemMasterLocalService;


}
