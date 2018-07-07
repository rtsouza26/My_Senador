package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.mysenador.mysenador.model.Parlamentar;

public interface ParlamentarRep extends CrudRepository<Parlamentar,Integer> {

}
