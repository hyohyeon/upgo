
<%@page import="com.upgo.dto.Member"%>
<%@page import="com.upgo.dto.Hotel"%>
<%@page import="com.upgo.dto.Airplane"%>
<%@page import="java.util.List"%>
<%@page import="com.upgo.dto.Scheduling"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>Schedule Detail</title>
	<link rel="stylesheet" type="text/css" href="../css/traveldetailshowstyle.css">
	<style>
		body {
			background: #ddd;
		}

		#container {
			width: 100%;
			margin: auto;
			position: relative;
		}
	</style>
</head>
<% List<Scheduling> schedulings = (List<Scheduling>)request.getAttribute("schedulings"); %>
<% List<Airplane> airplanesS = (List<Airplane>)request.getAttribute("airplanesS"); %>
<% List<Airplane> airplanesF = (List<Airplane>)request.getAttribute("airplanesF"); %>
<% List<Hotel> hotels = (List<Hotel>)request.getAttribute("hotels"); %>
<% int i = (Integer)request.getAttribute("schedulesequencebycustomer"); %>
<% Airplane airplaneS = airplanesS.get(i); %>
<% Airplane airplaneF = airplanesF.get(i); %>
<% Hotel hotel = hotels.get(i); %>
<body>

	<div id="container">
		<div class="pricing-table basic">
			<span class="table-head">
				Depart Flight
			</span>
			<span class="price">
				<%=airplaneS.getaDepartRegion()%> > <%=airplaneS.getaArrivalRegion() %>
			</span>
			<span class="table-row">Airline : <%=airplaneS.getaAirline() %></span>
			<span class="table-row">Flight Model : <%=airplaneS.getaModel() %></span>
			<span class="table-row">Depart Date : <%=airplaneS.getaDepartDay()%></span>
			<span class="table-row">Arrival Date : <%=airplaneS.getaArrivalDay()%></span>
			<span class="table-row">Flying Time : <%=airplaneS.getaFlyingTime() %></span>
			<span class="table-row">Flight Grade : <%=airplaneS.getaGrade()%></span>
			<div class="purchase">
				<a href="#" class="buy">Seat Location</a>
			</div>
		</div>

		<div class="pricing-table standard">
			<span class="table-head">
				Return Flight
			</span>
			<span class="price">
				<%=airplaneF.getaDepartRegion()%> > <%=airplaneF.getaArrivalRegion() %>
			</span>
			<span class="table-row">Airline : <%=airplaneF.getaAirline() %></span>
			<span class="table-row">Flight Model : <%=airplaneF.getaModel() %></span>
			<span class="table-row">Depart Date : <%=airplaneF.getaDepartDay()%></span>
			<span class="table-row">Arrival Date : <%=airplaneF.getaArrivalDay()%></span>
			<span class="table-row">Flying Time : <%=airplaneF.getaFlyingTime() %></span>
			<span class="table-row">Flight Grade : <%=airplaneF.getaGrade()%></span>
			<div class="purchase">
				<a href="#" class="buy">Seat Location</a>
			</div>
		</div>

		<div class="pricing-table premium">
			<span class="table-head">
				Hotel
			</span>
			<span class="price">
				<%=hotel.getName()%>
			</span>
			<span class="table-row">Grade : <%=hotel.getGrade() %></span>
			<span class="table-row">Rating : <%=hotel.getRating() %></span>
			<span class="table-row">Price : <%=hotel.getPrice() %></span>
			<span class="table-row">Phone : <%=hotel.getPhoneNo() %></span>
			<span class="table-row">Address : <%=hotel.getAddress() %></span>
			<span class="table-row">Check In/Out : <%=hotel.getCheckIn() %> / <%=hotel.getCheckOut() %></span>
			<div class="purchase">
				<a href="#" class="buy">Room Location</a>
			</div>
		</div>
	</div>
	
</body>
</html>