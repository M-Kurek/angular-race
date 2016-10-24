'use strict';

eventsApp.controller('TimeoutSampleController', function ($scope, $timeout) {

    var promise = $timeout(function () {
        $scope.name = 'Pan Jan';
    }, 3000);

    $scope.cancelTimeout = function () {
        $timeout.cancel(promise);
        
    }
});