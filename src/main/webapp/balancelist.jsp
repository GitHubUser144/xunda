<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>客户收（付）款明细</title>
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
        <strong>位置：</strong>客户收（付）款明细
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
                                        <p class="left_txt2">客户收（付）款明细</p>
                                    </td>
                                    <td width="20%" align="right">
                                        <div align="center">
                                            <img src="images/ico_Form.gif" width="14" height="14"/>&nbsp;<a
                                                href='./BalanceServlet?action=init&customerid=${customerid }'>收/付款</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
                                        style="BORDER: #c1dad7 1px solid">客户名称
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">收(付)款类别
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">收(付)款金额
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">是否有效
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">收(付)款时间
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">操作用户
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">其他说明
                                    </td>
                                    <td align="center" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">操作
                                    </td>
                                </tr>
                                <c:forEach items="${bals}" var="bal">
                                    <tr>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.customer.customername }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.paidtype }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.facefee }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid"><font color="red">${bal.isvalid }</font>
                                        </td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.paidtime }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.users.username }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">${bal.demo }</td>
                                        <td class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid" align="center"><a
                                                href="${pageContext.request.contextPath}/invalidBalance?balanceid=${bal.balanceid}&pn=${pages.pageNum}&customerid=${bal.customer.customerid}"
                                                onclick="return confirm('作废确定');">作废</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><a
                                href="${pageContext.request.contextPath}/balanceDetailPage?customerid=${customerid }">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/balanceDetailPage?customerid=${customerid }&pn=${pages.pageNum - 1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/balanceDetailPage?customerid=${customerid }&pn=${pages.pageNum + 1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/balanceDetailPage?customerid=${customerid }&pn=${pages.total}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            第${pages.pageNum }页&nbsp;&nbsp;&nbsp;&nbsp; 共${pages.pages }页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.total }笔记录&nbsp;&nbsp;&nbsp;&nbsp;
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
