<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="app">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
      
     
      
      <!-- Bootstrap Css -->
      <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
      <!-- <link href="src/css/angular-datepicker.css" rel="stylesheet" type="text/css" /> -->
      
      <style type="text/css">
  		background-color: lightblue;
      	.marginTop14 {
      		margin-top: 14px;
      	}
      </style>
    <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/controller/PaymentDetails.js"></script>    
      <script type="text/javascript" src="resource/js/angular-route.js"></script>
      <script src="resource/js/controller/PaymentDetails.js"></script>   
   	 <script src="http://code.angularjs.org/1.2.6/angular.js"></script>
   	<script src= 
"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"> 
        </script> 
         <script src="src/js/angular-datepicker.js"></script> 
  
         
   </head>
    <body>
   
    
    <body ng-controller="billing_controller" >
    <div >
	<div class="container">
	<div class="col-sm-8 col-sm-offset-2">
    
    <div class="page-header"><h2 align="center" class="text-primary">Book And Go</h2></div> 
   
    <form name="billingForm" method="post" ng-submit="submitForm()" novalidate>
    <label>Customer Details:</label>  
    
    <div class="form-group">
    	<p>Full Name:</p>
    	<input type="text" name="username" class="form-control" ng-model="billingData.user_name" ng-minlength="1" ng-maxlength="100" required placeholder="Name">
    	<p ng-show="billingForm.username.$invalid && !billingForm.username.$pristine && billingForm.username.$error.required || billingForm.username.$untouched" class="help-block">Your name is required.</p>
    </div>
    
    <label>Address:</label>  
    <div class="form-group">
    	<p>Address Line 1:</p>
    	<input type="text" name="add1" class="form-control" ng-model="billingData.add_line1" ng-minlength="1" ng-maxlength="100" required placeholder="Street or Apartment Name">
    	<p ng-show="billingForm.add_line1.$invalid && !billingForm.add_line1.$pristine && billingForm.add1.$error.required || billingForm.add1.$untouched" class="help-block">Address Line 1 is required.</p>
    </div>
    
    <div class="form-group">
    	<p>Address Line 2:</p>
    	<input type="text" name="add2" class="form-control" ng-model="billingData.add_line2" ng-minlength="1" ng-maxlength="100" placeholder="Apt No.">
    	<!-- <p ng-show="billingForm.add_line2.$invalid && billingForm.add2.$error.required" class="help-block">Address Line 2 is required.</p> -->
    </div>
    
     <div class="form-group">
            <p>Country</p>
            <select name='country' id="country" class="form-control" ng-model="country" ng-options="country as country.CountryName for country in countries" required>
                <option value="" disabled>Select</option>
            </select>
            <p ng-show="billingForm.country.$invalid && !billingForm.country.$pristine && billingForm.country.$error.required || billingForm.country.$untouched" class="help-block">Country is required.</p>
    </div>
        
    <div class="form-group">
            <p>State</p>
            <select name='state' id="state" class="form-control" ng-model="state" ng-options="state as state.StateName for state in states" required>
                <option value="" disabled>Select</option>
            </select>
            <p ng-show="billingForm.state.$invalid && !billingForm.state.$pristine && billingForm.state.$error.required || billingForm.state.$untouched" class="help-block">State is required.</p>
        </div>
        
         <div class="form-group">
            <p>City</p>
            <select name='city' required id="city" class="form-control" ng-disabled="cities.length == 0" ng-model="city" ng-options="city as city.CityName for city in cities">
                <option value="" disabled>Select</option>
            </select>
            <p ng-show="billingForm.city.$invalid && !billingForm.city.$pristine && billingForm.city.$error.required || billingForm.city.$untouched" class="help-block">City is required.</p>
        </div>
 
    <div class="form-group">
    	<p>Zipcode:</p>
    	<input type="text" name="pincode" class="form-control" ng-model="billingData.pincode" ng-minlength="5" ng-maxlength="5" required onkeypress="return /[0-9]/i.test(event.key)" placeholder="Zipcode">
    	<p ng-show="billingForm.pincode.$invalid && !billingForm.pincode.$pristine && billingForm.pincode.$error.required ||billingForm.pincode.$error.minlength||billingForm.pincode.$error.maxlength|| billingForm.pincode.$untouched " class="help-block">Valid zipcode is required.</p>
    </div>
    
  <div class="form-group">
         <label>Phone Number:</label>
        <input type="text" name="phoneNo" class="form-control" ng-model="billingData.phone_no" data-ng-minlength="10" maxlength="10" placeholder="Phone Number" required onkeypress="return /[0-9]/i.test(event.key)">
       <p ng-show="billingForm.phoneNo.$invalid && !billingForm.phoneNo.$pristine && billingForm.phoneNo.$error.required || billingForm.phoneNo.$untouched " class="help-block">Phone number is required (without country code).</p>
        </div>
        
         <div class="form-group">
         <label>E-mail:</label>
        <input type="text" name="email" class="form-control" ng-model="billingData.email" ng-pattern="/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/" placeholder="youraddress@example.com" required />
         <p ng-show="billingForm.email.$invalid && !billingForm.email.$pristine && billingForm.email.$error.required || billingForm.email.$error.pattern || billingForm.email.$untouched " class="help-block">Enter valid Email address.</p>
        </div>
   
     <button type="submit" class="btn btn-primary" ng-disabled="billingForm.$invalid" ng-click='postData()'>Submit</button>
     </div>
    </form>
    </div>
    </div>	
    </div>
    
   </body>



</html>