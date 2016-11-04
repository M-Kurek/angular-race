'use strict';

eventsApp.directive('upvote',
    function ($compile) {
        return {
            restrict: 'E', //one of E,A,C,M (element, attribute, class, comment)
            replace: true,
            templateUrl : '/templates/directives/upvote.html',
            scope: {
                count: "=",     //for number
                upvote: "&",    //for function
                downvote: "&"
                //last to use : '@' - for string
            }
        };
    });