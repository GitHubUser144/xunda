<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>订单查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css"
          media="screen"/>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip">
        <strong>位置：</strong>订单查询
    </div>
</div>
<div class="content-box role">
    <div class="content-box-content">
        <div class="tab-content default-tab" id="form">
            <div>
                <table style="width: 100%;" border="0" cellpadding="0"
                       cellspacing="0">
                    <tr>
                        <td style="BORDER-BOTTOM: #c1dad7 1px solid">
                            <table style="width: 100%; height: 55px;" border="0"
                                   cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="10%" height="55" valign="middle"><img
                                            src="images/user-info.gif"/></td>
                                    <td width="70%">
                                        <p class="left_txt2">订单查询</p>
                                    </td>
                                    <td width="20%" align="right">
                                        <div align="center">
                                            <img src="images/ico_Form.gif" width="14" height="14"/>&nbsp;<a
                                                href='javascript:self.location.reload();'>刷新</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <img src="images/002.gif" width="14" height="14"/><A
                                                href="javascript:self.history.back();">返回</A>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">

                            <table align="center" width="800" cellpadding="3"
                                   cellspacing="1" border="1">
                                <tr>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">订单号
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">托运日期
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">车牌号
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">发货单位
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">收货单位
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">货物名称
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">包装
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">件数
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">运输费
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">保险费
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">其他费
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">出发地
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">目的地
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">是否发货
                                    </td>
                                </tr>
                                <c:forEach items="${carDetail}" var="car" varStatus="status">
                                    <tr>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.detailid }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.sendtime }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.car.cardno }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${sendCust[status.index].customername }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${receCust[status.index].customername }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.goodsname}</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.unitname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.gcount }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.sendfee }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.insurancefee }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.otherfee }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${sendcitys[status.index].areaname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${rececitys[status.index].areaname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${car.orderid }</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><a
                                href="${pageContext.request.contextPath}/getCarDetailRep?cardetail=${cardetail}">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getCarDetailRep?pn=${pages.pageNum - 1}&cardetail=${cardetail}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getCarDetailRep?pn=${pages.pageNum + 1}&cardetail=${cardetail}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getCarDetailRep?pn=${pages.total}&cardetail=${cardetail}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            第${pages.pageNum }页&nbsp;&nbsp;&nbsp;&nbsp; 共${pages.pages }页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.total }笔订单&nbsp;&nbsp;&nbsp;&nbsp;
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
