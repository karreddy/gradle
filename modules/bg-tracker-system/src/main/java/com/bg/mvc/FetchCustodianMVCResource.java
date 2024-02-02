package com.bg.mvc;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.pll.common.util.PllMasterUtil;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name="+ BgTrackerSystemPortletKeys.FETCH_CUSTODIAN
		},
		service = MVCResourceCommand.class
	)

public class FetchCustodianMVCResource extends BaseMVCResourceCommand {
	private static final Log _log = LogFactoryUtil.getLog(FetchCustodianMVCResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		 long locationId = ParamUtil.getLong(resourceRequest, "fwrdto");
		_log.info("Inside Fetch Custodian");
		 PrintWriter pw = resourceResponse.getWriter();
		  pw.print(pllMasterUtil.getNameBylocationId(locationId)); pw.flush(); pw.close();
		
		
		
	}
	 @Reference private PllMasterUtil pllMasterUtil ;

}
