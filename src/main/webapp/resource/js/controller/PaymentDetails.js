// app.js
// create angular app

var validationApp = angular.module('app', []);

// create angular controller
validationApp.controller('payment_controller', function($scope, $http) {
	
	$scope.submitForm=function(){	
		debugger
	  var name=$scope.name;
	
  };
  
  it('should check ng-bind', function() {
  var nameInput = element(by.model('bookid'));

  expect(element(by.binding('bookid')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('bookid')).getText()).toBe('world');
});

it('should check ng-bind', function() {
  var nameInput = element(by.model('paymentid'));

  expect(element(by.binding('paymentid')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('paymentid')).getText()).toBe('world');
});

it('should check ng-bind', function() {
  var nameInput = element(by.model('roomprice'));

  expect(element(by.binding('roomprice')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('roomprice')).getText()).toBe('world');
});
  

});
