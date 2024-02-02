package com.bg.tracker.portlet;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.pll",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.display-name=Custodian",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/custodian_dashboard.jsp",
		"javax.portlet.name=" + BgTrackerSystemPortletKeys.CUSTODIAN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PllCustodianPortlet extends MVCPortlet {

}
