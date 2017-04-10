(function (app) {
	app.config(appRouterConfig);

	appRouterConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

	function appRouterConfig($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("/login");

		$stateProvider.state('login', {
			url: "/login",
			controller: "LoginController",
			templateUrl: "./pages/login.html"
		}).state('sellerPage', {
			url: "/seller",
			controller: "SellerController",
			templateUrl: "./pages/seller.html",
			params: {
				user: null
			}
		}).state('sellerPage.fabrics', {
			url: "/fabrics",
			parent: 'sellerPage',
			controller: "FabricController",
			templateUrl: "./pages/seller-fabrics.html",
			params: {
				seller: null
			}
		}).state('sellerPage.garments', {
			url: "/garments",
			parent: 'sellerPage',
			controller: "GarmentController",
			templateUrl: "./pages/seller-garments.html",
			params: {
				seller: null
			}
		}).state('sellerPage.yarns', {
			url: "/yarns",
			parent: 'sellerPage',
			controller: "YarnController",
			templateUrl: "./pages/seller-yarns.html",
			params: {
				seller: null
			}
		}).state('sellerPage.rawMaterials', {
			url: "/raw-materials",
			parent: 'sellerPage',
			controller: "RawMaterialController",
			templateUrl: "./pages/seller-raw-materials.html",
			params: {
				seller: null
			}
		}).state('buyerPage', {
			url: "/buyer",
			controller: "BuyerController",
			templateUrl: "./pages/buyer.html"
		}).state('adminConsole', {
			url: "/admin",
			controller: "AdminController",
			templateUrl: "./pages/admin.html"
		});
	}

})(angular.module("myApp"));
