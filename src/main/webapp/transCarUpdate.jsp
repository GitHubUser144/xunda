<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    修改运输车辆
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.0/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.0/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-easyui-1.3.0/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.3.0/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/DateFormat.js"></script>

</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>运输车辆管理</div>
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
                                        <p class="left_txt2">运输车辆管理</p>
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
                            <script type="text/javascript">
                                function check() {
                                    if (form1.sendTime.value == "") {
                                        alert("请输入发送时间");
                                        form1.sendTime.focus();
                                        return false;
                                    }
                                    if (form1.carFee.value == "") {
                                        alert("请输入运输费用");
                                        form1.carFee.focus();
                                        return false;
                                    }
                                    if (isNaN(form1.carFee.value)) {
                                        alert("运输费用含有非法字符");
                                        form1.carFee.focus();
                                        return false;
                                    }
                                    if (form1.sendCity.value == form1.receCity.value) {
                                        alert("发货城市和收货城市不能相同");
                                        form1.receCity.focus();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>
                            <form action="${pageContext.request.contextPath}/transCarUpdate?pn=${pn}" method="post"
                                  name="form1" onsubmit="return check();">
                                <input type="hidden" name="transid" value="${transCar.transid }"/>
                                <table align="center" border="1" cellpadding="2" cellspacing="1">
                                    <tr>
                                        <td align="right">运输车辆：</td>
                                        <td>
                                            <select name="carid" style="width:155px">
                                                <c:forEach items="${cars}" var="car">
                                                    <c:if test="${car.carid == transCar.carid}">
                                                        <option value="${car.carid }"
                                                                selected>${car.cardno }|${car.carname }</option>
                                                    </c:if>
                                                    <c:if test="${car.carid != transCar.carid}">
                                                        <option value="${car.carid }">${car.cardno }|${car.carname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">出发地：</td>
                                        <td>
                                            <select name="sendcity" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <c:if test="${area.areaid==transCar.sendcity}">
                                                        <option value="${area.areaid }"
                                                                selected>${area.areaname }</option>
                                                    </c:if>
                                                    <c:if test="${area.areaid != transCar.sendcity}">
                                                        <option value="${area.areaid }">${area.areaname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">目的地：</td>
                                        <td>
                                            <select name="rececity" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <c:if test="${area.areaid==transCar.rececity}">
                                                        <option value="${area.areaid }"
                                                                selected>${area.areaname }</option>
                                                    </c:if>
                                                    <c:if test="${area.areaid != transCar.rececity}">
                                                        <option value="${area.areaid }">${area.areaname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">司机姓名：</td>
                                        <td><input type="text" name="driver" value="${transCar.driver }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">司机电话：</td>
                                        <td><input type="text" name="drivertel" value="${transCar.drivertel }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">跟车负责人：</td>
                                        <td><input type="text" name="master" value="${transCar.master }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">负责人电话：</td>
                                        <td><input type="text" name="mastertel" value="${transCar.mastertel }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">运输工具：</td>
                                        <td>
                                            <select name="sendtypeid" style="width:155px">
                                                <c:forEach items="${sendtypes}" var="sendtype">
                                                    <c:if test="${sendtype.sendtypeid==transCar.sendtypeid}">
                                                        <option value="${sendtype.sendtypeid }"
                                                                selected>${sendtype.sendtypename }</option>
                                                    </c:if>
                                                    <c:if test="${sendtype.sendtypeid != transCar.sendtypeid}">
                                                        <option value="${sendtype.sendtypeid }">${sendtype.sendtypename }</option>
                                                    </c:if>
                                                </c:forEach>

                                            </select>
                                        </td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">发车时间：</td>
                                        <td><input type="text" name="sendtime" id="d_sr" cssClass="easyui-datebox"
                                                   value="${transCar.sendtime }"><font size="2"
                                                                                       color="red">格式:2008-8-8</font>
                                        </td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td align="right">车辆状态：</td>
                                        <td>${transCar.carstatus }</td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">运输费用：</td>
                                        <td><input type="text" name="carfee" value="${transCar.carfee }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">补充说明：</td>
                                        <td><input type="text" name="demo" size="50" value="${transCar.demo }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center"><input type="submit" value="  保 存 "></td>
                                    </tr>
                                </table>
                            </form>
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
