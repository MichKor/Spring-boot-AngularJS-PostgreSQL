angular.module('personApp')
    .controller('MainController', function($rootScope, $scope, $http, $state) {
        $scope.logout = function () {
          $http({ method: 'POST', url: 'logout' }).finally(function() {
            $rootScope.setLoggedOut();
            $state.transitionTo('login');
          });
        }
    });