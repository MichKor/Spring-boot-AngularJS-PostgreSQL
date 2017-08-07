angular.module('personApp', [
    'ui.router',
    'ngResource',
    'login',
    'register',
    'viewPersons',
    'viewMovies',
    'addPerson',
    'addMovie',
    'services.personService',
    'services.movieService'
]);