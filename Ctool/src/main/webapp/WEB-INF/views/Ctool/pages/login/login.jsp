<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="/Ctool/resources/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/bootstrap.min.css">
    <!-- font awesome CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/owl.carousel.css">
    <link rel="stylesheet" href="/Ctool/resources/css/owl.theme.css">
    <link rel="stylesheet" href="/Ctool/resources/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/normalize.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- wave CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/wave/waves.min.css">
    <!-- Notika icon CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/notika-custom-icon.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/main.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="/Ctool/resources/js/vendor/modernizr-2.8.3.min.js"></script>
    
    
    <style>
   #out
   {
   text-transform: uppercase;
   color: #00c292;
   font-weight: bold;
   }
   
   #wrong
   {
   text-transform: uppercase;
   color: red;
   font-weight: bold;
   
   }
    
    </style>
    
    
    
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Login Register area Start-->
    <div class="login-content">
        <!-- Login -->
    
        <div class="nk-block toggled" id="l-login">
         <form action="${loginUrl}" method="POST">
            <div class="nk-form">
            
            <%
            if(request.getParameter("out")=="")
            {%>
            	  <p id="out">Logout successfully</p>
            <%}else if(request.getParameter("error")==""){%>
            
            <p id="wrong"><u>Wrong Username or password</u></p>
           <% }%>
            
              
                <div class="input-group">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-support"></i></span>
                    <div class="nk-int-st">
                     <!--    <input type="text" class="form-control" placeholder="Username"> -->
                        <input type="text" name="username" id="username"  maxlength="10"  value="admin"   class="form-control"  required placeholder="<spring:message code='placeholder.username' />">
                    </div>
                </div>
                <div class="input-group mg-t-15">
                    <span class="input-group-addon nk-ic-st-pro"><i class="notika-icon notika-edit"></i></span>
                    <div class="nk-int-st">
                     <!--    <input type="password" class="form-control" placeholder="Password"> -->
                         <input type="password" name="password" id="password" class="form-control" value="1234"  required placeholder="<spring:message code='placeholder.password'  />">
                    </div>
                </div>
               
                  
                <button class="btn btn-login btn-success btn-float"><i class="notika-icon notika-right-arrow right-arrow-ant"></i></button>
            </div>
</form>
          

        <!-- Forgot Password -->
       
    </div>
    <!-- Login Register area End-->
    <!-- jquery
		============================================ -->
    <script src="/Ctool/resources/js//vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="/Ctool/resources/js//bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="/Ctool/resources/js//wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="/Ctool/resources/js/jquery-price-slider.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="/Ctool/resources/js/owl.carousel.min.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="/Ctool/resources/js/jquery.scrollUp.min.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="/Ctool/resources/js/meanmenu/jquery.meanmenu.js"></script>
    <!-- counterup JS
		============================================ -->
    <script src="/Ctool/resources/js/counterup/jquery.counterup.min.js"></script>
    <script src="/Ctool/resources/js/counterup/waypoints.min.js"></script>
    <script src="/Ctool/resources/js/counterup/counterup-active.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="/Ctool/resources/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="/Ctool/resources/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="/Ctool/resources/js/sparkline/sparkline-active.js"></script>
    <!-- flot JS
		============================================ -->
    <script src="/Ctool/resources/js/flot/jquery.flot.js"></script>
    <script src="/Ctool/resources/js/flot/jquery.flot.resize.js"></script>
    <script src="/Ctool/resources/js/flot/flot-active.js"></script>
    <!-- knob JS
		============================================ -->
    <script src="/Ctool/resources/js/knob/jquery.knob.js"></script>
    <script src="/Ctool/resources/js/knob/jquery.appear.js"></script>
    <script src="/Ctool/resources/js/knob/knob-active.js"></script>
    <!--  Chat JS
		============================================ -->
    <script src="/Ctool/resources/js/chat/jquery.chat.js"></script>
    <!--  wave JS
		============================================ -->
    <script src="/Ctool/resources/js/wave/waves.min.js"></script>
    <script src="/Ctool/resources/js/wave/wave-active.js"></script>
    <!-- icheck JS
		============================================ -->
    <script src="/Ctool/resources/js/icheck/icheck.min.js"></script>
    <script src="/Ctool/resources/js/icheck/icheck-active.js"></script>
    <!--  todo JS
		============================================ -->
    <script src="/Ctool/resources/js/todo/jquery.todo.js"></script>
    <!-- Login JS
		============================================ -->
    <script src="/Ctool/resources/js/login/login-action.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="/Ctool/resources/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="/Ctool/resources/js/main.js"></script>
</body>

</html>