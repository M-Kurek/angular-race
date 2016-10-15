'use strict';

eventsApp.filter('durations', function () {
    return function (duration) {
        switch (duration) {
            case 1:
                return "1/2 hour";
            case 2:
                return "1 hour";
            case 3:
                return "half day";
            case 4:
                return "DAY";
        }
    }
})
