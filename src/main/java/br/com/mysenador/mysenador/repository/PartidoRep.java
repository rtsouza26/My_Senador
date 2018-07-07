package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.mysenador.mysenador.model.Partido;

public interface PartidoRep extends CrudRepository<Partido, Integer> {

}
