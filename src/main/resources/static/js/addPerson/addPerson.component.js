angular.module('addPerson').component('addPerson', {
    templateUrl: 'js/addPerson/addPerson.template.html',
    controller:
        function (personService, $state, $stateParams) {
            var self = this;

            if ($stateParams.id !== null) {
                self.person = personService.get({"id" : $stateParams.id});

                self.submit = function () {
                    personService.update(self.person).$promise.then(
                        function success() {
                            $state.transitionTo('personList');
                        },
                        function failure(data) {
                            console.log(data);
                        }
                    );
                }
            }
            else {
                self.submit = function () {
                    personService.save(self.person).$promise.then(
                        function success() {
                            $state.transitionTo('personList');
                        },
                        function failure(data) {
                            console.log(data);
                        }
                    );
                }
            }
        }
});