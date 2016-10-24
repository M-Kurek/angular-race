'use strict';

eventsApp.controller('CookieSampleController',
    function CookieSampleController($scope, $cookieStore) {

        $scope.event = { id : 1, name : '1st event'};

        $scope.saveAsCookie = function (event) {
            $cookieStore.put('event', event);
        };

        $scope.getCookie = function () {
            console.log($cookieStore.get('event'));
        };

        $scope.removeCookie = function () {
            $cookieStore.remove('event');
        };
    });