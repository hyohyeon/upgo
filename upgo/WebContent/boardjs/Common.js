function scrollLink(obj, num){
	if(typeof(num)=='undefined') num=0;
	var position = $("#"+obj).offset();
	$('html, body').animate({scrollTop : position.top-parseInt(num)}, 500, 'swing');
}

/*
    처음으로
*/
function moveTop() {
    window.scrollTo(0, 0);
}


/*
    홈페이지에 즐겨찾기 추가 (IE만 가능함)
    --------------------------------------------
*/
function addFavorite(url, title) {
    if ($.browser.msie) {
        window.external.AddFavorite(url, title);
    }
    else {
        alert("인터넷 익스플로러에서만 지원하는 기능입니다.");
    }
} 


/*
    ---------------- Embed 추가 ----------------
    홈페이지에 삽입되는 Embed 객체관련 태그 출력

    tag
    f : 플래쉬
    m : 미디어플레이어

    objectID            : 객체아이디
    objectSrc           : 객체URL
    obejctWidth         : 가로크기 (픽셀단위)
    objectHeight        : 세로크기 (픽셀단위)
    --------------------------------------------
*/
function insertObj(tag, objectID, objectSrc, objectWidth, objectHeight) {
    switch (tag) {
        case "f":
            if ($.browser.msie) {
                document.write("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab#version=9,0,28,0\" id=\"" + objectID + "\" width=\"" + objectWidth + "\" height=\"" + objectHeight + "\">");
                document.write("<param name=\"allowScriptAccess\" value=\"always\">");
                document.write("<param name=\"wmode\" value=\"transparent\">");
                document.write("<param name=\"movie\" value=\"" + objectSrc + "\">");
                document.write("<param name=\"quality\" value=\"high\">");
                document.write("</object>");
            }
            else {
                if (!($.browser.safari && jQuery.browser.version == "528.18"))
                    document.write("<embed src=\"" + objectSrc + "\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"" + objectWidth + "\" height=\"" + objectHeight + "\" allowScriptAccess=\"always\" wmode=\"transparent\"></embed>");
            }
            break;
        case "m":
            if ($.browser.msie) {
                document.write("<object classid=\"clsid:22d6f312-b0f6-11d0-94ab-0080c74c7e95\" codebase=\"http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701\" id=\"" + objectID + "\" width=\"" + objectWidth + "\" height=\"" + objectHeight + "\" standby=\"Loading Microsoft Windows Media Player components...\" type=\"application/x-oleobject\">");
                document.write("<param name=\"AutoStart\" value=\"True\">");
                document.write("<param name=\"Filename\" value=\"" + objectSrc + "\">");
                document.write("<param name=\"AutoSize\" value=\"ture\">");
                document.write("<param name=\"ClickToPlay\" value=\"True\">");
                document.write("<param name=\"Volume\" value=\"-1\">");
                document.write("<param name=\"PlayCount\" value=\"1\">");
                document.write("<param name=\"DisplayMode\" value=\"0\">");
                document.write("<param name=\"DisplaySize\" value=\"0\">");
                document.write("<param name=\"Enabled\" value=\"True\">");
                document.write("<param name=\"EnableContextMenu\" value=\"False\">");
                document.write("<param name=\"EnablePositionControls\" value=\"False\">");
                document.write("<param name=\"EnableFullScreenControls\" value=\"False\">");
                document.write("<param name=\"EnableTracker\" value=\"True\">");
                document.write("<param name=\"ShowStatusBar\" value=\"True\">");
                document.write("<param name=\"ShowDisplay\" value=\"False\">");
                document.write("<param name=\"ShowCaptioning\" value=\"False\">");
                document.write("<param name=\"ShowControls\" value=\"True\">");
                document.write("<param name=\"ShowAudioControls\" value=\"True\">");
                document.write("<param name=\"ShowDisplay\" value=\"True\">");
                document.write("<param name=\"ShowGotoBar\" value=\"False\">");
                document.write("<param name=\"ShowPositionControls\" value=\"True\">");
                document.write("<param name=\"ShowTracker\" value=\"True\">");
                document.write("<param name=\"WindowlessVideo\" value=\"False\">");
                document.write("<param name=\"TransparentAtStart\" value=\"False\">");
                document.write("</object>");
            }
            else {
                if (!($.browser.safari && jQuery.browser.version == "528.18"))
                    document.write("<embed src=\"" + objectSrc + "\" quality=\"high\" pluginspage=\"http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701\" type=\"application/x-oleobject\" width=\"" + objectWidth + "\" height=\"" + objectHeight + "\"></embed>");
            }

            break;
    }
}


/*
    브라우저에 사용할 쿠키저장 및 저장된 쿠키 가져오기
    ---------------------------------------------------------
    set     : 쿠키저장
    name    : 쿠키명
    value   : 저장값
    expire  : 유효기간 (날짜형식)

    get     : 쿠키가져오기
    name    : 쿠키명
    ---------------------------------------------------------
*/
var cookie = {
    set: function(name, value, expire) {
        document.cookie = name + "=" + escape(value) + ((expire == null) ? "" : ("; expires=" + expire.toGMTString())) + "; path=/";
    },

    get: function(name) {
        var search = name + "=";

        if (document.cookie.length > 0) {
            //저장된 쿠키확인
            var offset = document.cookie.indexOf(search);

            if (offset != -1) {
                //찾는 쿠키명이 있을경우
                offset += search.length;
                var end = document.cookie.indexOf(";", offset); // 해당 쿠키의 처음과 끝의 범위를 설정
                if (end == -1) end = document.cookie.length;

                return unescape(document.cookie.substring(offset, end));
            }
        }
    }
}


/*
    ASP에서 Request.QueryString와 동일한 기능
    --------------------------------------------
*/
var Request = {
    // !!! 주석: 2010/01/06 박현중: MBCS(UTF-8, Unicode 등) 문자열에 오류가 있어 수정 함
    // !!! 오류 URL 예: http://localhost:8641/SampleCode/WebForm1.aspx?param1=value1&파람2=값2
    QueryString: function(paramName) {
        /// <summary>
        /// 현재 페이지의 QueryString을 리턴
        /// </summary>
        /// <param name="paramName" type="String">
        /// QueryString 이름
        /// </param>
        /// <returns type="String" />
        var returnValue = "";
        
        //var currentAddr = unescape(location.href);
        //var parameters = (currentAddr.slice(currentAddr.indexOf("?") + 1, currentAddr.length)).split("&");
        // 2010/01/06 박현중: 쿼리문자열에서 한글 파라미터 이름/값 분석에 오류가 있어 아래처럼 수정함
        var currentAddr = location.href;
        var parameters = (currentAddr.slice(currentAddr.indexOf("?") + 1, currentAddr.length)).split("&");
        
        var paramValue;

        for (var i = 0; i < parameters.length; i++) {
            paramValue = parameters[i].split("=")[0];

            if (paramValue.toUpperCase() == paramName.toUpperCase()) {
                //returnValue = parameters[i].split("=")[1];
                // 2010/01/06 박현중: 쿼리문자열에서 한글 파라미터 이름/값 분석에 오류가 있어 아래처럼 수정함
                // 또한 설정하는 곳에서는 반드시 UTF-8(UNICODE)를 위해서 encodeURIComponent 또는 UrlEncode를 사용해야 함
                returnValue = decodeURIComponent(parameters[i].split("=")[1]);
                break;
            }
        }

        return returnValue;
    }
};


/*
    팝업 중앙 위치
    ----------------
    팝업창을 화면 정중앙에 위치
        	
    docSrc			: 팝업에 표시되는 주소
    popName			: 팝업창 제어이름
    popWidth		: 가로크기
    popHeight		: 세로크기
    isScroll		: 스크롤여부 (1:사용, 0:사용안함)
    ----------------
*/
function openPopCenter(docSrc, popName, popWidth, popHeight, isScroll) {
    var popwindow = null;
    var LeftPosition = (screen.width) ? (screen.width - popWidth) / 2 : 0;
    var TopPosition = (screen.height) ? (screen.height - popHeight) / 2 : 0;
    var Settings = 'height=' + popHeight + ',width=' + popWidth + ',top=' + TopPosition + ',left=' + LeftPosition + ',scrollbars=' + isScroll + ',resizable=no';

    popwindow = window.open(docSrc, popName, Settings);
    return popwindow;
}


/*
    팝업 사용자지정위치
    ----------------------
    docSrc			: 팝업에 표시되는 주소
    popName			: 팝업창 제어이름
    popTop          : Top
    popLeft         : Left
    popWidth		: 가로크기
    popHeight		: 세로크기
    isScroll		: 스크롤여부 (1:사용, 0:사용안함)
    ----------------------
*/
function openPop(docSrc, popName, popTop, popLeft, popWidth, popHeight, isScroll) {
    var popwindow = null;
    var Settings = 'height=' + popHeight + ',width=' + popWidth + ',top=' + popTop + ',left=' + popLeft + ',scrollbars=' + isScroll + ',resizable=no';

    popwindow = window.open(docSrc, popName, Settings);
    return popwindow;
}



/*
    게시판 내용의 A 태그의 Target 값 추가 (새창 띄우기)
    ---------------------------------------------------------
*/
function setABlank(className) {
    if (!className) return false;
    if ($(className).length == 0) return false;

    var $items = $(className).find("a");

    for (var i = -1; ++i < $items.length; ) {
        $items.eq(i).attr("target", "_blank");
    }
}


/*
    특정문자열을 지정된 문자열로 변환
    --------------------------------------
    VBScript의 replace 내장함수와 동일
    --------------------------------------
*/
function replace(string, text, by) {
    if (!string) return false;

    var strLength = string.length, txtLength = text.length;

    if ((strLength == 0) || (txtLength == 0)) {
        return string;
    }

    var i = string.indexOf(text);

    if ((!i) && (text != string.substring(0, txtLength))) {
        return string;
    }

    if (i == -1) {
        return string;
    }

    var newstr = string.substring(0, i) + by;

    if (i + txtLength < strLength) {
        newstr += replace(string.substring(i + txtLength, strLength), text, by);
    }

    return newstr;
}


/* 
    string String::cut(int len)
    글자를 앞에서부터 원하는 바이트만큼 잘라 리턴합니다.
    한글의 경우 2바이트로 계산하며, 글자 중간에서 잘리지 않습니다.
*/
String.prototype.cut = function(len) {
    var str = this;
    var l = 0;
    for (var i = 0; i < str.length; i++) {
        l += (str.charCodeAt(i) > 128) ? 2 : 1;
        if (l > len) return str.substring(0, i) + "...";
    }
    return str;
}

/* 
    bool String::bytes(void)
    해당스트링의 바이트단위 길이를 리턴합니다. (기존의 length 속성은 2바이트 문자를 한글자로 간주합니다)
*/
String.prototype.bytes = function() {
    var str = this;
    var l = 0;
    for (var i = 0; i < str.length; i++) l += (str.charCodeAt(i) > 128) ? 2 : 1;
    return l;
}


/*
    바이트단위 문자수 계산
*/
function byteLen(aquery) {
    var tmpStr;
    var temp = 0;
    var onechar;
    var tcount;

    tcount = 0;
    tmpStr = new String(aquery);
    temp = tmpStr.length;

    for (k = 0; k < temp; k++) {
        onechar = tmpStr.charAt(k);

        if (escape(onechar).length > 4) {
            tcount += 2;
        }
        else if (onechar != '\r') {
            tcount++;
        }
    }

    return tcount;
}


/*
    TEXTAREA 최대 입력바이트 제한
    --------------------------------------------------------
    TEXTAREA에 입력된 값의 제한바이트를 체크
    만약 허용된 크기보다 작으면 true, 크면 false로 리턴
    --------------------------------------------------------
*/
function cal_byte(aquery, max_byte) {
    if (byteLen(aquery) < max_byte)
        return true;
    else
        return false;
}


/*
    브라우저별 투명효과 설정
    ---------------------------
*/
function setOpacity(el, opacity) {
    if (el.filters) {
        el.style.filter = "alpha(opacity=" + (opacity * 100) + ")";
    }
    else {
        el.style.opacity = opacity;
    }
}


/* 
    주민등록번호 유효성 검사
    ---------------------------
*/
function chkRegNo(RegNo) {
    var birthYear, birthMonth, birthDate, birth, buf;

    RegNo = replace(RegNo, "-", "");
    if (RegNo.length != 13) return false;

    // 날짜 유효성 검사		
    birthYear = (RegNo.charAt(6) <= "2") ? "19" : "20";
    birthYear += RegNo.substr(0, 2);
    birthMonth = RegNo.substr(2, 2);
    birthDate = RegNo.substr(4, 2);

    birth = new Date(birthYear, birthMonth, birthDate);

    if (!(birth.getFullYear() == birthYear || birth.getMonth() == birthMonth || birth.getDate() == birthDate))
        return false;

    // 각 자릿수에 buf배열로 숫자 입력
    buf = new Array(13);

    for (var i = 0; i < 13; i++)
        buf[i] = parseInt(RegNo.charAt(i));

    // 정해진 승수 배열 선언
    var multipliers = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5];

    // 각 자릿수에 지정된 승수를 곱한후 각 자리수를 덧셈
    for (i = 0, sum = 0; i < 12; i++)
        sum += (buf[i] *= multipliers[i]);

    // 최종 더한값에 11로 나눈후 마지막 자릿수와 일치여부 체크
    if ((11 - (sum % 11)) % 10 != buf[12])
        return false;
    else
        return true;
}


/*
    사업자등록번호 유효성 검사
    ------------------------------
*/
function chkBizNo(sBNo) {
    var nTotal = 0, nModValue, nBizChk;
    var nBizNo = new Array(9);
    var nChkValue = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5);
    var i, nTemp;

    sBNo = replace(sBNo, "-", "");
    sBNo = replace(sBNo, " ", "");

    // 사업자등록번호 총길이 검사 (10자)
    if (sBNo.length != 10)
        return false;

    // 숫자검사
    for (i = 0; i <= 9; i++) {
        nTemp = parseInt(sBNo.charAt(i));

        if (isNaN(nTemp))
            return false;

        nBizNo[i] = nTemp;
    }

    // 0부터 8번째까지는 체크값을 곱해서 총합에 더함
    for (var i = 0; i <= 8; i++) {
        nTotal += (nBizNo[i] * nChkValue[i]);
    }

    // 8번째는 따로 계산
    nTotal += Math.floor((nBizNo[8] * nChkValue[8]) / 10);

    // 총합에서 10으로 나눔 (정수형으로 변환)
    nModValue = Math.floor(nTotal % 10);

    // 나머지값이 0이 아니면 나머지에서 10으로 뺌
    if (nModValue == 0)
        nBizChk = 0;
    else
        nBizChk = 10 - nModValue;

    // 결과값과 마지막자리값 비교
    if (nBizChk == nBizNo[9])
        return true;
    else
        return false;
}


/*
    E-Mail 체크
    -----------------------------------
    입력값 이메일여부 확인 (정규식)
    -----------------------------------
*/
function isMail(cg) {
    emailEx1 = /[^@]+@[A-Za-z0-9_\-]+\.[A-Za-z]+/;
    emailEx2 = /[^@]+@[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z]+/;
    emailEx3 = /[^@]+@[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-]+\.[A-Za-z]+/;

    if (emailEx1.test(cg)) return true;
    if (emailEx2.test(cg)) return true;
    if (emailEx3.test(cg)) return true;

    return false;
}


/*
    날짜형식확인
    -----------------------------------
    입력값 유효한 날짜인지 확인
    -----------------------------------
*/
function isDate(s) {
    var tmp, checkString = new Array(3);
    var checkDate;

    if (!s) return false;
    tmp = s.split("-");

    if (tmp.length == 3) {
        for (var i = 0; i < checkString.length; i++) {
            tmp[i] = String(tmp[i]);

            if (tmp[i].length == 2) {
                if (tmp[i].substr(0, 1) == "0")
                    tmp[i] = tmp[i].substr(1);
            }

            checkString[i] = parseInt(String(tmp[i]));
            if (isNaN(checkString[i])) checkString[i] = 0;
        }

        checkDate = new Date(checkString[0], checkString[1] - 1, checkString[2]);

        if ((checkDate.getFullYear() == checkString[0] && (checkDate.getMonth() + 1) == checkString[1] && checkDate.getDate() == checkString[2]))
            return true;
        else
            return false;
    }
    else
        return false;
}


/*
    화폐형식으로 변경 및 초기화
    -------------------------------
*/
var currencyFormat = {
    //콤마표시 삭제
    clear: function(str) {
        if (str) return replace(str, ",", "");
    },

    //콤마값 표시
    set: function(numberText) {    
        if (!numberText) numberText = "0";
        if (isNaN(parseInt(numberText))) numberText = "0";

        var numberText = String(numberText);
        var numberLength = numberText.length;

        //3자리마다 콤마값 표시
        if (numberLength > 3) {
            var currencyText = "";
            var pos = 0;

            for (var i = numberLength; i > 0; i--) {
                currencyText = numberText.substr(i - 1, 1) + currencyText;
                pos++;

                if ((pos % 3 == 0) && (pos < numberLength))
                    currencyText = "," + currencyText;
            }
        }
        else
            currencyText = numberText;

        return currencyText;
    }
}

//숫자 허용 [ chkNum(폼이름, 엘리먼트 이름) ]
function chkNum(form, name) {
    var num = "0123456789";
    var ok = "yes";
    var temp;

    for (var i = 0; i < eval("document." + form + "." + name).value.length; i++) {
        temp = eval("document." + form + "." + name).value.substring(i, i + 1);
        if (num.indexOf(temp) == -1) ok = "no";
    }

    if (ok == "no") {
        alert("숫자만 입력하실 수 있습니다.");
        eval("document." + form + "." + name).value = "";
        eval("document." + form + "." + name).focus();
    }
}

function moveFocus(obj,num,nName){
	if(obj.value.length == num){
		document.getElementsByName(nName)[0].focus()
	}
}
function jsOnlyNumberKey() {
	if ( event != null) {
		if ( event.keyCode < 48 || event.keyCode > 57 ) {
			event.returnValue = false;
		}
	}
}


// 숫자만 입력가능하게
function OnlyNumber(){
	if ((event.keyCode<48) || (event.keyCode>57)) 
	{
		event.returnValue=false;
	}
	
}


function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
	var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
	if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

//대사관 휴무일 달력관련
try{
	document.execCommand("BackgroundImageCache",false,true);
}catch(err){}

//이미지주위에 점선없애기
function bluring(){ 
if(event.srcElement.tagName=="A"||event.srcElement.tagName=="IMG") document.body.focus(); 
} 
document.onfocusin=bluring; 


//LMV : 좌우측 이동값,TMV : 상하 이동값
function DP_OpenPicker(input,obj,LMV,TMV)
{

	if(LMV==""){LMV=0;}
	var top = document.body.clientTop + DP_GetObjectTop(input);
	var left = document.body.clientLeft + DP_GetObjectLeft(input);

	DP_PickerInput = input;

	var DPContainer = obj;

	if(!TMV){
		TMV = 0;
	}
	if(!LMV){
		LMV = 0;
	}

	
	eval("document.getElementById('"+DPContainer+"').style.pixelTop = top + TMV;");
	eval("document.getElementById('"+DPContainer+"').style.pixelLeft = left + LMV;");
	eval("document.getElementById('"+DPContainer+"').style.display='block';");
	
	/*
	DPContainer.style.pixelTop = top + TMV;
	DPContainer.style.pixelLeft = left + LMV;
	DPContainer.style.display = 'block';
	*/
	//DP_IFRAME.init(DP_ParseDate(DP_PickerInput.value));
}
function DP_GetObjectTop(obj)
{
	if (obj.offsetParent == document.body)
		return obj.offsetTop;
	else
		return obj.offsetTop + DP_GetObjectTop(obj.offsetParent);
}
function DP_GetObjectLeft(obj)
{
	if (obj.offsetParent == document.body)
		return obj.offsetLeft;
	else
		return obj.offsetLeft + DP_GetObjectLeft(obj.offsetParent);
}

//자바스크립트 문자열
function stringSplit(strData, strIndex){ 
 var stringList = new Array(); 
 while(strData.indexOf(strIndex) != -1){
  stringList[stringList.length] = strData.substring(0, strData.indexOf(strIndex)); 
  strData = strData.substring(strData.indexOf(strIndex)+(strIndex.length), strData.length); 
 } 
 stringList[stringList.length] = strData; 
 return stringList; 
}

//테스트 자리수 제한
function limitCharacters(textid, limit, limitid){
	var text = $('#'+textid).val();
	var textlength = text.length;
	
	if(textlength > limit){
		$('#' + limitid).html('요청사항을 '+limit+'자 까지만 쓸 수 있습니다!');
		$('#'+textid).val(text.substr(0,limit));
		return false;
	}else{
		$('#' + limitid).html('쓸수 있는 글자가 '+ (limit - textlength) +' 자 남았습니다.');
		return true;
	}
}	


//숫자 체크
//============================
function isValidNum(value) { 
  if ( value.search(/^[_0-9]+$/)==-1 ){
   return true;
  }else{
   return false;
  }
}

//영문 +숫자 체크
//============================
function isValidEngNum(value) { 
  if ( value.search(/^[_a-zA-Z0-9]+$/)==-1 ){
   return true;
  }else{
   return false;
  }
}

//메일 체크
//============================
function isValidMail(value) { 
  if ( value.search(/^[_a-zA-Z0-9-\.]+@[\.a-zA-Z0-9-]+\.[a-zA-Z]+$/)== -1 ){
   return true;
  }else{
   return false;
  }
}
//회원가입
//============================
var checkState = false;
function chk_join(){
  if (checkState)	{
    alert("자료를 전송중입니다. 잠시 기다려 주세요.");
      return ;
  }else{
    var frm = document.frmJoin;
    var site_cd = frm.site_cd;
    var site_nm = frm.site_nm;
	var mId = frm.mId;
    var mIdCk = frm.mIdCk;
    var mPass01 = frm.mPass01;
    var mPass02 = frm.mPass02;
	var mNm = frm.mNm;
	var mHand1 = frm.mHand1;
    var mHand2 = frm.mHand2;
    var mHand3 = frm.mHand3;
    var mMail = frm.mMail;

	if(site_cd.value=="" || site_nm.value==""){
      window.alert("거래처를 선택해 주세요.");
      return ;
	}

	if(mId.value.length<4||mId.value.length>20  || isValidEngNum(mId.value)){
      window.alert("아이디는 영문,숫자포함해서 4자 ~ 20자로 입력해야합니다.");
      mId.focus();
      return ;
	}
	if(mIdCk.value!="1"){
      window.alert("아이디 중복 체크를 하세요.");
      return ;
	}
	if(mPass01.value.length<4 || (mPass01.value.length>10) || isValidEngNum(mPass01.value)){
      window.alert("비밀번호는 영문,숫자포함해서 4자 ~ 10자로 입력해야합니다.");
      mPass01.focus();
      return ;
	}
	if(mPass02.value.length<1 ){
      window.alert("비밀번호 확인을 입력해주세요.");
      mPass02.focus();
      return ;
	}
	if(mPass01.value != mPass02.value ){
      window.alert("비밀번호가 일치하지않습니다.");
      mPass01.focus();
      return ;
	}
	if(mNm.value =="" ){
      window.alert("이름을 입력해주세요.");
      mNm.focus();
      return ;
	}

	if(mHand1.value.length < 2 ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand1.focus();
      return ;
	}
	if(mHand2.value.length < 3 || mHand2.value.length > 4 || isValidNum(mHand2.value) ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand2.focus();
      return ;
	}
	if(mHand3.value.length < 4 || mHand3.value.length > 4 || isValidNum(mHand3.value)  ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand3.focus();
      return ;
	}
	if(isValidMail(mMail.value)){
      window.alert("이메일 입력 형식이 잘못되었습니다.");
      mMail.focus();
      return;
	}else{
	  if (window.confirm("입력한 내용으로 저장을 합니다. 계속하려면 확인을 중지하려면 취소를 누르세요.")) {
	    checkState = true;
		frm.action="/Member/joinOk.asp"
		frm.target="hiddenFrm";
	    frm.submit();
	  }else{
		  return ;
	  }
	}
  }
}

// 아이디 중복체크
//============================
function idCheck(){
    var frm = document.frmJoin;
    var mId = frm.mId;
    var checkId = frm.checkId;
	if (mId.value==""){
      alert("아이디를 입력하세요   ");
      mId.focus()
		return;
    }
	checkId.value= mId.value;
	frm.action="/member/IdCheck.asp";
	frm.target="hiddenFrm";
	frm.submit();
}	

//리턴 처리
//============================
function returnCheck(msg, moveUrl, rState, w,h){
	if (msg.length>0 && msg!=""){
		alert(msg);
	}
	if (rState=="0"){
		checkState = false;
	}else if (rState=="1"){
		self.close();
	}else if (rState=="2"){
		location.href=moveUrl;
	}
}

//회원정보수정
//============================
function chk_Modify(){
  if (checkState)	{
    alert("자료를 전송중입니다. 잠시 기다려 주세요.");
      return ;
  }else{
    var frm = document.frmJoin;
    var mPass01 = frm.mPass01;
    var mPass02 = frm.mPass02;
	var mNm = frm.mNm;
	var mHand1 = frm.mHand1;
    var mHand2 = frm.mHand2;
    var mHand3 = frm.mHand3;
    var mMail = frm.mMail;

	if(mPass01.value.length>0){
		if(mPass01.value.length<4 || (mPass01.value.length>10) || isValidEngNum(mPass01.value)){
		  window.alert("비밀번호는 영문,숫자포함해서 4자 ~ 10자로 입력해야합니다.");
		  mPass01.focus();
		  return false ;
		}
		if(mPass02.value.length<1 ){
		  window.alert("비밀번호 확인을 입력해주세요.");
		  mPass02.focus();
		  return false;
		}
		if(mPass01.value != mPass02.value ){
		  window.alert("비밀번호가 일치하지않습니다.");
		  mPass01.focus();
		  return false;
		}
	}

	if(mNm.value =="" ){
      window.alert("이름을 입력해주세요.");
      mNm.focus();
      return false;
	}

	if(mHand1.value.length < 2 ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand1.focus();
      return false;
	}

	if(mHand2.value.length < 3 || mHand2.value.length > 4 || isValidNum(mHand2.value) ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand2.focus();
      return false;
	}

	if(mHand3.value.length < 4 || mHand3.value.length > 4 || isValidNum(mHand3.value)  ){
      window.alert("핸드폰번호 입력이 잘못되었습니다.");
      mHand3.focus();
      return false;
	}

	if(isValidMail(mMail.value)){
      window.alert("이메일 입력 형식이 잘못되었습니다.");
      mMail.focus();
      return false;
	}else{
	  if (window.confirm("입력한 내용으로 저장을 합니다. 계속하려면 확인을 중지하려면 취소를 누르세요.")) {
	    checkState = true;
		frm.action="/Mypage/MemModifyOk.asp"
		//frm.target="hiddenFrm";
	    frm.submit();
	  }else{
		  return false;
	  }
	}
  }
}

//팝업
//============================
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}


function DateDiffDay(sD, eD){
	var sdate = new Date(sD.substring(0,4),sD.substring(4,6),sD.substring(6,8));
	var edate = new Date(eD.substring(0,4),eD.substring(4,6),eD.substring(6,8));

	var sDate = sdate.getDate();	
	var count=-1;

	while(Date.parse(edate)>=Date.parse(sdate)){		
		count++;
		//if(sdate.getDate() == sDate){
		//	count++;
		//}		
		sdate.setDate(sdate.getDate()+1);
	}

	return count;	
}

//Date 객체를 2007-01-01 형식문자열로변환
function getDateStrFromDateObject(dateObject){
  var str = null;

  var month = dateObject.getMonth();
  var day = dateObject.getDate();

  if(month <  10)
					month = '0' + month;
  if(day < 10)
					day = '0' + day;

  str = dateObject.getFullYear() + '-' + month + '-' + day;
  return str;
}

function fncLPAD(num)
{
	if(num<10) return '0'+num;
	else return ''+num;
}

function post_goto(url, parm, target){
	var f = document.createElement('form');
	
	var objs, value;
	
	for(var key in parm){
		value = parm[key];
		objs = document.createElement('input');
		objs.setAttribute('type', 'hidden');
		objs.setAttribute('name', key);
		objs.setAttribute('value', value);
		f.appendChild(objs);
	}

	if(target)
		f.setAttribute('target', target);


	f.setAttribute('method', 'post');
	f.setAttribute('action', url);
	document.body.appendChild(f);
	f.submit();
}

function get_goto(url, parm, target){
	var f = document.createElement('form');
	
	var objs, value;
	
	for(var key in parm){
		value = parm[key];
		objs = document.createElement('input');
		objs.setAttribute('type', 'hidden');
		objs.setAttribute('name', key);
		objs.setAttribute('value', value);
		f.appendChild(objs);
	}

	if(target)
		f.setAttribute('target', target);


	f.setAttribute('method', 'get');
	f.setAttribute('action', url);
	document.body.appendChild(f);
	f.submit();
}

//숫자만 허용
function Number_chk()
{
	e = window.event;
	
	if((e.keyCode == 8) || (e.keyCode == 46)){
		e.returnValue=true;
	}else{
		if(((e.keyCode < 37)||(e.keyCode > 40)) && ((e.keyCode < 48)||(e.keyCode > 57)) && ((e.keyCode < 96)||(e.keyCode > 105))){
			e.returnValue=false;
		}else{
			e.returnValue=true;
		}		
	}
}

