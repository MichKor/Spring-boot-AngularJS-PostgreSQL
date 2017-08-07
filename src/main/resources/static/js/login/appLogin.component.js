angular.module('login')
    .component('login', {
    templateUrl: 'js/login/appLogin.template.html',
    controller: function($rootScope, $state) {
        var self = this;
        self.credentials = {};

        if ($rootScope.isLoggedIn()) {
            $state.transitionTo('personApp');
        }

        self.login = function() {
            $rootScope.authenticate(self.credentials, function() {
                if ($rootScope.isLoggedIn()) {
                    $state.transitionTo('personApp');
                    self.error = false;
                } else {
                    self.error = true;
                }
            });
        };
    }
});