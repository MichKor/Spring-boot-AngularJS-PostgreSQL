angular.module('services.movieService').factory('movieService', function ($resource) {
    return $resource('/movies/:id', {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});
