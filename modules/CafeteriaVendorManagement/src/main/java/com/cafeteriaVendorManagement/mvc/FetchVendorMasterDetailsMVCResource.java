package com.cafeteriaVendorManagement.mvc;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.petronet.model.CafeVendorMaster;
import com.petronet.service.CafeVendorMasterLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORMANAGEMENT,
			"mvc.command.name="+CafeteriaVendorManagementPortletKeys.VENDOR_MASTER_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchVendorMasterDetailsMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FetchVendorMasterDetailsMVCResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchVendorMasterDetailsListMVCResource.doServeResource()...");
		
		List<CafeVendorMaster> cafeVendorMastersList = _cafeVendorMasterLocalService.getCafeVendorMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeVendorMastersList ---"+cafeVendorMastersList);
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); 
	      
	    String jsonString = objectMapper.writeValueAsString(cafeVendorMastersList);
	      
    	resourceResponse.setContentType("json");
    	resourceResponse.getWriter().write(jsonString);
	}
	 @Reference private CafeVendorMasterLocalService _cafeVendorMasterLocalService;
}
