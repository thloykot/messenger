app.controller("chatCtl", function ($scope, $http) {
    $scope.headerTest = function () {
        $http.post('/post',{"massage":btoa($scope.text)})
            .then(function success(response){
                document.getElementById("chat-input").value='';
                $scope.data = response.data.massage;
            })
    }

    $(function() {
        setInterval(function() {
            $http.get('/massages')
                .then(function success(response){
                    $scope.massages = response.data;
                })
        }, 1000);
    });
});