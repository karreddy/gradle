<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>Petronet LNG Limited : ${the_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid position-relative p-0" id="wrapper">
	
	<header class="">
		<#assign preferences = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
		<@liferay_portlet["runtime"]
			    defaultPreferences="${preferences}"
			    instanceId="guest_navbar"
			    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			/>
	</header>

	<section id="content">
		<h2 class="hide-accessible sr-only d-none" role="heading" aria-level="1">${htmlUtil.escape(the_title)}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>
	
	<footer class="">
		<#assign preferences = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
		<@liferay_portlet["runtime"]
			    defaultPreferences="${preferences}"
			    instanceId="guest_footer"
			    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			/>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>