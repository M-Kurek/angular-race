'use strict';

eventsApp.directive('datePicker', function () {
    return {
        restrict: 'A',
        link: function (scope, element) {
            //calling jQuery method on element
            element.datepicker();
        }
    }
});