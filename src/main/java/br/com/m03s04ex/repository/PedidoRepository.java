package br.com.m03s04ex.repository;

import br.com.m03s04ex.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel , Long> {



}
