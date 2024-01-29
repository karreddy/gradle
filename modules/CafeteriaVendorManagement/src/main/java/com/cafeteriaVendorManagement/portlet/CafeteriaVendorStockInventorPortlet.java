package com.cafeteriaVendorManagement.portlet;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.petronet.model.CafeItemMaster;
import com.petronet.model.CafeQuantityMaster;
import com.petronet.model.CafeStockEntry;
import com.petronet.model.CafeVendorMaster;
import com.petronet.service.CafeItemMasterLocalService;
import com.petronet.service.CafeQuantityMasterLocalService;
import com.petronet.service.CafeStockEntryLocalService;
import com.petronet.service.CafeVendorMasterLocalService;

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
		"javax.portlet.display-name=CafeteriaVendorStockInventory",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/caf_vendor_stock_inventory/view.jsp",
		"javax.portlet.name=" + CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORSTOCKINVENTORY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CafeteriaVendorStockInventorPortlet extends MVCPortlet {
	
	 private static final Log _log = LogFactoryUtil.getLog(CafeteriaVendorStockInventorPortlet.class);
	
	@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
		_log.info("CafeteriaVendorStockInventorPortlet -- serveResource >>>>>>>>>>>>");

		List<CafeVendorMaster> cafeVendorMastersList = _cafeVendorMasterLocalService.getCafeVendorMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeVendorMastersList >>>>>>>>>>>>"+cafeVendorMastersList);
		renderRequest.setAttribute("cafeVendorMastersList", cafeVendorMastersList);
		
		List<CafeItemMaster> cafeItemMasterList = _cafeItemMasterLocalService.getCafeItemMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeItemMasterList ---"+cafeItemMasterList);
		renderRequest.setAttribute("cafeItemMasterList", cafeItemMasterList);
		
//		List<StockQuantityMaster> stockQuantityList = _stockQuantityMasterLocalService.getStockQuantityMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//		_log.info("stockQuantityList stockQuantityList >>>>>"+stockQuantityList);
//		renderRequest.setAttribute("stockQuantityList", stockQuantityList);
		
		List<CafeStockEntry> cafeStockEntryList = _cafeStockEntryLocalService.getCafeStockEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeStockEntryList  >>>>>"+cafeStockEntryList);
		renderRequest.setAttribute("cafeStockEntryList", cafeStockEntryList);
		
		List<CafeQuantityMaster> cafeQtyMasterDetailsList = _cafeQuantityMasterLocalService.getCafeQtyMasterDetails(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		_log.info("cafeQtyMasterDetailsList  >>>>>"+cafeQtyMasterDetailsList);
		renderRequest.setAttribute("cafeQtyMasterDetailsList", cafeQtyMasterDetailsList);
		
			super.render(renderRequest, renderResponse);
		}
	 
	@Reference private CafeVendorMasterLocalService _cafeVendorMasterLocalService;
	 @Reference private CafeItemMasterLocalService _cafeItemMasterLocalService; 
	 @Reference private CafeStockEntryLocalService _cafeStockEntryLocalService;
	 @Reference private CafeQuantityMasterLocalService _cafeQuantityMasterLocalService;
}



