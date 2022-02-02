let app = angular.module('test', ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/chat", {
            templateUrl: "../message-page/chat.html"
        })
        .when("/", {
            templateUrl: "../register-page/register.html"
        })
});


