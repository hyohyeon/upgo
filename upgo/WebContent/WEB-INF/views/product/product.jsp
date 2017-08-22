<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
       <center> <h1> Up &amp; Go </h1></center>
         <center> <h3>  Buy a New Thing &amp; Get More Happiness </h3></center>
   
   <!-- 체크박스 금액 누적-------------------------------->
   
   <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <script language="javascript">
   
   
   
  /* function test_checkbox()
   {
      var flag = false;
      var values = document.getElementByName("lang");
      var count=0;
      for(var i=0; i < values.length; i++ ){
        	count++;
         }
     }
    	if (count<1){
  	alert("상품을 선택해 주세요!")
    } else {
    	alert(count+" 개 선택하셨습니다")
    	flag= true;
    }
return flag;

}
    	*/
   function itemSum(frm)
   {
      var sum = 0;
      var count = frm.chkbox.length;
      for(var i=0; i < count; i++ ){
          if( frm.chkbox[i].checked == true ){
   	    sum += parseInt(frm.chkbox[i].value);
          }
      }
      frm.total_sum.value = sum;
   }
   
	</script>
   <!-- 체크박스로 체크한 값 불러오기-------------------------------->




 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
     <!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

   <link rel="Stylesheet" href="/upgo/styles/default.css" />
   <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	
	<script type = "text/javascript">
	$(function() { //jquery의 메인 function 
		$('#write').on('click', function(event) {
			location.href = 'write.action';
	});
});
	</script>

</head>
    
<body bgcolor="white" topmargin="50">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		
  <hr width='600' size='2' noshade>
  <center><h2>Product List</h2></center>
  <hr width='600' size='2' noshade>
  
  
<table width="75%" align="center" bgcolor="white">
	<tr> 
	<td align="center" bgcolor="white">

		<table width="50%" align="center" bgcolor="white" border="0">
		<tr bgcolor="white"> 
		<td align="center"><font color="black"></font></td>
		<td align="center"><font color="black"></font></td>
		<td align="center"><font color="black"></font></td>
		</tr>
		</table>
	</td>
	</tr>
	
	<script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    
    </script>
    
	
	<form name="form" method="POST" action="orderlist.jsp">
	
	<table align="center">
   	<tr>
     <td><a href = "/upgo/img/110v.png" target="blank" onclick='window.open("/upgo/img/110v.png", "window","width=800,height=600");'>
     <img src  = "/upgo/img/110v.png" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="10000">
      		<center><font color ="gray" size="4">
      		<p> 상품이름: 110v 변압기</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 10,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
     <td><a href = "/upgo/img/battery.jpg" target="blank" onclick='window.open("/upgo/img/battery.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/battery.jpg" width="400px" height="400px" border="0px" style= "opacity:1" 
     		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="20000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="20000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 휴대용 보조배터리</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 20,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
    <td><a href = "/upgo/img/drug.jpg" target="blank" onclick='window.open( "/upgo/img/drug.jpg", "window","width=800,height=600");'>
     <img src  =  "/upgo/img/drug.jpg" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="15000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="15000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 휴대용 비상약품</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 15,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
    </tr>
    
    <tr>
    <td><a href = "/upgo/img/earplug.jpg" target="blank" onclick='window.open("/upgo/img/earplug.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/earplug.jpg" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="1000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="1000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 비행기에서 꿀잠예약</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 1,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
     <td><a href = "/upgo/img/gochujang.jpg" target="blank" onclick='window.open("/upgo/img/gochujang.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/gochujang.jpg" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="1500" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="1500">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 해외에서 한국인 티내기</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 1,500</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
    <td><a href = "/upgo/img/handlight.jpg" target="blank" onclick='window.open("/upgo/img/handlight.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/handlight.jpg" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="15000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="15000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 어둠아 물러가랏</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 15,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
     </tr>
     
     <tr>
     <td><a href = "/upgo/img/locker.jpg" target="blank" onclick='window.open("/upgo/img/locker.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/locker.jpg" width="400px" height="400px" border="0px" style= "opacity:1"
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value ="13000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="13000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 내 물건은 없어지지 않아</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 13,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
     <td><a href = "/upgo/img/multiknife.jpg" target="blank" onclick='window.open("/upgo/img/multiknife.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/multiknife.jpg" width="400px" height="400px" border="0px" style= "opacity:1" 
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="30000" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="30000">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 이거하나면 정글가능</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 30,000</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      		 
   <td><a href = "/upgo/img/waterwear.jpg" target="blank" onclick='window.open("/upgo/img/waterwear.jpg", "window","width=800,height=600");'>
     <img src  = "/upgo/img/waterwear.jpg" width="400px" height="400px" border="0px" style= "opacity:1" 
      		onmouseover="this.style.opacity='0.5'" onmouseout="this.style.opacity='1'"/></a>
      		 <input type="checkbox" name="chkbox" value="1200" onClick="itemSum(this.form);"
      		 style= "width:40px; height:40px;" value="1200">
      		 <center><font color ="gray" size="4">
      		<p> 상품이름: 비가오나 눈이오나 뽀송</p>
      		<p> 등록날짜: 2015-05-15</p>
      		<p> 상품가격: 1,200</p>
      		<p> 상품설명: 여행의 필수템</p>
      		 </font></center></td>
      </tr>
      
      
      </table>
        
      <div style="height:120px" align="center"><H1>&nbsp;합계금액:&nbsp;<input style="height:100px" name="total_sum" type="text" size="4" readonly>원</H1></div>
      
       
      <div class="button" style="height:10px" align="center" >
		        	<a href="/upgo/product/orderlist.action">*결제창으로 가기*</a>
		        	&nbsp;&nbsp;
		        </div>
   </form>
       		 <hr width='600' size='2' noshade>
</body>
</html>
