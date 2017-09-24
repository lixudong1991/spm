
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改学生信息</title>
</head>
<body>
<form action="/spm/stu/editsub.action" method="post">
    <input type="hidden" name="id" value="${studt.id}">
    修改学生信息:
    <table border="1">
        <tr>
            <td>学号</td>
            <td><input type="text" name="number" value="${studt.number}"/></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${studt.name}"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${studt.age}"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="male" <c:if test="${ studt.sex eq 'male'}"> checked="checked"</c:if> /><label >男</label>
                <input type="radio" name="sex" value="female" <c:if test="${studt.sex eq 'female'}"> checked="checked"</c:if>/><label>女</label>
            </td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="<fmt:formatDate value="${studt.birthday}" pattern="yyyy-MM-dd"/>"/></td>
        </tr>

        <tr>
            <td>班级</td>
            <td><input type="text" name="classid" value="${studt.classid}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
    </table>

</form>
</body>
</html>