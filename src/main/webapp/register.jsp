<%--
  Created by IntelliJ IDEA.
  User: t_rav
  Date: 28.08.2024
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 16px;" lang="ru"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>Registration</title>
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
    <link rel="stylesheet" href="css/index.css" media="screen">
    <meta name="generator" content="Nicepage 6.16.13, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    <meta name="theme-color" content="#8945e8">
    <meta property="og:title" content="Registration">
    <meta property="og:type" content="website">
    <meta data-intl-tel-input-cdn-path="intlTelInput/"></head>
<body>
<section class="u-align-center u-clearfix u-container-align-center u-image u-section-1" id="sec-17b2" data-image-width="1600" data-image-height="1066">
    <div class="u-clearfix u-sheet u-valign-middle-xs u-sheet-1">
        <div class="u-align-center u-container-align-center u-container-style u-expanded-width-xs u-group u-shape-rectangle u-group-1">
            <div class="u-container-layout u-container-layout-1">
                <h3 class="u-custom-font u-font-montserrat u-text u-text-default u-text-1">Register</h3>
                <div class="u-expanded-width u-form u-login-control u-white u-form-1">
                    <form action="/register" class="u-clearfix u-form-custom-backend u-form-spacing-20 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 30px;" method="post">
                        <div class="u-form-group u-form-name">
                            <label for="username" class="u-label">Username *</label>
                            <input type="text" placeholder="Enter your Username" id="username" name="username" class="u-grey-5 u-input u-input-rectangle u-input-1" required="">
                        </div>
                        <div class="u-form-group u-form-password">
                            <label for="password" class="u-label">Password *</label>
                            <input type="text" placeholder="Enter your Password" id="password" name="password" class="u-grey-5 u-input u-input-rectangle u-input-2" required="">
                        </div>
                        <div class="u-align-right u-form-group u-form-submit">
                            <button type="submit" class="u-border-none u-btn u-btn-submit u-button-style u-palette-3-base u-btn-1">Register</button>
                            <input type="submit" value="submit" class="u-form-control-hidden">
                        </div>
                        <input type="hidden" value="" name="recaptchaResponse">
                    </form>
                </div>
                <a href="/login" class="u-border-active-palette-2-base u-border-hover-palette-1-base u-border-none u-btn u-button-style u-login-control u-login-create-account u-none u-text-grey-40 u-text-hover-palette-4-base u-btn-3">Already have an account? Login</a>
            </div>
        </div>
    </div>
</section>
</body></html>
