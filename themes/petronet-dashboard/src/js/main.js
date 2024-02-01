AUI().ready(function () {});

Liferay.Portlet.ready(function (_portletId, _node) {});

Liferay.on('allPortletsReady', function () {});

/*Sliding bar*/
document.getElementById('navIcon').addEventListener('click', function() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('nav-hidden'); 
     
    const content = document.querySelector('.content');
    content.classList.toggle('content-shifted'); 
    
    const sidebarIcons = document.getElementById('sidebarIcons');
    sidebarIcons.style.display = sidebar.classList.contains('nav-hidden') ? 'block' : 'none';
});


/*Dark Mode*/
if (sessionStorage.getItem('darkMode') === 'true') {
  enableDarkMode();
}

document.getElementById('darkModeToggle').addEventListener('click', function() {
  if (document.body.classList.contains('dark-mode')) {
    disableDarkMode();
  } else {
    enableDarkMode();
  }
});

function enableDarkMode() {
  document.body.classList.add('dark-mode');
  document.getElementById('darkModeIcon').src = '/o/petronet-dashboard/images/icons/darkmode.png';
  sessionStorage.setItem('darkMode', 'true');
}

function disableDarkMode() {
  document.body.classList.remove('dark-mode');
  document.getElementById('darkModeIcon').src = '/o/petronet-dashboard/images/icons/darkmode.png';
  sessionStorage.setItem('darkMode', 'false');
}


//For Breadcrub
function updateBreadcrumbs() { 
    var pathArray = window.location.pathname.split('/'); 
    pathArray = pathArray.filter(function (el) {
      return el !== '';
    });
     
    var breadcrumbsContainer = document.getElementById('breadcrumbs'); 
    breadcrumbsContainer.innerHTML = ''; 
    var homeCrumb = document.createElement('li');
    homeCrumb.className = 'breadcrumb-item text-dark';
    homeCrumb.innerHTML = '<a href="/">Dashboard</a>';
    breadcrumbsContainer.appendChild(homeCrumb); 
    for (var i = 0; i < pathArray.length; i++) {
      var separator = document.createElement('li');
      separator.className = 'breadcrumb-item';
      separator.textContent = '>';
      breadcrumbsContainer.appendChild(separator);
      var breadcrumb = document.createElement('li');
      breadcrumb.className = 'breadcrumb-item';
      breadcrumb.innerHTML = '<a href="/' + pathArray[i] + '">' + pathArray[i] + '</a>';
      breadcrumbsContainer.appendChild(breadcrumb);
    }
  } 
  window.onload = updateBreadcrumbs;