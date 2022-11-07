package br.com.m03s04ex.controllers;

import br.com.m03s04ex.model.ClienteModel;
import br.com.m03s04ex.model.PedidoModel;
import br.com.m03s04ex.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping(value = "/cadastrarPedido" , produces = "application/json")
    public ResponseEntity<PedidoModel> cadastrar(@RequestBody PedidoModel pedidoModel){

        PedidoModel pedido = pedidoRepository.save(pedidoModel);
        return new ResponseEntity<PedidoModel>(pedido, HttpStatus.CREATED);

    }

}
