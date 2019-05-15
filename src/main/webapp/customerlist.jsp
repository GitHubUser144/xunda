<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    客户资料列表
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>客户资料列表</div>
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
                                        <p class="left_txt2">客户资料列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font
                                                color="red">${delErrror }</font></p>
                                    </td>
                                    <td width="20%" align="right">
                                        <div align="center">
                                            <img src="images/ico_Form.gif" width="14" height="14"/>&nbsp;<a
                                                href='addCustomerPage'>新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
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

                            <table align="center" width="800" cellpadding="3" cellspacing="1" border="1">
                                <tr>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        客户名称
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        联系人
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        联系电话
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        结算方式
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        所在区域
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        客户类型
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        应收金额
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        应付金额
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid">
                                        操作
                                    </td>
                                </tr>
                                <c:forEach items="${customerList}" var="cust">
                                    <tr>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.customername }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.contactname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.phone }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.paidtype.paidname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.area.areaname }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.customertype.customertypename }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.factmoney }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${cust.paidmoney }</td>
                                        <td class="STYLE1" nowrap="nowrap" style="BORDER: #c1dad7 1px solid"
                                            align="center">
                                            <a href="${pageContext.request.contextPath}/balanceAddPage?customerid=${cust.customerid }">收/付款</a>&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/balanceDetailPage?customerid=${cust.customerid }">收付款明细</a>&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/getCarDetail?customerid=${cust.customerid }">订单明细</a>&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/customerUpdatePage?customerid=${cust.customerid }&pn=${pages.pageNum}">修改</a>&nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath}/customerDelete?customerid=${cust.customerid}"
                                               onclick="return confirm('删除确认')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/getCustomer">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getCustomer?pn=${pages.pageNum-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getCustomer?pn=${pages.pageNum+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getCustomer?pn=${pages.pages}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            第${pages.pageNum}页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.pages}页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.total}家客户&nbsp;&nbsp;&nbsp;&nbsp;
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
