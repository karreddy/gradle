package com.cafeteriaVendorManagement.portlet;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.petronet.model.CafeItemMaster;
import com.petronet.model.CafeStockEntry;
import com.petronet.service.CafeItemMasterLocalService;
import com.petronet.service.CafeStockEntryLocalService;

import java.io.IOException;
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
		"com.liferay.portlet.display-category=pll",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CafeteriaInventory",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/caf_inventory/view.jsp",
		"javax.portlet.name=" + CafeteriaVendorManagementPortletKeys.CAFETERIAINVENTORY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CafeteriaInventoryPortlet extends MVCPortlet {
	 private static final Log _log = LogFactoryUtil.getLog(CafeteriaInventoryPortlet.class);
	 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<CafeStockEntry> cafeStockEntryDetails = _cafeStockEntryLocalService.getCafeStockEntryDetails(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeStockEntryDetails >>>>>>>>>>>>"+cafeStockEntryDetails);
		renderRequest.setAttribute("cafeStockEntryDetails", cafeStockEntryDetails);
		
		List<CafeItemMaster> cafeItemMasterList = _cafeItemMasterLocalService.getCafeItemMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeItemMasterList ---"+cafeItemMasterList);
		renderRequest.setAttribute("cafeItemMasterList", cafeItemMasterList);
		
		super.render(renderRequest, renderResponse);
	}
	 @Reference private CafeStockEntryLocalService _cafeStockEntryLocalService;
	 @Reference private CafeItemMasterLocalService _cafeItemMasterLocalService; 
}