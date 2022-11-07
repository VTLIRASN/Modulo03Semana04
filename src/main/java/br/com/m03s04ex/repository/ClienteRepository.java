package br.com.m03s04ex.repository;

import br.com.m03s04ex.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {



}