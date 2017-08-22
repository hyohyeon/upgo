<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Region Choice</title>
    <style type="text/css">
    h1 {
    text-align:center;
    font-size: 40px;
    line-height: 30px;
    margin: 10px 0 10px 0;
    text-shadow: 1px 1px 5px #789;
	}
	.light-blue { color: #c9112d; }
    </style>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.maphilight.min.js"></script>
    <script type="text/javascript">
        $(function() {
        	
            $('.map').maphilight();
                                    
            $('.region').on('click',function(event){
            	var interestregion = this.getAttribute("title");
                $('#interestregion').val(interestregion);
                $("#ir").submit();
            });
            
        });
    </script>
</head>
<body>
 
<% Member member = (Member)session.getAttribute("loginuser"); %>
<% String departregion = request.getParameter("departregion"); %>
<h1 class="light-blue">Hi, <%= member.getMemberId() %>!! Just, Pick Where You Want to Go!!</h1>
	<img class="map" src="../img/usamapword.jpg" width="2000" height="1400" usemap="#usa">
	<map name="usa">
    <area class="region" shape="poly" alt="" title="WA" coords="283,105,452,159,424,275,360,259,332,264,308,259,279,243,258,221,231,211,242,126,267,129" href="#" target="" />
    <area class="region" shape="poly" alt="" title="OR" coords="228,217,256,222,278,250,314,265,364,262,429,277,437,298,434,304,405,343,410,358,397,370,387,422,168,352,177,322" href="#" target="" />
    <area class="region" shape="poly" alt="" title="CA" coords="155,415,180,358,303,401,273,505,287,540,320,593,397,731,374,767,377,791,357,807,291,799,255,732,199,695,175,618,160,482,163,448" href="#" target="" />
    <area class="region" shape="poly" alt="" title="ID" coords="456,161,440,235,428,276,436,276,437,290,440,309,418,333,407,367,399,422,551,458,574,366,566,358,535,366,513,351,506,324,490,307,498,280,472,240,467,196,480,167" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NV" coords="460,479,466,447,305,404,278,503,389,699,402,666,416,669,433,586" href="#" target="" />
    <area class="region" shape="poly" alt="" title="UT" coords="552,468,473,447,434,631,585,660,595,583,605,517,546,502" href="#" target="" />
    <area class="region" shape="poly" alt="" title="AZ" coords="580,668,431,639,424,659,420,671,407,674,392,706,409,740,391,752,380,773,381,791,377,799,365,808,431,858,479,888,502,893,548,897,555,842" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MT" coords="782,227,769,375,574,346,563,357,535,355,498,307,508,273,477,227,478,195,485,171,582,192" href="#" target="" />
    <area class="region" shape="poly" alt="" title="WY" coords="768,385,749,524,559,494,566,434,582,356" href="#" target="" />
    <area class="region" shape="poly" alt="" title="CO" coords="806,542,796,684,590,670,613,514,679,524" href="#" target="" />
    <area class="region" shape="poly" alt="" title="ND" coords="789,225,964,236,972,297,973,322,980,346,971,350,846,343,780,343" href="#" target="" />
    <area class="region" shape="poly" alt="" title="SD" coords="980,359,975,377,981,396,983,442,977,464,976,479,933,471,931,465,906,461,768,453,778,350" href="#" target="" />
    <area class="region" shape="poly" alt="" title="KS" coords="1018,592,1002,582,810,581,807,632,807,691,1029,698,1033,659,1028,622" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NE" coords="1003,578,818,575,819,533,780,529,764,526,768,463,925,470,941,478,972,483,981,503,990,519" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NM" coords="767,694,591,681,558,896,588,902,630,887,644,879,758,886" href="#" target="" />
    <area class="region" shape="poly" alt="" title="OK" coords="776,692,879,702,1035,706,1029,728,1039,756,1035,821,1026,825,988,818,927,822,858,791,859,759,861,722,768,712" href="#" target="" />
    <area class="region" shape="poly" alt="" title="TX" coords="937,1156,867,1122,852,1073,828,1054,814,1005,766,983,762,997,716,1012,687,972,639,888,764,895,773,720,855,725,849,789,929,832,992,823,1042,838,1051,868,1044,896,1064,937,1048,998,1014,1008,1012,1035,961,1059,937,1103,945,1147" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MN" coords="1167,251,980,234,972,247,982,310,985,347,985,385,991,451,1120,447,1119,431,1092,406,1098,381,1098,357,1112,328,1110,321,1134,294,1153,279,1170,263" href="#" target="" />
    <area class="region" shape="poly" alt="" title="IA" coords="1122,456,1014,460,986,456,983,488,996,513,999,539,1004,560,1089,554,1139,555,1145,533,1158,501,1147,486" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MO" coords="1134,564,1063,561,1030,564,1009,563,1009,577,1031,588,1030,605,1045,645,1040,708,1043,712,1085,716,1099,717,1133,719,1158,720,1185,721,1189,745,1197,741,1211,703,1198,693,1195,674,1172,656,1171,628,1147,612,1135,595" href="#" target="" />
    <area class="region" shape="poly" alt="" title="AR" coords="1196,756,1181,747,1181,724,1038,718,1047,751,1049,789,1041,832,1055,845,1056,864,1161,860,1166,844,1164,826,1177,806,1187,783,1190,767" href="#" target="" />
    <area class="region" shape="poly" alt="" title="LA" coords="1235,1028,1167,1036,1058,996,1072,938,1049,897,1057,868,1158,866,1165,891,1161,908,1145,918,1137,940,1145,946,1197,948,1201,963,1226,982" href="#" target="" />
    <area class="region" shape="poly" alt="" title="WI" coords="1246,367,1233,432,1244,471,1154,480,1133,457,1125,432,1115,416,1100,407,1106,389,1103,364,1115,344,1117,323,1133,306,1150,310,1145,336,1159,324,1164,340,1173,331,1187,331,1212,335,1221,344,1231,360" href="#" target="" />
    <area class="region" shape="poly" alt="" title="IL" coords="1242,480,1160,486,1163,511,1150,532,1152,546,1142,576,1146,596,1169,616,1177,616,1182,654,1196,656,1210,692,1214,693,1234,685,1242,672,1248,647,1256,625,1250,599,1252,560,1250,532,1251,512" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MI" coords="1236,268,1220,272,1188,299,1157,308,1165,321,1182,325,1210,320,1238,356,1269,340,1324,323,1292,364,1281,400,1285,434,1293,494,1389,482,1413,448,1414,411,1379,351,1349,295" href="#" target="" />
    <area class="region" shape="poly" alt="" title="IN" coords="1349,496,1293,498,1260,513,1258,567,1265,628,1256,645,1250,672,1277,666,1297,654,1310,654,1326,635,1353,624,1349,563" href="#" target="" />
    <area class="region" shape="poly" alt="" title="KY" coords="1447,612,1421,617,1405,627,1387,622,1373,610,1362,610,1358,624,1353,635,1334,638,1321,654,1298,665,1289,668,1272,677,1250,676,1234,692,1219,698,1211,724,1225,724,1257,722,1272,715,1295,717,1345,712,1422,708,1433,701,1442,683,1453,673,1463,656,1453,645,1448,645" href="#" target="" />
    <area class="region" shape="poly" alt="" title="TN" coords="1402,779,1359,781,1325,779,1248,783,1198,783,1207,730,1239,732,1279,723,1333,722,1417,716,1485,708,1484,720,1465,732,1450,734,1445,744,1429,750,1421,754,1417,756" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MS" coords="1260,791,1253,863,1252,898,1256,946,1266,976,1262,978,1237,976,1207,959,1204,944,1153,940,1146,932,1169,908,1171,888,1164,869,1174,847,1171,829,1179,813,1195,788,1221,789" href="#" target="" />
    <area class="region" shape="poly" alt="" title="AL" coords="1272,789,1356,784,1367,817,1382,860,1385,880,1386,894,1379,919,1385,944,1291,944,1308,978,1293,984,1274,976,1267,947,1265,898,1265,851,1265,832" href="#" target="" />
    <area class="region" shape="poly" alt="" title="FL" coords="1523,948,1502,960,1491,960,1480,952,1439,955,1387,952,1303,951,1312,966,1314,977,1350,983,1368,983,1388,999,1422,998,1436,988,1454,991,1456,1017,1475,1039,1472,1064,1479,1085,1509,1128,1511,1144,1540,1188,1571,1173,1571,1144,1583,1141,1584,1126,1584,1107,1567,1075,1559,1040,1561,1030,1531,986,1531,988" href="#" target="" />
    <area class="region" shape="poly" alt="" title="GA" coords="1545,893,1547,912,1535,925,1528,944,1509,948,1496,955,1483,948,1465,944,1447,947,1395,943,1387,913,1396,896,1394,872,1387,857,1384,841,1365,786,1449,782,1441,800,1459,798,1466,805,1467,812,1495,832,1503,844,1515,850,1521,860,1526,882" href="#" target="" />
    <area class="region" shape="poly" alt="" title="SC" coords="1615,809,1591,852,1579,862,1544,888,1533,880,1532,858,1516,842,1507,836,1497,822,1476,810,1471,794,1451,789,1466,764,1523,763,1531,778,1580,774,1595,790" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NC" coords="1728,732,1698,755,1684,776,1652,780,1643,804,1619,807,1617,800,1602,785,1578,766,1536,774,1528,757,1501,756,1464,761,1449,776,1411,779,1425,760,1471,736,1490,720,1494,708,1575,701,1611,694,1648,684,1674,680,1699,675,1713,698,1723,709" href="#" target="" />
    <area class="region" shape="poly" alt="" title="VA" coords="1702,667,1660,675,1628,683,1519,698,1437,708,1439,696,1458,680,1469,662,1480,666,1505,667,1527,654,1535,631,1553,615,1570,616,1603,568,1623,569,1654,581,1666,605,1685,624" href="#" target="" />
    <area class="region" shape="poly" alt="" title="OH" coords="1485,466,1491,492,1495,516,1481,530,1485,548,1476,577,1475,586,1447,603,1427,608,1403,617,1391,608,1360,598,1355,496,1404,492,1435,498" href="#" target="" />
    <area class="region" shape="poly" alt="" title="WV" coords="1615,556,1601,548,1580,554,1562,561,1552,571,1543,548,1517,553,1499,546,1503,536,1498,526,1489,535,1492,561,1480,587,1464,602,1452,606,1452,632,1469,652,1481,656,1504,659,1518,652,1525,637,1547,611,1571,599,1579,586,1583,575,1594,564" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MD" coords="1716,590,1703,631,1692,626,1694,607,1693,596,1667,575,1627,561,1614,548,1603,544,1589,545,1576,551,1554,560,1547,542,1605,529,1634,524,1666,516,1684,577,1701,573,1709,586" href="#" target="" />
    <area class="region" shape="poly" alt="" title="DE" coords="1680,508,1704,568,1686,572,1667,512,1669,511" href="#" target="" />
    <area class="region" shape="poly" alt="" title="PA" coords="1649,416,1519,447,1503,445,1487,464,1498,505,1510,544,1534,540,1553,535,1656,510,1679,502,1678,488,1668,471,1676,437" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NJ" coords="1721,448,1729,526,1713,551,1704,544,1702,535,1697,529,1689,524,1682,509,1687,492,1677,469,1675,457,1680,439" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NY" coords="1663,265,1621,274,1613,282,1597,332,1596,357,1532,385,1511,399,1519,418,1508,435,1512,443,1537,435,1561,429,1628,410,1638,406,1659,406,1677,426,1696,437,1704,441,1715,439,1725,448,1744,446,1771,425,1755,425,1729,442,1725,445,1715,435,1701,386,1697,363,1690,336,1675,321,1675,316,1675,286,1668,269" href="#" target="" />
    <area class="region" shape="poly" alt="" title="VT" coords="1706,250,1669,262,1679,280,1680,316,1694,329,1697,332,1702,355,1727,351,1722,329,1719,317,1715,308,1717,298,1720,285,1716,271,1714,260" href="vermont" target="" />
    <area class="region" shape="poly" alt="" title="CT" coords="1770,411,1748,417,1721,438,1714,418,1711,394,1762,378,1765,394" href="#" target="" />
    <area class="region" shape="poly" alt="" title="RI" coords="1802,393,1779,376,1774,373,1767,376,1773,412,1787,413,1788,409" href="#" target="" />
    <area class="region" shape="poly" alt="" title="MA" coords="1831,355,1833,374,1830,383,1813,391,1806,391,1794,384,1785,375,1776,370,1769,370,1757,376,1709,391,1704,362,1738,354,1761,346,1782,324,1798,334,1788,351,1800,358,1809,374,1816,374,1822,370,1823,364,1817,359" href="#" target="" />
    <area class="region" shape="poly" alt="" title="NH" coords="1783,320,1772,326,1760,339,1752,344,1730,351,1726,330,1721,308,1718,299,1722,286,1723,277,1723,266,1716,255,1709,247,1725,220,1735,242,1741,260,1754,284,1761,298,1763,303,1778,304" href="#" target="" />
    <area class="region" shape="poly" alt="" title="ME" coords="1791,88,1798,116,1814,143,1821,150,1834,154,1838,166,1858,176,1858,189,1845,218,1830,228,1822,240,1807,246,1802,274,1783,263,1776,268,1784,288,1777,300,1764,296,1761,280,1730,218,1740,198,1740,187,1741,174,1726,147,1735,95,1762,83" href="#" target="" />
    <area class="region" shape="circle" alt="" title="AK" coords="253,1013,145" href="#" target="" />
    <area class="region" shape="circle" alt="" title="HI" coords="551,1147,131" href="#" target="" />
    
	</map>  
  
<form id="ir" action="/upgo/scheduling/regionchoiceto.action" method="post">
<input id="interestregion" type="hidden" name="interestregion" value = "">
<input id="departregion" type="hidden" name="departregion" value = "<%=departregion%>">
<input type="hidden" value="<%= member.getMemberId() %>" id="customer" name="customer">
</form>
</body>
</html>