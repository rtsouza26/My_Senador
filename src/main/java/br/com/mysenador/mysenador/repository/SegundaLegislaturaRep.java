package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.SegundaLegislaturaDoMandato;
@Component
public interface SegundaLegislaturaRep extends CrudRepository<SegundaLegislaturaDoMandato, Integer>{

}
