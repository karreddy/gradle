package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.petronet.model.CafeItemMaster;
import com.petronet.service.CafeItemMasterLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaVendorManagementPortletKeys.CAFETERIAITEMMASTERMANAGEMENT,
			"mvc.command.name="+CafeteriaVendorManagementPortletKeys.ITEM_MASTER_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchItemMasterDetailsMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FetchItemMasterDetailsMVCResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchItemMasterDetailsListMVCResource.doServeResource()...");
		
		List<CafeItemMaster> cafeItemMasterList = _cafeItemMasterLocalService.getCafeItemMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeItemMasterList ---"+cafeItemMasterList);
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); 
	      
	    String jsonString = objectMapper.writeValueAsString(cafeItemMasterList);
	      
    	resourceResponse.setContentType("json");
    	resourceResponse.getWriter().write(jsonString);
	}
	 @Reference private CafeItemMasterLocalService _cafeItemMasterLocalService;
}
