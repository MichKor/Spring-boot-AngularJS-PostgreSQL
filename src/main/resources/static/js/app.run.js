angular.module('personApp')
    .run(function ($rootScope, $http) {
        var self = this;

        $rootScope.username = undefined;
        self.authenticated = false;
        self.authorities = undefined;

        $rootScope.isLoggedIn = function() {
            return self.authenticated;
        };

        $rootScope.authenticate = function(credentials, callback) {
            var headers = credentials ? {authorization : "Basic "
                                         + btoa(credentials.userName + ":" + credentials.password)
                                        } : {};
            $http.get('login', {headers : headers}).then(function(response) {
                if (response.data.name) {
                    $rootScope.setLoggedIn(response.data.name, response.data.authorities);
                } else {
                    $rootScope.setLoggedOut();
                }
                callback && callback();
            }, function() {
                $rootScope.setLoggedOut();
                callback && callback();
            });
        }
        $rootScope.authenticate();

        $rootScope.setLoggedIn = function (username, authorities) {
            self.authenticated = true;
            self.authorities = authorities;
            $rootScope.username = username;
        };

        $rootScope.setLoggedOut = function () {
            self.authenticated = false;
            self.authorities = undefined;
            $rootScope.username = undefined;
        };

        $rootScope.hasAuthority = function (auth) {
            if (self.authorities === undefined) {
                return false;
            }
            for (var i = 0; i < self.authorities.length; i++) {
                if (self.authorities[i].authority === auth) {
                    return true;
                }
            };
            return false;
        };
    });