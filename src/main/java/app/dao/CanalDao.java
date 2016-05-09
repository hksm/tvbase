package app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Canal;

@Transactional
public interface CanalDao extends CrudRepository<Canal, Long> {

}
