(function (app) {
    app.controller("AdminController", AdminController);

    AdminController.$inject = ['$scope', '$http', '$state', 'USER'];

    function AdminController($scope, $http, $state, USER) {

        console.log("In admin controller");

        $scope.error = "";
        $scope.user = USER;

        $scope.login = login;

        function login(username, password) {
            let url = 'admins/' + username;
            console.log(username, password);
            $http.get(url).then(response => {
                    if (response.data.password) {
                        if (response.data.password == password) {
                            USER.info = username;
                            window.location.href = "/admin/admin-dashboard.html";
                            console.log(USER, 'Logged in');
                        } else {
                            $scope.error = "Incorrect Username/Password";
                        }
                    } else {
                        $scope.error = "Incorrect Username/Password";
                    }
                },
                response => {
                    $scope.error = "Invalid Credentials";
                });
        }

        function createUser(url, user) {
            return $http.post(url, user);
        }
    }
})(angular.module("myApp"));
