package br.com.m03s04ex.controllers;


import br.com.m03s04ex.model.ProdutoModel;
import br.com.m03s04ex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(value = "/salvar/{descricao}" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvarGet(@PathVariable String descricao){

        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        produtoRepository.save(produto); // vai gravar um produto no banco de dados

        return "Produto " + descricao + " registrado com sucesso";
    }

    @GetMapping(value = "/listarprodutos")
    @ResponseBody // Retorna os dados no copro da resposta
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){

        List<ProdutoModel> produtos =   produtoRepository.findAll(); // consulta no BD todos os produtos

        return new ResponseEntity<List<ProdutoModel>>(produtos, HttpStatus.OK); // Retornar a lista consulta do BD em JSON

    }

    @PostMapping(value = "/salvar") /* Mapeia a URL */
    @ResponseBody /* Descreve a resposta informando que o retorno será no corpo da requisição */
    public ResponseEntity<ProdutoModel> salvarPost(@RequestBody ProdutoModel produto){

        ProdutoModel prod = produtoRepository.save(produto);
        return new ResponseEntity<ProdutoModel>(prod, HttpStatus.CREATED);

    }

    @PutMapping(value = "/atualizar" , produces = "application/json")
    public ResponseEntity<ProdutoModel> atualizar(@RequestBody ProdutoModel produtoModel){

        ProdutoModel produto = produtoRepository.save(produtoModel);
        return new ResponseEntity<ProdutoModel>(produto, HttpStatus.OK);


    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public  ResponseEntity<String> delete(@RequestParam Long idProduto) {

        produtoRepository.deleteById(idProduto);

        return new ResponseEntity<String>("Produto Deletado com sucesso" , HttpStatus.OK);

    }

}
