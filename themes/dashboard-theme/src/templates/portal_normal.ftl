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

<#if is_signed_in && permissionChecker.isOmniadmin()>
	<@liferay.control_menu />

	<style>
		.nav-fixed, #dashbaord-header  { 
			top: 56px;
		}		
	</style>
</#if>

<div class="container-fluid position-relative" id="wrapper">
	<side-bar>
		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</side-bar>


	<div class="content content-shifted">

		<header id="dashbaord-header">
			<#include "${full_templates_path}/header.ftl" />
		</header> 
		 
		<div class="breadcrubs-section">
			<ol class="bg-transparent breadcrumb font-weight-semi-bold mb-0 px-0 py-4 text-dark" id="breadcrumbs"></ol>
		</div>		

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

	</div>

	<footer id="footer" role="contentinfo">
		<#include "${full_templates_path}/footer.ftl" />
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>