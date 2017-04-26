(function (app) {
    app.controller("HomeController", HomeController);

    HomeController.$inject = ['$scope', '$http', '$state', '$uibModal', 'CART'];

    function HomeController($scope, $http, $state, $uibModal, CART) {

        $scope.products = [];

        let prefix = "http://localhost:8080";

        $scope.viewFabrics = viewFabrics;
        $scope.viewGarments = viewGarments;
        $scope.viewYarns = viewYarns;
        $scope.viewMaterials = viewMaterials;
        $scope.addToCart = addToCart;
        $scope.productDetails = productDetails;

        activate();

        function activate() {
            viewFabrics();
        }

        function addToCart(product) {
            CART.products.add(product);
        }

        function productDetails(product) {

            modalController.$inject = ['$scope'];

            function modalController($scope) {
                $scope.product = product;
                $scope.addToCart = addToCart;
            }

            let modalInstance = $uibModal.open({
                animation: true,
                size: 'lg',
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: './pages/modals/product-details-popup.html',
                controller: modalController
            });

            modalInstance.result.then(() => {}, () => {});
        }

        function viewFabrics() {
            $http.get(prefix + '/fabrics').then(response => {
                $scope.products = response.data._embedded.fabrics;
            });
        }

        function viewGarments() {
            $http.get(prefix + '/garments').then(response => {
                $scope.products = response.data._embedded.garments;
            });
        }

        function viewYarns() {
            $http.get(prefix + '/yarns').then(response => {
                $scope.products = response.data._embedded.yarns;
            });
        }

        function viewMaterials() {
            $http.get(prefix + '/raw-materials').then(response => {
                $scope.products = response.data._embedded["raw-materials"];
            });
        }


    }
})(angular.module("myApp"));
