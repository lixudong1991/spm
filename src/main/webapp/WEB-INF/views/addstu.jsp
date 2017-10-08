<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>增加学生信息</title>
    <link href="${pageContext.request.contextPath}/css/log.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/addstu.js"></script>
</head>
<body>
<div class="c">
    <form id="addform" method="post">
        <div class="c4">
            <div style="width: 300px;height:18px">
            </div>
            <div class="c5">
               <div class="c6">学生姓名:</div>
                <div class="c3"><input id="name" type="text" name="name"
                        class="i"    maxlength="20"/></div>
            </div>
            <div style="width: 300px;height:18px">
            </div>
            <div class="c5">
                <div class="c6">学号:</div>
                <div class="c3"><input type="text" name="number"
                                       class="i"  maxlength="20"/></div>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c5">
                <div class="c6">年龄:</div>
                <div class="c3"><input type="text" name="age"
                                       class="i" maxlength="20"/></div>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c5">
                <div class="c6">性别:</div>
                <div class="c3"><input type="radio" name="sex" value="male" checked="checked"/><label >男</label>
                    <input type="radio" name="sex" value="female" /><label>女</label></div>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c5">
                <div class="c6">出生日期:</div>
                <div class="c3"><input type="text" name="birthday"
                                       class="i"      maxlength="20"/></div>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c5">
                <div class="c6">班级:</div>
                <div class="c3"><input type="text" name="classid"
                                       class="i"      maxlength="20"/></div>
            </div>
            <div style="width: 300px;height: 18px">
            </div>
            <div class="c5">
                <input type="submit" id="submit" value="增加" style="width:180px;height:30px;"/>
            </div>

        </div>
    </form>
</div>

</body>
</html>
