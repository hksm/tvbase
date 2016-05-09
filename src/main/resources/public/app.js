var app = angular.module('tvbase', ['ui.bootstrap', 'mgcrea.ngStrap', 'ngRoute', 'ngAnimate']);

app.config(['$routeProvider', function ($routeProvider) {
	$routeProvider
		.when('/', {
			controller: 'seriesController',
			templateUrl: 'partials/series.html'
	    })
	    .when('/canais', {
	    	controller: 'canaisController',
	    	templateUrl: 'partials/canais.html'
	    })
	    .when('/series/:id', {
	    	controller: 'serieController',
	    	templateUrl: 'partials/serie.html'
	    })
	    .when('/episodios', {
	    	controller: 'episodiosController',
	    	templateUrl: 'partials/episodios.html'
	    })
		.otherwise({
			redirectTo:'/'
		});
}]);