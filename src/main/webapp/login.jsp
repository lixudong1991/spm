<%--
  Created by IntelliJ IDEA.
  User: Tomcat
  Date: 2017/9/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/css/log.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#submit").click(function(){
                $.ajax({
                    type:'post',
                    url:"/spm/log/login.action",
                    data:$("#loginform").serialize(),
                    cache:false,
                    success:function(data){
                        if(data.logsuccess) {
                            location.href = "/spm/index.jsp";
                            return true;
                        }else {
                            $("#errmess").text(data.logmessage);
                            return false;
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="c">
    <form id="loginform" method="post">
        <div class="c2">
            <div style="width: 300px;height: 30px">
                <p class="p" id="errmess"></p>
            </div>
            <div class="c1">
                <input type="text" name="username" value="请输入用户名" onfocus="this.value=''" class="c3"/>
            </div>
            <div class="c1">
                <input type="text" name="password" value="请输入密码" onfocus="this.type='password',this.value=''" class="c3"/><br/>
            </div>
            <div class="c1">
                <input type="button" id="submit" value="登录" style="width:180px;height:30px;"/>
            </div>
            <div class="c1">
                <a href="/spm/reg.jsp" style="float: left">注册</a><a href="" style="float: right">忘记密码</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
