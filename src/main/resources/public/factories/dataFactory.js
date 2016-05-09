app.factory('dataFactory', ['$http', function ($http) {
	var dataFactory = {};
	
	dataFactory.getSeries = function () {
		return $http.get('/series');
	};
	
	dataFactory.getSerie = function (id) {
		return $http.get('/series/' + id);
	};
	
	dataFactory.insereSerie = function (serie) {
		return $http.post('/series', serie);
	};
	
	dataFactory.atualizaSerie = function (serie) {
		return $http.put('/series/' + serie.id, serie);
	};
	
	dataFactory.removeSerie = function (id) {
		return $http.delete('/series/' + id);
	};
	
	dataFactory.getCanais = function() {
		return $http.get('/canais');
	};
	
	dataFactory.getCanal = function (id) {
		return $http.get('/canais/' + id);
	};
	
	dataFactory.insereCanal = function (canal) {
		return $http.post('/canais', canal);
	};
	
	dataFactory.removeCanal = function (id) {
		return $http.delete('/canais/' + id);
	};
	
	dataFactory.getEpisodios = function() {
		return $http.get('/episodios');
	};
	
	dataFactory.getEpisodiosBySerie = function() {
		return $http.get('/episodios');
	};
	
	dataFactory.getEpisodio = function (id) {
		return $http.get('/episodios/' + id);
	};
	
	dataFactory.insereEpisodio = function (episodio) {
		episodio.serie.episodios = undefined;
		return $http.post('/episodios', episodio);
	};
	
	dataFactory.removeEpisodio = function (id) {
		return $http.delete('/episodios/' + id);
	};
	
	dataFactory.insereTemporada = function (episodios) {
		return $http.post('/temporada', episodios);
	}
	
	dataFactory.getProximaTemporada = function (id) {
		return $http.get('/maxTemporada/' + id);
	}
	
	return dataFactory;
}]);