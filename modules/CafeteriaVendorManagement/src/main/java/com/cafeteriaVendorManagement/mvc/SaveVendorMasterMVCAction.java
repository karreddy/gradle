package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.service.CafeVendorMasterLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
   immediate = true,
   property = {
		   "javax.portlet.name="+CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORMANAGEMENT,
		    "mvc.command.name="+CafeteriaVendorManagementPortletKeys.VENDOR_MASTER
		   },
   service = {MVCActionCommand.class}
)
public class SaveVendorMasterMVCAction extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveVendorMasterMVCAction.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveVendorMaster.doProcessAction()..... ");
      String vendorName = ParamUtil.getString(actionRequest, "vendorName");
      String vendorAddress = ParamUtil.getString(actionRequest, "vendorAddr");
 
      _cafeVendorMasterLocalService.addCafeteriaVendorMaster(vendorName, vendorAddress);
		_log.info("vendorName :" + vendorName + "--vendorAddress:" + vendorAddress );
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
   @Reference private CafeVendorMasterLocalService _cafeVendorMasterLocalService;


}
