package br.com.mysenador.mysenador.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.mysenador.mysenador.model.Suplente;
@Component
public interface SuplenteRep extends CrudRepository<Suplente, Integer>{

}
