<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息查询</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-size: 14px;
            color: #000;
        }

        #biaoge {
            width: 859px;
            margin: 30px auto;
        }

        .biao{
            list-style-type: none;
            width:100px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            float: left;
            margin-left: 1px;
            margin-bottom: 1px;
            background: #ccc;
        }
       .bir{
            list-style-type: none;
            width:150px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            float: left;
            margin-left: 1px;
            margin-bottom: 1px;
            background: #ccc;
        }

    </style>
</head>
<body>
<div style="margin:0 auto;width:1000px">
<c:if test="${empty requestScope.students}">
    <span style="font-size: 15px"><a href="emp">没有学生信息</a></span>
</c:if>
<c:if test="${!empty requestScope.students }">
    <div style="float:left;width:1000px">
        <ul id="biaoge">
            <li class="biao">学号</li>
            <li class="biao">姓名</li>
            <li class="biao">年龄</li>
            <li class="biao">性别</li>
            <li class="bir">生日</li>
            <li class="biao">班级</li>
            <li class="biao"></li>
            <li class="biao"></li>
            <c:forEach items="${requestScope.students}" var="stu">
                <li class="biao">${stu.number}</li>
                <li class="biao">${stu.name }</li>
                <li class="biao">${stu.age }</li>
                <li class="biao">${stu.sex}</li class="biao">
                <li class="bir"><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></li>
                <li class="biao">${stu.classid}</li>
                <li class="biao">
                    <a href="/spm/stu/edit.action?id=${stu.id}">编辑</a>
                </li>
                <li class="biao">
                    <a href="">删除</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div style="float:left;width:1000px;text-align:center">
        <a href="emp"><span style="font-size: 20px">增加学生信息</span></a>
        <a href="emp"><span style="font-size: 20px">首页</span></a>
        <a href="emp"><span style="font-size: 20px">下一页</span></a>
        <a href="emp"><span style="font-size: 20px">上一页</span></a>
        <a href="emp"><span style="font-size: 20px">末页</span></a>
    </div>
    </c:if>


</div>
</body>
</html>