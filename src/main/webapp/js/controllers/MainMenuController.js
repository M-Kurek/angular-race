'use strict';

eventsApp.controller('MainMenuController',
    function MainMenuController($scope, $location) {
        $scope.createEvent = function() {

            console.log('abs url :' + $location.absUrl());
            console.log('url :' + $location.url());
            console.log('path :' + $location.path());

            //history lock ?? why history grows?
            $location.replace();

            $location.url('/newEvent');
        };
    });
