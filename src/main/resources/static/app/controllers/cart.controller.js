(function (app) {
    app.controller("CartController", CartController);

    CartController.$inject = ['$scope', '$http', '$state', '$uibModal', 'CART', 'USER'];

    function CartController($scope, $http, $state, $uibModal, CART, USER) {

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
            let boughtProduct = "";
            let uriList = "";
            let collectionName = "";
            let putLink = "";
            let transaction = "";
            for (let product of $scope.products) {
                if (product._links.hasOwnProperty("fabricModel")) {
                    boughtProduct = "boughtFabrics";
                    collectionName = "fabrics";
                    putLink = USER.info._links.boughtFabrics.href;
                    transaction = "Bought a fabric";
                } else if (product._links.hasOwnProperty("yarnModel")) {
                    boughtProduct = "boughtYarns";
                    collectionName = "yarns";
                    putLink = USER.info._links.boughtYarns.href;
                    transaction = "Bought a yarn";
                } else if (product._links.hasOwnProperty("garmentModel")) {
                    boughtProduct = "boughtGarments";
                    collectionName = "garments";
                    putLink = USER.info._links.boughtGarments.href;
                    transaction = "Bought a garment";
                } else if (product._links.hasOwnProperty("rawMaterialModel")) {
                    boughtProduct = "boughtRawMaterials";
                    collectionName = "raw-materials";
                    putLink = USER.info._links.boughtRawMaterials.href;
                    transaction = "Bought a raw material";
                }

                let summary = {};
                summary.username = USER.info.email;
                summary.transaction = transaction + " with name: " + product.name;
                summary.date = new Date();

                $http.post('/transactions', summary).then(response => console.log(response, "logged successfully"));


                $http.get(USER.info._links[boughtProduct].href).then(response => {
                    let products = response.data._embedded[collectionName];
                    console.log(products);
                    for (let product of products) {
                        uriList += product._links.self.href + '\n';
                    }
                    uriList += product._links.self.href;
                    console.log(uriList);

                    return $http.put(putLink, uriList, {
                        headers: {
                            'Content-Type': 'text/uri-list'
                        }
                    });
                }).then(response => {
                    console.log(response);
                });
            }
            alert("Products purchased successfully!");
            CART.products.clear();
        }




    }
})(angular.module("myApp"));
