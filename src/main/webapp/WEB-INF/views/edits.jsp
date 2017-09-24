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
            width: 659px;
            margin: 30px auto;
        }


        .biao {
            list-style-type: none;
            width: 100px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            float: left;
            margin-left: 1px;
            margin-bottom: 1px;
            background: #ccc;
        }
        .bir {
            list-style-type: none;
            width: 150px;
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
    <c:if test="${!empty requestScope.students }">
        <form  action="/spm/stu/editsubmit.action" method="post">
            <div style="float:left;width:1000px">
                <ul id="biaoge">
                    <li class="biao">学号</li>
                    <li class="biao">姓名</li>
                    <li class="biao">年龄</li>
                    <li class="biao">性别</li>
                    <li class="bir">生日</li>
                    <li class="biao">班级</li>
                    <c:forEach items="${requestScope.students}" var="stu" varStatus="status">
                        <input type="hidden" name="stus[${status.index}].id" value="${stu.id}">
                        <li class="biao"><input  style="height: 28px; width: 98px"  type="text" name="stus[${status.index}].number" value="${stu.number}"/></li>
                        <li class="biao"><input   style="height: 28px; width: 98px" type="text" name="stus[${status.index}].name" value="${stu.name }"/></li>
                        <li class="biao"><input   style="height: 28px; width: 98px" type="text" name="stus[${status.index}].age" value="${stu.age }"/></li>
                        <li class="biao"><input   style="height: 28px; width: 98px" type="text" name="stus[${status.index}].sex" value="${stu.sex}"/></li>
                        <li class="bir"> <input   style="height: 28px; width: 145px" type="text" name="stus[${status.index}].birthday" value="<fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/>"/></li>
                        <li class="biao"><input   style="height: 28px; width: 98px" type="text" name="stus[${status.index}].classid" value="${stu.classid}"/></li>
                    </c:forEach>
                </ul>
            </div>
            <div style="float:left;width:1000px;text-align:center">
                <input type="submit" value="保存"/>
            </div>
        </form>
    </c:if>
</div>
</body>
</html>