package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;

@Component
public interface IdentificacaoParlamentarRep extends CrudRepository<IdentificacaoParlamentar, Integer> {

}