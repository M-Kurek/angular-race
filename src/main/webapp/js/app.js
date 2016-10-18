'use strict';

var eventsApp = angular.module('eventsApp', ['ngSanitize'])
    .factory('myCache', function($cacheFactory) {
        return $cacheFactory('myCache', {capacity:3});
    });
