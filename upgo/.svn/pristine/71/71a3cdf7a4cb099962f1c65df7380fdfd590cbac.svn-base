
<%@page import="com.upgo.dto.ReserveAirseat"%>
<%@page import="com.upgo.dto.Airseat"%>
<%@page import="com.upgo.dto.Airplane"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Reserve Airseat</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	
	$( ".accordion").accordion({
	    collapsible: true
	});
	<!-- Initiate accordion and set default opt collapsible -->
	  
	$( "#tabs" ).tabs({
	    collapsible: true
	});
	<!-- Initiate tabs and set default opt collapsible-->
	  
    $("#reserveFlightS").click(function() {
        var reserveAirseatS = $("input[name=seatS]:checked").val();
    	$("#reserveAirseatS").val(reserveAirseatS);
    });
    
    <!-- get value from radiobutton as reserveAirseat(depart) -->
    
    $("#reserveFlightF").click(function() {
    	var reserveAirseatF = $("input[name=seatF]:checked").val();
    	$("#reserveAirseatF").val(reserveAirseatF);
    	$("#submitReserveAirseats").submit();
    });
    <!-- get value from radiobutton as reserveAirseat(return) and submit data to reserveairseat.action -->
    
  });
  </script>
</head>
<body>

<div id="tabs">
  <ul>
    <li><a href="#flightS">Departure Flight</a></li>
    <li><a href="#flightF">Return Flight</a></li>
  </ul>
  <div id="flightS"> 
 
	<div class="accordion">
		<% List<Airplane> airplanesS = (List<Airplane>)request.getAttribute("airplanesS"); %>
		<% List<Airseat> airseats = (List<Airseat>)request.getAttribute("airseats"); %>
		<% List<ReserveAirseat> reserveairseats = (List<ReserveAirseat>)request.getAttribute("reserveairseats");%>
		<!-- Make three List about airplane(depart), airplane(return), reserveairseat -->
		<% for (Airplane airplaneS : airplanesS){ %>
		<!-- Show appropriate depart airplane list about scheduling-->
	  	<h3>Depart Region:<%= airplaneS.getaDepartRegion() %>&nbsp;&nbsp;Arrival Region:<%= airplaneS.getaArrivalRegion() %>&nbsp;&nbsp;Depart Day:<%= airplaneS.getaDepartDay() %>&nbsp;&nbsp;Flying Time:<%= airplaneS.getaFlyingTime() %>&nbsp;&nbsp;Airline:<%= airplaneS.getaAirline() %>  </h3>
	  	<div>
		  	<% for(int i=1; i<7; i++){ %>
			  	<p>
			  	<% for (Airseat airseat : airseats){ %>
			  		<% if(airplaneS.getaNo()==airseat.getaNo()){ %>
			    		<% if(airseat.getAsSeatType()==i){ %>
				    	<label><input type="radio" name="seatS" value="<%= airseat.getAsNo() %>"<%for(ReserveAirseat reserveairseat : reserveairseats){ if(airseat.getAsNo()==reserveairseat.getAsNo()){ %>disabled<% } %><% } %>><%= airseat.getAsRealNo()%></label>
				    	<% } %>
			    	<% } %>
			    <% } %>
			    </p>
			<% } %>
	  	</div>
	  	<% } %>
	  	<button id='reserveFlightS'>Reserve Departure Airseat</button>
	</div>
  </div>
  <div id="flightF"> 
 	<div class="accordion">
		<% List<Airplane> airplanesF = (List<Airplane>)request.getAttribute("airplanesF"); %>
		<% for (Airplane airplaneF : airplanesF){ %>
		<!-- Show appropriate return airplane list about scheduling-->
	  	<h3>Depart Region:<%= airplaneF.getaDepartRegion() %>&nbsp;&nbsp;Arrival Region:<%= airplaneF.getaArrivalRegion() %>&nbsp;&nbsp;Depart Day:<%= airplaneF.getaDepartDay() %>&nbsp;&nbsp;Flying Time:<%= airplaneF.getaFlyingTime() %>&nbsp;&nbsp;Airline:<%= airplaneF.getaAirline() %>  </h3>
	  	<div>
		  	<% for(int i=1; i<7; i++){ %>
			  	<p>
			  	<% for (Airseat airseat : airseats){ %>
			  		<% if(airplaneF.getaNo()==airseat.getaNo()){ %>
			    		<% if(airseat.getAsSeatType()==i){ %>
				    	<label><input type="radio" name="seatF" value="<%=airseat.getAsNo()%>" <%for(ReserveAirseat reserveairseat : reserveairseats){ if(airseat.getAsNo()==reserveairseat.getAsNo()){ %> disabled <% }  } %>><%= airseat.getAsRealNo()%></label>
				    	<% } %>
			    	<% } %>
			    <% } %>
			    	</p>
			<% } %>
	  	</div>
	  	<% } %>
	  	<button id='reserveFlightF'>Reserve Arrival Airseat</button>
	  	<!-- Button to submit data to reserveairseat.action -->
	</div>
  </div>
</div>
<form id="submitReserveAirseats" action="/upgo/scheduling/reserveairseat.action" method="post">
	<input type="hidden" id="reserveAirseatS" name="reserveAirseatS" value="">
	<input type="hidden" id="reserveAirseatF" name="reserveAirseatF" value="">
	<input type="hidden" id="sNo" name="sNo" value = "<%=request.getParameter("sNo")%>">
</form>
</body>

</html>