'use strict';

eventsApp.directive('repeatX', function () {
    return {
        link: function (scope, element, attrs, controller) {
            for (var i=0; i< Number(attrs.repeatX)-1; i++) {
                console.log("repeat " + i);
                element.after(element.clone().attr('repeat-x', 0));
            }
        }
    }
});
