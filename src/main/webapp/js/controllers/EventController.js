'use strict';

eventsApp.controller('EventController',
    function EventController($scope, eventData) {

        $scope.snippet = '<span style="color:red">hi there</span>';

        $scope.buttonDisabled = true;

        $scope.sortOrder = "";
        $scope.sortVotesOnly = '-upVoteCount';
        $scope.sortNamesOnly = 'name';

        $scope.event = eventData.event;

        $scope.upVoteSession = function (session) {
            session.upVoteCount++;
        }
        $scope.downVoteSession = function (session) {
            session.upVoteCount--;
        }
    })
