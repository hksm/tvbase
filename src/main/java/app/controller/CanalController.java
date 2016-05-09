package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dao.CanalDao;
import app.model.Canal;

@RestController
public class CanalController {

	@Autowired
	private CanalDao canalDao;
	
	@RequestMapping(value="/canais", method=RequestMethod.GET)
	public List<Canal> lista() {
		return (List<Canal>) canalDao.findAll();
	}
	
	@RequestMapping(value="/canais/{id}", method=RequestMethod.GET)
	public Canal getCanalById(@PathVariable Long id) {
		return canalDao.findOne(id);
	}
	
	@RequestMapping(value="/canais", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String adiciona(@RequestBody Canal canal) {
		try {
			canalDao.save(canal);
		} catch(Exception e) {
			return "Erro na adição de canal: " + e.toString();
		}
		return "Canal adicionado com sucesso!";
	}
	
	@RequestMapping(value="/canais/{id}", method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleta(@PathVariable Long id) {
		try {
			canalDao.delete(id);
		} catch(Exception e) {
			return "Erro na remoção de canal: " + e.toString();
		}
		return "Canal removido com sucesso!";
	}
}
