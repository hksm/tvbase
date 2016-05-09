package app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import app.model.Episodio;
import app.model.Serie;

@Transactional
public interface EpisodioDao extends CrudRepository<Episodio, Long>{

	@Query("SELECT MAX(temporada)+1 FROM Episodio WHERE serie = :serie")
	Integer getProximaTemporada(@Param("serie") Serie serie);
	
}
