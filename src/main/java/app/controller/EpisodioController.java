package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dao.EpisodioDao;
import app.dao.SerieDao;
import app.model.Episodio;
import app.model.Serie;

@RestController
public class EpisodioController {

	@Autowired
	private EpisodioDao episodioDao;
	
	@Autowired
	private SerieDao serieDao;
	
	@RequestMapping(value="/episodios", method=RequestMethod.GET)
	public List<Episodio> lista() {
		return (List<Episodio>) episodioDao.findAll();
	}
	
	@RequestMapping(value="/episodios/{id}", method=RequestMethod.GET)
	public Episodio getEpisodioById(@PathVariable Long id) {
		return episodioDao.findOne(id);
	}
	
	@RequestMapping(value="/episodios", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String adiciona(@RequestBody Episodio episodio) {
		try {
			episodioDao.save(episodio);
		} catch(Exception e) {
			e.printStackTrace();
			return "Erro na adição de episódio: " + e.toString();
		}
		return "Episódio adicionado com sucesso!";
	}
	
	@RequestMapping(value="/episodios/{id}", method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleta(@PathVariable Long id) {
		try {
			episodioDao.delete(id);
		} catch(Exception e) {
			return "Erro na remoção de episódio: " + e.toString();
		}
		return "Episódio removido com sucesso!";
	}
	
	@RequestMapping(value="/maxTemporada/{id}", method=RequestMethod.GET)
	public Integer getProximaTemporada(@PathVariable Long id) {
		Serie serie = serieDao.findOne(id);
		return episodioDao.getProximaTemporada(serie);
	}
	
	@RequestMapping(value="/temporada", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String adicionaAll(@RequestBody List<Episodio> episodios) {
		try {
			episodioDao.save(episodios);
		} catch(Exception e) {
			e.printStackTrace();
			return "Erro na adição de episódios: " + e.toString();
		}
		return "Episódios adicionado com sucesso!";
	}
}
