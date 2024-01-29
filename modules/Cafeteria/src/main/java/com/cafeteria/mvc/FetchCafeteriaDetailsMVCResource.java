package com.cafeteria.mvc;

import com.cafeteria.constants.CafeteriaPortletKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.petronet.model.CafeteriaCouponDetails;
import com.petronet.service.CafeteriaCouponDetailsLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +CafeteriaPortletKeys.CAFETERIA_REPORT,
			"mvc.command.name="+ CafeteriaPortletKeys.CAFETERIA_REPORT_MONTHLY_DETAILS
		},
		service = MVCResourceCommand.class
	)
public class FetchCafeteriaDetailsMVCResource extends BaseMVCResourceCommand {
	private static final Log _log = LogFactoryUtil.getLog(FetchCafeteriaDetailsMVCResource.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("FetchCafeteriaDetailsMVCResource.doServeResource() ..");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		int selMonth = ParamUtil.getInteger(resourceRequest, "selectedMonth");
		int selYear = ParamUtil.getInteger(resourceRequest, "selectedYear");
	      _log.info("userId -->"+userId+"::: year-->"+selYear+" ::: month-->"+selMonth);

	      List<CafeteriaCouponDetails> cafeteriaDetailList = _cafeteriaCouponDetailsLocalService.getByUserIdAndDate(userId, selMonth, selYear);
	      _log.info("cafeteriaDetailList-->"+cafeteriaDetailList);
	      ObjectMapper objectMapper = new ObjectMapper();
	      objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); 
	      
	      String jsonString = objectMapper.writeValueAsString(cafeteriaDetailList);
	      
      	resourceResponse.setContentType("json");
      	resourceResponse.getWriter().write(jsonString);
	}
	 @Reference private CafeteriaCouponDetailsLocalService _cafeteriaCouponDetailsLocalService;

}
