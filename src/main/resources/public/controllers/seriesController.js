app.controller('seriesController', ['$scope', 'dataFactory', function ($scope, dataFactory) {	
	
	function getSeries() {
		dataFactory.getSeries()
			.then(function (response) {
				$scope.series = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	function getCanais() {
		dataFactory.getCanais()
			.then(function (response) {
				$scope.canais = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	function resetaForm() {
		$scope.serie = {
				canal: {
					id: 1,
					nome: 'ABC'
				}
		};
	}
	
	getSeries();
	getCanais();
	resetaForm();
	
	$scope.seleciona = function (id) {
		dataFactory.getCanal(id)
			.then(function (response) {
				$scope.serie.canal = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	$scope.resetaSerie = resetaForm;
	
	$scope.adicionaSerie = function () {		
		dataFactory.insereSerie($scope.serie)
			.then(function (response) {
				$scope.mensagem = response.data;
				resetaForm();
				getSeries();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.deletaSerie = function (id) {
		dataFactory.removeSerie(id)
			.then(function (response) {
				$scope.mensagem = response.data;
				getSeries();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.carregaSerie = function (id) {
		dataFactory.getSerie(id)
			.then(function (response) {
				$scope.serie = response.data;
			});
		
	};
}]);