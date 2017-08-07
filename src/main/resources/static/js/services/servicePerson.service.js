angular.module('services.personService').factory('personService', function ($resource) {
    return $resource('/persons/:id', {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});
