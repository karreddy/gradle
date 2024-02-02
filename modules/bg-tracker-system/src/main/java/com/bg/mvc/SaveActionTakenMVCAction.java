package com.bg.mvc;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.pll.common.util.PllMasterUtil;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.EmployeeDirectoryLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pll_common_schema.model.BgInitiation;
import pll_common_schema.model.fileMovement;
import pll_common_schema.service.BgInitiationLocalServiceUtil;
import pll_common_schema.service.fileMovementLocalService;
import pll_common_schema.service.fileMovementLocalServiceUtil;
import pll_common_schema.service.persistence.fileMovementPersistence;
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name=" +BgTrackerSystemPortletKeys.SAVEACTIONTAKEN
		},
		service = MVCActionCommand.class
	)

public class SaveActionTakenMVCAction extends BaseMVCActionCommand{
	private static final Log _log = LogFactoryUtil.getLog(SaveActionTakenMVCAction.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("Inside Action Taken");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		 User user = UserLocalServiceUtil.getUser(userId);
		 String sentby = user.getFullName();
		 _log.info("sentby>>>>>>>"+sentby);

		   String bgid = ParamUtil.getString(actionRequest, "bgtid");
		   _log.info("bgid>>>>>>>"+bgid);
		   
		    long sentto = ParamUtil.getLong(actionRequest, "name");
		    String comments = ParamUtil.getString(actionRequest, "comments");
		   _log.info("sentto>>>>>>>>>>>"+sentto);
		    String actionTaken = ParamUtil.getString(actionRequest, "action");
		    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		    
		   
		    Date sentdate = ParamUtil.getDate(actionRequest, "sentdate",dateFormatter);
		    long forwardToLiferayUserId = 0L;
			EmployeeDirectory employeeDirectory = EmployeeDirectoryLocalServiceUtil.getEmployeeDirectory(sentto);
			if (Validator.isNotNull(employeeDirectory)) {
			
				forwardToLiferayUserId = employeeDirectory.getUserId();
				_log.info("forwardToLiferayUserId>>>>>>>."+forwardToLiferayUserId);
			}
		List<fileMovement> movementlist=_filemovementlocalservice.getBybgUniqueIdAndSentto(bgid, userId);
	    _log.info("movementlist>>>>>>>>>>>>>"+movementlist);
	         for(fileMovement movement: movementlist) {
	        	 movement.setActionTaken(actionTaken);
	        	 movement.setComments(comments);
	        	 _filemovementlocalservice.updatefileMovement(movement);
	        	
	      }
	       
			
		    
	   fileMovement filemovement=fileMovementLocalServiceUtil.createfileMovement(CounterLocalServiceUtil.increment(fileMovement.class.getName()));
		filemovement.setSentTo(forwardToLiferayUserId);
		filemovement.setSentBy(userId);
		filemovement.setSentOn(sentdate);
		filemovement.setBgInitiationUniqueId(bgid);
		

		fileMovementLocalServiceUtil.addfileMovement(filemovement);
		
		}

	
	 @Reference private fileMovementLocalService _filemovementlocalservice;
	
	
}
