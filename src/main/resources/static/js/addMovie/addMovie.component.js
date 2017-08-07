angular.module('addMovie').component('addMovie', {
    templateUrl: 'js/addMovie/addMovie.template.html',
    controller:
        function (movieService, personService, $state, $stateParams) {
            var self = this;

            self.persons = personService.query();

            if ($stateParams.id !== null) {
                self.movie = movieService.get({"id" : $stateParams.id});

                self.submit = function () {
                    movieService.update(self.movie).$promise.then(
                        function success() {
                            $state.transitionTo('movieList');
                        },
                        function failure(data) {
                            console.log(data);
                        }
                    );
                }
            }
            else {
                self.submit = function () {
                    movieService.save(self.movie).$promise.then(
                        function success() {
                            $state.transitionTo('movieList');
                        },
                        function failure(data) {
                            console.log(data);
                        }
                    );
                }
            }
        }
});

angular.module('addMovie')
    .directive('personList',
        function() {
            return {
                restrict: 'E',
                replace: true,
                scope: {
                    list: "=",
                    model: "="
                },
                template: "<select ng-model=\"model.id\" ng-options=\"person.id as person.pesel for person in list | orderBy: 'pesel'\">" +
                "<option value=\"\">No people in the database</option></select>"
            };
        }
    );