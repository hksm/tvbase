app.controller('episodiosController', ['$scope', 'dataFactory', function ($scope, dataFactory) {
	
	function getSeries() {
		dataFactory.getSeries()
			.then(function (response) {
				$scope.series = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	function resetaForm() {
		$scope.episodio = {};
		dataFactory.getSerie(1)
			.then(function (response) {
				$scope.episodio.serie = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}

	getSeries();
	resetaForm();
		
	$scope.seleciona = function (id) {
		dataFactory.getSerie(id)
			.then(function (response) {
				$scope.episodio.serie = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	$scope.resetaEpisodio = resetaForm;
	
	$scope.adicionaEpisodio = function () {
		console.log($scope.episodio.dataExibicao);
		dataFactory.insereEpisodio($scope.episodio)
			.then(function (response) {
				$scope.mensagem = response.data;
				resetaForm();
				getSeries();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.deletaEpisodio = function (id) {
		dataFactory.removeEpisodio(id)
			.then(function (response) {
				$scope.mensagem = response.data;
				getSeries();
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	};
	
	$scope.carregaEpisodio = function (id) {
		dataFactory.getEpisodio(id)
			.then(function (response) {
				$scope.episodio = response.data;
			});
	};
}]);