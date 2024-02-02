package com.pll.birthdaywishesmvc.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.pll.birthdaywishesmvc.constants.BirthdayWishesMvcPortletKeys;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.EmployeeDirectoryLocalServiceUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			
			"javax.portlet.name=" + BirthdayWishesMvcPortletKeys.BIRTHDAYWISHESMVC,
			"mvc.command.name=/hello/RenderBirthday"
		},
		service = MVCRenderCommand.class
	)
public class BirthdayInMonth implements MVCRenderCommand{
	Log log=LogFactoryUtil.getLog(BirthdayInMonth.class);
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MM")); 

		try {
		    JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		    List<EmployeeDirectory> employeeDirectories = EmployeeDirectoryLocalServiceUtil.getEmployeeDirectories(-1, -1);
		  //  List<regisForm> getsuggestionformses = regisFormLocalServiceUtil.getregisForms(-1, -1);
		    for (EmployeeDirectory userloop : employeeDirectories) {
		    	User user = UserLocalServiceUtil.getUser(userloop.getUserId());
		        Date userBirthDate = user.getBirthday();
		        log.info("userBirthDate-------"+userBirthDate);

		        
		        if (userBirthDate == null) {
		            continue; 
		        }

		        LocalDate birthLocalDate = userBirthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        String formattedBirthDate = birthLocalDate.format(dateFormatter);
		        log.info("birthLocalDate-------"+birthLocalDate);
		        
		        String birthMonth = birthLocalDate.format(DateTimeFormatter.ofPattern("MM"));
		        System.out.println("birthMonth: " + birthMonth);
		        DLFileEntry image;
		        String imageUrl ="";
		        
		        if (currentMonth.equals(birthMonth)) {
		            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		            
		            try {
		                image = DLFileEntryLocalServiceUtil.getFileEntry(userloop.getFileEntryId());
		                imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getTitle() + "/"
		                            + image.getUuid();
		            } catch (PortalException e) {
		                e.printStackTrace();
		            }
		            
		            jsonObject.put("birthdate", formattedBirthDate);
		            jsonObject.put("employeename", userloop.getEmployeeName());
		            jsonObject.put("designation", userloop.getDesignation());
		            jsonObject.put("location", userloop.getLocation());
		            jsonObject.put("imageUrl", imageUrl);
		            jsonObject.put("email", user.getEmailAddress());
		            jsonarray.put(jsonObject);
		        }
		        renderRequest.setAttribute("jsonarray", jsonarray);
		    }
		} catch (Exception e) {
		    System.out.println("Failed to retrieve birthdays: " + e.getMessage());
		}

		
		
		
		return "/MonthBirthday.jsp";
	}
	

}
