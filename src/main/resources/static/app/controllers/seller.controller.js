(function (app) {
    app.controller("SellerController", SellerController);

    SellerController.$inject = ['$scope', '$http', '$state', '$stateParams', '$uibModal', 'USER'];

    function SellerController($scope, $http, $state, $stateParams, $uibModal, USER) {

        $scope.viewFabrics = viewFabrics;
        $scope.viewGarments = viewGarments;
        $scope.viewYarns = viewYarns;
        $scope.viewMaterials = viewMaterials;
        $scope.addProduct = addProduct;

        activate();

        function activate() {
            viewFabrics();
        }

        function addProduct() {

            modalController.$inject = ['$scope'];

            function modalController($scope) {
                $scope.choice = "fabrics";
            }

            let modalInstance = $uibModal.open({
                animation: true,
                size: 'lg',
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: './pages/modals/product-choice.html',
                controller: modalController
            });

            modalInstance.result.then((choice) => {

                let productAddTemplateURL = "";

                switch (choice) {
                    case "fabrics":
                        productAddTemplateURL = './pages/modals/add-fabric.html';
                        break;
                    case "garments":
                        productAddTemplateURL = './pages/modals/add-garment.html';
                        break;
                    case "yarns":
                        productAddTemplateURL = './pages/modals/add-yarn.html';
                        break;
                    case "raw-materials":
                        productAddTemplateURL = './pages/modals/add-raw-material.html';
                        break;
                }

                addProductController.$inject = ['$scope'];

                function addProductController($scope) {
                    $scope.product = {};
                }

                let addProductInstance = $uibModal.open({
                    animation: true,
                    size: 'lg',
                    ariaLabelledBy: 'modal-title',
                    ariaDescribedBy: 'modal-body',
                    templateUrl: productAddTemplateURL,
                    controller: addProductController
                });

                addProductInstance.result.then((product) => {
                    let url = "";
                    let putLink = "";
                    let listedProduct = "";
                    let transaction = "";
                    switch (choice) {
                        case "fabrics":
                            url = '/fabrics';
                            putLink = USER.info._links.listedFabrics.href;
                            listedProduct = "listedFabrics";
                            transaction = "Listed a fabric for selling";
                            break;
                        case "garments":
                            url = '/garments';
                            putLink = USER.info._links.listedGarments.href;
                            listedProduct = "listedGarments";
                            transaction = "Listed a Garment for selling";
                            break;
                        case "yarns":
                            url = '/yarns';
                            putLink = USER.info._links.listedYarns.href;
                            listedProduct = "listedYarns";
                            transaction = "Listed a Yarn for selling";
                            break;
                        case "raw-materials":
                            url = '/raw-materials';
                            putLink = USER.info._links.listedRawMaterials.href;
                            listedProduct = "listedRawMaterials";
                            transaction = "Listed a Raw Material for selling";
                            break;
                    }

                    $http.post(url, product).then(savedProduct => {
                        console.log(savedProduct);

                        let summary = {};
                        summary.username = USER.info.email;
                        summary.transaction = transaction + " with name: " + savedProduct.data.name;
                        summary.date = new Date();

                        $http.post('/transactions', summary).then(response => console.log(response, "logged successfully"));

                        let uriList = "";
                        $http.get(USER.info._links[listedProduct].href).then(response => {
                            let products = response.data._embedded[choice];
                            console.log(products);
                            for (let product of products) {
                                uriList += product._links.self.href + '\n';
                            }
                            uriList += savedProduct.data._links.self.href;
                            console.log(uriList);

                            return $http.put(putLink, uriList, {
                                headers: {
                                    'Content-Type': 'text/uri-list'
                                }
                            });
                        }).then(response => {
                            console.log(response);
                            viewFabrics();
                        });
                    });

                }, () => {});

            }, () => {});
        }

        function viewFabrics() {
            $http.get(USER.info._links.listedFabrics.href).then(response => {
                $scope.products = response.data._embedded.fabrics;
            });
        }

        function viewGarments() {
            $http.get(USER.info._links.listedGarments.href).then(response => {
                $scope.products = response.data._embedded.garments;
            });
        }

        function viewYarns() {
            $http.get(USER.info._links.listedYarns.href).then(response => {
                $scope.products = response.data._embedded.yarns;
            });
        }

        function viewMaterials() {
            $http.get(USER.info._links.listedRawMaterials.href).then(response => {
                $scope.products = response.data._embedded["raw-materials"];
            });
        }



    }

})(angular.module("myApp"));
