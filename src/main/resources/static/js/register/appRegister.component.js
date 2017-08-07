angular.module('register')
    .component('register', {
    templateUrl: 'js/register/appRegister.template.html',
    controller: function($state, $http) {
        var self = this;

        self.credentials = {};
        self.register = function() {
            $http.post('register', self.credentials).then(
                function(response) {
                    self.error = false;
                    $state.transitionTo('login');
                },
                function (response) {
                    self.error = true;
                }
            )
        }
    }
});