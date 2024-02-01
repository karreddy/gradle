<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class} nav-fixed py-4 lfr-tooltip-scope nav-hidden" id="sidebar" role="navigation">
	<div class="menu-slider text-center">
		<i class="bi bi-arrow-right text-white pointer" id="navIcon" title=""></i>
	</div>
	<div class="scrollbox" tabindex="0">
		<ul role="menubar" class="nav flex-column p-4 main-nav-links scrollbox-content">
			<#list nav_items as nav_item>
				<#assign
					nav_item_attr_has_popup = ""
	                nav_item_attr_selected = ""
	                nav_item_css_class = ""
	                nav_item_dropdown = ""
	                nav_a_css_class = ""
	                nav_a_dropdown_toggle = ""
	                nav_span_dropdown_toggle = ""
	                nav_item_layout = nav_item.getLayout()
				/>
				
				<#assign nav_item_layout = nav_item.getLayout() />

				<#if nav_item.isSelected()>
					<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_attr_selected = "aria-selected='true'"
                    	nav_item_css_class = "selected active"
					/>
				</#if>
				
				<#if nav_item.hasChildren()>
                    <#assign
						nav_item_dropdown = "dropdown"
						nav_a_css_class = "dropdown-toggle"
						nav_a_dropdown_toggle = "aria-expanded='false'"
						nav_span_dropdown_toggle = "class='bi bi-chevron-down'"
                    />
                </#if>

				<li class="${nav_item_css_class} ${nav_item_dropdown}" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<a data-toggle="${nav_item_dropdown}" ${nav_a_dropdown_toggle} ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem" class="${nav_a_css_class} align-items-center d-flex text-decoration-none text-white" title="${nav_item.getName()}"> 
							<@liferay_theme["layout-icon"] layout=nav_item_layout /> 
							<span class="nav-title ml-3">${nav_item.getName()} <span ${nav_span_dropdown_toggle}></span></span>
					</a>

					<#if nav_item.hasChildren()>
						<ul class="child-menu dropdown-menu p-0" role="menu">
							<#list nav_item.getChildren() as nav_child>
								<#assign
									nav_child_css_class = ""
									nav_child_attr_selected = ""
								/>

								<#if nav_item.isSelected()>
									<#assign
										nav_child_css_class = "selected active"
									/>
								</#if>

								<li ${nav_child_attr_selected} class="${nav_child_css_class} mb-0" id="layout_${nav_child.getLayoutId()}" role="presentation">
									<a class="text-decoration-none text-dark" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
								</li>
							</#list>
						</ul>
					</#if>
				</li>
			</#list>
		</ul>
	</div>
</nav>