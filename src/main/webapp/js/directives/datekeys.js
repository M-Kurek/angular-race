'use strict';

eventsApp.directive('dateKeys',
    function() {
        return {
            restrict: 'A',
            link: function (scope, element, attrs, controller) {
                element.on('keydown', function (event) {
                    return isNumeric(event.keyCode) || isForwardSlash(event.keyCode) || isNavigationKeycode(event.keyCode);
                })
            }
        };
        function isForwardSlash(keyCode) {
            return keyCode === 191;
        }
        function isNumeric(keyCode) {
            return (keyCode > 47 && keyCode < 58) || (keyCode > 95 && keyCode < 106);
        }
        function isNavigationKeycode(keyCode) {
            switch (keyCode) {
                case 8: //backspace
                case 35: //end
                case 36: //home
                case 37: //left
                case 38: //up
                case 39: //right
                case 40: //down
                case 45: //ins
                case 46: //del
                    return true;
                default:
                    return false;
            }
        }
    });