<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
      
      <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/controller/form.js"></script>    
      <script type="text/javascript" src="resource/js/angular-route.js"></script>

      <script src="resource/js/controller/Login.js"></script>
      <script src="resource/js/controller/Cancel.js"></script>
      <!-- Bootstrap Css -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      
      <style type="text/css">
  		background-color: lightblue;
      	.marginTop14 {
      		margin-top: 14px;
      	.confirmation-dialog
  display: none
      	}
      </style>
      
   
      
      
   </head>
    <body>
<div class="container form_style">
     <div class="alert {{alertClass}} alert-dismissible" ng-show="alertMsg">
    <a href="#" class="close" ng-click="closeMsg()" aria-label="close">&times;</a>
   </div>

   <div class="panel panel-default" ng-show="cancel_form">
    <div class="panel-heading">

	<h3 class="panel-title">Cancellation</h3>
    </div>
    <div class="panel-body">
     <form method="post" ng-submit="submitCancel()">
      <div class="form-group">
       <label>Booking ID? </label>
       <input type="text" name="bookingid" ng-model="cancelData.bookid" class="form-control" />
      </div>
      
      <div class="form-group" align="center">
      <!-- <input type="submit" name="cancel" class="btn btn-primary" value="Cancel" ng-click="myFunction()" />
         -->
      <!--   <button mw-confirm-click="showCancel()" mw-confirm-click-message="You are about to overwrite your PUBLISHED content!! Are you SURE you want to publish?"></button> --> 
       
       
		<!-- <button ng-click="showConfirm()" >Sure to delete?</button>-->
      <button ng-click="myFunction()">Cancel</button>

	<p id="demo"></p>

	



       
       </div>
     </form>
    </div>
   </div>

   </form>
   </div>  
</body>
</html>



