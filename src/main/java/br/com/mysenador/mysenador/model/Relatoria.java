package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "relatoria")
public class Relatoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@OneToOne
	protected Materia Materia;
	@OneToOne
	protected IdentificacaoComissao IdentificacaoComissao;
	@Column
	protected String DescricaoTipoRelator;
	@Column
	protected String DataDesignacao;
	@Column
	protected String DataDestituicao;
	@Column
	protected String DescricaoMotivoDestituicao;
	

	public IdentificacaoComissao getIdentificacaoComissao() {
		return IdentificacaoComissao;
	}

	public void setIdentificacaoComissao(IdentificacaoComissao identificacaoComissao) {
		IdentificacaoComissao = identificacaoComissao;
	}

	public String getDescricaoTipoRelator() {
		return DescricaoTipoRelator;
	}

	public void setDescricaoTipoRelator(String descricaoTipoRelator) {
		DescricaoTipoRelator = descricaoTipoRelator;
	}

	public String getDataDesignacao() {
		return DataDesignacao;
	}

	public void setDataDesignacao(String dataDesignacao) {
		DataDesignacao = dataDesignacao;
	}

	public Materia getMateria() {
		return Materia;
	}

	public void setMateria(Materia materia) {
		Materia = materia;
	}
	
	
	

}
