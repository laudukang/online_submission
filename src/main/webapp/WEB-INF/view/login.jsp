<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线投稿系统</title>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<header class="user_header">
    <h1>在线投稿系统</h1>
</header>
<div class="user_wrap">
    <div class="user_bg"></div>
    <form class="user_container login" action="#" method="post">
        <ul class="user_content">
            <li class="login_item">
                <h2 class="login_title">用户登录</h2>
            </li>
            <li class="login_item">
                <input class="doc_text doc_text_Large" type="text" name="account" placeholder="请输入注册邮箱" required
                       pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$"/>
            </li>
            <li class="login_item">
                <input class="doc_text doc_text_Large" type="password" name="password" placeholder="密码(6到16位有效字符)"
                       required pattern="[\w]{6,16}"/>
            </li>
            <li class="login_item">
                <input type="submit" class="doc_btn doc_btn_Blue" value="登录"/>
                <span class="user_remind remind">${账号或密码出错}</span>
            </li>
            <li class="login_item">
                <a id="forgivePasswordBtn" class="login_item_leftBtn" href="forgivePassword.html">忘记密码?</a>
                <a id="registerBtn" class="login_item_rightBtn" href="register.html">立即注册</a>
            </li>
        </ul>
    </form>
</div>
<script src="js/jquery.js"></script>
<script src="js/jQuery.md5.js"></script>
<script>
    $(function () {
        $('.login').on('submit', function () {
            var password = $(this).find('input[name="password"]').val();
            $(this).find('input[name="password"]').val($.md5(password));
        });
    });
</script>
</body>
</html>