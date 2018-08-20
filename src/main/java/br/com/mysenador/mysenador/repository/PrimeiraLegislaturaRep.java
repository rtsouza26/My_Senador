package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.mysenador.mysenador.model.PrimeiraLegislaturaDoMandato;
@Component
public interface PrimeiraLegislaturaRep extends CrudRepository<PrimeiraLegislaturaDoMandato, Integer> {

}
