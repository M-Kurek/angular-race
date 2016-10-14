'use strict';

eventsApp.controller('EventController',
    function EventController($scope) {
        $scope.event = {
            name : 'App Ang',
            date : '2016-10-12',
            time : '8 pm',
            location : {
                address: "abc",
                city : "Krk",
                state : "mpl."
            },
            imgUrl : "/img/angularjs-logo.png",
            sessions : [
                {
                    name : "name session A",
                    creatorName : 'Ante A',
                    duration : '1 hr',
                    level : 'advanced',
                    abstract : 'Lorem ipsum',
                    upVoteCount : 0
                },
                {
                    name : "session next B",
                    creatorName : 'Andy B',
                    duration : '2 hr',
                    level : '1st level',
                    abstract : 'Lorem ipsum i pruitum',
                    upVoteCount : 0
                },
                {
                    name : "another session c",
                    creatorName : 'Beta Meta',
                    duration : '5 hr',
                    level : 'interm',
                    abstract : 'Lorem ipsum interm interm',
                    upVoteCount : 0
                },
            ]
        }

        $scope.upVoteSession = function (session) {
            session.upVoteCount++;
        }
        $scope.downVoteSession = function (session) {
            session.upVoteCount--;
        }
    }
);