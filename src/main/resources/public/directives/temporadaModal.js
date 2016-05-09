app.directive('temporadaModal', ['$modal', 'dataFactory', function($modal, dataFactory) {
	return {
		restrict: 'E',
		scope: {
			serie: '='
		},
		template: '<button type="button" class="btn btn-default" ng-click="showModal()">Adicionar Temporada</button>',
		link: function (scope, element, attrs) {

			scope.$watch('serie', function(serie) {
				if(serie) {
					dataFactory.getProximaTemporada(scope.serie.id)
						.then(function (response) {
							if (response.data !== '') {
								scope.proximaTemporada = response.data;
							} else {
								scope.proximaTemporada = 1;
							}
						});
				}
			});
			
			scope.showModal = function() {
				$modal({
					animation: 'am-fade-and-slide-top',
					controller: 'temporadaController',
					templateUrl: 'partials/temporadaModal.html',
					resolve: {
						serie: function() {
							return scope.serie;
						},
						temporada: function() {
							return scope.proximaTemporada;
						}
					},
					show: true
				});
			};
		}
	};
}]);