<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<div class="container right-panel-active">
    <!-- 注册 -->
    <div class="container__form container--signup">
        <form class="form" id="form1">
            <h2 class="form__title">欢迎登录</h2>
            <input type="text" placeholder="Username" class="input" name="username" />
            <input type="password" placeholder="Password" class="input" name="password" />
            <input type="text" placeholder="Verification Code" class="input" name="verificationCode">
            <div class="myButton">
                <input type="checkbox" name="saved" value="autoLogin">记住登录&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <img src="/VerificationCodeServlet" alt="">
            </div>
            <button type="submit" class="btn" id="login">点击登录</button>
        </form>
    </div>

<%--    <!-- 登录 -->--%>
<%--    <div class="container__form container--signin">--%>
<%--        <form action="#" class="form" id="form2">--%>
<%--            <h2 class="form__title">欢迎登录</h2>--%>
<%--            <input type="email" placeholder="Email" class="input" />--%>
<%--            <input type="password" placeholder="Password" class="input" />--%>
<%--            <a href="#" class="link">忘记密码?</a>--%>
<%--            <button class="btn">登录</button>--%>
<%--        </form>--%>
<%--    </div>--%>

    <!-- 叠加部分 -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <button class="btn" id="signIn" disabled="disabled">欢迎你，管理员用户</button>
            </div>
            <div class="overlay__panel overlay--right">
                <button class="btn" id="signUp">没有账号，点击注册</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    // 获取元素和点击操作
    const signInBtn = document.getElementById("signIn");
    const signUpBtn = document.getElementById("signUp");
    const fistForm = document.getElementById("form1");
    const secondForm = document.getElementById("form2");
    const container = document.querySelector(".container");

    signInBtn.addEventListener("click", () => {
        container.classList.remove("right-panel-active");
    });

    signUpBtn.addEventListener("click", () => {
        container.classList.add("right-panel-active");
    });

    fistForm.addEventListener("submit", (e) => e.preventDefault());
    // secondForm.addEventListener("submit", (e) => e.preventDefault());
</script>

<script src = 'https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script>
    $(function () {
        $('#login').on('click', function () {
            var name = $('[name=username]').val();
            var pwd = $('[name=password]').val();
            var code = $('[name=verificationCode]').val();
            var saved = $("input[name='saved']:checked").val();
            console.log(saved);
            $.ajax({
                url: '/IndexHttpServlet',
                type: 'post',
                data:{
                    name: name,
                    pwd: pwd,
                    code: code,
                    saved: saved
                },
                dataType: 'text',
                success:function (data) {
                    if (data == 'true') {
                        window.location.href=('/home');
                    }
                    else {
                        alert("账号或密码输入错误");
                    }
                }
            })
        })
    })
</script>
</html>