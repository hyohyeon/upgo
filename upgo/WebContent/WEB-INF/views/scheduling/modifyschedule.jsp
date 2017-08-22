
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Table Style</title>
	<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
	<link rel="stylesheet" href="../css/modifyschedule.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
	 
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
		    
	    $('input#modify-schedule').on('click',function(){
	    	var datepickerS = $('#datepickerS').val();
	    	var datepickerF = $('#datepickerF').val();
	    	var amount = $('#amount').val();
	    	
	    	var e1 = document.getElementById("selectdepartregion");
	    	var departregion = e1.options[e1.selectedIndex].value;
	    	
	    	var e2 = document.getElementById("selectinterestregion");
	    	var interestregion = e2.options[e2.selectedIndex].value;
	    	
	    	$('#departregion').val(departregion);
	    	$('#interestregion').val(interestregion);
	    	
	    	
	    	if(!datepickerS){
	    		alert('please input start date');
	    		$('#datepickerS').focus();
	    		return;
	    	}else if(!datepickerF){
	    		alert('please input finish date');
	    		$('#datepickerF').focus();
	    		return;
	    	}
	    	
	    	$("#modifyscheduleform").submit();
	    });
    
  });
  </script>
</head>

 <% List<String> regions = (List<String>)request.getAttribute("regions"); %>
 <% List<String> fullnameregions = (List<String>)request.getAttribute("fullnameregions"); %>
<body>
	<div class="table-title">
		<h3>Schedule Option</h3>
	</div>
	<form id="modifyscheduleform" action="/upgo/scheduling/modifyschedule.action" method="post">
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Option</th>
				<th class="text-left">Value</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<tr>
				<td class="text-left">Depart Region</td>
				<td class="text-left">
				<select id="selectdepartregion">
				<% for(int i=0; i<regions.size(); i++){ %>
				<%String region = regions.get(i); %>
				<%String fullnameregion = fullnameregions.get(i); %>
				  <option value="<%=region%>"><%=fullnameregion%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td class="text-left">Interest Region</td>
				<td class="text-left">
				<select id="selectinterestregion">
				<% for(int i=0; i<regions.size(); i++){ %>
				<%String region = regions.get(i); %>
				<%String fullnameregion = fullnameregions.get(i); %>
				  <option value="<%=region%>"><%=fullnameregion%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td class="text-left">Depart Date</td>
				<td class="text-left"><div><input type="text" name="datepickerS" id="datepickerS" class="datePic"></div></td>
			</tr>
			<tr>
				<td class="text-left">Return Date</td>
				<td class="text-left"><div><input type="text" name="datepickerF" id="datepickerF" class="datePic"></div></td>
			</tr>
			<tr>
				<td class="text-left">Budget</td>
				<td class="text-left"><label for="amount">$ </label><input type="text" name="amount" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
				<div id="slider" style="width:500px"></div></td>
			</tr>
		</tbody>
	</table>
		<input id="departregion" type="hidden" name="departregion" value ="">
		<input id="interestregion" type="hidden" name="interestregion" value ="">
		<input id="sNo" type="hidden" name="sNo" value ="<%=request.getAttribute("sNo")%>">
		<input style="text-align:center"id="modify-schedule" type="button" value="Next" style="height:25px"/>
	</form>
</body>