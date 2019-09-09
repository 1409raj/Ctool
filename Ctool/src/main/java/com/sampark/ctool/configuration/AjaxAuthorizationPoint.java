package com.sampark.ctool.configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class AjaxAuthorizationPoint extends LoginUrlAuthenticationEntryPoint {

    public AjaxAuthorizationPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setStatus(401);
        response.setContentType("text/html");
        response.getWriter().print("<!DOCTYPE html> "+
        		"<!DOCTYPE html>" +
        		"<html ng-app='myApp'>" +
        		"<head>" +
        		  "<meta charset='utf-8'>" +
        		  "<meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
        		  "<title>FieldForce</title>" +
        		  "<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>" +
        		  "<link rel='stylesheet' href='/FieldForce/resources/bower_components/bootstrap/dist/css/bootstrap.min.css'>" +
        		  "<link rel='stylesheet' href='/FieldForce/resources/bower_components/font-awesome/css/font-awesome.min.css'>" +
        		  "<link rel='stylesheet' href='/FieldForce/resources/bower_components/Ionicons/css/ionicons.min.css'>" +
        		  "<link rel='stylesheet' href='/FieldForce/resources/dist/css/AdminLTE.min.css'>" +
        		  "<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic'>" +
        		"<script src='/FieldForce/resources/dist/js/angular.min.js'>" +"</script>" +
        		"<script src='https://apis.google.com/js/platform.js' async defer>" +"</script>" +

        		"</head>" +
        		"<body class='hold-transition login-page' ng-controller='myCtrl'>" +
        		"<div class='login-box' ng-show='login'>" +
        		  "<div class='login-logo'>" +
        		  "</div>" +
        		  "<span>" +"</span>" +
        		  "<div class='login-box-body' style='margin-top: 50%;'>" +
        		     "<div>" +
        		   "</div>" +
        		    "<form action='login' method='POST'>" +
        		      "<div class='form-group has-feedback' style='margin-top:25px;'>" +
        		        "<input type='text' name='username' id='username' class='form-control' placeholder=' Enter Username' required>" +
        		        "<span class='glyphicon glyphicon-envelope form-control-feedback'>" +"</span>" +
        		      "</div>" +
        		      "<div class='form-group has-feedback'>" +
        		        "<input type='password' name='password' id='password' class='form-control' placeholder='Enter Password' required>" +
        		        "<span class='glyphicon glyphicon-lock form-control-feedback'>" +"</span>" +
        		     "</div>" +
        		      "<div class='row'>" +
        		       
        		         "<div class='col-xs-12' style='margin-top:15px;'>" +
        		          "<button type='submit' class='btn btn-danger  btn-block btn-flat'>Login</button>" +
        		        "</div>" +
        		      
        		      "</div>" +
        		    "</form>" +
        		  "</div>" +
        		"</div>" +
        		"<script src='/FieldForce/resources/bower_components/jquery/dist/jquery.min.js'>" +"</script>" +
        		"<script src='/FieldForce/resources/bower_components/bootstrap/dist/js/bootstrap.min.js'>" +"</script>" +
        		"<script src='/FieldForce/resources/plugins/iCheck/icheck.min.js'>" +"</script>" +
        		"</body>" +
        		"</html>"

        		);
        response.getWriter().flush();
    }
}