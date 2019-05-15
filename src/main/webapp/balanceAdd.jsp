<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>收/付款开单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css"
          media="screen"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="application/javascript">
        $(function () {
            $("#paidType").change(function () {
                var p = $(this).val();
                if(p=="付款"){
                    var paidmoney = ${cust.paidmoney};
                    $("#faceFee").val(paidmoney);
                }else{
                    var paidmoney = ${cust.factmoney};
                    $("#faceFee").val(paidmoney);
                }
            })
        })
    </script>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip">
        <strong>位置：</strong>收/付款开单
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
                                        <p class="left_txt2">收/付款开单</p>
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
                            <script type="text/javascript">
                                function check() {
                                    if (form1.faceFee.value == "") {
                                        alert("请输入收/付款金额");
                                        form1.faceFee.focus();
                                        return false;
                                    }
                                    if (isNaN(form1.faceFee.value)) {
                                        alert("收/付款金额含有非法字符");
                                        form1.faceFee.focus();
                                        return false;
                                    }
                                    if (parseInt(form1.faceFee.value) <= 0) {
                                        alert("收付款金额必须大于0");
                                        form1.faceFee.focus();
                                        return false;
                                    }
                                    if (form1.paidtime.value == "") {
                                        alert("请输入收/付款时间，格式如：2014-08-08");
                                        form1.paidtime.focus();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>
                            <form action="${pageContext.request.contextPath}/balanceAdd"
                                  method="post" name="form1" onsubmit="return check();">
                                <table align="center" border="1" cellpadding="2"
                                       cellspacing="1">
                                    <input type="hidden" name="customerid"
                                           value="${cust.customerid }"/>
                                    <tr>
                                        <td align="right">客户名称：</td>
                                        <td><font size="2"
                                                  color="red">${cust.customername }&nbsp;&nbsp;&nbsp;&nbsp;联系人：${cust.contactname}&nbsp;&nbsp;&nbsp;&nbsp;电话：${cust.phone}&nbsp;&nbsp;&nbsp;&nbsp;应收金额：${cust.factmoney }&nbsp;&nbsp;&nbsp;&nbsp;应付金额${cust.paidmoney}</font>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">类别：</td>
                                        <td><select name="paidtype" style="width: 155px" id="paidType">
                                            <option value="收款">收款</option>
                                            <option value="付款">付款</option>
                                        </select></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">收付款金额：</td>
                                        <td><input type="text" name="facefee"
                                                   value="${cust.factmoney }" readonly="readonly" id="faceFee"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">收付款时间：</td>
                                        <%
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                            String sdate = dateFormat.format(new Date());
                                        %>
                                        <td><input type="text" name="paidtime"
                                                   value="<%=sdate%>"><font size="2" color="red">格式：2014-03-10</font>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">补充说明：</td>
                                        <td><input type="text" name="demo" size="50"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center"><input type="submit"
                                                                              value="  收（付）款 "></td>
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
