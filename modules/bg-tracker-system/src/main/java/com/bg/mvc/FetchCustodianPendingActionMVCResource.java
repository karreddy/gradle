package com.bg.mvc;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.pll.common.util.PllMasterUtil;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BgTrackerSystemPortletKeys.CUSTODIAN,
			"mvc.command.name="+ BgTrackerSystemPortletKeys.FETCH_PENDING_ACTIONS
		},
		service = MVCResourceCommand.class
	)

public class FetchCustodianPendingActionMVCResource extends BaseMVCResourceCommand  {
	private static final Log _log = LogFactoryUtil.getLog(FecthPendingActionMVCResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("Fetching Custodian Peanding Actions");
		 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 long userId = themeDisplay.getUserId();
		 User user = UserLocalServiceUtil.getUser(userId);
		   String name = user.getFullName();
		   _log.info("name>>>>>>>>>>>>>"+name);
		   PrintWriter pw = resourceResponse.getWriter();
			 pw.print(pllMasterUtil.fetchCustodianPendingActionsByUserId(userId));
			 _log.info("Data>>>>>>>>>>>>"+ pllMasterUtil.fetchCustodianPendingActionsByUserId(userId));
			 pw.flush();
		     pw.close();
		
		
	}
	 @Reference private PllMasterUtil pllMasterUtil ;
}
