'use strict';

var eventsApp = angular.module('eventsApp', ['ngSanitize', 'ngResource', 'ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider.when('/newEvent',
            {
                templateUrl : 'templates/NewEvent.html',
                controller : 'EditEventController'
            });
        $routeProvider.when('/events',
            {
                templateUrl : 'templates/EventList.html',
                controller : 'EventListController'
            });
        $routeProvider.when('/event/:eventId',
            {
                /*
                see: $route.current
                myParam : "someValueAsParam",
                * */
                templateUrl : 'templates/EventDetails.html',
                controller : 'EventController'
            });
        $routeProvider.otherwise({redirectTo : '/events'});
    });