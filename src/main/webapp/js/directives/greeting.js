'use strict';

eventsApp.directive('greeting',
    function () {
        return {
            restrict: 'E',
            replace: true,
            template: '<button class="btn" ng-click="sayHello()">Say hello</button>',
            controller : function ($scope) {
                $scope.sayHello = function () {
                    alert("saying hello");
                }
            }

        };
    });