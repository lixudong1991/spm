<%--
  Created by IntelliJ IDEA.
  User: Tomcat
  Date: 2017/9/26
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/css/log.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/auth.js"></script>
</head>
<body>
<div class="c">
    <form id="regform" method="post">
        <div class="c2">
            <div class="c1">
               <input id="name" type="text" name="username" class="c3"
                       maxlength="20"/>
            </div>
            <div style="width: 300px;height:18px">
            </div>
            <div class="c1">
              <input type="password" name="password"
                       class="c3" maxlength="20"/><br/>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c1">
                <input type="submit" id="submit" value="注册" style="width:180px;height:30px;"/>
            </div>

        </div>
    </form>
</div>

</body>
</html>
