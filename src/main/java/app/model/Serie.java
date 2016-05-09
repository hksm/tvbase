package app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Serie {

	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	private String nome;
	
	private String poster;
	private int status;
	private int anoInicio;
	private int anoFim;

	@ManyToOne
	private Canal canal;
	
	@OneToMany(mappedBy="serie", fetch=FetchType.LAZY) @JsonManagedReference("serie") @OrderBy
	private Set<Episodio> episodios;
	
	public Serie() {
	}
	
	public Serie(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	public Set<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(Set<Episodio> episodios) {
		this.episodios = episodios;
	}
}
