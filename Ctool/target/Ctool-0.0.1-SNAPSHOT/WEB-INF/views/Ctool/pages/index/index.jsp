<!DOCTYPE html>
<%-- <%@page import="com.sampark.track.constants.AppConstants"%> --%>
<html ng-app="app">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Compensation Tool</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/Track/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/Track/resources/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/Track/resources/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/Track/resources/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/Track/resources/dist/css/skins/_all-skins.min.css">
  <script src="/Track/resources/dist/js/angular.min.js"></script>
   <script src="/Track/resources/dist/js/angular-ui-router.min.js"></script>
   
    <!-- daterange picker -->
  <link rel="stylesheet" href="/Track/resources/bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap slider -->
  <link rel="stylesheet" href="/Track/resources/plugins/bootstrap-slider/slider.css">
 <!-- Date Picker -->
  <link rel="stylesheet" href="/Track/resources/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="/Track/resources/bower_components/select2/dist/css/select2.min.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="/Track/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="/Track/resources/plugins/iCheck/all.css">
    <!-- DataTables -->
  <link rel="stylesheet" href="/Track/resources/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <script src="/Track/resources/js/app.js"></script> 
  
 
 

  <script>
  </script>
  
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
   <script src="http://ui-grid.info/release/ui-grid-unstable.js"></script>
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid-unstable.css" type="text/css">
 
<style>
.all-labels-dashboard h3 {
font-size:30px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%-- <%String username=(String)session.getAttribute(AppConstants.USER); %> --%>
  <header class="main-header">
    <!-- Logo -->
    <a href="" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>L</b>M</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Compensation</b>Tool</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
         <li class="dropdown notifications-menu">
            <a href="#/mapdirection" class="dropdown-toggle" data-toggle="dropdown" data->
            <i class="fa fa-map-marker"></i><span class="hidden-xs">&nbsp;Tracking</span>
            </a>
            </li>
          <li class="dropdown notifications-menu">
            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-gears"></i><span class="hidden-xs">&nbsp;Settings</span>
            </a>
            <ul class="dropdown-menu">
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                 <li><a ui-sref="user"><i class="fa fa-users text-aqua"></i>Registration</a></li>
                 <li><a href="#/supervisior"><i class="fa fa-users text-aqua"></i>Supervisor</a></li>
                 <li><a href="#/sim"><i class="fa fa-users text-aqua"></i>SIM Details</a></li>
                 <li><a href="#/vehicle"><i class="fa fa-users text-aqua"></i>Vehicle Configuration</a></li>
                 <li><a href="#/device"><i class="fa fa-users text-aqua"></i>Device and Command</a></li>
                 <li><a href="#/devicedtls"><i class="fa fa-users text-aqua"></i>Device Details</a></li>
                  <li><a href="#/alarms"><i class="fa fa-users text-aqua"></i>Alarm View</a></li> 
                  <li><a href="#/reports"><i class="fa fa-users text-aqua"></i>Reports</a></li> 
                  
                </ul>
              </li>
            </ul>
          </li>
         <li class="dropdown user user-menu">
            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/Track/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">1</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="/Track/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                <%-- <%=username%> --%>1
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="javascript:void(0);" class="btn btn-default btn-flat" data-toggle="modal" data-target="#myModal1">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="javascript:void(0);" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
         
           </ul>
      </div>
          </nav>
  </header>
        <aside class="main-sidebar">
  <%--  <jsp:include page="inc-sidebar.jsp"></jsp:include> --%> 
       <%@ include file="/WEB-INF/views/Ctool/pages/menu/inc-sidebar.jsp"%>
        </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
   
    <ui-view>
   
  </div>
  
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>V</b> 2
    </div>
    <strong>Copyright &copy; 2018 <a href="#">Sampark Software</a>.</strong> All rights
    reserved.
  </footer>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="/Track/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/Track/resources/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/Track/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="/Track/resources/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- Morris.js charts -->
<script src="/Track/resources/bower_components/raphael/raphael.min.js"></script>
<!-- InputMask -->
<script src="/Track/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="/Track/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="/Track/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="/Track/resources/bower_components/moment/min/moment.min.js"></script>
<script src="/Track/resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="/Track/resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<!-- jvectormap -->
<script src="/Track/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/Track/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/Track/resources/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/Track/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/Track/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/Track/resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- iCheck 1.0.1 -->
<script src="/Track/resources/plugins/iCheck/icheck.min.js"></script>
<!-- Select2 -->
<script src="/Track/resources/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- AdminLTE App -->
<script src="/Track/resources/dist/js/adminlte.min.js"></script>
<!-- Bootstrap slider -->
<script src="/Track/resources/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/Track/resources/dist/js/demo.js"></script>
 <!-- DataTables -->
<script src="/Track/resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/Track/resources/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- Select2 -->
<script src="/Track/resources/bower_components/select2/dist/js/select2.full.min.js"></script>


  
  <div id="myModal1" class="modal fade" role="dialog">
   <div class="modal-dialog modal-md">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Supervisior Details</h4>
      </div>
       <div class="modal-body">
       <div class="row">
       <div class="col-md-6">
              <div class="form-group">
                <label>Supervisior Id:</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-user"></i>
                  </div>
                  <input type="text" class="form-control" placeholder="Id">
                </div>
                </div>
              </div>
              <div class="col-md-6">
              <div class="form-group">
                <label>Supervisior Name:</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-user"></i>
                  </div>
                  <input type="text" class="form-control" placeholder="name">
                </div>
                </div>
              </div>
              </div>
              <div class="row">
              <div class="col-md-6">
              <div class="form-group">
                <label>Email Id:</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-envelope"></i>
                  </div>
                  <input type="text" class="form-control" placeholder="email">
                </div>
                </div>
              </div>
              <div class="col-md-6">
              <div class="form-group">
                <label>Phone no:</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-phone"></i>
                  </div>
                  <input type="text" class="form-control" placeholder="phone no">
                </div>
              </div>
              </div>
              </div>
              <div class="row">
              <div class="col-md-6">
                 <div class="form-group">
                  <label for="exampleInputFile">Profile Image</label>
                  <input type="file" id="exampleInputFile">
                </div>
              </div>
              </div>
              
            </div>
      
      <div class="modal-footer">
       <button type="button" class="btn btn-success" data-dismiss="modal">Submit</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

</body>
</html>
