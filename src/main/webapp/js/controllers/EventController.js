'use strict';

eventsApp.controller('EventController',

    function EventController($scope, eventData, $routeParams, $route) {

        $scope.buttonDisabled = true;

        $scope.sortOrder = "";
        $scope.sortVotesOnly = '-upVoteCount';
        $scope.sortNamesOnly = 'name';

        $scope.reload = function () {
            $route.reload();
        }

        /*
         console.log('my param example : ' + $route.current.myParam);
         console.log('query param example : ' + $route.current.params.uKnow);
         */

        console.log('query for event #' + $route.current.pathParams.eventId);

        $scope.event = $route.current.locals.event;

/*        //with promise
        eventData.getEvent($routeParams.eventId)
            .$promise
            .then(function (event) {
                $scope.event = event;
                console.log("GET returning :" + event);
            })
            .catch(function (response) {
                console.log("failed : " + response);
            });*/
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
