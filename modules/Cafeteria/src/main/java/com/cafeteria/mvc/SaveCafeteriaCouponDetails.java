package com.cafeteria.mvc;

import com.cafeteria.constants.CafeteriaPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petronet.model.CafeInventory;
import com.petronet.service.CafeInventoryLocalService;
import com.petronet.service.CafeteriaCouponDetailsLocalService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
   immediate = true,
   property = {
		   "javax.portlet.name="+CafeteriaPortletKeys.CAFETERIA,
		    "mvc.command.name="+CafeteriaPortletKeys.CAFETERIA_REPORT_DETAILS
		   },
   service = {MVCActionCommand.class}
)
public class SaveCafeteriaCouponDetails extends BaseMVCActionCommand {
   private static final Log _log = LogFactoryUtil.getLog(SaveCafeteriaCouponDetails.class);

   protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
      _log.info("SaveCafeteriaCouponDetails.doProcessAction()..... ");
      long empId = ParamUtil.getLong(actionRequest, "empId");
      String eName = ParamUtil.getString(actionRequest, "eName");
      String requestFor = ParamUtil.getString(actionRequest, "reqFor");
      String item = ParamUtil.getString(actionRequest, "itemid");
      long availQty = ParamUtil.getLong(actionRequest, "availQty");
      long reqQty = ParamUtil.getLong(actionRequest, "rq");
      long itemVal = ParamUtil.getLong(actionRequest, "ItemVal");
      
	  long companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(empId);
	  Group group = GroupLocalServiceUtil.getCompanyGroup(companyId);
      long groupId = group.getGroupId();
      _cafeteriaCouponDetailsLocalService.addCafeteriaCouponDetails(empId, companyId, groupId, eName, requestFor, item, reqQty, availQty, itemVal);
		_log.info("empId :" + empId + "--ename:" + eName + "--requestFor:" + requestFor + "--item:" + item + "--availQty:" + availQty + "--reqQty:" + reqQty + "--ItemVal:" + itemVal);
		_log.info("companyId :" + companyId + "--groupId:" + groupId);
		
		
		LocalDate today = LocalDate.now();
	    Date convertedDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		_log.info("originalDate >>>" + today);
		_log.info("convertedDate >>>" + convertedDate);
		
		List<CafeInventory> cafeInventoryByItem = _cafeInventoryLocalService.getCafeInventoryByItem(item, "Cafeteria",convertedDate);
	      for (int i = 0; i < cafeInventoryByItem.size(); i++) {
	    	  if (cafeInventoryByItem.get(i).getItem().trim().equalsIgnoreCase(item.trim())) {
	    		  CafeInventory cafeInventory =cafeInventoryByItem.get(i);
	    		  _log.info("cafeInventory >>>" + cafeInventory);
	    		  long curquantity = cafeInventory.getCurrentStockquantity1();
	    		  _log.info("curquantity >>>" + curquantity);
	    		  long orgQuantity = cafeInventory.getQuantity();
	    		  _log.info("orgQuantity >>>" + orgQuantity);
	    		  cafeInventory.setCurrentStockquantity1(curquantity-reqQty);
	    		  cafeInventory.setQuantity(orgQuantity-reqQty);
	    		  _cafeInventoryLocalService.updateCafeInventory(cafeInventory);
	    		  break;
			}
			
		}
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("redirectURL :" + redirectURL);
      actionResponse.sendRedirect(redirectURL);
      
   }
   
   @Reference private CafeteriaCouponDetailsLocalService _cafeteriaCouponDetailsLocalService;
   @Reference private CafeInventoryLocalService _cafeInventoryLocalService;
}
