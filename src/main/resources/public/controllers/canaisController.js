app.controller('canaisController', ['$scope', 'dataFactory', function ($scope, dataFactory) {
	getCanais();
	
	$scope.canal = {};
	
	function getCanais() {
		dataFactory.getCanais()
		.then(function (response) {
			$scope.canais = response.data;
		}, function (response) {
			$scope.mensagem = response.statusText;
		});
	}
	
	$scope.resetaCanal = function () {
		$scope.canal = {};
	};
	
	$scope.adicionaCanal = function () {		
		dataFactory.insereCanal($scope.canal)
			.then(function (response) {
				$scope.mensagem = response.data;
				$scope.canal = {};
				getCanais();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.deletaCanal = function (id) {
		dataFactory.removeCanal(id)
			.then(function (response) {
				$scope.mensagem = response.data;
				getCanais();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.carregaCanal = function (id) {
		dataFactory.getCanal(id)
			.then(function (response) {
				$scope.canal = response.data;
			});
	};
}]);