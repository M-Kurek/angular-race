'use strict';

eventsApp.directive('mySample',
    function ($compile) {
        return {
            link: function(scope, element, atributes, controller) {
                var markup = "<input type='text' ng-model='sampleData' />{{sampleData}}<br/>";
                angular.element(element).html($compile(markup)(scope));
            }
        };
    }
);