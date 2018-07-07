package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "mandato")
public class Mandato {
	
	@Id
	protected Integer id;
	@Column
	protected Integer CodigoMandato;
	@Column
	protected String UfParlamentar;
	@OneToOne
	protected PrimeiraLegislaturaDoMandato PrimeiraLegislaturaDoMandato;
	@OneToOne
	protected SegundaLegislaturaDoMandato SegundaLegislaturaDoMandato;
	@Column
	protected String DescricaoParticipacao;
	@OneToMany
	protected List<Suplente>Suplentes = new ArrayList<Suplente>();	
	@OneToMany
	protected List<Exercicio>Exercicios = new ArrayList<Exercicio>();
	@OneToOne
	protected Titular Titular;
	
	
	
	public Mandato() {
		
	}
	
	public Mandato(Integer codigoMandato, String ufParlamentar,
			PrimeiraLegislaturaDoMandato primeiraLegislaturaDoMandato,
			SegundaLegislaturaDoMandato segundaLegislaturaDoMandato,
			String descricaoParticipacao, Titular titular) {
		
		CodigoMandato = codigoMandato;
		UfParlamentar = ufParlamentar;
		PrimeiraLegislaturaDoMandato = primeiraLegislaturaDoMandato;
		SegundaLegislaturaDoMandato = segundaLegislaturaDoMandato;
		DescricaoParticipacao = descricaoParticipacao;
		Titular = titular;
	}
	public Integer getCodigoMandato() {
		return CodigoMandato;
	}
	public void setCodigoMandato(Integer codigoMandato) {
		this.CodigoMandato = codigoMandato;
	}
	public String getUfParlamentar() {
		return UfParlamentar;
	}
	public void setUfParlamentar(String ufParlamentar) {
		this.UfParlamentar = ufParlamentar;
	}
	public PrimeiraLegislaturaDoMandato getPrimeiraLegislaturaDoMandato() {
		return PrimeiraLegislaturaDoMandato;
	}
	public void setPrimeiraLegislaturaDoMandato(PrimeiraLegislaturaDoMandato primeiraLegislaturaDoMandato) {
		this.PrimeiraLegislaturaDoMandato = primeiraLegislaturaDoMandato;
	}
	public SegundaLegislaturaDoMandato getSegundaLegislaturaDoMandato() {
		return SegundaLegislaturaDoMandato;
	}
	public void setSegundaLegislaturaDoMandato(SegundaLegislaturaDoMandato segundaLegislaturaDoMandato) {
		this.SegundaLegislaturaDoMandato = segundaLegislaturaDoMandato;
	}
	
	public String getDescricaoParticipacao() {
		return DescricaoParticipacao;
	}
	public void setDescricaoParticipacao(String descricaoParticipacao) {
		this.DescricaoParticipacao = descricaoParticipacao;
	}
	public List<Suplente> getSuplentes() {
		return Suplentes;
	}
	public void setSuplentes(List<Suplente> suplentes) {
		Suplentes = suplentes;
	}
	public List<Exercicio> getExercicios() {
		return Exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		Exercicios = exercicios;
	}

	public Titular getTitular() {
		return Titular;
	}

	public void setTitular(Titular titular) {
		Titular = titular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void preenche(Mandato mandato, Optional<Mandato> mandatop) {
		mandato.setId(mandatop.get().getId());
		mandato.setCodigoMandato(mandatop.get().getCodigoMandato());
		mandato.setDescricaoParticipacao(mandatop.get().getDescricaoParticipacao());
		mandato.setExercicios(mandatop.get().getExercicios());
		mandato.setPrimeiraLegislaturaDoMandato(mandatop.get().getPrimeiraLegislaturaDoMandato());
		mandato.setSegundaLegislaturaDoMandato(mandatop.get().getSegundaLegislaturaDoMandato());
		mandato.setSuplentes(mandatop.get().getSuplentes());
		mandato.setTitular(mandatop.get().getTitular());
		mandato.setUfParlamentar(mandatop.get().getUfParlamentar());
		
	}
	

}
