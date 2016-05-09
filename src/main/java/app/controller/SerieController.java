package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dao.SerieDao;
import app.model.Serie;

@RestController
public class SerieController {

	@Autowired
	private SerieDao serieDao;

	@RequestMapping(value="/series", method=RequestMethod.GET)
	public List<Serie> lista() {
		return (List<Serie>) serieDao.findAll();
	}
	
	@RequestMapping(value="/series/{id}", method=RequestMethod.GET)
	public Serie getSerieById(@PathVariable Long id) {
		return serieDao.findOne(id);
	}
	
	/*@RequestMapping(value="/series/{id}/episodios", method=RequestMethod.GET)
	public Set<Episodio> getEpisodioBySerie(Long id) {
		return ;
	}*/
	
	@RequestMapping(value="/series", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String adiciona(@RequestBody Serie serie) {
		try {
			serieDao.save(serie);
		} catch(Exception e) {
			return "Erro na adição de série: " + e.toString();
		}
		return "Série adicionada com sucesso!";
	}
	
	@RequestMapping(value="/series/{id}", method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleta(@PathVariable Long id) {
		try {
			serieDao.delete(id);
		} catch(Exception e) {
			return "Erro na remoção de série: " + e.toString();
		}
		return "Série removida com sucesso!";
	}
	
}