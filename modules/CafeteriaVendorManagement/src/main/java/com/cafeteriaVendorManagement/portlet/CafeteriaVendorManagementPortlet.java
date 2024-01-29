package com.cafeteriaVendorManagement.portlet;

import com.cafeteriaVendorManagement.constants.CafeteriaVendorManagementPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author USER
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=pll",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CafeteriaVendorManagement",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CafeteriaVendorManagementPortletKeys.CAFETERIAVENDORMANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CafeteriaVendorManagementPortlet extends MVCPortlet {
	
}