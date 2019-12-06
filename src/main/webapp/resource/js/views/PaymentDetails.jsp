

<!DOCTYPE html>
<html ng-app="app">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>BookAndGo Payment</title>
      
     
      
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
    
      <script type="text/javascript" src="resource/js/angular-route.js"></script>
      <script type="text/javascript" src="resource/js/controller/PaymentDetails.js"></script>   
   	 <script src="http://code.angularjs.org/1.2.6/angular.js"></script>
   	<script src= 
"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"> 
        </script> 
         <script src="src/js/angular-datepicker.js"></script> 
  
         
   </head>
    <body>
   
    
    <body ng-controller="payment_controller" >
    
        
    <div >
	<div class="container">
	<div class="col-sm-8 col-sm-offset-2">
    
     
   
    <form name="paymentForm" method="post" ng-submit="submitForm()" novalidate>
  
       
    <label style="font-size:20px;">Payment Details:</label>
    
    <div class="form-group">
    	<lable>Name on credit/debit card</lable>
    	<input type="text" name="username" class="form-control" ng-model="paymentData.user_name" ng-minlength="1" ng-maxlength="100" required>
    	<p ng-show="paymentForm.username.$invalid && !paymentForm.username.$pristine" class="help-block">Your name is required.</p>
    </div>
    
    <div class="form-group">
    	<lable>Card number</lable>
    	<input type="text" name="creditCard" class="form-control" ng-model="paymentData.card_no" required data-credit-card-type data-ng-pattern="/^[0-9]+$/" data-ng-minlength="15" maxlength="19" placeholder="Card Number" >{{paymentData.type}}
		<br/>
    	<ul ng-show="paymentForm.creditCard.$invalid && !paymentForm.creditCard.$pristine" class="help-block">
    	<li ng-show="paymentForm.creditCard.$error.minlength">Card number must be 15-19 digits</li>
    	 <li ng-show="paymentForm.creditCard.$error.pattern">Card number must consist of only numbers</li>
    	  <li ng-show="paymentForm.creditCard.$error.invalid">Card number must be a valid Amex, Visa, Discover, or Master Card</li>
    	   <li ng-show="paymentForm.creditCard.$error.required">Card number required</li>
    	</ul>
    </div>
    
    <div class="form-group">
    	<lable>CCV</lable>
    	<input
      type="password"
      name="securityCode"
      class="form-control"
      ng-model="paymentData.ccv"
      placeholder="CCV"
      required
      data-ng-pattern="/^[0-9]+$/"
      data-ng-minlength="3"
      maxlength="4">
    <br/>
    <ul ng-show="paymentForm.securityCode.$invalid && !paymentForm.securityCode.$pristine" class="help-block">
      <li ng-show="paymentForm.securityCode.$error.pattern">Security code must contain only numbers</li>
      <li ng-show="paymentForm.securityCode.$error.minlength">Security code must be 3-4 digits</li>
      <li ng-show="paymentForm.securityCode.$error.required">Security code required</li>
    </ul>
    </div>
    
    <label>Card valid till:</label>
     <div class="form-group">
    	<lable>Month</lable>
    	<select ng-model="paymentData.month" name="month" data-card-expiration required ng-change="onMonthChange(paymentData.month)">
      <option disabled selected value="">Month</option>
      <option ng-repeat="month in months" value="{{$index+1}}" > {{$index+1}} - {{month}}</li>
    </select>
    <br/>
    <ul ng-show="paymentForm.month.$invalid && !paymentForm.month.$pristine" class="help-block">
      <li ng-show="paymentForm.month.$error.required">Expiration month required</li>
    </ul>
    </div> 
    
    <div class="form-group">
    <lable>Year</lable>
    <select ng-model="paymentData.year" name="year" data-card-expiration required ng-change="onYearChange(paymentData.year)">
      <option disabled selected value="">Year</option>
       <option ng-repeat="year in years">{{year}}</option>
    </select>
    <br/>
    <ul ng-show="paymentForm.year.$invalid && !paymentForm.year.$pristine" class="help-block">
      <li ng-show="paymentForm.year.$error.required">Expiration year required</li>
      <li ng-show="paymentForm.month.$error.invalid">Provided expiration date is invalid</li>
    </ul>    	
    </div>
    <button type="submit" class="btn btn-primary" ng-disabled="paymentForm.$invalid" ng-click='postData()'>Submit</button>
    </form>
    </div>
    </div>	
    </div>
    <div> 
            <p>{{ today | date : "dd.MM.y" }}</p> 
        </div> 
   </body>



</html>



