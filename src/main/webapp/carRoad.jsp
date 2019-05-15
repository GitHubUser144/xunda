<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    途径路线明细
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>途径路线明细</div>
</div>
<div class="content-box role">
    <div class="content-box-content">
        <div class="tab-content default-tab" id="form">
            <div>
                <table style="width:100%;" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td style="BORDER-BOTTOM: #c1dad7 1px solid">
                            <table style="width:100%;height:55px;" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="10%" height="55" valign="middle"><img src="images/user-info.gif"/></td>
                                    <td width="70%">
                                        <p class="left_txt2">途径路线明细:<font
                                                color="red">车牌：${transcar.car.cardno },起点站：${sendCity}=====>终点站：${receCity}====发出时间：${transcar.sendtime }</font>
                                        </p>
                                    </td>
                                    <td width="20%" align="right">
                                        <div align="center">
                                            <img src="images/ico_Form.gif" width="14" height="14"/>&nbsp;<a
                                                href='javascript:self.location.reload();'>刷新</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <img src="images/002.gif" width="14" height="14"/><A
                                                href="javascript:self.history.back();">返回</A></div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <script language="javascript">
                                function check() {
                                    if (form1.startCity.value == form1.endCity.value) {
                                        alert("出发站和下一站不能相同");
                                        form1.areaname.focus();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>
                            <form action="${pageContext.request.contextPath}/carRoadAdd" method="post" name="form1" onsubmit="return check();">

                                <input type="hidden" name="transid" value="${road.transid }"/>
                                <table border="0" align="left" cellpadding="2" cellspacing="1">
                                    <tr>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div align="right">出发站：</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <select name="startcity" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <c:if test="${area.areaid == transcar.sendcity}">
                                                        <option value="${area.areaid }"
                                                                selected>${area.areaname }</option>
                                                    </c:if>
                                                    <c:if test="${area.areaid != transcar.sendcity}">
                                                        <option value="${area.areaid }">${area.areaname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div align="right">出发时间：</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input type="text" name="starttime" value="">
                                        </td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div align="right">下一站：</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <select name="endcity" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <c:if test="${area.areaid==transcar.rececity}">
                                                        <option value="${area.areaid }"
                                                                selected>${area.areaname }</option>
                                                    </c:if>
                                                    <c:if test="${area.areaid != transcar.rececity}">
                                                        <option value="${area.areaid }">${area.areaname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>

                                        </td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div align="right">到达时间：</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input type="text" name="endtime" value="">
                                        </td>
                                        <td><input type="submit" value=" 保 存 "></td>
                                    </tr>
                                    <tr>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid" colspan="9"
                                            align="center"><h3>途&nbsp;&nbsp;径&nbsp;&nbsp;路&nbsp;&nbsp;线&nbsp;&nbsp;明&nbsp;&nbsp;细</h3>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table border="0" align="left" cellpadding="2" cellspacing="1">
                                <tr>
                                    <td height="30" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">出发站</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">出发时间</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">下一站</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">到达时间</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">操作</div>
                                    </td>
                                </tr>
                                <%if (request.getAttribute("roads") != null) { %>
                                <c:forEach items="${roads}" var="roads" varStatus="status">
                                    <tr>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${startcitys[status.index].areaname }</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${roads.starttime}</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${endcitys[status.index].areaname}</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${roads.endtime}</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">
                                                <a href="./CarRoadServlet?action=update&roadid=${roads.roadid }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="./CarRoadServlet?action=del&roadid=${roads.roadid}"
                                                   onclick="return confirm('删除确认')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <%} %>
                            </table>

                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
