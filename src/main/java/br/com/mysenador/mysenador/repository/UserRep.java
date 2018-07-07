package br.com.mysenador.mysenador.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.mysenador.mysenador.model.User;

public interface UserRep extends CrudRepository<User, String> {

}
