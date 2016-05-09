app.controller('temporadaController', ['$scope', '$filter', 'serie', 'temporada', 'dataFactory', function ($scope, $filter, serie, temporada, dataFactory) {

	$scope.temporada = temporada;
	$scope.episodios = [];
	serie.episodios = undefined;
	
	$scope.adicionaEpisodioInput = function () {
		$scope.episodios.push({
			'numero': $scope.episodios.length+1
		});
	};
    
	$scope.removeEpisodioInput = function () {
		var ultimoEpisodio = $scope.episodios.length-1;
		$scope.choices.splice(ultimoEpisodio);
	};
	
	// datePicker
	$scope.dataPrimeiro = new Date();
	$scope.open = function ($event) {
		$scope.status.opened = true;
	};
	$scope.status = {
		opened: false
	};
	
	$scope.gerarEpisodios = function () {
		var dataExib = $scope.dataPrimeiro;
		var i = 1;
		var last = $scope.numEpisodios;
		if ($scope.episodios.length != 0) {
			i += $scope.episodios.length;
			last += $scope.episodios.length;
		}
		
		for (i; i <= last; i++) {
			$scope.episodios.push({
				'serie': ($scope.episodios.length > 0 ? serie.id : serie),
				'temporada': $scope.temporada,
				'numero': i,
				'dataExibicao': $filter('date')(dataExib,'yyyy-MM-dd')
			});
			
			var novaData = new Date(dataExib);
			novaData.setDate(dataExib.getDate() + 7);
			dataExib = novaData;
		}
	};
	
	$scope.bindHideModalFunction = function(hideModalFunction){
	    $scope.hideModal = hideModalFunction;
	}
	
	$scope.salvar = function () {
		dataFactory.insereTemporada($scope.episodios)
			.then(function (response) {
				$scope.hideModal();
			}, function (response) {
				console.log(response.status + ": " + response.statusText);
			});
	}
}]);