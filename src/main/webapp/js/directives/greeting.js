'use strict';

eventsApp.directive('greeting', function () {
    return {
        restrict: 'E',
        replace: true,
        template: '<button class="btn" ng-click="sayHello()">Say hello</button>',
        controller: function ($scope) {
            var greetings = ['hello'];
            $scope.sayHello = function () {
                alert(greetings.join());
            }
            this.addGreeting = function (nextGreet) {
                greetings.push(nextGreet);
            }
        }
    };
})
    .directive('finnish', function () {
        return {
            restrict: 'A',
            require: 'greeting',
            link: function (scope, element, attrs, controller) {
                controller.addGreeting('hei');
            }
        }
    })
    .directive('polski', function () {
        return {
            restrict: 'A',
            require: 'greeting',
            link: function (scope, element, attrs, controller) {
                controller.addGreeting('czesc');
            }
        }
    })
;

/* U can put it to file in js/controllers as well */
/*
 eventsApp.controller('GreetController',
 function GreetController($scope) {
 $scope.sayHello = function () {
 alert("saying hello now !!");
 }
 });*/
