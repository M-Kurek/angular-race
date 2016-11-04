'use strict';

eventsApp.directive('greeting',
    function () {
        return {
            restrict: 'E',
            replace: true,
            template: '<button class="btn" ng-click="sayHello()">Say hello</button>',
            controller: 'GreetController'
        };
    });

/* U can put it to file in js/controllers as well */
eventsApp.controller('GreetController',
    function GreetController($scope) {
        $scope.sayHello = function () {
            alert("saying hello now !!");
        }
    });