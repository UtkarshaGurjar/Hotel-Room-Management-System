<!DOCTYPE html>
<html ng-app='MyApp'>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>BookandGo</title>
   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
  
</head>
<body ng-controller="invoice_controller">

  <table style="text-align:center; padding:30px; margin:30px;">
    <tbody ng-repeat="data in data" ng-model="invoicedata">
    
    <tr>
		<div >
        <th> Name of hotel selected :{{hotel_name}}</th>
         <th> Hotel address  :{{hotel_address}}</th>
        </tr>
         <tr >
         <td>Floor Number :{{data.room_floor}}</td>
         </tr>
     <tr >
         <td>Type of Room chosen: {{data.room_type}}</td>
         </tr>
          <tr ><td>Review room price {{data.roomPrice}}</td></tr>
        </div>
         
     
  </table>
  
  <div style="padding:30px; margin:10px;">
  <button ng-click="confirmBooking()" ng-disabled="confirmBook">Confirm Booking</button>
  <button ng-click="goBack()">Go back</button>
  <br/><Br/>
  </div>
  
   <div id="invoice" style="display:none">
           <label>Sub Total:</label>
      <input type="text"  placeholder="sale price"  
             ng-value="invoice.total" readonly="true"/><br />

     <!--  <label >Tax(2%):</label>
      <input type="text" readonly="true"  
             ng-value="invoice.tax" placeholder="tax"/>
      <label >Discount(%):</label>
      <input type="text" readonly="true"  
             ng-value="invoice.discount" 
             placeholder="discount(%)" /><br />
      <label>Total Price:</label>

      <input type="text" 
             ng-value="invoice.total+invoice.tax-invoice.discount"readonly="true" placeholder="Total price"/> -->
  
  </div>
  
</body>
</html>