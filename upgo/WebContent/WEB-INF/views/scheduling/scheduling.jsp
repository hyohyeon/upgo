
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>Scheduling</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<script src="../js/jquery-1.8.3.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	$( "#tabs" ).tabs();
    $( ".datePic" ).datepicker();
    $( "#slider" ).slider({
	      value:4000,
	      min: 0,
	      max: 30000,
	      step: 1,
	      slide: function( event, ui ) {
	        $( "#amount" ).val( ui.value );
	      }
	    });
    $( "#amount" ).val( $( "#slider" ).slider( "value" ) );
	    
    $('input#register-schedule').on('click',function(){
    	var datepickerS = $('#datepickerS').val();
    	var datepickerF = $('#datepickerF').val();
    	var amount = $('#amount').val();
    	
    	if(!datepickerS){
    		alert('please input start date');
    		$('#datepickerS').focus();
    		return;
    	}else if(!datepickerF){
    		alert('please input finish date');
    		$('#datepickerF').focus();
    		return;
    	}
    	
    	$("#scheduleInfo").submit();
    	
	});
	  
  });  
  </script>

<body>
	<form id="scheduleInfo" action="/upgo/scheduling/scheduling.action" method="post">
	<div id="tabs">
	  <ul>
	    <li><a href="#tabs-1">Date</a></li>
	    <li><a href="#tabs-2">Budget</a></li>
	  </ul>
	  <div id="tabs-1">
	    Date: <input type="text" name="datepickerS" id="datepickerS" class="datePic"> &nbsp;~
		Date: <input type="text" name="datepickerF" id="datepickerF" class="datePic">
	  </div>
	  <div id="tabs-2">
	    <label for="amount">Budget : $</label>
			<input type="text" name="amount" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
			<div id="slider" style="width:500px;"></div>
	  </div>
	</div>
	<input id="interestregion" type="hidden" name="interestregion" value ="<%=request.getParameter("interestregion")%>">
	<input id="departregion" type="hidden" name="departregion" value = "<%=request.getParameter("departregion")%>">
	<input id="register-schedule" type="button" value="save" style="height:25px"/>
	</form>
</body>
</html>