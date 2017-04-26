(function (app) {
    app.controller("IndexController", IndexController);

    IndexController.$inject = ['$scope', '$http', '$state', 'USER'];

    function IndexController($scope, $http, $state, USER) {

        $scope.account = account;
        $scope.user = USER;

        function account() {
            console.log(USER);
            if (USER.info) {

            } else {
                $state.go('login');
            }
        }

    }
})(angular.module("myApp"));
