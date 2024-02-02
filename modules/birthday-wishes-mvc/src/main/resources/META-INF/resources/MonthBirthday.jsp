<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
<portlet:renderURL var="RenderBirthday">
    <portlet:param name="mvcRenderCommandName" value="/hello/RenderBirthday" />
</portlet:renderURL>


<portlet:renderURL var="WishesSend">
    <portlet:param name="mvcRenderCommandName" value="/hello/WishesSend" />
</portlet:renderURL>
<style>
    /* Hover effect */
    #dataTable tbody tr:hover {
        background-color: #e0e0e0;
    }

    /* Gray background for even rows */
    #dataTable tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>



<div class="plng-accordion-cards">
        <div class="card">
            <div class="card-header form-title">
                <h6 class="mb-0">
                    Birthday in the Month
                </h6>
            </div>


<%
    JSONArray influencerData = (JSONArray)request.getAttribute("jsonarray");

    if (influencerData != null) {
%>


            <div class="card-body">
                <div class="">
                    <div class="row">
                    <div class="col-md-12 table-responsive">
                        <table id="dataTable" class="table" aria-describedby="table-info" >
                            <thead>
                                <tr>
                        <th>Date</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Location</th>
                        <th>Send Wishes</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < influencerData.length(); i++) {
                        JSONObject influencer = influencerData.getJSONObject(i);
                    %>
                    <tr>
                        <td><%= influencer.getString("birthdate") %></td>
                        <td><img src="<%= influencer.getString("imageUrl")%>" class="img-thumbnail" alt="..." style="max-width: 100px; height: auto;"></td>
                       <td><%= influencer.getString("employeename") %></td>
                        <td><%= influencer.getString("designation") %></td>
                        <td><%= influencer.getString("location") %></td>
                        <td><a href="<%= WishesSend%>&email=<%= influencer.getString("email")%>">Send Wishes</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</div>
</div>

<% } %>


<script>
    $(document).ready(function() {
        $('#dataTable').DataTable({
            "hover": true
        });
    });
</script>
