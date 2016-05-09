package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity @Table(uniqueConstraints=@UniqueConstraint(columnNames={"serie", "temporada", "numero"}))
public class Episodio {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne @NotNull @JsonBackReference("serie")
	private Serie serie;
	
	@NotNull
	private int temporada;

	@NotNull
	private int numero;
	
	@NotNull
	private String nome;
	
	private LocalDate dataExibicao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public int getTemporada() {
		return temporada;
	}
	
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataExibicao() {
		return dataExibicao;
	}
	
	public void setDataExibicao(LocalDate dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
}
