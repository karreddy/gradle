package com.bg.mvc;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import org.osgi.service.component.annotations.Component;

import pll_common_schema.model.BgInitiation;
import pll_common_schema.model.fileMovement;
import pll_common_schema.service.BgInitiationLocalServiceUtil;
import pll_common_schema.service.fileMovementLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name=" +BgTrackerSystemPortletKeys.ACKNOWLEGE
		},
		 service=MVCRenderCommand.class
	)

public class Aknowledge implements MVCRenderCommand{
	private static final Log _log = LogFactoryUtil.getLog(Aknowledge.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_log.info("aknowlege");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		 User user;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			 String holdwith = user.getFullName();
			 String bgUniqueId = ParamUtil.getString(renderRequest, "bgUniqueId");
			 _log.info("bgUniqueId>>>>>>>>>>>"+bgUniqueId);
			 Date currentDate = new Date();
		        LocalTime currentTime = LocalTime.now();

		     
		        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		      
		        String formattedDate = dateFormatter.format(currentDate);
		        _log.info("formattedDate>>>>>>>>>>>"+formattedDate);
		        String formattedTime = currentTime.format(timeFormatter);
		        _log.info("formattedTime>>>>>>>>>>>"+formattedTime);

			   

		        List<fileMovement> filemovement = fileMovementLocalServiceUtil.getfileMovements(-1, -1);
		        

		        for (fileMovement  file : filemovement) {
		        	_log.info("file bgId>>>>>>>>>>>"+file.getBgInitiationUniqueId());
		        	_log.info("bg bgId>>>>>>>>>>>"+bgUniqueId);
		        	 if (file.getBgInitiationUniqueId().equals(bgUniqueId)) { 
		        		 _log.info("file bgId>>>>>>>>>>>"+file.getBgInitiationUniqueId());
		        	
		        		 file.setAckOnDate(formattedDate);
		        		 file.setAckOnTime(formattedTime);
		        		 
		        		fileMovementLocalServiceUtil.updatefileMovement(file);
		        		 _log.info("success");
		        		 List<BgInitiation> bgInititaion=BgInitiationLocalServiceUtil.getBgInitiations(-1, 1);
		        		 for (BgInitiation  bgs : bgInititaion) {
		     	        	
		     	        	 if (bgs.getBgInitiationUniqueId().equals(bgUniqueId)) { 
		     	        		bgs.setStatus("Pending");
		     	        		bgs.setHold_with(holdwith);
		     	        		_log.info("Updating>>>>>>>>>>>"+bgs);
		     	        	
		     	        		BgInitiationLocalServiceUtil.updateBgInitiation(bgs);
		     	        		 _log.info("successfully updated");
		     	        		 
		     	        
			
		}
		        

 }
		      
		       
	}
		 
		        }
		} catch (PortalException e) {
		
			e.printStackTrace();
		}
		
	        return "/acknowledge-bg.jsp";  
	}
	
}
