(function (app) {

    app.value('CART', (function () {
        return {
            "products": new Set()
        }
    })());

    app.value('USER', (function () {
        return {
            "info": null
        };
    })());

    app.config(appRouterConfig);

    appRouterConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function appRouterConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/home");

        $stateProvider.state('home', {
            url: "/home",
            controller: "HomeController",
            templateUrl: "./pages/home.html"
        }).state('products', {
            url: "/products",
            controller: "ProductsController",
            templateUrl: "./pages/products.html"
        }).state('cart', {
            url: "/cart",
            controller: "CartController",
            templateUrl: "./pages/cart.html"
        }).state('login', {
            url: "/login",
            controller: "LoginController",
            templateUrl: "./pages/login.html"
        }).state('sell', {
            url: "/sell",
            controller: "SellerController",
            templateUrl: "./pages/products-seller.html"
        });
    }

})(angular.module("myApp"));
