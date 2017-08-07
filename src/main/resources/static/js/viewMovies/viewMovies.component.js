angular.module('viewMovies').component('viewMovies', {
    templateUrl: 'js/viewMovies/viewMovies.template.html',
    controller:
        function (movieService, $state) {
            var self = this;

            self.movies = movieService.query();

            self.edit = function (id) {
                $state.go('addMovie', {"id": self.movies[id].id});
            }

            self.delete = function (id) {
                movieService.remove({"id" : self.movies[id].id}).$promise.then(
                    function () {
                        self.movies.splice(id, 1);
                    }
                );
            }
        }
});