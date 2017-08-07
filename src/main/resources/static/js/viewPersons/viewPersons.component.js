angular.module('viewPersons').component('viewPersons', {
    templateUrl: 'js/viewPersons/viewPersons.template.html',
    controller:
        function (personService, $state) {
            var self = this;

            self.persons = personService.query();

            self.edit = function (id) {
                $state.go('addPerson', {"id": self.persons[id].id});
            }

            self.delete = function (id) {
                personService.remove({"id" : self.persons[id].id}).$promise.then(
                    function () {
                        self.persons.splice(id, 1);
                    }
                );
            }
        }
});