package com.bg.mvc;

import com.bg.tracker.constants.BgTrackerSystemPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pll_common_schema.model.BgInitiation;
import pll_common_schema.model.fileMovement;
import pll_common_schema.service.BgInitiationLocalServiceUtil;
import pll_common_schema.service.fileMovementLocalService;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + BgTrackerSystemPortletKeys.BGTRACKERSYSTEM,
        "mvc.command.name=" + BgTrackerSystemPortletKeys.BG_DETAILS
    },
    service = MVCRenderCommand.class
)

public class AcknowledgeDetailsMVCRender implements MVCRenderCommand {
    private static final Log _log = LogFactoryUtil.getLog(AcknowledgeDetailsMVCRender.class);

    @Reference
    private fileMovementLocalService filemovementlocalservice;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        _log.info("Inside acknowledgeDetails");
        String bgUniqueId = ParamUtil.getString(renderRequest, "bgUniqueId");
        _log.info("bgUniqueId>>>>>>>>>>>>" + bgUniqueId);

        List<BgInitiation> bgdetails = BgInitiationLocalServiceUtil.getBgInitiations(-1, -1);
        JSONObject resultJSON = JSONFactoryUtil.createJSONObject();

        for (BgInitiation bgInitiation : bgdetails) {
            if (bgUniqueId.equals(bgInitiation.getBgInitiationUniqueId())) {
                resultJSON.put("bgId", bgInitiation.getBgInitiationUniqueId());
                resultJSON.put("byType", bgInitiation.getBgtype());
                resultJSON.put("eicName", bgInitiation.getEicname());
                resultJSON.put("vendorName", bgInitiation.getVendorname());
                resultJSON.put("bankName", bgInitiation.getBankname());
                resultJSON.put("bgNo", bgInitiation.getBgno());
                resultJSON.put("sfms", bgInitiation.getSfms());
                resultJSON.put("issueDate", bgInitiation.getBgissuedate());
                resultJSON.put("claimDate", bgInitiation.getBgclaimdate());
                resultJSON.put("expDate", bgInitiation.getBgexpdate());
                resultJSON.put("initiationDate", bgInitiation.getCreateDate());
                resultJSON.put("amount", bgInitiation.getAmount());
                resultJSON.put("currency", bgInitiation.getCurrency());
                resultJSON.put("initiator", bgInitiation.getInitiatorname());
                resultJSON.put("holdwith", bgInitiation.getHold_with());
                resultJSON.put("status", bgInitiation.getStatus());

                _log.info("resultJSON (bgInitiation)>>>>>>>>>>>>" + resultJSON);
            }
        }

        List<fileMovement> movement = filemovementlocalservice.getBybgUniqueId(bgUniqueId);
        JSONArray movementArray = JSONFactoryUtil.createJSONArray();

        for (fileMovement fileMovement : movement) {
            JSONObject movementObject = JSONFactoryUtil.createJSONObject();
            try {
                User sentByUser = UserLocalServiceUtil.getUserById(fileMovement.getSentBy());
                User sendToUser = UserLocalServiceUtil.getUserById(fileMovement.getSentTo());

                movementObject.put("sentby", sentByUser.getFullName());
                movementObject.put("sendto", sendToUser.getFullName());
            } catch (PortalException e) {
               
            }
          
            movementObject.put("sentDate", fileMovement.getSentOn());
            movementObject.put("actionTaken", fileMovement.getActionTaken());
           
            movementObject.put("comments", fileMovement.getComments());
            movementObject.put("acknDate", fileMovement.getAckOnDate());
            movementObject.put("acknTime", fileMovement.getAckOnTime());

            movementArray.put(movementObject);
            _log.info("movementArray>>>>>>>>>>>"+movementArray);
        }

       
        resultJSON.put("fileMovements", movementArray);
        renderRequest.setAttribute("bgDetailsJSON", resultJSON);

        return "/status.jsp";
    }
}
