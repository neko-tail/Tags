// 验证用户名是否符合
function Username() {
    var a = $("#UserName").val();
    var reg = /[a-zA-Z0-9]{2,6}/
    if (!reg.test(a)) {
        $("#UserName").next("i").text("请输入2到6位的数字或字母");
        return false;
    } else {
        $("#UserName").next("i").text("")
        return true;
    }
}

// 验证密码是否符合
function pwd() {
    var a = $("#pwds").val();
    var reg = /[a-zA-Z0-9]{2,10}/
    if (!reg.test(a)) {
        $("#pwds").next("i").text("请输入2到10位的数字或字母");
        return false;
    } else {
        $("#pwds").next("i").text("");
        return true;
    }
}

// 验证密码是否一致
function repwd() {
    var a = $("#pwds").val();
    var b = $("#repwds").val();
    if (b != a) {
        $("#repwds-i").text("两次密码不一致");
        return false;
    } else if (a.length < 1) {
        $("#repwds-i").text("两次密码不一致");
        return false;
    } else {
        $("#repwds-i").text("");
        return true;
    }
}

// 验证邮箱是否符合
function Email() {
    var a = $("#e-mail").val();
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
    if (!reg.test(a)) {
        $("#e-mail").next("i").text("请输入正确的邮箱");
        return false;
    } else {
        $("#e-mail").next("i").text("");
        return true;
    }
}

// 验证协议是否勾选
function Treaty() {
    var a = $("#treaty-input").prop('checked');
    if (a) {
        $("#treaty-i").text("")
        return true;
    } else {
        $("#treaty-i").text("请阅读协议并勾选");
        return false;
    }
}

// 点击注册按钮时检验是否全部正确
function Register() {
    var flag1 = Username();
    var flag2 = pwd();
    var flag3 = repwd();
    var flag4 = Email();
    var flag5 = Treaty();
    if (flag1 && flag2 && flag3 && flag4 && flag5) {
        alert("注册成功")
    }
}