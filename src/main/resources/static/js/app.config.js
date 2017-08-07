angular.module('personApp').config(function($stateProvider, $urlServiceProvider, $httpProvider) {

    $stateProvider
        .state('personApp', {
            url: "/",
            templateUrl: "../index.html"
        })
        .state('login', {
            url: '/login',
            component: 'login'
        })
        .state('register', {
            url: '/register',
            component: 'register'
        })
        .state('personList', {
            url: '/personList',
            component: 'viewPersons'
        })
        .state('addPerson', {
            url: '/addPerson',
            params: {
                "id": null
            },
            component: 'addPerson'
        })
        .state('movieList', {
            url: '/movieList',
            component: 'viewMovies'
        })
        .state('addMovie', {
            url: '/addMovie',
            params: {
                "id": null
            },
            component: 'addMovie'
        });

    $urlServiceProvider.rules.otherwise({ state: 'login' });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});