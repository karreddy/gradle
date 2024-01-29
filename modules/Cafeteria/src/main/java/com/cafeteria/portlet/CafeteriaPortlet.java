package com.cafeteria.portlet;

import com.cafeteria.constants.CafeteriaPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.petronet.model.CafeteriaCouponDetails;
import com.petronet.service.CafeInventoryLocalService;
import com.petronet.service.CafeteriaCouponDetailsLocalService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * @author USER
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=PLNG",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=cafeteria",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CafeteriaPortletKeys.CAFETERIA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CafeteriaPortlet extends MVCPortlet {
	 private static final Log _log = LogFactoryUtil.getLog(CafeteriaPortlet.class);

	   public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
	      _log.info("CafeteriaPortlet.render()...");

	      try {
	         Group fetchFriendlyURLGroup = GroupLocalServiceUtil.fetchFriendlyURLGroup(PortalUtil.getDefaultCompanyId(), "/guest");
	         Layout fetchLayoutByFriendlyURL = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(fetchFriendlyURLGroup.getGroupId(), false, "/monthly-report");
	         renderRequest.setAttribute("plId", fetchLayoutByFriendlyURL.getPlid());
	      } catch (Exception e) {
	         _log.error(e.getMessage());
	      }

	      LocalDate today = LocalDate.now();
			Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
			int start=0;
			int end=10;
			
			_cafeInventoryLocalService.getCafeInventoriesByDate(date, start, end); 
			_log.info("cafeteria entries ---"+_cafeInventoryLocalService.getCafeInventoriesByDate(date, start, end).get("Cafeteria"));
			renderRequest.setAttribute("cafeStockEntriesByDate", _cafeInventoryLocalService.getCafeInventoriesByDate(date, start, end).get("Cafeteria"));
	      
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			  _log.info("userId..."+userId);
			List<CafeteriaCouponDetails> totalAmountByUser = _CafeteriaCouponDetailsLocalService.getAmountByUserIdAndCurrentMonth(userId);
			long totalAmount = totalAmountByUser.stream().mapToLong(i -> i.getItemValue()).sum();
			_log.info("totalAmountByUser..."+totalAmount);
			renderRequest.setAttribute("totalAmount",totalAmount);
			Month currentMonth = today.getMonth();
			 _log.info("currentMonth..."+currentMonth);
			 renderRequest.setAttribute("currentMonth",currentMonth);
	      super.render(renderRequest, renderResponse);
	   }
	   @Reference private CafeInventoryLocalService _cafeInventoryLocalService;
	   @Reference private CafeteriaCouponDetailsLocalService _CafeteriaCouponDetailsLocalService;
}