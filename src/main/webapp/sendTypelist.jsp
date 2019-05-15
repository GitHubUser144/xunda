<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    运输工具类别列表
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>运输工具类别列表</div>
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
                                        <p class="left_txt2">运输工具类别列表</p>
                                    </td>
                                    <td width="20%" align="right">
                                        <div align="center">
                                            <img src="images/ico_Form.gif" width="14" height="14"/>&nbsp;<a
                                                href='${pageContext.request.contextPath}/sendTypeAddPage'>新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
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

                            <table width="70%" border="0" align="left" cellpadding="2" cellspacing="1">
                                <tr>
                                    <td width="130" height="30" class="STYLE1" nowrap="nowrap"
                                        style="BORDER: #c1dad7 1px solid">
                                        <div align="center">运输工具编号</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">运输工具名称</div>
                                    </td>
                                    <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                        <div align="center">操作</div>
                                    </td>
                                </tr>
                                <c:forEach items="${send}" var="send">
                                    <tr>
                                        <td width="130" height="30" class="STYLE1" nowrap="nowrap"
                                            style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${send.sendtypeid }</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">${send.sendtypename}</div>
                                        </td>
                                        <td class="STYLE1" style="BORDER: #c1dad7 1px solid">
                                            <div align="center">
                                                <a href="${pageContext.request.contextPath}/sendTypeUpdatePage?sendtypeid=${send.sendtypeid}&pn=${pages.pageNum}">修改</a>&nbsp;&nbsp;
                                                <a href="${pageContext.request.contextPath}/sendTypeDelete?sendtypeid=${send.sendtypeid}&pn=${pages.pageNum}"
                                                   onclick="return confirm('删除确认')">删除</a>&nbsp;&nbsp;

                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/getSendType">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getSendType?pn=${pages.pageNum-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getSendType?pn=${pages.pageNum+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/getSendType?pn=${pages.pages}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            第${pages.pageNum }页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.pages }页&nbsp;&nbsp;&nbsp;&nbsp;
                            共${pages.total }种运输工具&nbsp;&nbsp;&nbsp;&nbsp;
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
