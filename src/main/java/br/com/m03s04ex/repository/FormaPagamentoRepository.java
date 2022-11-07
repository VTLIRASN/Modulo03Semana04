package br.com.m03s04ex.repository;


import br.com.m03s04ex.model.FormaPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoModel , Long> {
}
