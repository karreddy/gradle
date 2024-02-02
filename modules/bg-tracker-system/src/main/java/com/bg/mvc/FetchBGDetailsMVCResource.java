package com.bg.mvc;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pll_common_schema.model.BgInitiation;
import pll_common_schema.service.BgInitiationLocalServiceUtil;
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
			"mvc.command.name="+ BgTrackerSystemPortletKeys.FETCH_BG_DETAILS
		},
		service = MVCResourceCommand.class
	)

public class FetchBGDetailsMVCResource extends BaseMVCResourceCommand{
	private static final Log _log = LogFactoryUtil.getLog(FetchBGDetailsMVCResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		  String bgUniqueId = ParamUtil.getString(resourceRequest, "bgUniqueId");
		  

        // Your existing logic to fetch data from the database
        List<BgInitiation> bgInitiations = BgInitiationLocalServiceUtil.getBgInitiations(-1, -1);
        JSONObject jsonobj = JSONFactoryUtil.createJSONObject();

        for (BgInitiation bgInitiation : bgInitiations) {
            if (bgInitiation.getBgInitiationUniqueId().equals(bgUniqueId)) { 
                jsonobj.put("bgtid", bgInitiation.getBgInitiationUniqueId());
                jsonobj.put("initiatorname", bgInitiation.getInitiatorname());
                jsonobj.put("bgtype", bgInitiation.getBgtype());
                Date issuancedate=bgInitiation.getBgissuedate();
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate1 = dateFormat1.format(issuancedate);
                jsonobj.put("issuancedate", formattedDate1);
                Date expirydate=bgInitiation.getBgexpdate();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate2 = dateFormat2.format(expirydate);
                jsonobj.put("expirydate", formattedDate2);
                Date claimdate=bgInitiation.getBgclaimdate();
                SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate3 = dateFormat3.format(claimdate);
                jsonobj.put("claimdate", formattedDate3);
                jsonobj.put("vendorname", bgInitiation.getVendorname());
                jsonobj.put("bankname", bgInitiation.getBankname());
                jsonobj.put("bgno", bgInitiation.getBgno());
                jsonobj.put("sfms", bgInitiation.getSfms());
                jsonobj.put("amount", bgInitiation.getAmount());
                jsonobj.put("currancy", bgInitiation.getCurrency());
                jsonobj.put("remarks", bgInitiation.getRemarks());
               
                long fileEntryId = bgInitiation.getFileId();
    			if(Validator.isNotNull(fileEntryId))
    				jsonobj.put("file", getFileURL(fileEntryId, themeDisplay));
                
               
            }
        }

        PrintWriter pw = resourceResponse.getWriter();
        pw.print(jsonobj);
        pw.flush();
        pw.close();
      
    }
	private String getFileURL(long fileEntryId, ThemeDisplay themeDisplay) {

		FileEntry fileEntry;
		String uploadedFileURL = StringPool.BLANK;
		try {
			fileEntry = _dlAppService.getFileEntry(fileEntryId);
			uploadedFileURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "");
		} catch (Exception e) {
			_log.error("Exception occured while fetching filePreviewURL"+e.getMessage());
			e.printStackTrace();
		}

		return uploadedFileURL;
	}
		
	@Reference
	private DLAppService _dlAppService;

	}


