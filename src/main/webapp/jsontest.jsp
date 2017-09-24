<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomcat
  Date: 2017/9/25
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jsontest</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#id").bind('input propertychange', function() {
                responsejson();
            });
        });
        //请求json，响应json
        function requestjson() {
            $.ajax({
                type: 'post',
                url:'${pageContext.request.contextPath}/requestjson.action',
                contentType:'application/json;charset=utf-8',
                data:'{"id":'+$("#id").val()+'}',
                success:function (data) {
                   setPro(data);
                }
            });
        }
        //请求key/value，响应json
        function responsejson() {
            $.ajax({
                type: 'post',
                url:'${pageContext.request.contextPath}/responsejson.action',
                data:'id='+$("#id").val(),
                success:function (data) {
                  setPro(data);
                }
            });
        }
        function setPro(data) {
            $("#name").val(data.name);
            $("#number").val(data.number);
            $("#age").val(data.age);
            $("#sex").val(data.sex);
            $("#birthday").val(data.birthday);
            $("#classid").val(data.classid);
        }
    </script>
</head>
<body>

<input type="text" value="请输入查询的学生id" onfocus="this.value=''" id="id">
<input type="button" onclick="requestjson()" value="请求json，响应json"/>
<input type="button" onclick="responsejson()" value="请求key/value，响应json"/><br/>
名字:<input type="text" id="name"/><br/>
学号:<input type="text" id="number"/><br/>
年龄:<input type="text" id="age"/><br/>
性别:<input type="text" id="sex"/><br/>
出生日期:<input type="text" id="birthday"/><br/>
班级:<input type="text" id="classid"/><br/>
</body>
</html>
