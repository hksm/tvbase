app.controller('serieController', ['$scope', '$routeParams', '$modal', 'dataFactory', 
                                   function($scope, $routeParams, $modal, dataFactory) {	
	
	function getSerie(id) {
		dataFactory.getSerie(id)
			.then(function (response) {
				$scope.serie = response.data;
			}, function (response) {
				$scope.mensagem = response.statusText;
			});
	}
	
	function getProximaTemporada() {
		dataFactory.getProximaTemporada($routeParams.id)
			.then(function (response) {
				if (response.data !== '') {
					$scope.proximaTemporada = response.data;
				} else {
					$scope.proximaTemporada = 1;
				}
			});
	}
	
	getSerie($routeParams.id);
		
	getProximaTemporada();
	
	/*$scope.showModal = function() {
		$modal({
			animation: 'am-fade-and-slide-top',
			controller: 'temporadaController',
			templateUrl: 'partials/temporadaModal.html',
			resolve: {
				serie: function() {
					return $scope.serie;
				},
				temporada: function() {
					return $scope.proximaTemporada;
				} 
			},
			show: true
		});
	};*/
}]);