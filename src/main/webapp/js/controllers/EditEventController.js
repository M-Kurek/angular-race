'use strict';

eventsApp.controller('EditEventController',
    function EditEventController($scope, eventData) {

        $scope.saveEvent = function (event, newEventForm) {
            if(newEventForm.$valid) {
                eventData.save(event)
                    .$promise
                    .then(function (response) {
                        console.log("saved ", response);
                    })
                    .catch(function (response) {
                        console.log("save failure : ", response);
                    });
            }
        }

        $scope.cancelEdit = function () {
            window.location = "/templates/EventDetails.html";
        }

    })
