package br.com.m03s04ex.controllers;

import br.com.m03s04ex.model.FormaPagamentoModel;
import br.com.m03s04ex.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/formaPagamento")
public class FormaPagamentoController {

    @Autowired
    FormaPagamentoRepository formaPagamentoRepository;


    @GetMapping(value = "/cadastroviaGet/{descricao}" , produces = "application/json")
    @ResponseBody
    public ResponseEntity<FormaPagamentoModel> cadastroGet(@PathVariable(value = "descricao") String descricao){

        FormaPagamentoModel formaPagamentoModel = new FormaPagamentoModel();
        formaPagamentoModel.setDescricao(descricao);
        return new ResponseEntity<FormaPagamentoModel>(formaPagamentoModel , HttpStatus.CREATED);

    }

    @PostMapping(value = "/cadastrarFormaPagamento" , produces = "application/json")
    public ResponseEntity<FormaPagamentoModel> cadastrarFormaPagamento(@RequestBody FormaPagamentoModel formaPag){

        FormaPagamentoModel formPg = (FormaPagamentoModel) formaPagamentoRepository.save(formaPag);


        return new ResponseEntity<FormaPagamentoModel>(formPg, HttpStatus.CREATED);

    }

}
