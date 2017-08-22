
<%@page import="com.upgo.dto.ReserveRoom"%>
<%@page import="com.upgo.dto.Room"%>
<%@page import="com.upgo.dto.Hotel"%>
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
    
	$("#confirmroom").click(function() {
        var reserveroom = $("input[name=room]:checked").val();
    	$("#reserveroom").val(reserveroom);
    	$("#submitreserveroom").submit();
    });
	<!-- get value from radiobutton as reserveRoom and submit data to reserveroom.action -->
    
  });
  </script>
</head>
<body>

<% List<Hotel> hotels = (List<Hotel>)request.getAttribute("hotels"); %>
<% List<Room> rooms = (List<Room>)request.getAttribute("rooms"); %>
<% List<ReserveRoom> reserverooms = (List<ReserveRoom>)request.getAttribute("reserverooms");%>
<!-- <% List<Integer> countRemainRoomByHotels = (List<Integer>)request.getAttribute("countremainroombyhotels"); %> -->
<div id="tabs">
<!-- Show appropriate return airplane list about scheduling-->
  <ul>
  	<!-- Divide hotel by star(grade) -->
    <%for(int i=5; i>0; i--){ %>
    <li><a href="#showhotel<%=i%>star">Hotel <%=i%> Star</a></li>
    <% } %>
  </ul>
  <%for(int i=5; i>0; i--){ %>
  <div id="showhotel<%=i%>star"> 
	<div class="accordion">
		<% for (Hotel hotel : hotels){ %>
			<%if(hotel.getGrade()==i){ %>
		  	<h3>Hotel Name:<%= hotel.getName() %>&nbsp;&nbsp;Grade : <%= i %>&nbsp;&nbsp; Price : <%= hotel.getPrice() %>&nbsp;&nbsp; address : <%= hotel.getAddress() %>&nbsp;&nbsp;</h3>
		  	<div>
				<% for(int j=10; j>0; j--){ %>
				<p>
				  	<% for (Room room : rooms){ %>
				  		<% if(hotel.getNo()==room.gethNo()){ %>
				    		<% if(room.getFloor()==j){ %>
					    	<label><input type="radio" name="room" value="<%=room.getNo()%>"<%for(ReserveRoom reserveroom : reserverooms){ if(room.getNo()==reserveroom.getRmNo()){ %>disabled<% }  } %>> <%=room.getRealNo() %> </label>
					    	<% } %>
				    	<% } %>
				    <% } %>
				</p>
				<% } %>
			</div>
	  		<% } %>
	  	<% } %>
	</div>
  </div>
  <% } %>
</div>
<button id='confirmroom'>Reserve Room</button>
<!-- Button to submit data to reserveroom.action -->
<form id="submitreserveroom" action="/upgo/scheduling/reserveroom.action" method="post">
	<input type="hidden" id="reserveroom" name="reserveroom" value="">
	<input type="hidden" id="sNo" name="sNo" value = "<%=request.getParameter("sNo")%>">
</form>
</body>

</html>