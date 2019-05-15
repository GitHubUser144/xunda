<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    修改汽车资料
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>修改汽车资料</div>
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
                                        <p class="left_txt2">修改汽车资料</p>
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
                                    if (form1.cardNo.value == "") {
                                        alert("请输入车牌号");
                                        form1.cardNo.focus();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>


                            <form action="${pageContext.request.contextPath}/carUpdate?pn=${pn}" method="post"
                                  name="form1" onsubmit="return check();">
                                <input type="hidden" name="carid" value="${car.carid }"/>
                                <table align="center" border="1" cellpadding="2" cellspacing="1">
                                    <tr>
                                        <td align="right">车牌号：</td>
                                        <td><input type="text" name="cardno" value="${car.cardno }"></td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">车主姓名：</td>
                                        <td><input type="text" name="carname" value="${car.carname }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">车辆型号：</td>
                                        <td><input type="text" name="model" value="${car.model }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">公司名称：</td>
                                        <td>
                                            <select name="customerid" style="width:155px">
                                                <c:forEach items="${custs}" var="cust">
                                                    <c:if test="${cust.customerid==car.customer.customerid}">
                                                        <option value="${cust.customerid }"
                                                                selected>${cust.customername }</option>
                                                    </c:if>
                                                    <c:if test="${cust.customerid!=car.customer.customerid}">
                                                        <option value="${cust.customerid }">${cust.customername }</option>
                                                    </c:if>
                                                </c:forEach>

                                            </select>
                                        </td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">车辆状态：</td>
                                        <td>
                                            <select name="status" style="width:155px">
                                                <c:if test="${car.status == '空闲中'}">
                                                    <option value="空闲中" selected>空闲中</option>
                                                    <option value="运货中" >运货中</option>
                                                </c:if>
                                                <c:if test="${car.status == '运货中'}">
                                                    <option value="运货中" selected>运货中</option>
                                                    <option value="空闲中">空闲中</option>
                                                </c:if>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">所属地区：</td>
                                        <td>
                                            <select name="areaid" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <c:if test="${area.areaid == car.area.areaid}">
                                                        <option value="${area.areaid }"
                                                                selected>${area.areaname }</option>
                                                    </c:if>
                                                    <c:if test="${area.areaid != car.area.areaid}">
                                                        <option value="${area.areaid }">${area.areaname }</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">联系人：</td>
                                        <td><input type="text" name="contact" value="${car.contact }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">联系电话：</td>
                                        <td><input type="text" name="mobile" value="${car.mobile }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">QQ号码：</td>
                                        <td><input type="text" name="qq" value="${car.qq }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">邮箱地址：</td>
                                        <td><input type="text" name="email" value="${car.email }"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">补充说明：</td>
                                        <td><input type="text" name="demo" size="50" value="${car.demo }"></td>
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
