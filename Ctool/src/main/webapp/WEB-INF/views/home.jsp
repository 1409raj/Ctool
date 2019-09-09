<!doctype html>
<html class="no-js" lang="" ng-app="app">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Compensation Tool</title>
    <meta name="description" content="">
 
    <meta name="viewport" content="initial-scale = 1.0,maximum-scale = 1.0" />
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
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
    <!-- meanmenu CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/meanmenu/meanmenu.min.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/normalize.css">
	<!-- wave CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/wave/waves.min.css">
    <link rel="stylesheet" href="/Ctool/resources/css/wave/button.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- jvectormap CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/jvectormap/jquery-jvectormap-2.0.3.css">
    <!-- Notika icon CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/notika-custom-icon.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/main.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/style.css">
    <link rel="stylesheet" href="/Ctool/resources/color.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="/Ctool/resources/js/vendor/modernizr-2.8.3.min.js"></script>
    
     <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular.min.js"></script>
   <script src="/Ctool/resources/angular/angular-ui-router.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular-route.js"></script>
   <script src="/Ctool/resources/angular/app.js"></script> 
   
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
   
   
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css">
   <!-- bootstrap select CSS
		============================================ -->
    <link rel="stylesheet" href="/Ctool/resources/css/bootstrap-select/bootstrap-select.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="https://cdn.datatables.net/fixedcolumns/3.2.6/css/fixedColumns.dataTables.min.css">
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
   <style>
   ul.nav li.dropdown:hover > ul.dropdown-menu {
    display: block;    
}

.font-lato
{
display: none!important;
}

/* width */
::-webkit-scrollbar {
  width: 8px;
  height: 8px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #FFCB5B; 
}


   </style>
   
   <style>
.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: #00C292;
  color: white;
  text-align: center;
}
.circlelogo {
    width: 120px;
    height: 120px;
    background: white;
    position: absolute;
    margin-left: 0px;
    -moz-border-radius: 70px;
    -webkit-border-radius: 70px;
    border-radius: 70px;
    
    }
    .headerLogoImg {
    margin-top: 25px !important;
    height: 69px;
    width: 114px;
    margin-left: 3px;
    border-radius: 32%;
    }
    
    #my{
zoom: 80%;
}

</style>
</head>

<body ng-controller="bodyController" style="height: 100%!important" id="my">
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Start Header Top Area -->
    <div class="header-top-area navbar-fixed-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: left;">
                 <ul class="nav navbar-nav notika-top-nav" style="float: left;">
                 <li>
                 <div class="circlelogo hidden-xs">
					   <img src="/Ctool/resources/images/logo.jpg" style="position: fixed;height: 62px;" class="headerLogoImg">

				</div>
                 </li>
              
                            </ul>
                </div>
                <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                    <div class="header-top-menu">
                        <ul class="nav navbar-nav notika-top-nav ">
                           
                            <li class="nav-item dropdown">
                            
                                <a href="/Ctool/logoutCtool"  role="button"><span><i class="fa fa-power-off"></i></span></a>
                               
                            </li>
                         
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div style="padding-top: 50px;">
    
       <%@ include file="/WEB-INF/views/Ctool/pages/menu/inc-sidebar.jsp"%>
    
    </div>
      
   
    <!-- Main Menu area End-->
	<!-- Breadcomb area Start-->
	
		<div class="container-fluid" style="padding-bottom: 90px;">
			<div class="row">
				<div class="col-md-12 form-group">
						   <ui-view>
							</div>
						</div>
					</div>
				

	
	
	 

    <!-- Alert area End-->
    <!-- Start Footer area-->
    <div class="footer-copyright-area footer" style="margin-top: 5%;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="footer-copy-right">
                        <p>Copyright © 2019. All rights reserved.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Footer area-->
    <!-- jquery
		============================================ -->
    <script src="/Ctool/resources/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="/Ctool/resources/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="/Ctool/resources/js/wow.min.js"></script>
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
    <!--  todo JS
		============================================ -->
    <script src="/Ctool/resources/js/todo/jquery.todo.js"></script>
	<!--  wave JS
		============================================ -->
    <script src="/Ctool/resources/js/wave/waves.min.js"></script>
    <script src="/Ctool/resources/js/wave/wave-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="/Ctool/resources/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="/Ctool/resources/js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
     
      <!-- Data Table JS
		============================================ -->

 
  <!-- bootstrap select JS
		============================================ -->
    <script src="/Ctool/resources/js/bootstrap-select/bootstrap-select.js"></script>


<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>
<script src="/Ctool/resources/js/data-table/data-table-act.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/fixedcolumns/3.2.6/js/dataTables.fixedColumns.min.js"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2014-11-29/FileSaver.min.js"></script>
<script type="text/javascript" src="http://markswindoll.github.io/jquery-word-export/jquery.wordexport.js"></script>
</body>

</html>
