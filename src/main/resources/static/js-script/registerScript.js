app.controller('regCtl', function ($http, $scope, $window) {

    $scope.reg = function () {
        let name = $scope.user.name;
        $http.put("/registration", {"username": name})
            .then(
                function success(response) {
                    $http.defaults.headers.common.Token = response.headers('Token');
                    $window.location.replace('#!chat');
                    connect();
                }
            )
    }

});