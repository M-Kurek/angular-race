'use strict';

eventsApp.controller('EditEventController',
    function EditEventController($scope) {

        $scope.saveEvent = function (event, newEventForm) {
            if(newEventForm.$valid) {
                window.alert("to save : " +event.name)
            }
        }

        $scope.cancelEdit = function () {
            window.location = "/EventDetails.html";
        }

    })
