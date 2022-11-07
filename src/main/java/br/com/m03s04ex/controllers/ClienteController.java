package br.com.m03s04ex.controllers;

import br.com.m03s04ex.model.ClienteModel;
import br.com.m03s04ex.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(value = "/cadastroviaGet/{nome}" , produces = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteModel> cadastroGet(@PathVariable(value = "nome") String nome){

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(nome);
        return new ResponseEntity<ClienteModel>(cliente , HttpStatus.CREATED);

    }


    @PostMapping(value = "/cadastrarcliente" , produces = "application/json")
    public ResponseEntity<ClienteModel> cadastrar(@RequestBody ClienteModel clienteModel){

        ClienteModel cliente = clienteRepository.save(clienteModel);
        return new ResponseEntity<ClienteModel>(cliente, HttpStatus.CREATED);

    }

    @PutMapping(value = "/atualizar" , produces = "application/json")
    public ResponseEntity<ClienteModel> atualizar(@RequestBody ClienteModel clienteModel){

        ClienteModel cliente = clienteRepository.save(clienteModel);
        return new ResponseEntity<ClienteModel>(cliente, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long idCliente){

        clienteRepository.deleteById(idCliente);
        return new ResponseEntity<String>("Cliente Deletado com sucesso" , HttpStatus.OK);

    }

    @GetMapping(value="/buscarporid/{idCliente}" , produces = "application/json")
    public ResponseEntity<ClienteModel> getClienteById(@PathVariable(value = "idCliente") Long idCliente){

        ClienteModel clienteModel = clienteRepository.findById(idCliente).get();
        return new ResponseEntity<ClienteModel>(clienteModel, HttpStatus.OK);

    }



}