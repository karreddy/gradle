package com.bg.mvc;
import java.io.File;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.EmployeeDirectoryLocalServiceUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import pll_common_schema.model.BgInitiation;
import pll_common_schema.model.fileMovement;
import pll_common_schema.service.BgInitiationLocalServiceUtil;
import pll_common_schema.service.fileMovementLocalServiceUtil;



@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" +BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name=" +BgTrackerSystemPortletKeys.Submit_BG_INITIATION
		},
		service = MVCActionCommand.class
	)

public class SubmitBgInitiationMVCAction extends BaseMVCActionCommand{
	private static final Log _log = LogFactoryUtil.getLog(SubmitBgInitiationMVCAction.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("Inside Action");
		
		UploadPortletRequest uploadRequest  = PortalUtil.getUploadPortletRequest(actionRequest);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
          MVCPortlet.class.getName(), uploadRequest);

      long uploadFileEntity = uploadFileEntity(serviceContext, uploadRequest);
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId=themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
	    String submittedby = user.getScreenName();
	    String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
	    _log.info("redirectURL>>>>>>>>>>>>"+redirectURL);
	    Long empId = ParamUtil.getLong(actionRequest, "name");
	    _log.info("empId>>>>>>>>>>."+empId);
	    String initiatorName = ParamUtil.getString(actionRequest, "initiatorName");
	    String bgType = ParamUtil.getString(actionRequest, "bgType");
	    String amendment = ParamUtil.getString(actionRequest, "amendment");
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    
		
	   Date bgIssuanceDate =  ParamUtil.getDate(actionRequest, "bgIssuanceDate", dateFormatter);
		
		Date bgClaimDate =ParamUtil.getDate(actionRequest, "bgClaimDate", dateFormatter);
		
		Date bgExpiryDate =ParamUtil.getDate(actionRequest, "bgExpiryDate", dateFormatter);
		
		 String vendorName = ParamUtil.getString(actionRequest, "vendorName");
		 String bankName = ParamUtil.getString(actionRequest, "bankName");
		 String bgNoSFMS = ParamUtil.getString(actionRequest, "bgNoSFMS");
		 String currency = ParamUtil.getString(actionRequest, "currency");
		 Long totalAmount = ParamUtil.getLong(actionRequest, "totalAmount");
		 String remarks = ParamUtil.getString(actionRequest, "remarks");
		 String selectEIC = ParamUtil.getString(actionRequest, "selectEIC");
		 String fwrdto = ParamUtil.getString(actionRequest, "fwrdto");
		 String department = ParamUtil.getString(actionRequest, "department");
		
		 String oldrefeferenceNo = ParamUtil.getString(actionRequest, "oldReferenceNo");
		 String eicName = ParamUtil.getString(actionRequest, "eicName");
		  
		 String bgno=ParamUtil.getString(actionRequest, "bgno");
		  Date sentonFormatted = ParamUtil.getDate(actionRequest, "senton", new SimpleDateFormat("dd/MM/yyyy"));
		  String forwardToEmployeeName = StringPool.BLANK;
			long forwardToLiferayUserId = 0L;
			EmployeeDirectory employeeDirectory = EmployeeDirectoryLocalServiceUtil.getEmployeeDirectory(empId);
			if (Validator.isNotNull(employeeDirectory)) {
				forwardToEmployeeName = employeeDirectory.getEmployeeName();
				forwardToLiferayUserId = employeeDirectory.getUserId();
			}
			
		
		  
		  BgInitiation bginitiation=BgInitiationLocalServiceUtil.createBgInitiation(CounterLocalServiceUtil.increment(BgInitiation.class.getName()));
		 String bgInitiationUniqueId;
		 LocalDate currentdate = LocalDate.now();

		 int currentYear = currentdate.getYear();
	     long bginitiationId =CounterLocalServiceUtil.increment(BgInitiation.class.getName());
	  
		
		if ("delhi".equalsIgnoreCase(selectEIC)) {
			
		    
		    bgInitiationUniqueId = "11" + currentYear+ bginitiationId;
		} else if ("dahej".equalsIgnoreCase(selectEIC)) {
			
		   
		    bgInitiationUniqueId = "22" + currentYear +bginitiationId;
		} else if ("kochi".equalsIgnoreCase(selectEIC)) {
			
		   
		    bgInitiationUniqueId = "33" +currentYear + bginitiationId;
		} else {
		   
		    bgInitiationUniqueId = "unknown"; 
		}
		bginitiation.setEmpId(empId);
		bginitiation.setInitiatorname(initiatorName);
		bginitiation.setBgtype(bgType);
		bginitiation.setAmendment(amendment);
		bginitiation.setBgissuedate(bgIssuanceDate);
		bginitiation.setBgclaimdate(bgClaimDate);
		bginitiation.setBgexpdate(bgExpiryDate);
		bginitiation.setVendorname(vendorName);
		bginitiation.setBankname(bankName);
		bginitiation.setBgreference(oldrefeferenceNo);
		bginitiation.setSfms(bgNoSFMS);
		bginitiation.setCurrency(currency);
		bginitiation.setEic(selectEIC);
		bginitiation.setEicname(eicName);
		bginitiation.setRemarks(remarks);
		bginitiation.setAmount(totalAmount);
		bginitiation.setForwardedTo(fwrdto);
		bginitiation.setDepartment(department);
		bginitiation.setForwardToEmployeeId(empId);
		bginitiation.setForwardToEmployeeName(forwardToEmployeeName);
		bginitiation.setForwardToLiferayUserId(forwardToLiferayUserId);
		bginitiation.setBgInitiationUniqueId(bgInitiationUniqueId);
		bginitiation.setSenton(sentonFormatted);
		bginitiation.setStatus("Created");
		
		bginitiation.setFileId(uploadFileEntity);
		bginitiation.setBgno(bgno);
		bginitiation.setUserId(userId);
	_log.info("bgInitiationUniqueId>>>>>>>>>>"+bgInitiationUniqueId);
		BgInitiation bgdetails =BgInitiationLocalServiceUtil.addBgInitiation(bginitiation);
		_log.info("bgdetails>>>>>."+bgdetails);
		_log.info("Success full");
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		responseJson.put("bgTrackId", bgdetails.getBgInitiationUniqueId());
	      _log.info(bgdetails.getBgInitiationUniqueId());
		if (Validator.isNotNull(responseJson) && Validator.isNotNull(responseJson.getString("bgTrackId"))) {
			SessionMessages.add(actionRequest, "bgTrackId", responseJson.getString("bgTrackId"));
			SessionMessages.add(actionRequest, "bg-initiated-success");
		}
		SessionMessages.add(actionRequest, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(actionRequest, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		actionResponse.sendRedirect(redirectURL);
		_log.info("Success");
		
		fileMovement filemovement=fileMovementLocalServiceUtil.createfileMovement(CounterLocalServiceUtil.increment(fileMovement.class.getName()));
		filemovement.setBgInitiationUniqueId(bgInitiationUniqueId);
		filemovement.setSentBy(userId);
		filemovement.setSentOn(new Date());
		filemovement.setSentTo(forwardToLiferayUserId);
		filemovement.setUserId(employeeDirectory.getUserId());

		
		
		fileMovementLocalServiceUtil.addfileMovement(filemovement);
	}
	private long uploadFileEntity(ServiceContext serviceContext, UploadPortletRequest request) 
            throws PortalException, SystemException {

String filename = "";
String description = "File description";
String foldername = ParamUtil.getString(request,"getfolder");
FileEntry entry=null;
try{

  
    long repositoryId = DLFolderConstants.getDataRepositoryId(
        serviceContext.getScopeGroupId(), 
        DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);


    Folder f = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "BG_Files");
    long folderId = f.getFolderId();


    File file = request.getFile("customFile");
    filename = request.getFileName("customFile");
    
    String mimeType =  MimeTypesUtil.getContentType(file);

    entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
            repositoryId, folderId, filename, 
            mimeType, filename, description, "", 
            file, serviceContext
    );  
  

}catch(PortalException e){
  _log.error("An exception occured uploading file: " 
            + e.getMessage());
}catch(SystemException e ){
      _log.error("An exception occured uploading file: " 
            + e.getMessage());
}
return entry.getFileEntryId() ;
}
	
	
}	
		
	


