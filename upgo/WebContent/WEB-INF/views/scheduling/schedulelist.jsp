
<%@page import="com.upgo.dto.Member"%>
<%@page import="com.upgo.dto.Hotel"%>
<%@page import="com.upgo.dto.Airplane"%>
<%@page import="java.util.List"%>
<%@page import="com.upgo.dto.Scheduling"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Schedule List</title>
     <!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="../css/traveldetailstyle.css">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	 
	  
    
  });
  </script>
</head>

<% Member member = (Member)session.getAttribute("loginuser"); %>
<% List<Scheduling> schedulings = (List<Scheduling>)request.getAttribute("schedulings"); %>
<% List<Airplane> airplanesS = (List<Airplane>)request.getAttribute("airplanesS"); %>
<% List<Airplane> airplanesF = (List<Airplane>)request.getAttribute("airplanesF"); %>
<% List<Hotel> hotels = (List<Hotel>)request.getAttribute("hotels"); %>
<body>
<div id="pageContainer">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section id="pricePlans">
		<ul id="plans">
		<% for(int i = 0; i<schedulings.size(); i++){ %>
			<%Scheduling scheduling = schedulings.get(i); %>
			<%Airplane airplaneS = airplanesS.get(i); %>
			<%Airplane airplaneF = airplanesF.get(i); %>
			<%Hotel hotel = hotels.get(i); %>
			<li class="plan">
				<ul class="planContainer">
					<li class="title"><h2>Plan <%=i+1%></h2></li>
					<li class="price"><p>$<%=scheduling.getTotalPrice()%>/<span>$<%=scheduling.getBudget()%></span></p></li>
					<li>
						<ul class="options">
							<li><%=scheduling.getDateS() %>&nbsp;~&nbsp;<%=scheduling.getDateF()%>&nbsp;&nbsp;<span>Schedule</span></li>
							<li><%=scheduling.getInterestregion() %>&nbsp;&nbsp;&nbsp;<span>Interest Region</span></li>
							<li><a href="/upgo/scheduling/scheduledetail.action?schedulesequencebycustomer=<%=i%>" onclick="window.open(this.href, 'scheduledetail', 'width=1263, height=505'); return false;"><%=airplaneS.getaNo()%></a>&nbsp;&nbsp;&nbsp;<span>Flight to <%=airplaneS.getaDepartRegion()%></span></li>
							<li><a href="/upgo/scheduling/scheduledetail.action?schedulesequencebycustomer=<%=i%>" onclick="window.open(this.href, 'scheduledetail', 'width=1263, height=505'); return false;"><%=airplaneF.getaNo()%></a>&nbsp;&nbsp;&nbsp;<span>Flight to <%=airplaneF.getaDepartRegion()%></span></li>
							<li><a href="/upgo/scheduling/scheduledetail.action?schedulesequencebycustomer=<%=i%>" onclick="window.open(this.href, 'scheduledetail', 'width=1263, height=505'); return false;"><%=hotel.getName()%></a>&nbsp;&nbsp;<span>Hotel</span></li>
						</ul>
					</li>
					<li class="button"><a class="modifyButton" href="/upgo/scheduling/modifyschedule.action?sNo=<%=scheduling.getNo() %>">Modify</a></li>
				</ul>
			</li>
		<% } %>

			<li class="plan">
				<ul class="planContainer">
					<li class="title"><h2 class="bestPlanTitle">New Plan</h2></li>
					<li class="price"><p class="bestPlanPrice">$1000/month</p></li>
					<li>
						<ul class="options">
							<li>Hi, <%=member.getName()%> <span></span></li>
							<li>On This Time, <span></span></li>
							<li>Where You Want to Go?<span></span></li>
							<li>Lots of Place <span></span></li>
							<li>Are Waiting for You <span></span></li>
						</ul>
					</li>
					<li class="button"><a class="newPlanButton" href="/upgo/scheduling/regionchoicefrom.action">New Plan</a></li>
				</ul>
			</li>
		</ul> <!-- End ul#plans -->
		<div id="credits">by <a href="http://medialoot.com/">Medialoot</a></div>
	</section>
<jsp:include page="/WEB-INF/views/include/function.jsp" />
</div>
</body>
</html>