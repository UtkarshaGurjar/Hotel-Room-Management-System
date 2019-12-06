var myApp = angular.module('MyApp', ['ngStorage']);


    myApp.controller('SearchController', function($scope, $localStorage){
         debugger
    	$scope.save = function() {
            $localStorage.message = "Hello World";
        }

        $scope.load = function() {
            $scope.data = $localStorage.message;
        }

    });