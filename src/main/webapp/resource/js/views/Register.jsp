<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
      
      <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/controller/form.js"></script>    
      <script type="text/javascript" src="resource/js/angular-route.js"></script>
      <script src="resource/js/controller/Login.js"></script>
      
      <!-- Bootstrap Css -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      
      <style type="text/css">
  		background-color: lightblue;
      	.marginTop14 {
      		margin-top: 14px;
      	}
      </style>
</head>
<body>

 	<h2 align="center" class="text-primary">Book And Go</h2>
 
     <form method="post" ng-submit="registerEntry()">
     
   <div class="container form_style">
     
      <div class="form-group">
       <label>Username:</label>
       <input type="text" name="username" required  class="form-control" ng-minlength="4" ng-maxlength="10"/>
        <p  ng-show="userForm.username.$error.minlength" class="help-block">Username must be at least 4 characters.</p>
  		<p ng-show="userForm.username.$error.maxlength" class="help-block">Username must be at most 10 characters.</p>
      </div>
      
     <div class="form-group">
       <label>First Name:</label>
       <input type="text" name="username" required  ng-model="registerData.users_nameFirst" class="form-control"/>
      </div>
      
      <div class="form-group">
       <label>Last Name:</label>
       <input type="text" name="username" required ng-model="registerData.users_nameLast" class="form-control" />
      </div>

 
      <div class="form-group">
       <label>Email address:</label>
       <input type="email" name="email"  required ng-model="registerData.users_email" class="form-control" />
       <p ng-show="userForm.email.$invalid && !userForm.email.$pristine" class="help-block">Enter a valid email.</p>
      </div>
      
      <div class="form-group">
       <label>Enter password:</label>
       <input type="password" name="password" required  ng-model="registerData.users_password" class="form-control" />
      </div>
      
      <div class="form-group">
       <label>Re-enter password:</label>
       <input type="password" name="repeat-password" required class="form-control" />
      </div>
      
      
      
      <div class="form-group" align="center">
       <input type="submit" name="register" class="btn btn-primary" value="Register" ng-click="showRegister()" />
 		<br>
      </div>
      </div>
     </form>

</body>
</html>