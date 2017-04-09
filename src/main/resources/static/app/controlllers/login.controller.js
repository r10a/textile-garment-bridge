(function (app) {
    app.controller("LoginController", LoginController);

    LoginController.$inject = ['$scope', '$http', '$state'];

    function LoginController($scope, $http, $state) {

        $scope.hasLogin = true;
        $scope.isUser = true;
        $scope.type = "/sellers";

        $scope.login = login;

        function login() {
            if ($scope.isUser) {

                if ($scope.hasLogin) {
                    let url = $scope.type + '/search/findByEmail?email=' + $scope.email;
                    getUser(url).then(response => {  
                        console.log(response);
                        if (response.data._embedded.sellers[0].password == $scope.inputpassword) {
                            if ($scope.type == "/sellers") {
                                $state.go("sellerPage", {
                                    user: response.data._embedded.sellers[0]
                                });
                            } else {
                                $state.go("buyerPage", {
                                    user: response.data._embedded.sellers[0]
                                });
                            }
                        } else {

                        }
                    });
                } else {
                    let user = {
                        firstName: $scope.firstName,
                        lastName: $scope.lastName,
                        email: $scope.email,
                        password: $scope.password,
                        mobile: $scope.mobile,
                        address: $scope.address,
                        type: $scope.type
                    };

                    createUser($scope.type, user).then(response => {
                        $scope.hasLogin = true;
                        $scope.password = "";
                    });
                }
            } else {

                let url = '/admins/search/findByEmail?email=' + $scope.email;
                getUser(url).then(response => {
                    if (response.data._embedded.admins[0].password == $scope.inputpassword) {
                        $state.go("adminConsole", {
                            admin: response.data._embedded.sellers[0]
                        })
                    }
                });
            }
        }

        function getUser(url) {
            return $http.get(url);
        }

        function createUser(url, user) {
            return $http.post(url, user);
        }
    }
})(angular.module("myApp"));
