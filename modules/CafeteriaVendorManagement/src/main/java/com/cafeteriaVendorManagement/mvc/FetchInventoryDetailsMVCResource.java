package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.petronet.service.CafeInventoryLocalService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaVendorManagementPortletKeys.CAFETERIAINVENTORY,
			"mvc.command.name="+CafeteriaVendorManagementPortletKeys.PANTRY_OFFICE_INVENTORY_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchInventoryDetailsMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FetchInventoryDetailsMVCResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchStockEntryDetailsMVCResource.doServeResource()...");
		
		LocalDate today = LocalDate.now();
		Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		int start=0;
		int end=10;
	
		JSONObject cafeInventoriesByDate = _cafeInventoryLocalService.getCafeInventoriesByDate(date, start, end);
		
		_log.info("cafeInventoriesByDate ---"+cafeInventoriesByDate);
		
		resourceResponse.getWriter().print(cafeInventoriesByDate);
	}
	
	 @Reference private CafeInventoryLocalService _cafeInventoryLocalService;
}
