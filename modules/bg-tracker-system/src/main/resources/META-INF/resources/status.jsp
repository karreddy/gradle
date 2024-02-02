<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
JSONObject bgDetailsJSON = (JSONObject) request.getAttribute("bgDetailsJSON");
JSONArray movementArray = bgDetailsJSON.getJSONArray("fileMovements");

%>

<script>
$(document).ready(function () {
	var jsMovementArray = <%= movementArray.toString() %>;
        console.log("jsMovementArray:", jsMovementArray);

       
        var tableBody = document.getElementById("tableBody");

      
        if (tableBody) {
         
            for (var i = 0; i < jsMovementArray.length; i++) {
                var row = "<tr>" +
                    "<td>" + jsMovementArray[i].sentby + "</td>" +
                    "<td>" + jsMovementArray[i].sentDate + "</td>" +
                    "<td>" + jsMovementArray[i].actionTaken + "</td>" +
                    "<td>" + jsMovementArray[i].sendto + "</td>" +
                    "<td>" + jsMovementArray[i].comments + "</td>" +
                    "<td>" + jsMovementArray[i].acknDate + "</td>" +
                    "</tr>";

               
                tableBody.innerHTML += row;
            }
        } else {
            console.error("Element with id 'tableBody' not found.");
        }
    });
</script>
<div class="mt-3">
    <div class="plng-accordion-cards ">
        <div class="card">
            <div class="align-content-center card-header d-flex justify-content-between">
                <h6 class="mb-0">
                    BG Details
                </h6>
            </div>
            <div class="card-body">
                <div class="row mb-4">
                    <label for="bgtid">BG Tracker Id</label>: <p><%= bgDetailsJSON.getString("bgId") %></p>
                </div>
                <div class="row mb-4">
                    <label for="bgtype">BG Type</label>: <p><%= bgDetailsJSON.getString("byType") %></p>
                </div>
                <div class="row mb-4">
                    <label for="eicName">EIC Name</label>: <p><%= bgDetailsJSON.getString("eicName") %></p>
                </div>
                <div class="row mb-4">
                    <label for="vendorname">Vendor Name</label>: <p><%= bgDetailsJSON.getString("vendorName") %></p>
                </div>
                <div class="row mb-4">
                    <label for="bankname">Bank Name</label>: <p><%= bgDetailsJSON.getString("bankName") %></p>
                </div>
                <div class="row mb-4">
                    <label for="bgno">BG No</label>: <p><%= bgDetailsJSON.getString("bgNo") %></p>
                </div>
                <div class="row mb-4">
                    <label for="sfms">SFMS Attached</label>: <p><%= bgDetailsJSON.getString("sfms") %></p>
                </div>
                <div class="row mb-4">
                    <label for="issuncedate">BG Issuance Date</label>: <p><%= bgDetailsJSON.getString("issueDate") %></p>
                </div>
                <div class="row mb-4">
                    <label for="expdate">BG Expiry Date</label>: <p><%= bgDetailsJSON.getString("expDate") %></p>
                </div>
                <div class="row mb-4">
                    <label for="claimdate">BG Claim Date</label>: <p><%= bgDetailsJSON.getString("claimDate") %></p>
                </div>
                <div class="row mb-4">
                    <label for="initiationDate">Date of Initiation</label>: <p><%= bgDetailsJSON.getString("initiationDate") %></p>
                </div>
                <div class="row mb-4">
                    <label for="amount">Amount</label>: <p><%= bgDetailsJSON.getString("amount") %></p>
                </div>
                <div class="row mb-4">
                    <label for="initiator">Initiator</label>: <p><%= bgDetailsJSON.getString("initiator") %></p>
                </div>
                <div class="row mb-4">
                    <label for="currently">Currently With</label>: <p><%= bgDetailsJSON.getString("holdwith") %></p>
                </div>
                <div class="row mb-4">
                    <label for="status">Status</label>: <p><%= bgDetailsJSON.getString("status") %><%= bgDetailsJSON.getString("holdwith") %></p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="mt-3">
    <div class="plng-accordion-cards">
        <div class="card">
            <div class="align-content-center card-header d-flex justify-content-between">
                <h6 class="mb-0">
                    BG Flow
                </h6>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Sent By</th>
                            <th scope="col">Sent Date</th>
                            <th scope="col">Action Taken</th>
                            <th scope="col">Sent To</th>
                            <th scope="col">Comments</th>
                            <th scope="col">Receive Date</th>
                        </tr>
                    </thead>
                    <tbody id="tableBody">
      
             </tbody>
                </table>
            </div>
        </div>
    </div>
</div>