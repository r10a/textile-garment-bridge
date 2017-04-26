(function (app) {
    app.controller("LoginController", LoginController);

    LoginController.$inject = ['$scope', '$http', '$state', 'USER'];

    function LoginController($scope, $http, $state, USER) {

        $scope.error = "";
        $scope.user = USER;

        $scope.login = login;
        $scope.signup = signup;

        function signup(name, email, password) {

            let url = 'users';
            $http.post(url, {
                "firstName": name,
                "email": email,
                "password": password
            }).then(response => {
                alert("User created successfully")
            }, response => {
                $scope.error = "Could not connect";
            })
        }

        function login(email, password) {
            let url = 'users/search/findByEmailIgnoreCase?email=' + email;

            $http.get(url).then(response => {
                    if (response.data._embedded.users.length) {
                        if (response.data._embedded.users[0].password == password) {
                            USER.info = response.data._embedded.users[0];
                            console.log(USER, 'Logged in');
                            $state.go('home');
                        } else {
                            $scope.error = "Incorrect Username/Password";
                        }
                    } else {
                        $scope.error = "Incorrect Username/Password";
                    }
                },
                response => {
                    $scope.error = "Could not connect";
                });
        }

        function createUser(url, user) {
            return $http.post(url, user);
        }
    }
})(angular.module("myApp"));
