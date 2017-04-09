(function (app) {
    app.controller("SellerController", SellerController);
    app.controller("AddFabricController", AddFabricController);
    app.controller("AddGarmentController", AddGarmentController);
    app.controller("AddYarnController", AddYarnController);
    app.controller("AddRawMaterialController", AddRawMaterialController);

    SellerController.$inject = ['$scope', '$http', '$state', '$stateParams'];

    function SellerController($scope, $http, $state, $stateParams) {

        console.log($stateParams);
        $scope.seller = $stateParams.user;

        $http.get("/sellers/search/getAllInfo/id?=" + $scope.seller.id).then(response => {
            $scope.seller = response.data._embedded.sellers[0];
            $state.go('sellerPage.fabrics', {
                seller: $scope.seller
            });
        });
    }

    AddFabricController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

    function AddFabricController($scope, $http, $state, $uibModal, $stateParams) {

        $scope.addFabric = addFabric;
        $scope.seller = $stateParams.seller;

        function addFabric() {

            modalController.$inject = ['$scope', 'item', '$http'];

            function modalController($scope, item, $http) {
                $scope.product = item.type;
                $scope.fabric = {};
            }

            let modalInstance = $uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: './pages/modals/add-product.html',
                controller: modalController,
                size: 'lg',
                resolve: {
                    item: function () {
                        return {
                            type: "Fabric"
                        };
                    }
                }
            });
            modalInstance.result.then(fabric => {
                $scope.seller.fabrics.push(fabric);
                $http.put($scope.seller._links.self.href, $scope.seller).then(response => {
                    $scope.seller = response.data;
                });
            });

        }
    }

    AddGarmentController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

    function AddGarmentController($scope, $http, $state, $uibModal, $stateParams) {


    }

    AddYarnController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

    function AddYarnController($scope, $http, $state, $uibModal, $stateParams) {


    }

    AddRawMaterialController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

    function AddRawMaterialController($scope, $http, $state, $uibModal, $stateParams) {


    }


})(angular.module("myApp"));
