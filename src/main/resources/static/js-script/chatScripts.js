app.controller("chatCtl", function ($scope, $http) {

    $scope.headerTest = function () {
        $http.post('/post', {"massage": btoa($scope.text)})
            .then(function success(response) {
                document.getElementById("chat-input").value = '';
                $scope.data = response.data.massage;

            })
    }
});