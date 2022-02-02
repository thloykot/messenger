app.controller("chatCtl", function ($scope, $http) {
    Head = new Headers();
    $scope.headerTest = function () {
        $http.post('/post',{"username":$http.defaults.headers.common.Token,"massage":btoa($scope.text)})
            .then(function success(response){
                $scope.data = response.data;
            })
    }

});