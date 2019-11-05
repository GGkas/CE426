<%-- 
    Document   : login
    Created on : Nov 3, 2019, 4:58:07 PM
    Author     : gkoffas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form action="Login" method="post">
                    <input type="text" name = "uname" placeholder="Username" required="required">
                    <input type="password" name="password" placeholder="Password" required="required">
                    <input type="submit" value="Log In">
                    <p class="message">Don't have an account? <a href="./register.jsp">Sign Up</a></p>
                </form>
            </div>
        </div>
    </body>
</html>