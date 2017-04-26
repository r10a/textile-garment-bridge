(function (app) {
    app.controller("CartController", CartController);

    CartController.$inject = ['$scope', '$http', '$state', '$uibModal', 'CART'];

    function CartController($scope, $http, $state, $uibModal, CART) {

        $scope.subTotal = 0;
        $scope.ecoTax = 20;
        $scope.total = 0;


        $scope.deleteProduct = deleteProduct;
        $scope.checkout = checkout;

        activate();

        function activate() {
            $scope.products = Array.from(CART.products);
            $scope.subTotal = $scope.products.reduce((acc, product) => acc += product.price, 0);
            $scope.total = $scope.subTotal + $scope.ecoTax;
        }

        function deleteProduct(product) {
            CART.products.delete(product);
            activate();
        }

        function checkout() {
            //TODO
        }




    }
})(angular.module("myApp"));
