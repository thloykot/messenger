app.controller('regCtl', function ($http, $scope,$window) {

    $scope.reg = function () {
        let name = $scope.user.name;
        let token = btoa( name + ":" + new Date().toUTCString());
        $http.defaults.headers.common.Token = token;
        $http.put("/registration", {"username": name,"token": token})
            .then(
            function success() {
                $window.location.replace('#!chat');
            }
        )
    }

});