package app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Serie;

@Transactional
public interface SerieDao extends CrudRepository<Serie, Long>{

	//@Query("SELECT MAX(temporada)+1 FROM Serie s JOIN s.episodios WHERE s.id = :id")
	//Integer getProximaTemporada(@Param("id") Long id);
}
