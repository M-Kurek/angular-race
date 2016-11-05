'use strict';

eventsApp.directive('repeatX', function () {
    return {
        compile: function (element, attrs) {
            for (var i = 0; i < Number(attrs.repeatX) - 1; i++) {
                console.log("repeat " + i);
                element.after(element.clone().attr('repeat-x', 0));
            }
            //compile can return linking function:
            return function (scope, element, attrs, controller) {
                attrs.$observe('text', function (newValue) {
                    if (newValue === 'Hello you') {
                        element.css('color', 'red');
                    }
                });
            }
        }
    };
});
