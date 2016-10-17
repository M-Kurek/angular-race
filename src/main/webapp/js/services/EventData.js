eventsApp.factory('eventData', function () {
    return {
        event: {
            name: 'Angular_js supported',
            date: '2016-10-12',
            time: '8 pm',
            price: 23,
            location: {
                address: "abc",
                city: "Krk",
                state: "mpl."
            },
            imgUrl: "/img/angularjs-logo.png",
            sessions: [
                {
                    name: "name session A",
                    creatorName: 'Ante A',
                    duration: 1,
                    level: 'advanced',
                    abstract: 'Lorem ipsum',
                    upVoteCount: 0
                },
                {
                    name: "session next B",
                    creatorName: 'Andy B',
                    duration: 2,
                    level: '1st level',
                    abstract: 'Lorem ipsum i pruitum',
                    upVoteCount: 0
                },
                {
                    name: "another session c",
                    creatorName: 'Beta Meta',
                    duration: 4,
                    level: 'intermediate',
                    abstract: 'Lorem ipsum interm interm',
                    upVoteCount: 0
                },
            ]
        }
    };
});