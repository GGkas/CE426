<%-- 
    Document   : register
    Created on : Nov 3, 2019, 5:09:20 PM
    Author     : gkoffas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form action="Register" method="post">
                    <input type="text" name="uname" placeholder="Username" required="required">
                    <input type="password" name="password" placeholder="Password" required="required">
                    <input type="email" name="email" placeholder="E-mail" required="required">
                    <input type="submit" value="Sign Up">
                    <p class="message">
                        Already have an account? <a href="./login.jsp">Sign In</a>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>