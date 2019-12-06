<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Homepage</title>
<style>
	{
	margin:0;
	padding:0;
}

body{
	font:15px/1.3 'Open Sans', sans-serif;
	color: #5e5b64;
	text-align:center;
}

a, a:visited {
	outline:none;
	color:blue;
}

a:hover{
	text-decoration:none;
}

section, footer, header, aside, nav{
	display: block;
}


/*-------------------------
	The search input
--------------------------*/


.bar{
	background-color:#5c9bb7;

	background-image:-webkit-linear-gradient(top, #5c9bb7, #5392ad);
	background-image:-moz-linear-gradient(top, #5c9bb7, #5392ad);
	background-image:linear-gradient(top, #5c9bb7, #5392ad);

	box-shadow: 0 1px 1px #ccc;
	border-radius: 2px;
	width: 400px;
	padding: 14px;
	margin: 80px auto 20px;
	position:relative;
}

.bar input{
	background:#fff no-repeat 13px 13px;
	

	border: none;
	width: 100%;
	line-height: 19px;
	padding: 11px 0;

	border-radius: 2px;
	box-shadow: 0 2px 8px #c4c4c4 inset;
	text-align: left;
	font-size: 14px;
	font-family: inherit;
	color: #738289;
	font-weight: bold;
	outline: none;
	text-indent: 40px;
}

ul{
	list-style: none;
	width: 428px;
	margin: 0 auto;
	text-align: left;
}

ul li{
	border-bottom: 1px solid #ddd;
	padding: 10px;
	overflow: hidden;
}

ul li img{
	width:60px;
	height:60px;
	float:left;
	border:none;
}

ul li p{
	margin-left: 75px;
	font-weight: bold;
	padding-top: 12px;
	color:#6e7a7f;
}
</style>	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.27/angular.min.js"></script>
<scipt src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.11/ngStorage.min.js">
<script type="text/javascript" src="resource/js/controller/form.js"></script>
	
	<!-- Initialize a new AngularJS app and associate it with a module named "instantSearch"-->
	<script type="text/javascript">

		
		</script>
	<body  ng-app="myApp" ng-controller="SearchController">
     		<div class="bar">
			<!-- Create a binding between the searchString model and the text field -->
			<input type="text" ng-model="searchString" placeholder="Enter name or location." />
			</div>
		<input type="button" name="search_button" class="btn btn-primary btn-link" ng-click="onSearch()" value="Search" />

		<ul>
			<!-- Render a li element for every entry in the items array. Notice
				 the custom search filter "searchFor". It takes the value of the
				 searchString model as an argument.
			 -->
			  <li ng-repeat="i in items">
				<img ng-src="{{i.image}}" /></a>
				<p>{{i.hotel_name}}<br>{{i.hotel_address}}</p>
				<p>{{roomavailable}}<br><a ng-href="#/roomPage/{{i.hotel_name}}/{{i.room_type}}" ng-click="roomData(i.hotel_name, i.hotel_address)">{{i.room_type}}</a><br>{{i.event_name}}<br>{{i.event_times}}</p>
			</li> 
		</ul>
		

		<!-- Include AngularJS from Google's CDN -->
		
		
			
	

</body>	
</head>
</html>	
	