'use strict';

eventsApp.controller('EventController',

  function EventController($scope, eventData, $routeParams) {

        $scope.buttonDisabled = true;

        $scope.sortOrder = "";
        $scope.sortVotesOnly = '-upVoteCount';
        $scope.sortNamesOnly = 'name';

        //with promise

        eventData.getEvent($routeParams.eventId)
            .$promise
            .then(function (event) {
                $scope.event = event;
                console.log("GET returning :" + event);
            })
            .catch(function (response) {
                console.log("failed : " + response);
            });
        /*
         directly
         $scope.event = eventData.getEvent();
         */

        //not REST - usage with $http
        /*        eventData.getEvent()
         .success(function (event) {$scope.event = event})
         .error(function (data, status, headers, config) {
         $log.warn(data, status, headers(), config)
         });*/

        $scope.upVoteSession = function (session) {
            session.upVoteCount++;
        }
        $scope.downVoteSession = function (session) {
            session.upVoteCount--;
        }
});
