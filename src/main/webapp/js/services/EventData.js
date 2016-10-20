eventsApp.factory('eventData', function ($resource) {

    var resource = $resource('/data/event/:id', {id: '@id'});

    return {
        //REST version :
        getEvent: function () {
            return resource
                .get({id: 2});
            //not REST :
//            return $http({method :'GET', url: '/data/event/2'});
        },

        save: function (event) {
            return $resource('/data/event/create').save(event);
        }
    };
});