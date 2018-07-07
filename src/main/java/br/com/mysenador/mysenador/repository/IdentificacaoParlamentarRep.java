package br.com.mysenador.mysenador.repository;
import org.springframework.beans.factory.annotation.*;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;

@Component
public interface IdentificacaoParlamentarRep extends CrudRepository<IdentificacaoParlamentar, Integer> {

}