$(document).ready(function () {
    $("#addform").validate({
        focusInvalid : true,
        rules: {　　　　//规则
            name: {　　//要对应相对应的input中的name属性
                required: true,
            },
            number: {
                required: true
            }

        },
        messages: {　　　　//验证错误信息
            name: {
                required: "请输入用户名",
            },
            number: {
                required: "请输入学号"
            }
        },
        submitHandler: function (form) { //通过之后回调

            $.ajax({
                type: 'post',
                url: "/spm/stu/addStusubmit.action",
                data: $("#addform").serialize(),
                cache: false,
                success: function (data) {
                    location.href = "/spm/success.jsp";
                    return true;
                }
            });
        },
        invalidHandler: function (form, validator) {
            return false;
        }
    });

});