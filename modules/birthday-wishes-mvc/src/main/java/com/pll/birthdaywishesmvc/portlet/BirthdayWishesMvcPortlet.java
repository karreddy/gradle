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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.pll.birthdaywishesmvc.constants.BirthdayWishesMvcPortletKeys;
import com.pll.employee.directory.model.EmployeeDirectory;
import com.pll.employee.directory.service.EmployeeDirectoryLocalServiceUtil;

import java.io.IOException;
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

/**
 * @author USER
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BirthdayWishesMvc",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BirthdayWishesMvcPortletKeys.BIRTHDAYWISHESMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class BirthdayWishesMvcPortlet extends MVCPortlet {
	Log log=LogFactoryUtil.getLog(BirthdayWishesMvcPortlet.class);
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {
	    log.info("main portlet------------");
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd");
	    String formattedDate = currentDate.format(dateFormatter);
	    DateTimeFormatter dateFormatterFull = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	    try {
	        JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
	        List<EmployeeDirectory> employeeDirectories = EmployeeDirectoryLocalServiceUtil.getEmployeeDirectories(-1, -1);
	     //   List<regisForm> getsuggestionformses = regisFormLocalServiceUtil.getregisForms(-1, -1);
	        for (EmployeeDirectory userloop : employeeDirectories) {
	        	User user = UserLocalServiceUtil.getUser(userloop.getUserId());
	        	
	        	
	            Date userBirthDate = user.getBirthday();
	            log.info("userBirthDate-------" + userBirthDate);


	            if (userBirthDate == null) {
	                continue;
	            }

	            LocalDate birthLocalDate = userBirthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	            String formattedBirthDate = birthLocalDate.format(dateFormatter);
	            String formattedBirthDateFull = birthLocalDate.format(dateFormatterFull);

	            DLFileEntry image;
	            String imageUrl = "";

	            if (formattedDate.equals(formattedBirthDate)) {
	                JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

	                try {
	                    image = DLFileEntryLocalServiceUtil.getFileEntry(userloop.getFileEntryId());
	                    imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getTitle() + "/"
	                            + image.getUuid();
	                } catch (PortalException e) {
	                    e.printStackTrace();
	                }

	                jsonObject.put("birthdate", formattedBirthDateFull);
	                jsonObject.put("employeename", userloop.getEmployeeName());
	                
	                jsonObject.put("location", userloop.getLocation());
	                jsonObject.put("Department", userloop.getDepartment());
	                jsonObject.put("Designation", userloop.getDesignation());
	                jsonObject.put("imageUrl", imageUrl);
	                jsonObject.put("email", user.getEmailAddress());
	                jsonarray.put(jsonObject);
	            }
	            renderRequest.setAttribute("jsonarray", jsonarray);
	        }
	    } catch (Exception e) {
	        System.out.println("Failed to retrieve birthdays: " + e.getMessage());
	    }

	    super.render(renderRequest, renderResponse);
	}

}