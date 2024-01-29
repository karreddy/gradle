package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.petronet.model.CafeStockEntry;
import com.petronet.service.CafeStockEntryLocalService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORSTOCKINVENTORY,
			"mvc.command.name="+CafeteriaVendorManagementPortletKeys.VENDOR_STOCK_ENTRY_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchStockEntryDetailsMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FetchStockEntryDetailsMVCResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchStockEntryDetailsMVCResource.doServeResource()...");
		
		LocalDate today = LocalDate.now();
		Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		int start=0;
		int end=10;
		List<CafeStockEntry> cafeStockEntriesByDate =null;
		try {
			cafeStockEntriesByDate = _cafeStockEntryLocalService.getCafeStockEntriesByDate(date, start, end);
			_log.info("cafeStockEntriesByDate ---"+cafeStockEntriesByDate);
		} catch (Exception e) {
			_log.info("Exception getting Entries >>>"+e.getMessage());
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); 
	      
	    String jsonString = objectMapper.writeValueAsString(cafeStockEntriesByDate);
	      
    	resourceResponse.setContentType("json");
    	resourceResponse.getWriter().write(jsonString);
	}
	 @Reference private CafeStockEntryLocalService _cafeStockEntryLocalService;
}
