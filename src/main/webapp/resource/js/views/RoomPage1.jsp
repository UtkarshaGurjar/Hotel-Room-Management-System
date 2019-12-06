<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
      <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/controller/form.js"></script>    
       <script type="text/javascript" src="resource/js/controller/Room.js"></script> 
      <script type="text/javascript" src="resource/js/angular-route.js"></script>
        <script src="resource/js/controller/Room.js"></script> 
      
     </head>
    <body style="background-color:grey;">
      
      <div class="container form_style">
      
<div class="panel panel-default" ng-show="show_images">
    <div class="panel-heading">


	<h3 style="text-align:center; font-size:50px;" class="panel-title">{{Selected_hotel_name}}</h3>
     <h2 style="text-align:center;" >{{Selected_hotel_address}}</h2>
   
    <div class="panel-body">
     <form method="post" ng-submit="showBook()">
      <div class="form-group">
      <table border = "1px" align="center">
      	<tr>
      		<th><img ng-src="resource/js/images/hotel2_room1.jpg" width="300" height="300" ng-model="roomData.roomid3"/><th>
      		<th>
      		  <td  width ="300" align="center">
      			<b>King size bed</b><br/>
      			Features:
      			<ul>
      			<li>AC</li>
      			<li>Heater</li>
      			<li>Fan</li>
      			<li>Bathing stuff</li>
      			</ul>
      			</td>
      		</th>
      		
      		<th><input type="button" ng-model="book_selection" name="room_link3" class="btn btn-primary btn-link" ng-click="doBook(book_selection='Kings Bed')" value="Book" /></th>
      	</tr>
      	      	<tr>
      		<th><img ng-src="resource/js/images/hotel2_room2.jpg" width="300" height="300" ng-model="roomData.roomid4"/><th>
      		<th>
      		  <td  width ="300" align="center">
      			<b>Double bed</b><br/>
      			Features:
      			<ul>
      			<li>AC</li>
      			<li>Heater</li>
      			</ul>
      			</td>
      		</th>
      		
      		<th><input type="button" ng-model="book_selection" name="room_link4" class="btn btn-primary btn-link" ng-click="doBook(book_selection='Double Bed')" value="Book" /></th>
      	</tr>
      	</table>
      </div>

       
     </form>
    </div>
 </div>
   </div>

</body>
</html>