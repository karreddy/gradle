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
			"mvc.command.name="+ BgTrackerSystemPortletKeys.FETCH_DEPARTMENT_DATA
		},
		service = MVCResourceCommand.class
	)

public class FetchDepartmentsMVCResource extends BaseMVCResourceCommand {
	private static final Log _log = LogFactoryUtil.getLog(FetchEmployeeMVCResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("Calling fetch Departments ..");
		
		 long locationId = ParamUtil.getLong(resourceRequest, "fwrdto");
		  _log.info("location: "+locationId);
		  _log.info("Departments"+(pllMasterUtil.getDepartmentsBylocationId(locationId)));
		  
		 PrintWriter pw = resourceResponse.getWriter();
		  pw.print(pllMasterUtil.getDepartmentsBylocationId(locationId)); pw.flush(); pw.close();
		
		
	}
	 @Reference private PllMasterUtil pllMasterUtil ;
		
	}


