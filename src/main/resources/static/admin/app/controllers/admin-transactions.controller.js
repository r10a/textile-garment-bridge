(function (app) {
    app.controller("AdminTransactionsController", AdminTransactionsController);

    AdminTransactionsController.$inject = ['$scope', '$http', '$state'];

    function AdminTransactionsController($scope, $http, $state, USER) {
    	
    	$scope.transactions = {};
    	$scope.convertDate = convertDate;
    	
    	$http.get('/transactions').then(response => {
    		$scope.transactions = response.data._embedded.transactions;
    		console.log($scope.transactions);
    	});
    	
    	function convertDate(date){
    		return moment(date).format('hh:mm A MM/DD/YY')
    	}
    	
    }
})(angular.module("admin"));
