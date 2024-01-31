<#assign profileImageURL = user.getPortraitURL(themeDisplay)>

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
                <div class="dropdown"> 
                    <img class="header-icon dropdown-toggle pointer" src="${images_folder}/icons/notification-icon.png" title="Notification" alt="Notifications" data-toggle="dropdown" aria-expanded="false"/>  
                    <div class="dropdown-menu dropdown-menu-right rounded-0 shadow-lg border-0 notification pb-0 mb-0">
                        <ul class="list-group list-group-flush mb-0">
                        <a href="" class="text-decoration-none text-dark">
                            <li class="list-group-item list-group-item-action">Notification 01</li>
                        </a>

                        <a href="" class="text-decoration-none text-dark">
                            <li class="list-group-item list-group-item-action">Notification 02</li>
                        </a>

                        <a href="" class="text-decoration-none text-dark">
                            <li class="list-group-item list-group-item-action">Notification 03</li>
                        </a>

                        <a href="" class="text-decoration-none text-dark">
                            <li class="list-group-item list-group-item-action">Notification 04</li>
                        </a>

                        <a href="" class="text-decoration-none text-dark">
                            <li class="list-group-item list-group-item-action">Notification 05</li>
                        </a> 
                        </ul>

                        <div class="text-center p-3">
                            <a href="javascript:;" class="text-decoration-none text-dark">View all</a>
                        </div>
                    </div>
                </div> 
            </li>

            <li class="list-inline-item pointer theme-icon" id="darkModeToggle">  
                <img id="darkModeIcon" src="${images_folder}/icons/darkmode.png" title="Theme Select"> 
            </li>

        </ul>
    </div>
    
</div>