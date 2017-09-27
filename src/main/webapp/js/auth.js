
$(document).ready(function () {
    $("#regform").validate({
        focusInvalid : true,
        rules: {　　　　//规则
            username: {　　//要对应相对应的input中的name属性
                required: true,
            },
            password: {
                required: true
            }
        },
        messages: {　　　　//验证错误信息
            username: {
                required: "请输入用户名",
            },
            password: {
                required: "请输入密码"
            }
        },
        submitHandler: function (form) { //通过之后回调
            $.ajax({
                type: 'post',
                url: "/spm/log/reg.action",
                data: $("#regform").serialize(),
                cache: false,
                success: function (data) {
                    if (data.logsuccess) {
                        location.href = "/spm/login.jsp";
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        },
        invalidHandler: function (form, validator) {
            return false;
        }
    });

});