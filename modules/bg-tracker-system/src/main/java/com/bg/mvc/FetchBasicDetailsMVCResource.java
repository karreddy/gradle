package com.bg.mvc;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.EmployeeDirectoryLocalServiceUtil;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import pll_master_schema.model.Departments;
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name="+ BgTrackerSystemPortletKeys.FETCH_BASIC_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchBasicDetailsMVCResource extends BaseMVCResourceCommand {
	private static final Log _log = LogFactoryUtil.getLog(FetchBasicDetailsMVCResource.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("Inside basic details");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId=themeDisplay.getUserId();
		List<EmployeeDirectory> employees=EmployeeDirectoryLocalServiceUtil.getEmployeeDirectories(-1, -1);
		JSONObject jsonobj=JSONFactoryUtil.createJSONObject();
		for (EmployeeDirectory employee : employees) {
            if (employee.getUserId() == userId) {
            	jsonobj.put("empId",employee.getEmployeeId());
            	jsonobj.put("empname", employee.getEmployeeName());

            }
        }
		PrintWriter pw = resourceResponse.getWriter();
		  pw.print(jsonobj); pw.flush(); pw.close();
      
    }
		
	 
		
		
		
	}
	

