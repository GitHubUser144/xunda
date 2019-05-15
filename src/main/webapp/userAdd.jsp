<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
    新增用户
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
    <script type="application/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="application/javascript">
        $(function(){
            $("#username").blur(function (){
                var username = $(this).val();
                $.ajax({
                    url: "userRepetition",
                    data:"username="+username,
                    success: function (result) {
                        if(username==""){
                            $("#username_title").html("用户名不能为空");
                        }else{
                            if(result.status == 0) {
                                $("#username_title").html(result.faile);
                            }else{
                                $("#username_title").html(result.ok);
                            }
                        }

                    }
                })
            })
        })
    </script>
</head>
<body>
<div id="maintitle">
    <div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>新增用户</div>
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
                                    <td width="45%">
                                        <p class="left_txt2">新增用户</p>
                                    </td>
                                    <td width="45%" align="right">
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
                                    if (form1.userid.value == "") {
                                        alert("请输入用户名");
                                        form1.userid.focus();
                                        return false;
                                    }
                                    if (form1.password.value == "") {
                                        alert("密码不能为空");
                                        form1.password.focus();
                                        return false;
                                    }
                                    if (form1.password.value != form1.cfgpwd.value) {
                                        alert("密码与确认密码不符");
                                        form1.cfgpwd.focus();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>


                            <form action="./userAdd" method="post" name="form1"
                                  onsubmit="return check();">
                                <table align="center" border="1" cellpadding="2" cellspacing="1">
                                    <tr>
                                        <td align="right">用户名称：</td>
                                        <td><input type="text" name="username" id="username"></td>
                                        <td><span id="username_title"></span></td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">登录密码：</td>
                                        <td><input type="password" name="password"></td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">确认密码：</td>
                                        <td><input type="password" name="cfgpwd"></td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">用户区域：</td>
                                        <td>
                                            <select name="areaid" style="width:155px">
                                                <c:forEach items="${areas}" var="area">
                                                    <option value="${area.areaid }">${area.areaname }</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><font size="2" color="red">*必填</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">部门名称：</td>
                                        <td><input type="text" name="depname"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">工作岗位：</td>
                                        <td><input type="text" name="degree"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">联系电话：</td>
                                        <td><input type="text" name="mobile"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">通讯地址：</td>
                                        <td><input type="text" name="addr"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">公司名称：</td>
                                        <td><input type="text" name="companyname"></td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td align="right">其他说明：</td>
                                        <td>
                                            <textarea rows="5" cols="80" name="demo">请在这里填写其他说明...</textarea>
                                        </td>
                                        <td><font size="2" color="red">&nbsp;</font></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center"><input type="submit" value="  注 册 "></td>
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
