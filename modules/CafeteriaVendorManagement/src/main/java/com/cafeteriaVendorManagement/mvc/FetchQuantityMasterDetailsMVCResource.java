package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.petronet.model.CafeQuantityMaster;
import com.petronet.service.CafeQuantityMasterLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaVendorManagementPortletKeys.CAFETERIAQUANTITYMASTER,
			"mvc.command.name="+CafeteriaVendorManagementPortletKeys.QUANTITY_MASTER_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchQuantityMasterDetailsMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FetchQuantityMasterDetailsMVCResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchQuantityMasterDetailsMVCResource.doServeResource()...");
		
		List<CafeQuantityMaster> cafeQtyMasterList = _cafeQuantityMasterLocalService.getCafeQtyMasterDetails(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeQtyMasterList ---"+cafeQtyMasterList);
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); 
	      
	    String jsonString = objectMapper.writeValueAsString(cafeQtyMasterList);
	      
    	resourceResponse.setContentType("json");
    	resourceResponse.getWriter().write(jsonString);
	}
	 @Reference private CafeQuantityMasterLocalService _cafeQuantityMasterLocalService;
}