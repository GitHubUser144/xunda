<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%@page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>客户账目往来明细</title>
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
        <strong>位置：</strong>客户账目往来明细
    </div>
</div>
<div class="content-box role">
    <div class="content-box-content">
        <div class="tab-content default-tab" id="form">
            <div>
                <table style="width: 100%;" border="0" cellpadding="0"
                       cellspacing="0">

                    <tr>
                        <td colspan="2">
                            <form
                                    action="${pageContext.request.contextPath}/getBalanceRepQuery"
                                    method="post" name="form1">
                                <table border="0" align="left" cellpadding="2" cellspacing="1">
                                    <tr>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div
                                                    align="right">客户名称：
                                            </div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input
                                                type="text" name="customername"></td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div
                                                    align="right">收付款类别：
                                            </div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <select name="paidtype" style="width: 100px">
                                                <option value="">-----不选-----</option>
                                                <option value="收款">收款</option>
                                                <option value="付款">付款</option>
                                            </select>
                                        </td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div
                                                    align="right">状态：
                                            </div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <select name="isvalid" style="width: 100px">
                                                <option value="有效" selected>有效单据</option>
                                                <option value="作废">作废单据</option>
                                            </select>
                                        </td>
                                        <td height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <div
                                                    align="right">付款时间：
                                            </div>
                                        </td>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
                                            <%
                                                Calendar cal = Calendar.getInstance();//获取当前时间
                                                int maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                                                int nyear = cal.get(Calendar.YEAR) - 1900;
                                                int nmonth = cal.get(Calendar.MONTH);

                                                String strmin = nyear + "-" + nmonth + "-01";
                                                String strmax = nyear + "-" + nmonth + "-" + maxday;
                                                Date date1 = new Date(nyear, nmonth, 1);
                                                Date date2 = new Date(nyear, nmonth, maxday);
                                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                                strmin = sdf.format(date1);
                                                strmax = sdf.format(date2);
                                            %> <input type="text" name="paidtime1" size="10"
                                                      value="<%=strmin%>"/>到 <input type="text" name="paidtime2"
                                                                                    size="10" value="<%=strmax%>"/>
                                        </td>
                                        <td><input type="submit" value=" 搜 索 "></td>
                                    </tr>
                                    <tr>
                                        <td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
                                            colspan="9" align="center"><h3>客&nbsp;&nbsp;户&nbsp;&nbsp;收&nbsp;&nbsp;（付）&nbsp;&nbsp;款&nbsp;&nbsp;明&nbsp;&nbsp;细</h3>
                                        </td>
                                    </tr>
                                </table>
                            </form>
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
                                </tr>
                                <c:forEach items="${pages.list}" var="bal">
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
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><a
                                href="${pageContext.request.contextPath}/getBalanceRep">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getBalanceRep?pn=${pages.pageNum - 1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getBalanceRep?pn=${pages.pageNum + 1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a
                                    href="${pageContext.request.contextPath}/getBalanceRep?pn=${pages.pages}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
