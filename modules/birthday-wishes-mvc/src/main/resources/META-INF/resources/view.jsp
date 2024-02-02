<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="RenderBirthday">
    <portlet:param name="mvcRenderCommandName" value="/hello/RenderBirthday" />
</portlet:renderURL>

<portlet:renderURL var="mailSend">
    <portlet:param name="mvcRenderCommandName" value="/hello/MailSendUrl" />
</portlet:renderURL>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap">

<%

LocalDate currentDate = LocalDate.now();
DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formattedDate = currentDate.format(dateFormatter);


%>



<div class="plng-accordion-cards">
        <div class="card">
        <div class="card-header form-title">
                <h6 class="mb-0">
                   Birthday Wishes
                </h6>
            </div>
            
<div class="card-body">
<div class="center-content" >
                <img src="https://www.bestworldevents.com/wp-content/uploads/2023/09/happy-birthday-cake-and-candle-latest.gif"
                    alt="birthday" class="birthday">
                <h2 class="text-center" style="font-family: Arial, sans-serif; color: navy; "><%=formattedDate %></h2>
            </div>
<%
    JSONArray influencerData = (JSONArray) request.getAttribute("jsonarray");
%>
 <div class="row">
        <% if (influencerData != null) {
            for (int i = 0; i < influencerData.length(); i++) {
                JSONObject influencer = influencerData.getJSONObject(i);
        %>
        
       
                <div class="col-md-3">
                    <div class="card border-5 shadow">
                        <div class="card-header">
                            <img class="w-100" style="height:300px;" src="<%= influencer.getString("imageUrl")%>" alt="">
                        </div>
                        <div class="card-body text-center">
                          <h5 class=""><%= influencer.getString("employeename") %></h5>
                          <span class="text-muted"><%=influencer.getString("Designation") %></span>
                          <p class=""><%=influencer.getString("Department") %>, <%=influencer.getString("location") %></p>
                          <a class="btn btn-primary plng-btn" type="sumbit">Send Wishes</a>
                        </div>
                    </div>
                </div>
           
        
      
       

        <% }
            }
        %>
     </div>
     
     <div class="btnclass">
    <a href="<%= RenderBirthday%>"><button type="submit" class="btn btn-primary plng-btn">Birthdays in Month</button></a>
</div>
 </div>
 </div>
</div>




<style>
.center-content{

display: grid;
    justify-content: center;
}


.btnclass{
display: grid;
    justify-content: center;
}

</style>
