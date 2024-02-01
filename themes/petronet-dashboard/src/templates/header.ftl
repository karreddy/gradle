<#assign UserNotificationEventLocalService=serviceLocator.findService("com.liferay.portal.kernel.service.UserNotificationEventLocalService") />
<#assign profileImageURL = user.getPortraitURL(themeDisplay)>
<#assign preferences = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
<#assign user = themeDisplay.getUser() />

<div class="align-items-baseline d-flex justify-content-between lfr-tooltip-scope my-2">
    <div class="menu-title">
        <h6>${the_title}</h6>
    </div>

    <div class="menu-title">
        <ul class="list-inline mb-0">
            <li class="list-inline-item">
                <div class="menu-title">
                    <h6>Hello, ${user_first_name}</h6>
                </div>
            </li>

            <li class="list-inline-item">  
                <div class="dropdown"> 
                    <img src="${profileImageURL}" title="My Profile" data-toggle="dropdown" aria-expanded="false" alt="${user_name}" class="header-icon p-2 rounded-circle dropdown-toggle pointer" />   
                <div class="dropdown-menu dropdown-menu-right rounded-0 shadow-lg border-0 p-0"> 
                    <a class="dropdown-item px-2 py-2 border-bottom" href="#"><img src="${profileImageURL}" class="header-icon p-2 rounded-circle" /> My Profile</a>    
                    <a class="dropdown-item px-2 py-2" href="/c/portal/logout"><img src="${images_folder}/icons/logout.png" class="header-icon" /> Logout</a>
                </div>
                </div> 
            </li>

            <li class="list-inline-item"> 
				<div class="dropdown position-realative"> 
					<#if UserNotificationEventLocalService.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false)??>
						<#assign notification_count = UserNotificationEventLocalService.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false)/>
						<#else>
							<#assign notification_count = 0/>
					</#if>
					<img class="header-icon dropdown-toggle pointer" src="${images_folder}/icons/notification-icon.png" title="Notification" alt="Notifications" data-toggle="dropdown" aria-expanded="false"/>  
					<sup class="notification-count">${notification_count}</sup>
					<div class="dropdown-menu dropdown-menu-right rounded-0 shadow-lg border-0 notification pb-0 mb-0">
						<@liferay_portlet["runtime"]
							defaultPreferences="${preferences}"
							portletName="com_liferay_notifications_web_portlet_NotificationsPortlet"
						/> 
						<div class="dropdown-divider m-0"></div>
						<a class="dropdown-item p-3" href="">View all</a> 
					</div>
				</div> 
			</li>

            <li class="list-inline-item pointer theme-icon" id="darkModeToggle">  
                <img id="darkModeIcon" src="${images_folder}/icons/darkmode.png" title="Theme Select"> 
            </li>

        </ul>
    </div>
    
</div>