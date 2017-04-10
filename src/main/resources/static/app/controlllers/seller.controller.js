(function (app) {
	app.controller("SellerController", SellerController);
	app.controller("FabricController", FabricController);
	app.controller("GarmentController", GarmentController);
	app.controller("YarnController", YarnController);
	app.controller("RawMaterialController", RawMaterialController);

	SellerController.$inject = ['$scope', '$http', '$state', '$stateParams'];

	function SellerController($scope, $http, $state, $stateParams) {

		activate();
		//		testPage();
		function activate() {
			$scope.seller = $stateParams.user;
			console.log(angular.toJson($scope.seller));
			$state.go('sellerPage.fabrics', {
				seller: $scope.seller
			});
		}

		function testPage() {
			$http.get('./app/data/seller.json').then(response => {
				$scope.seller = response.data;
				console.log($scope.seller);
			});
		}

	}

	FabricController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

	function FabricController($scope, $http, $state, $uibModal, $stateParams) {

		$scope.fabrics = [];
		$scope.addFabric = addFabric;
		$scope.seller = $stateParams.seller;

		activate();

		function activate() {
			$http.get($scope.seller._links.fabrics.href).then(response => {
				$scope.fabrics = response.data._embedded.fabrics;
			});
		}

		function addFabric() {

			modalController.$inject = ['$scope', '$http'];

			function modalController($scope, $http) {
				$scope.fabric = {};
			}

			let modalInstance = $uibModal.open({
				animation: true,
				ariaLabelledBy: 'modal-title',
				ariaDescribedBy: 'modal-body',
				templateUrl: './pages/modals/add-fabric.html',
				controller: modalController
			});

			modalInstance.result.then(fabric => {
				$http.post($scope.seller._links.fabrics.href, fabric).then(response => {
					activate();
				});
			});

		}
	}

	GarmentController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

	function GarmentController($scope, $http, $state, $uibModal, $stateParams) {


	}

	YarnController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

	function YarnController($scope, $http, $state, $uibModal, $stateParams) {


	}

	RawMaterialController.$inject = ['$scope', '$http', '$state', '$uibModal', '$stateParams'];

	function RawMaterialController($scope, $http, $state, $uibModal, $stateParams) {


	}


})(angular.module("myApp"));
